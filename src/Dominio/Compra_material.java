package Dominio;

import Controller.ConectorDb;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Compra_material {
    private int CM_id;
    private int CM_solicitud_pieza_id;
    private int CM_material_id;
    private Date CM_fecha;
    private int CM_solicitud_id_avion;
    private int CM_pieza_id;

    public Compra_material(int CM_solicitud_pieza_id, int CM_solicitud_id_avion,int CM_pieza_id) {
        this.CM_solicitud_pieza_id = CM_solicitud_pieza_id;
        this.CM_solicitud_id_avion = CM_solicitud_id_avion;
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
            PreparedStatement pst = conector.conexion.prepareStatement("SELECT mp_material_id FROM solicitud_pieza,pieza,material_pieza,material,solicitud_avion WHERE sp_pieza_id = PI_ID AND mp_pieza_id = '"+CM_pieza_id+"' AND mp_material_id = ma_id AND sa_id = sp_solicitud_avion_id AND sa_id = '"+CM_solicitud_id_avion+"' AND sp_id = '"+CM_solicitud_pieza_id+"' ");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                this.CM_material_id = rs.getInt("mp_material_id");
                agregarDb(conector);
            }
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }
}

