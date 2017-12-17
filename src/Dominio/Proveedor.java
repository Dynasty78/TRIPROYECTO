package Dominio;

import Controller.ConectorDb;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Proveedor {
    private int PR_id;
    private double PR_monto_acreditado;
    private Date PR_fecha_inicio_operaciones;
    private int PR_persona_id;


    public Proveedor(double PR_monto_acreditado, Date PR_fecha_inicio_operaciones, int PR_persona_id) {
        this.PR_monto_acreditado = PR_monto_acreditado;
        this.PR_fecha_inicio_operaciones = PR_fecha_inicio_operaciones;
        this.PR_persona_id = PR_persona_id;
    }

    public Proveedor(int PR_id, double PR_monto_acreditado, Date PR_fecha_inicio_operaciones, int PR_persona_id) {
        this.PR_id = PR_id;
        this.PR_monto_acreditado = PR_monto_acreditado;
        this.PR_fecha_inicio_operaciones = PR_fecha_inicio_operaciones;
        this.PR_persona_id = PR_persona_id;
    }

    public int getPR_id() {
        return PR_id;
    }

    public void setPR_id(int PR_id) {
        this.PR_id = PR_id;
    }

    public double getPR_monto_acreditado() {
        return PR_monto_acreditado;
    }

    public void setPR_monto_acreditado(double PR_monto_acreditado) {
        this.PR_monto_acreditado = PR_monto_acreditado;
    }

    public Date getPR_fecha_inicio_operaciones() {
        return PR_fecha_inicio_operaciones;
    }

    public void setPR_fecha_inicio_operaciones(Date PR_fecha_inicio_operaciones) {
        this.PR_fecha_inicio_operaciones = PR_fecha_inicio_operaciones;
    }

    public int getPR_persona_id() {
        return PR_persona_id;
    }

    public void setPR_persona_id(int PR_persona_id) {
        this.PR_persona_id = PR_persona_id;
    }

    public void agregarDb(ConectorDb conector) {
        try {
            String stm = "INSERT INTO PROVEEDOR(PR_monto_acreditado,PR_persona_id) VALUES (?,?);";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setDouble(1, PR_monto_acreditado);
            pst.setInt(2, PR_persona_id);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void modificarDb(ConectorDb conector) {
        try {
            String stm = "UPDATE PROVEEDOR SET PR_monto_acreditado = ?, PR_persona_id = ? WHERE CL_id='" + PR_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setDouble(1, PR_monto_acreditado);
            pst.setInt(2, PR_persona_id);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void eliminarDb(ConectorDb conector) {
        try {
            String stm = "DELETE FROM PROVEEDOR WHERE PR_id ='" + PR_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

}

