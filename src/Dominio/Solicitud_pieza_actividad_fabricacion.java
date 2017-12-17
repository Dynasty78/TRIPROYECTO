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




    public Solicitud_pieza_actividad_fabricacion(int SPAF_solicitud_pieza_id, int SPAF_solicitud_id_avion,int SPAF_pieza_id) {
        this.SPAF_solicitud_pieza_id = SPAF_solicitud_pieza_id;
        this.SPAF_solicitud_id_avion = SPAF_solicitud_id_avion;
        this.SPAF_pieza_id = SPAF_pieza_id;
        this.SPAF_aprobado = false;
    }

    public void agregarDb(ConectorDb conector) {
        try {
            String stm = "INSERT INTO Solicitud_pieza_actividad_fabricacion(SPAF_solicitud_pieza_id,SPAF_pieza_actividad_fabricacion_id,SPAF_aprobado) VALUES (?,?,?);";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setInt(1, SPAF_solicitud_pieza_id);
            pst.setInt(2,SPAF_pieza_actividad_fabricacion_id);
            pst.setBoolean(3,SPAF_aprobado);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.println("aqui2");
            System.out.print(ex.toString());
        }
    }

    public void generarSPAF(ConectorDb conector){
        try {
            String stm = "SELECT PAF_id FROM actividad_fabricacion,pieza,solicitud_pieza,pieza_actividad_fabricacion,solicitud_avion WHERE sp_pieza_id = pi_id AND paf_pieza_id = '"+SPAF_pieza_id+"' AND paf_actividad_id = af_id AND sp_id = '"+SPAF_solicitud_pieza_id+"' AND sa_id = '"+SPAF_solicitud_id_avion+"';";
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
