package Dominio;

import Controller.ConectorDb;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Solicitud_pieza_actividad_fabricacion {

    private int SPAF_solicitud_pieza_id;
    private int SPAF_pieza_actividad_fabricacion_id;
    private Date SPAF_fecha_inicio;
    private Date SPAF_fecha_fin;
    private Boolean SPAF_aprobado;
    private int SPAF_zona_planta_id;
    private int SPAF_pieza_id;
    private int SPAF_solicitud_id_avion;

    public Solicitud_pieza_actividad_fabricacion(int SPAF_solicitud_pieza_id, int SPAF_pieza_id) {
        this.SPAF_solicitud_pieza_id = SPAF_solicitud_pieza_id;
        this.SPAF_pieza_id = SPAF_pieza_id;
    }

    public void agregarDb(ConectorDb conector) {
        try {
            String stm = "INSERT INTO Solicitud_pieza_actividad_fabricacion(SPAF_solicitud_pieza_id,SPAF_pieza_actividad_fabricacion_id) VALUES (?,?);";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setInt(1, SPAF_solicitud_pieza_id);
            pst.setInt(2,SPAF_pieza_actividad_fabricacion_id);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println("aqui2");
            System.out.print(ex.toString());
        }
    }

    public void generarSPAF(ConectorDb conector){
        try {
            String stm = 
                "SELECT paf.paf_id, af_nombre, paf.paf_orden "+
                "FROM actividad_fabricacion af "+
                "INNER JOIN pieza_actividad_fabricacion paf ON af.af_id = paf.paf_actividad_id "+
                "INNER JOIN pieza pz ON paf.paf_pieza_id = pz.pi_id "+
                "WHERE pz.pi_id =" + SPAF_pieza_id + " "+
                "ORDER BY paf.paf_orden";

            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                this.SPAF_pieza_actividad_fabricacion_id = rs.getInt("PAF_id");
                agregarDb(conector);
            }
        } catch (SQLException ex) {
            System.out.println("sucede acqui");
            System.out.print(ex.toString());
        }
    }

    public void modificarDb(ConectorDb conector) {
        try {
            String stm = "UPDATE Pieza_actividad_fabricacion SET SPAF_solicitud_pieza_id = ?, SPAF_pieza_actividad_fabricacion_id = ?, SPAF_aprobado = ?, PAF_zona_planta_id = ?,SPAF_fecha_fin = ? WHERE SPAF_solicitud_pieza_id='" + SPAF_solicitud_pieza_id + " AND SPAF_pieza_actividad_fabricacion_id = '"+SPAF_pieza_actividad_fabricacion_id+"' '";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setInt(1, SPAF_solicitud_pieza_id);
            pst.setInt(2,SPAF_pieza_actividad_fabricacion_id);
            pst.setBoolean(3,SPAF_aprobado);
            pst.setInt(4,SPAF_zona_planta_id);
            pst.setDate(5,SPAF_fecha_fin);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }
}
