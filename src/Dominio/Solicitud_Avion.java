package Dominio;

import Controller.ConectorDb;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Solicitud_Avion {
    private int SA_id;
    private int SA_cliente_id;
    private int SA_avion_id;
    private Date SA_fecha_inicio;
    private Date SA_fecha_fin;
    private int SA_estatus;
    private ArrayList<Solicitud_pieza> piezas = new ArrayList<Solicitud_pieza>();

    public Solicitud_Avion(int SA_cliente_id, int SA_avion_id) {
        this.SA_cliente_id = SA_cliente_id;
        this.SA_avion_id = SA_avion_id;
        this.SA_estatus = 1;

    }

    public void agregarDb(ConectorDb conector) {
        try {
            String stm = "INSERT INTO SOLICITUD_AVION (SA_cliente_id,SA_avion_id,SA_estatus_id) VALUES (?,?,?);";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setInt(1, SA_cliente_id);
            pst.setInt(2, SA_avion_id);
            pst.setInt(3, SA_estatus);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void modificarDb(ConectorDb conector) {
        try {
            String stm = "UPDATE SOLICITUD_AVION SET SA_fecha_fin = ? WHERE SA_id ='" + SA_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setDate(1, SA_fecha_fin);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println("aqui");
            System.out.print(ex.toString());
        }
    }

    public void eliminarDb(ConectorDb conector) {
        try {
            String stm = "DELETE FROM SOLICITUD_AVION WHERE SA_id ='" + SA_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void agregarPieza(ConectorDb conector) {
        try {
            String stm = "SELECT pz.pi_id, pz.pi_nombre, ap.ap_cantidad_pieza "+
                            "FROM pieza pz "+
                            "INNER JOIN avion_pieza ap ON pz.pi_id = ap.ap_pieza_id "+
                            "INNER JOIN avion av ON ap.ap_avion_id = av.av_id "+
                            "WHERE av.av_id = " + SA_avion_id + " ";


            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                // por cada pieza, genero la solicitud de la misma 
                for (int i = 0; i < rs.getInt("ap_cantidad_pieza"); i++) {
                    int pieza_id = rs.getInt("pi_id");
                    SA_id = getLastId(conector);
                    
                    Solicitud_pieza sp = new Solicitud_pieza(SA_id, pieza_id);
                    sp.agregarDb(conector);

                    int SP_id = sp.getLastId(conector);

                    // genero compras de los materiales
                    Compra_material cm = new Compra_material(SP_id, pieza_id);
                    cm.generarCompra_Material(conector);

                    // genero las actividades de cada  pieza
                    Solicitud_pieza_actividad_fabricacion spaf = new Solicitud_pieza_actividad_fabricacion(SP_id, pieza_id);
                    spaf.generarSPAF(conector);
                }
            }
        } catch (SQLException ex) {
            System.out.println("aqui");
            System.out.print(ex.toString());
        }
    }

    public int getLastId(ConectorDb conector) {
        int i = 0;
        try {
            PreparedStatement pst = conector.conexion.prepareStatement("SELECT sa_id as id FROM solicitud_avion ORDER BY id DESC LIMIT 1");
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

    public void generarSolicitud(ConectorDb conector) {
        agregarDb(conector);
        agregarPieza(conector);
    }



}
