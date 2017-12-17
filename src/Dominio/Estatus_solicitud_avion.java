package Dominio;

import Controller.ConectorDb;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Estatus_solicitud_avion {
    private int ESA_id;
    private String ESA_nombre;
    private String ESA_descripcion;

    public Estatus_solicitud_avion(String ESA_nombre, String ESA_descripcion) {
        this.ESA_nombre = ESA_nombre;
        this.ESA_descripcion = ESA_descripcion;
        this.ESA_id = 4;
    }

    public Estatus_solicitud_avion(int ESA_id, String ESA_nombre, String ESA_descripcion) {
        this.ESA_id = ESA_id;
        this.ESA_nombre = ESA_nombre;
        this.ESA_descripcion = ESA_descripcion;
    }
    public int getESA_id() {
        return ESA_id;
    }
    public void setESA_id(int ESA_id) {
        this.ESA_id = ESA_id;
    }
    public String getESA_nombre() {
        return ESA_nombre;
    }
    public void setESA_nombre(String ESA_nombre) {
        this.ESA_nombre = ESA_nombre;
    }
    public String getESA_descripcion() {
        return ESA_descripcion;
    }
    public void setESA_descripcion(String ESA_descripcion) {
        this.ESA_descripcion = ESA_descripcion;
    }
    public void modificarDb(ConectorDb conector) {
        try {
            String stm = "UPDATE estatus_solicitud_avion SET ESA_nombre = ?, ESA_descripcion = ? WHERE ESA_id='" + ESA_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setString(1, ESA_nombre);
            pst.setString(2, ESA_descripcion);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }
    public void eliminarDb(ConectorDb conector) {
        try {
            String stm = "DELETE FROM estatus_solicitud_avion WHERE ESA_id ='" + ESA_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }
}
