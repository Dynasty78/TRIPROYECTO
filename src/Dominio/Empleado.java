package Dominio;

import Controller.ConectorDb;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Empleado {
    private int EM_id;
    private Date EM_fecha_inicio;
    private String EM_titulo;
    private int EM_persona_id;
    private int EM_zona_planta_id;
    private int EM_cargo_id;


    public Empleado(String EM_titulo, int EM_persona_id, int EM_zona_planta_id, int EM_cargo_id) {
        this.EM_titulo = EM_titulo;
        this.EM_persona_id = EM_persona_id;
        this.EM_zona_planta_id = EM_zona_planta_id;
        this.EM_cargo_id = EM_cargo_id;
    }

    public Empleado(int EM_id, Date EM_fecha_inicio, String EM_titulo, int EM_persona_id, int EM_zona_planta_id, int EM_cargo_id) {
        this.EM_id = EM_id;
        this.EM_fecha_inicio = EM_fecha_inicio;
        this.EM_titulo = EM_titulo;
        this.EM_persona_id = EM_persona_id;
        this.EM_zona_planta_id = EM_zona_planta_id;
        this.EM_cargo_id = EM_cargo_id;
    }

    public int getEM_id() {
        return EM_id;
    }

    public void setEM_id(int EM_id) {
        this.EM_id = EM_id;
    }

    public Date getEM_fecha_inicio() {
        return EM_fecha_inicio;
    }

    public void setEM_fecha_inicio(Date EM_fecha_inicio) {
        this.EM_fecha_inicio = EM_fecha_inicio;
    }

    public String getEM_titulo() {
        return EM_titulo;
    }

    public void setEM_titulo(String EM_titulo) {
        this.EM_titulo = EM_titulo;
    }

    public int getEM_zona_planta_id() {
        return EM_zona_planta_id;
    }

    public void setEM_zona_planta_id(int EM_zona_planta_id) {
        this.EM_zona_planta_id = EM_zona_planta_id;
    }

    public int getEM_cargo_id() {
        return EM_cargo_id;
    }

    public void setEM_cargo_id(int EM_cargo_id) {
        this.EM_cargo_id = EM_cargo_id;
    }

    public void agregarDb(ConectorDb conector) {
        try {
            String stm = "INSERT INTO EMPLEADO(EM_titulo,EM_persona_id,EM_zona_planta_id,EM_cargo_id) VALUES (?,?,?,?);";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setString(1, EM_titulo);
            pst.setInt(2, EM_persona_id);
            pst.setInt(3, EM_zona_planta_id);
            pst.setInt(4, EM_cargo_id);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void modificarDb(ConectorDb conector) {
        try {
            String stm = "UPDATE EMPLEADO SET EM_titulo = ?, EM_persona_id = ?,EM_zona_planta_id = ?, EM_cargo_id = ? WHERE CL_id='" + EM_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setString(1, EM_titulo);
            pst.setInt(2, EM_persona_id);
            pst.setInt(3, EM_zona_planta_id);
            pst.setInt(4, EM_cargo_id);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void eliminarDb(ConectorDb conector) {
        try {
            String stm = "DELETE FROM EMPLEADO WHERE PR_id ='" + EM_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }
}
