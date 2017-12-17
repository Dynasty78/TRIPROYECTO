package Dominio;

import Controller.ConectorDb;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Persona {

    private int PE_id;
    private int PE_cedula;
    private String PE_nombre;
    private String PE_segundo_nombre;
    private String PE_apellido;
    private String PE_segundo_apellido;
    private String PE_website;
    private int PE_lugar_id;
    private Date PE_fecha_nacimiento;


    public Persona(int PE_cedula, String PE_nombre, String PE_segundo_nombre, String PE_apellido, String PE_segundo_apellido, String PE_website, int PE_lugar_id, Date PE_fecha_nacimiento) {
        this.PE_cedula = PE_cedula;
        this.PE_nombre = PE_nombre;
        this.PE_segundo_nombre = PE_segundo_nombre;
        this.PE_apellido = PE_apellido;
        this.PE_segundo_apellido = PE_segundo_apellido;
        this.PE_website = PE_website;
        this.PE_lugar_id = PE_lugar_id;
        this.PE_fecha_nacimiento = PE_fecha_nacimiento;
    }

    public Persona(int PE_id, int PE_cedula, String PE_nombre, String PE_segundo_nombre, String PE_apellido, String PE_segundo_apellido, String PE_website, int PE_lugar_id, Date PE_fecha_nacimiento) {
        this.PE_id = PE_id;
        this.PE_cedula = PE_cedula;
        this.PE_nombre = PE_nombre;
        this.PE_segundo_nombre = PE_segundo_nombre;
        this.PE_apellido = PE_apellido;
        this.PE_segundo_apellido = PE_segundo_apellido;
        this.PE_website = PE_website;
        this.PE_lugar_id = PE_lugar_id;
        this.PE_fecha_nacimiento = PE_fecha_nacimiento;
    }

    public int getPE_id() {
        return PE_id;
    }

    public void setPE_id(int PE_id) {
        this.PE_id = PE_id;
    }

    public int getPE_cedula() {
        return PE_cedula;
    }

    public void setPE_cedula(int PE_cedula) {
        this.PE_cedula = PE_cedula;
    }

    public String getPE_nombre() {
        return PE_nombre;
    }

    public void setPE_nombre(String PE_nombre) {
        this.PE_nombre = PE_nombre;
    }

    public String getPE_segundo_nombre() {
        return PE_segundo_nombre;
    }

    public void setPE_segundo_nombre(String PE_segundo_nombre) {
        this.PE_segundo_nombre = PE_segundo_nombre;
    }

    public String getPE_apellido() {
        return PE_apellido;
    }

    public void setPE_apellido(String PE_apellido) {
        this.PE_apellido = PE_apellido;
    }

    public String getPE_segundo_apellido() {
        return PE_segundo_apellido;
    }

    public void setPE_segundo_apellido(String PE_segundo_apellido) {
        this.PE_segundo_apellido = PE_segundo_apellido;
    }

    public String getPE_website() {
        return PE_website;
    }

    public void setPE_website(String PE_website) {
        this.PE_website = PE_website;
    }

    public int getPE_lugar_id() {
        return PE_lugar_id;
    }

    public void setPE_lugar_id(int PE_lugar_id) {
        this.PE_lugar_id = PE_lugar_id;
    }

    public Date getPE_fecha_nacimiento() {
        return PE_fecha_nacimiento;
    }

    public void setPE_fecha_nacimiento(Date PE_fecha_nacimiento) {
        this.PE_fecha_nacimiento = PE_fecha_nacimiento;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "PE_id=" + PE_id +
                ", PE_cedula=" + PE_cedula +
                ", PE_nombre='" + PE_nombre + '\'' +
                ", PE_segundo_nombre='" + PE_segundo_nombre + '\'' +
                ", PE_apellido='" + PE_apellido + '\'' +
                ", PE_segundo_apellido='" + PE_segundo_apellido + '\'' +
                ", PE_website='" + PE_website + '\'' +
                ", PE_lugar_id=" + PE_lugar_id +
                ", PE_fecha_nacimiento=" + PE_fecha_nacimiento +
                '}';
    }

    public void agregarDb(ConectorDb conector) {
        try {
            String stm = "INSERT INTO PERSONA(PE_cedula,PE_nombre,PE_segundo_nombre,PE_apellido,PE_segundo_apellido,PE_website,PE_lugar_id,PE_fecha_nacimiento) VALUES (?,?,?,?,?,?,?,?);";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setInt(1, PE_cedula);
            pst.setString(2, PE_nombre);
            pst.setString(3, PE_segundo_nombre);
            pst.setString(4, PE_apellido);
            pst.setString(5, PE_segundo_apellido);
            pst.setString(6, PE_website);
            pst.setInt(7, PE_lugar_id);
            pst.setDate(8, PE_fecha_nacimiento);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }


    public void modificarDb(ConectorDb conector) {
        try {
            String stm = "UPDATE PERSONA SET PE_cedula = ?,PE_nombre = ?,PE_segundo_nombre = ?,PE_apellido = ?,PE_segundo_apellido = ?,PE_website = ?,PE_lugar_id = ?,PE_fecha_nacimiento = ? WHERE CL_id='" + PE_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setInt(1, PE_cedula);
            pst.setString(2, PE_nombre);
            pst.setString(3, PE_segundo_nombre);
            pst.setString(4, PE_apellido);
            pst.setString(5, PE_segundo_apellido);
            pst.setString(6, PE_website);
            pst.setInt(7, PE_lugar_id);
            pst.setDate(8, PE_fecha_nacimiento);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void eliminarDb(ConectorDb conector) {
        try {
            String stm = "DELETE FROM PERSONA WHERE PE_id ='" + PE_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }
}
