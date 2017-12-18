package Dominio;

import Controller.ConectorDb;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class Compra_material {
    private int CM_id;
    private int CM_solicitud_pieza_id;
    private int CM_material_id;
    private Date CM_fecha;
    private int CM_solicitud_id_avion;
    private int CM_pieza_id;

    // public Compra_material(int CM_solicitud_pieza_id, int CM_solicitud_id_avion,int CM_pieza_id) {
    //     this.CM_solicitud_pieza_id = CM_solicitud_pieza_id;
    //     this.CM_solicitud_id_avion = CM_solicitud_id_avion;
    //     this.CM_pieza_id = CM_pieza_id;
    // }

    public Compra_material(int CM_solicitud_pieza_id,int CM_pieza_id) {
        this.CM_solicitud_pieza_id = CM_solicitud_pieza_id;
        this.CM_pieza_id = CM_pieza_id;
    }

    public void agregarDb(ConectorDb conector) {
        try {
            String stm = "INSERT INTO Compra_Material(CM_solicitud_pieza_id,CM_material_id) VALUES (?,?);";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setInt(1, CM_solicitud_pieza_id);
            pst.setInt(2,CM_material_id);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

     public void generarCompra_Material(ConectorDb conector) {
        try {
            String stm = 
            "SELECT ma_id, ma_nombre, mp_cantidad_material "+
            " FROM material ma "+
            " INNER JOIN material_pieza mp ON ma.ma_id = mp.mp_material_id "+
            " INNER JOIN pieza pz ON mp.mp_pieza_id = pz.pi_id "+
            "WHERE pz.pi_id = " + this.CM_pieza_id + " ";

            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                for (int i = 0; i < rs.getInt("mp_cantidad_material"); i++) {
                    this.CM_material_id = rs.getInt("ma_id");
                    agregarDb(conector);
                    // generar pruebas para las compras
                    generarPruebas(conector, CM_material_id, getLastId(conector));
                }
            }
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void generarPruebas(ConectorDb conector, int material_id, int compra_material_id)
    {

        try {


            String stm = 
            "SELECT pm.pm_id, ma.ma_id, ma.ma_nombre, pru.pru_id, pru.pru_nombre "+
            "FROM material ma "+
            "INNER JOIN prueba_material pm ON ma.ma_id = pm.pm_material_id "+
            "INNER JOIN prueba pru ON pm.pm_prueba_id = pru.pru_id "+
            "WHERE ma.ma_id = " + material_id + " "+
            "ORDER BY pm.pm_orden ";

            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int prueba_material_id = rs.getInt("pm_id");
                // insertar en prueba_mterial_compra
                // esto deberia ser pasado despues a un modelo

                String insert_stm = "INSERT INTO prueba_material_compra(pmc_compra_material_id, pmc_prueba_material_id) VALUES (?,?);";
                PreparedStatement insert_pst = conector.conexion.prepareStatement(insert_stm);
                insert_pst.setInt(1, compra_material_id);
                insert_pst.setInt(2, prueba_material_id);
                insert_pst.executeUpdate();
                insert_pst.close();
            }

            int primera_prueba = siguientePruebaSinCompletar(conector, compra_material_id);
            settearFechaInicialPrueba(conector, primera_prueba);

        } catch(SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public int getLastId(ConectorDb conector) {
        int i = 0;
        try {
            PreparedStatement pst = conector.conexion.prepareStatement("SELECT cm_id as id FROM compra_material ORDER BY id DESC LIMIT 1");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                i = rs.getInt("id");
                return i;
            }
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
        return i;
    }

    public int siguientePruebaSinCompletar(ConectorDb conector, int compra_material_id)
    {
        try {
            String stm = 
            "SELECT pmc_id "+
            "FROM prueba_material_compra "+
            "WHERE pmc_compra_material_id =" + compra_material_id + "AND pmc_aprobado IS NULL "+
            "LIMIT 1 ";

            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            ResultSet rs = pst.executeQuery();

            int prueba_material_compra_id = 0;
            if (rs.next()) {
                prueba_material_compra_id = rs.getInt("pmc_id");
            }

            return prueba_material_compra_id;
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
        return 0;
    }

    public void settearFechaInicialPrueba(ConectorDb conector, int prueba_material_compra_id)
    {
        try {
            String stm = "UPDATE prueba_material_compra SET pmc_fecha_inicio = ? WHERE pmc_id = ?";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setDate(1, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
            pst.setInt(2, prueba_material_compra_id);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void setPruebaStatus(ConectorDb conector, int compra_material_id, boolean aprobado)
    {
        int prueba_material_compra_id = siguientePruebaSinCompletar(conector, compra_material_id);
       
        try {
            String stm = "UPDATE prueba_material_compra SET pmc_aprobado = ?, pmc_fecha_fin = ? WHERE pmc_id = ?";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setBoolean(1, aprobado);
            pst.setDate(2, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
            pst.setInt(3, prueba_material_compra_id);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
        
        int siguiente = siguientePruebaSinCompletar(conector, compra_material_id);
        if (siguiente == 0) {
            int solicitud_pieza_actividad_fabricacion_id = Solicitud_pieza.siguienteActividadSinCompletar(conector, CM_solicitud_pieza_id);
            Solicitud_pieza.settearFechaInicialActividad(conector, solicitud_pieza_actividad_fabricacion_id);
        }
        else {
            settearFechaInicialPrueba(conector, siguiente);
        }
    }
}

