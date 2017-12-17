package Dominio;

import Controller.ConectorDb;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Jose Jesus on 14/12/2017.
 */
public class Zona_planta {
    private int ZP_id;
    private int ZP_planta_id;
    private int ZP_zona_id;

    public Zona_planta(int ZP_id, int ZP_planta_id, int ZP_zona_id) {
        this.ZP_id = ZP_id;
        this.ZP_planta_id = ZP_planta_id;
        this.ZP_zona_id = ZP_zona_id;
    }

    public int getZP_id() {
        return ZP_id;
    }

    public void setZP_id(int ZP_id) {
        this.ZP_id = ZP_id;
    }

    public int getZP_planta_id() {
        return ZP_planta_id;
    }

    public void setZP_planta_id(int ZP_planta_id) {
        this.ZP_planta_id = ZP_planta_id;
    }

    public int getZP_zona_id() {
        return ZP_zona_id;
    }

    public void setZP_zona_id(int ZP_zona_id) {
        this.ZP_zona_id = ZP_zona_id;
    }

    public void agregarDb(ConectorDb conector) {
        try {
            String stm = "INSERT INTO Zona_planta(ZP_planta_id,ZP_zona_id) VALUES (?,?);";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setInt(1, ZP_planta_id);
            pst.setInt(2, ZP_zona_id);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void modificarDb(ConectorDb conector) {
        try {
            String stm = "UPDATE Zona_planta SET ZP_planta_id = ?, ZP_zona_id = ? WHERE ZP_id='" + ZP_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setInt(1, ZP_planta_id);
            pst.setInt(2, ZP_zona_id);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println("aqui");
            System.out.print(ex.toString());
        }
    }

    public void eliminarDb(ConectorDb conector) {
        try {
            String stm = "DELETE FROM Zona_planta WHERE ZP_id ='" + ZP_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

}
