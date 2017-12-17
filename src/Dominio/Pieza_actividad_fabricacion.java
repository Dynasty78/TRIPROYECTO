package Dominio;

import Controller.ConectorDb;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pieza_actividad_fabricacion {
    private int PAF_id;
    private int PAF_pieza_id;
    private int PAF_actividad_id;
    private int PAF_tiempo_estimado;
    private int PAF_orden;
    private int PAF_zona_planta_id;

    public Pieza_actividad_fabricacion(int PAF_pieza_id, int PAF_actividad_id, int PAF_tiempo_estimado, int PAF_orden, int PAF_zona_planta_id) {
        this.PAF_pieza_id = PAF_pieza_id;
        this.PAF_actividad_id = PAF_actividad_id;
        this.PAF_tiempo_estimado = PAF_tiempo_estimado;
        this.PAF_orden = PAF_orden;
        this.PAF_zona_planta_id = PAF_zona_planta_id;
    }

    public void agregarDb(ConectorDb conector) {
        try {
            String stm = "INSERT INTO Pieza_actividad_fabricacion(PAF_pieza_id,PAF_actividad_id,PAF_tiempo_estimado,PAF_orden,PAF_zona_planta_id) VALUES (?,?,?,?,?);";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setInt(1, PAF_pieza_id);
            pst.setInt(2,PAF_actividad_id);
            pst.setInt(2,PAF_tiempo_estimado);
            pst.setInt(2,PAF_orden);
            pst.setInt(2,PAF_zona_planta_id);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void modificarDb(ConectorDb conector) {
        try {
            String stm = "UPDATE Pieza_actividad_fabricacion SET PAF_pieza_id = ?, PAF_actividad_id = ?, PAF_tiempo_estimado = ?, PAF_orden = ?, PAF_zona_planta_id WHERE PAF_id='" + PAF_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setInt(1, PAF_pieza_id);
            pst.setInt(2,PAF_actividad_id);
            pst.setInt(2,PAF_tiempo_estimado);
            pst.setInt(2,PAF_orden);
            pst.setInt(2,PAF_zona_planta_id);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void eliminarDb(ConectorDb conector) {
        try {
            String stm = "DELETE FROM Pieza_actividad_fabricacion WHERE SP_id ='" + PAF_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }
}
