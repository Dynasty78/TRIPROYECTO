package Dominio;

import Controller.ConectorDb;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Solicitud_pieza {
    private int SP_id;
    private int SP_solicitud_avion_id;
    private int SP_pieza_id;
    private Date SP_fecha_inicio;
    private Date SP_fecha_fin;
    private int SP_estatus_id;

    public Solicitud_pieza(int SP_solicitud_avion_id, int SP_pieza_id) {
        this.SP_solicitud_avion_id = SP_solicitud_avion_id;
        this.SP_pieza_id = SP_pieza_id;
        this.SP_estatus_id = 1;
    }

    public int getSP_id() {
        return SP_id;
    }

    public void setSP_id(int SP_id) {
        this.SP_id = SP_id;
    }

    public int getSP_solicitud_avion_id() {
        return SP_solicitud_avion_id;
    }

    public void setSP_solicitud_avion_id(int SP_solicitud_avion_id) {
        this.SP_solicitud_avion_id = SP_solicitud_avion_id;
    }

    public int getSP_pieza_id() {
        return SP_pieza_id;
    }

    public void setSP_pieza_id(int SP_pieza_id) {
        this.SP_pieza_id = SP_pieza_id;
    }

    public Date getSP_fecha_inicio() {
        return SP_fecha_inicio;
    }

    public void setSP_fecha_inicio(Date SP_fecha_inicio) {
        this.SP_fecha_inicio = SP_fecha_inicio;
    }

    public Date getSP_fecha_fin() {
        return SP_fecha_fin;
    }

    public void setSP_fecha_fin(Date SP_fecha_fin) {
        this.SP_fecha_fin = SP_fecha_fin;
    }

    public int getSP_estatus_id() {
        return SP_estatus_id;
    }

    public void setSP_estatus_id(int SP_estatus_id) {
        this.SP_estatus_id = SP_estatus_id;
    }

    public void agregarDb(ConectorDb conector) {
        try {
            String stm = "INSERT INTO Solicitud_pieza(SP_solicitud_avion_id,SP_pieza_id,SP_fecha_fin,SP_estatus_id) VALUES (?,?,?,?);";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setInt(1, SP_solicitud_avion_id);
            pst.setInt(2, SP_pieza_id);
            pst.setDate(3, SP_fecha_fin);
            pst.setInt(4, SP_estatus_id);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void modificarDb(ConectorDb conector) {
        try {

            String stm = "UPDATE PIEZA_ACTIVIDAD_FABRICACION SET SP_solicitud_avion_id = ?, SP_pieza_id = ?, SP_fecha_fin =?, SP_estatus_id = ? WHERE SP_id='" + SP_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setInt(1, SP_solicitud_avion_id);
            pst.setInt(2, SP_pieza_id);
            pst.setDate(3, SP_fecha_fin);
            pst.setInt(4, SP_estatus_id);

            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void eliminarDb(ConectorDb conector) {
        try {
            String stm = "DELETE FROM PIEZA_ACTIVIDAD_FABRICACION WHERE SP_id ='" + SP_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public int getLastId(ConectorDb conector) {
        // int i = 0;
        // try {
        //     PreparedStatement pst = conector.conexion.prepareStatement("select count(*) AS cuenta from Solicitud_pieza");
        //     ResultSet rs = pst.executeQuery();
        //     while (rs.next()) {
        //         i = rs.getInt("cuenta");
        //         return i;
        //     }
        // } catch (SQLException ex) {
        //     System.out.print(ex.toString());
        // }
        // return i;
        int i = 0;
        try {
            PreparedStatement pst = conector.conexion.prepareStatement("SELECT sp_id as id FROM Solicitud_pieza ORDER BY id DESC LIMIT 1");
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

    public static int siguienteActividadSinCompletar(ConectorDb conector, int solicitud_pieza_id)
    {
        // SELECT spaf_id
        // FROM solicitud_pieza_actividad_fabricacion
        // WHERE spaf_solicitud_pieza_id = 1 AND spaf_aprobado IS NULL
        // LIMIT 1
        try {
            String stm = 
            "SELECT spaf_id "+
            "FROM solicitud_pieza_actividad_fabricacion "+
            "WHERE spaf_solicitud_pieza_id =" + compra_material_id + "AND spaf_aprobado IS NULL "+
            "LIMIT 1 ";

            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            ResultSet rs = pst.executeQuery();

            int solicitud_pieza_actividad_fabricacion_id = 0;
            if (rs.next()) {
                solicitud_pieza_actividad_fabricacion_id = rs.getInt("spaf_id");
            }

            return solicitud_pieza_actividad_fabricacion_id;
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
        return 0;
    }

     public static void settearFechaInicialActividad(ConectorDb conector, int solicitud_pieza_actividad_fabricacion_id)
    {
        try {
            String stm = "UPDATE solicitud_pieza_actividad_fabricacion SET spaf_fecha_inicio = ? WHERE spaf_id = ?";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setDate(1, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
            pst.setInt(2, solicitud_pieza_actividad_fabricacion_id);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void setActividadStatus(ConectorDb conector, int solicitud_pieza_id, bool aprobado)
    {
        int solicitud_pieza_actividad_fabricacion_id = siguienteActividadSinCompletar(conector, solicitud_pieza_id)
       
        try {
            String stm = "UPDATE solicitud_pieza_actividad_fabricacion SET spaf_aprobado = ?, spaf_fecha_fin = ? WHERE spaf_id = ?";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setBool(1, aprobado);
            pst.setDate(2, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
            pst.setInt(3, solicitud_pieza_actividad_fabricacion_id);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
        
        int siguiente = siguienteActividadSinCompletar(conector, solicitud_pieza_id);
        if (siguiente == 0) {
            // termino construccion pieza
        }
        else {
            settearFechaInicialActividad(conector, siguiente)
        }
    }
}
