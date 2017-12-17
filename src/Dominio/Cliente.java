package Dominio;

import Controller.ConectorDb;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cliente {
    private int CL_id;
    private double CL_monto_acreditado;
    private Date CL_fecha_inicio_operaciones;
    private int CL_persona_id;

    public Cliente(double CL_monto_acreditado, int CL_persona_id) {
        this.CL_monto_acreditado = CL_monto_acreditado;
        this.CL_persona_id = CL_persona_id;
    }

    public Cliente(int CL_id, double CL_monto_acreditado, Date CL_fecha_inicio_operaciones, int CL_persona_id) {
        this.CL_id = CL_id;
        this.CL_monto_acreditado = CL_monto_acreditado;
        this.CL_fecha_inicio_operaciones = CL_fecha_inicio_operaciones;
        this.CL_persona_id = CL_persona_id;
    }

    public int getCL_id() {
        return CL_id;
    }

    public void setCL_id(int CL_id) {
        this.CL_id = CL_id;
    }

    public double getCL_monto_acreditado() {
        return CL_monto_acreditado;
    }

    public void setCL_monto_acreditado(double CL_monto_acreditado) {
        this.CL_monto_acreditado = CL_monto_acreditado;
    }

    public Date getCL_fecha_inicio_operaciones() {
        return CL_fecha_inicio_operaciones;
    }

    public void setCL_fecha_inicio_operaciones(Date CL_fecha_inicio_operaciones) {
        this.CL_fecha_inicio_operaciones = CL_fecha_inicio_operaciones;
    }

    public int getCL_persona_id() {
        return CL_persona_id;
    }

    public void setCL_persona_id(int CL_persona_id) {
        this.CL_persona_id = CL_persona_id;
    }

    public void agregarDb(ConectorDb conector) {
        try {
            String stm = "INSERT INTO CLIENTE(CL_monto_acreditado,CL_persona_id) VALUES (?,?);";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setDouble(1, CL_monto_acreditado);
            pst.setInt(2, CL_persona_id);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void modificarDb(ConectorDb conector) {
        try {
            String stm = "UPDATE Cliente SET CL_monto_acreditado = ?, CL_persona_id = ? WHERE CL_id='" + CL_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setDouble(1, CL_monto_acreditado);
            pst.setInt(2, CL_persona_id);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println("aqui");
            System.out.print(ex.toString());
        }
    }

    public void eliminarDb(ConectorDb conector) {
        try {
            String stm = "DELETE FROM CLIENTE WHERE CL_id ='" + CL_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    private static java.sql.Timestamp getCurrentTimeStamp() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());

    }
}
