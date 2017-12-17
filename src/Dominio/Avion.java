package Dominio;

import Controller.ConectorDb;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Avion {
    private int AV_id;
    private String AV_nombre;
    private String AV_descripcion;

    public Avion(int AV_id, String AV_nombre, String AV_descripcion) {
        this.AV_id = AV_id;
        this.AV_nombre = AV_nombre;
        this.AV_descripcion = AV_descripcion;
    }

    public int getAV_id() {
        return AV_id;
    }

    public void setAV_id(int AV_id) {
        this.AV_id = AV_id;
    }

    public String getAV_nombre() {
        return AV_nombre;
    }

    public void setAV_nombre(String AV_nombre) {
        this.AV_nombre = AV_nombre;
    }

    public String getAV_descripcion() {
        return AV_descripcion;
    }

    public void setAV_descripcion(String AV_descripcion) {
        this.AV_descripcion = AV_descripcion;
    }

    public void agregarDb(ConectorDb conector) {
        try {
            String stm = "INSERT INTO AVION(AV_nombre,AV_descripcion) VALUES (?,?);";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setString(1, AV_nombre);
            pst.setString(2, AV_descripcion);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void modificarDb(ConectorDb conector) {
        try {
            String stm = "UPDATE AVION SET AV_nombre = ?,AV_descripcion = ? WHERE AV_id='" + AV_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setString(1, AV_nombre);
            pst.setString(2, AV_descripcion);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void eliminarDb(ConectorDb conector) {
        try {
            String stm = "DELETE FROM Avion WHERE AV_id ='" + AV_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }
}
