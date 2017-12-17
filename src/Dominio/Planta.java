package Dominio;

import Controller.ConectorDb;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Planta {
    private int PL_id;
    private String PL_nombre;
    private int PL_lugar;

    public Planta(int PL_id, String PL_nombre, int PL_lugar) {
        this.PL_id = PL_id;
        this.PL_nombre = PL_nombre;
        this.PL_lugar = PL_lugar;
    }

    public int getPL_id() {
        return PL_id;
    }

    public void setPL_id(int PL_id) {
        this.PL_id = PL_id;
    }

    public String getPL_nombre() {
        return PL_nombre;
    }

    public void setPL_nombre(String PL_nombre) {
        this.PL_nombre = PL_nombre;
    }

    public int getPL_lugar() {
        return PL_lugar;
    }

    public void setPL_lugar(int PL_lugar) {
        this.PL_lugar = PL_lugar;
    }

    public void agregarDb(ConectorDb conector) {
        try {
            String stm = "INSERT INTO Planta(PL_nombre,PL_lugar) VALUES (?,?);";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setString(1, PL_nombre);
            pst.setInt(2, PL_lugar);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void modificarDb(ConectorDb conector) {
        try {
            String stm = "UPDATE Planta SET PL_nombre = ?, PL_lugar = ? WHERE PL_id='" + PL_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setString(1, PL_nombre);
            pst.setInt(2, PL_lugar);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println("aqui");
            System.out.print(ex.toString());
        }
    }

    public void eliminarDb(ConectorDb conector) {
        try {
            String stm = "DELETE FROM PLANTA WHERE PL_id ='" + PL_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }



}
