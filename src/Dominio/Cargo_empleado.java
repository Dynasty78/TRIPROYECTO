package Dominio;

import Controller.ConectorDb;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cargo_empleado {
    private int CE_id;
    private String CE_nombre;

    public Cargo_empleado(int CE_id, String CE_nombre) {
        this.CE_id = CE_id;
        this.CE_nombre = CE_nombre;
    }

    public int getCE_id() {
        return CE_id;
    }

    public void setCE_id(int CE_id) {
        this.CE_id = CE_id;
    }

    public String getCE_nombre() {
        return CE_nombre;
    }

    public void setCE_nombre(String CE_nombre) {
        this.CE_nombre = CE_nombre;
    }

    public void agregarDb(ConectorDb conector) {
        try {
            String stm = "INSERT INTO CARGO_EMPLEADO (CE_nombre) VALUES (?);";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setString(1, CE_nombre);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void modificarDb(ConectorDb conector) {
        try {
            String stm = "UPDATE CARGO_EMPLEADO SET CE_nombre = ? WHERE CE_id='" + CE_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setString(1, CE_nombre);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println("aqui");
            System.out.print(ex.toString());
        }
    }

    public void eliminarDb(ConectorDb conector) {
        try {
            String stm = "DELETE FROM CARGO_EMPLEADO WHERE CE_id ='" + CE_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }





}
