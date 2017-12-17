package Dominio;

import Controller.ConectorDb;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Avion_caracteristica {
        private int AC_id;
        private int AC_caracteristica_id;
        private String AC_valor;

    public Avion_caracteristica(int AC_id, int AC_caracteristica_id, String AC_valor) {
        this.AC_id = AC_id;
        this.AC_caracteristica_id = AC_caracteristica_id;
        this.AC_valor = AC_valor;
    }

    public int getAC_id() {
        return AC_id;
    }

    public void setAC_id(int AC_id) {
        this.AC_id = AC_id;
    }

    public int getAC_caracteristica_id() {
        return AC_caracteristica_id;
    }

    public void setAC_caracteristica_id(int AC_caracteristica_id) {
        this.AC_caracteristica_id = AC_caracteristica_id;
    }

    public String getAC_valor() {
        return AC_valor;
    }

    public void setAC_valor(String AC_valor) {
        this.AC_valor = AC_valor;
    }

    public void agregarDb(ConectorDb conector) {
        try {
            String stm = "INSERT INTO AVION_CARACTERISTICA(caracteristica_id,valor) VALUES (?,?);";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setInt(1, AC_caracteristica_id);
            pst.setString(2, AC_valor);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void modificarDb(ConectorDb conector) {
        try {
            String stm = "UPDATE AVION_CARACTERISTICA SET AC_valor = ? WHERE AC_id='" + AC_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setString(1, AC_valor);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void eliminarDb(ConectorDb conector) {
        try {
            String stm = "DELETE FROM avion_caracteristica WHERE AC_id ='" + AC_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }


}
