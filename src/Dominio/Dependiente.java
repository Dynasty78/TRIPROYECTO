package Dominio;

import Controller.ConectorDb;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dependiente {
    private int DE_id;
    private String DE_nombre;
    private String DE_apellido;
    private Date DE_fecha_nacimiento;
    private int DE_empleado_id;

    public Dependiente(int DE_id, String DE_nombre, String DE_apellido, Date DE_fecha_nacimiento, int DE_empleado_id) {
        this.DE_id = DE_id;
        this.DE_nombre = DE_nombre;
        this.DE_apellido = DE_apellido;
        this.DE_fecha_nacimiento = DE_fecha_nacimiento;
        this.DE_empleado_id = DE_empleado_id;
    }

    public int getDE_id() {
        return DE_id;
    }

    public void setDE_id(int DE_id) {
        this.DE_id = DE_id;
    }

    public String getDE_nombre() {
        return DE_nombre;
    }

    public void setDE_nombre(String DE_nombre) {
        this.DE_nombre = DE_nombre;
    }

    public String getDE_apellido() {
        return DE_apellido;
    }

    public void setDE_apellido(String DE_apellido) {
        this.DE_apellido = DE_apellido;
    }

    public Date getDE_fecha_nacimiento() {
        return DE_fecha_nacimiento;
    }

    public void setDE_fecha_nacimiento(Date DE_fecha_nacimiento) {
        this.DE_fecha_nacimiento = DE_fecha_nacimiento;
    }

    public int getDE_empleado_id() {
        return DE_empleado_id;
    }

    public void setDE_empleado_id(int DE_empleado_id) {
        this.DE_empleado_id = DE_empleado_id;
    }

    public void agregarDb(ConectorDb conector) {
        try {
            String stm = "INSERT INTO DEPENDIENTE (DE_nombre = ?,DE_apellido = ?,DE_fecha_nacimiento = ?, DE_empleado_id = ?) VALUES (?);";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setString(1, DE_nombre);
            pst.setString(2,DE_apellido);
            pst.setDate(3,DE_fecha_nacimiento);
            pst.setInt(4,DE_empleado_id);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void modificarDb(ConectorDb conector) {
        try {
            String stm = "UPDATE DEPENDIENTE SET DE_nombre = ?, DE_apellido = ?,DE_fecha_nacimiento = ?, DE_empleado_id = ? WHERE DE_id='" + DE_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setString(1, DE_nombre);
            pst.setString(2,DE_apellido);
            pst.setDate(3,DE_fecha_nacimiento);
            pst.setInt(4,DE_empleado_id);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void eliminarDb(ConectorDb conector) {
        try {
            String stm = "DELETE FROM DEPENDIENTE WHERE DE_id ='" + DE_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }






}
