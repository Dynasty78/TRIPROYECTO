package Dominio;

import Controller.ConectorDb;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Zona {
    private int ZO_id;
    private String ZO_nombre;
    private String ZO_descripcion;

    public Zona(int ZO_id, String ZO_nombre, String ZO_descripcion) {
        this.ZO_id = ZO_id;
        this.ZO_nombre = ZO_nombre;
        this.ZO_descripcion = ZO_descripcion;
    }

    public int getZO_id() {
        return ZO_id;
    }

    public void setZO_id(int ZO_id) {
        this.ZO_id = ZO_id;
    }

    public String getZO_nombre() {
        return ZO_nombre;
    }

    public void setZO_nombre(String ZO_nombre) {
        this.ZO_nombre = ZO_nombre;
    }

    public String getZO_descripcion() {
        return ZO_descripcion;
    }

    public void setZO_descripcion(String ZO_descripcion) {
        this.ZO_descripcion = ZO_descripcion;
    }

    public void agregarDb(ConectorDb conector) {
        try {
            String stm = "INSERT INTO Zona(ZO_planta_id,ZO_zona_id) VALUES (?,?);";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setString(1, ZO_nombre);
            pst.setString(2, ZO_descripcion);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void modificarDb(ConectorDb conector) {
        try {
            String stm = "UPDATE ZONA SET ZO_nombre = ?, ZO_descripcion = ? WHERE ZO_id='" + ZO_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setString(1, ZO_nombre);
            pst.setString(2, ZO_descripcion);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println("aqui");
            System.out.print(ex.toString());
        }
    }

    public void eliminarDb(ConectorDb conector) {
        try {
            String stm = "DELETE FROM Zona_planta WHERE ZO_id ='" + ZO_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }
}
