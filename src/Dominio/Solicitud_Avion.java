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
        this.SA_estatus = 4;

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
            PreparedStatement pst = conector.conexion.prepareStatement("SELECT PI_ID,PI_NOMBRE,AV_NOMBRE FROM AVION,AVION_PIEZA,PIEZA WHERE AP_AVION_ID = AV_ID AND AP_PIEZA_ID = PI_ID AND AV_ID = '"+SA_avion_id+"'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int SP_pieza_id = rs.getInt("PI_ID");
                SA_id = getLastId(conector);
                Solicitud_pieza sp = new Solicitud_pieza(SA_id, SP_pieza_id);
                sp.agregarDb(conector);

            }
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void agregarMaterial(ConectorDb conector){
        try {
            PreparedStatement pst = conector.conexion.prepareStatement("select SP_ID,SP_PIEZA_ID FROM solicitud_pieza,solicitud_avion  where sp_solicitud_avion_id = sa_id AND sa_id = '"+getLastId(conector)+"'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int SP_id = rs.getInt("SP_ID");
                int SP_PIEZA_ID = rs.getInt("SP_PIEZA_ID");
                SA_id = getLastId(conector);
                Compra_material cm = new Compra_material(SP_id,getLastId(conector),SP_PIEZA_ID);
                cm.generarCompra_Material(conector);

            }
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void agregarSPAF(ConectorDb conector){
        try {
            PreparedStatement pst = conector.conexion.prepareStatement("select SP_ID,SP_PIEZA_ID FROM solicitud_pieza,solicitud_avion  where sp_solicitud_avion_id = sa_id AND sa_id = '"+getLastId(conector)+"'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int SP_id = rs.getInt("SP_ID");
                int SP_PIEZA_ID = rs.getInt("SP_PIEZA_ID");
                SA_id = getLastId(conector);
                Solicitud_pieza_actividad_fabricacion spaf = new Solicitud_pieza_actividad_fabricacion(SP_id,getLastId(conector),SP_PIEZA_ID);
                spaf.generarSPAF(conector);
            }
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public int getLastId(ConectorDb conector) {
        int i = 0;
        try {
            PreparedStatement pst = conector.conexion.prepareStatement("SELECT count(*) as cuenta FROM SOLICITUD_AVION");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                i = rs.getInt("cuenta");
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
        agregarMaterial(conector);
        agregarSPAF(conector);
    }

}
