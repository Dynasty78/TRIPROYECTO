package Dominio;

import Controller.ConectorDb;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Experiencia_empleado {
    private int EE_id;
    private String EE_empresa;
    private String EE_cargo;
    private Date EE_fecha_inicio;
    private Date EE_fecha_fin;
    private int EE_empleado_id;


    public Experiencia_empleado(int EE_id, String EE_empresa, String EE_cargo, Date EE_fecha_inicio, Date EE_fecha_fin, int EE_empleado_id) {
        this.EE_id = EE_id;
        this.EE_empresa = EE_empresa;
        this.EE_cargo = EE_cargo;
        this.EE_fecha_inicio = EE_fecha_inicio;
        this.EE_fecha_fin = EE_fecha_fin;
        this.EE_empleado_id = EE_empleado_id;
    }

    public int getEE_id() {
        return EE_id;
    }

    public void setEE_id(int EE_id) {
        this.EE_id = EE_id;
    }

    public String getEE_empresa() {
        return EE_empresa;
    }

    public void setEE_empresa(String EE_empresa) {
        this.EE_empresa = EE_empresa;
    }

    public String getEE_cargo() {
        return EE_cargo;
    }

    public void setEE_cargo(String EE_cargo) {
        this.EE_cargo = EE_cargo;
    }

    public Date getEE_fecha_inicio() {
        return EE_fecha_inicio;
    }

    public void setEE_fecha_inicio(Date EE_fecha_inicio) {
        this.EE_fecha_inicio = EE_fecha_inicio;
    }

    public Date getEE_fecha_fin() {
        return EE_fecha_fin;
    }

    public void setEE_fecha_fin(Date EE_fecha_fin) {
        this.EE_fecha_fin = EE_fecha_fin;
    }

    public int getEE_empleado_id() {
        return EE_empleado_id;
    }

    public void setEE_empleado_id(int EE_empleado_id) {
        this.EE_empleado_id = EE_empleado_id;
    }

    public void agregarDb(ConectorDb conector) {
        try {
            String stm = "INSERT INTO Experiencia_empleado(EE_empresa,EE_cargo,EE_fecha_inicio,EE_fecha_fin,EE_empleado_id) VALUES (?,?,?,?,?);";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setString(1, EE_empresa);
            pst.setString(2, EE_cargo);
            pst.setDate(3, EE_fecha_inicio);
            pst.setDate(4, EE_fecha_fin);
            pst.setInt(5, EE_empleado_id);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void modificarDb(ConectorDb conector) {
        try {
            String stm = "UPDATE Experiencia_empleado SET EE_empresa = ?, EE_cargo = ?,EE_fecha_inicio = ?,EE_fecha_fin = ?,EE_empleado_id = ? WHERE EE_id='" + EE_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setString(1, EE_empresa);
            pst.setString(2, EE_cargo);
            pst.setDate(3, EE_fecha_inicio);
            pst.setDate(4, EE_fecha_fin);
            pst.setInt(5, EE_empleado_id);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println("aqui");
            System.out.print(ex.toString());
        }
    }

    public void eliminarDb(ConectorDb conector) {
        try {
            String stm = "DELETE FROM Experiencia_empleado WHERE EE_id ='" + EE_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

}
