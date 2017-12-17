
package Dominio;

import Controller.ConectorDb;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pieza {
    private int PI_id;
    private String PI_nombre;
    private String PI_descripcion;
    private int PI_tipo_pieza;

    public int getPI_id() {
        return PI_id;
    }

    public void setPI_id(int PI_id) {
        this.PI_id = PI_id;
    }

    public String getPI_nombre() {
        return PI_nombre;
    }

    public void setPI_nombre(String PI_nombre) {
        this.PI_nombre = PI_nombre;
    }

    public String getPI_descripcion() {
        return PI_descripcion;
    }

    public void setPI_descripcion(String PI_descripcion) {
        this.PI_descripcion = PI_descripcion;
    }

    public int getPI_tipo_pieza() {
        return PI_tipo_pieza;
    }

    public void setPI_tipo_pieza(int PI_tipo_pieza) {
        this.PI_tipo_pieza = PI_tipo_pieza;
    }

    public void agregarDb(ConectorDb conector) {
        try {
            String stm = "INSERT INTO PIEZA(PI_nombre,PI_descripcion,PI_tipo_pieza) VALUES (?,?,?);";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setString(1, PI_nombre);
            pst.setString(2, PI_descripcion);
            pst.setInt(3, PI_tipo_pieza);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }


    public void modificarDb(ConectorDb conector) {
        try {
            String stm = "UPDATE PIEZA SET PI_nombre = ?, PI_descripcion = ?, PI_tipo_pieza = ? WHERE PI_id='" + PI_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.setString(1, PI_nombre);
            pst.setString(2, PI_descripcion);
            pst.setInt(3, PI_tipo_pieza);

            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }

    public void eliminarDb(ConectorDb conector) {
        try {
            String stm = "DELETE FROM PIEZA WHERE PI_id ='" + PI_id + "'";
            PreparedStatement pst = conector.conexion.prepareStatement(stm);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }
}
