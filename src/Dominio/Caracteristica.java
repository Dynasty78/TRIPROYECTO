package Dominio;

import Controller.ConectorDb;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Caracteristica {

    private int CA_id;
    private String CA_nombre;

    public Caracteristica(int CA_id, String CA_nombre) {
        this.CA_id = CA_id;
        this.CA_nombre = CA_nombre;
    }

    public int getCA_id() {
        return CA_id;
    }

    public void setCA_id(int CA_id) {
        this.CA_id = CA_id;
    }

    public String getCA_nombre() {
        return CA_nombre;
    }

    public void setCA_nombre(String CA_nombre) {
        this.CA_nombre = CA_nombre;
    }

    public void agregarDb(ConectorDb conector) {
        try {
            String stm = "INSERT INTO CARACTERISTICA (CA_nombre) VALUES (?);";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setString(1, CA_nombre);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void modificarDb(ConectorDb conector) {
        try {
            String stm = "UPDATE CARACTERISTICA SET CA_nombre = ? WHERE CA_id='" + CA_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setString(1, CA_nombre);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void eliminarDb(ConectorDb conector) {
        try {
            String stm = "DELETE FROM CA_nombre WHERE CA_id ='" + CA_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }



}
