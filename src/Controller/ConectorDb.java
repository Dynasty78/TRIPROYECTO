package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectorDb {

    public Connection conexion;

    public ConectorDb() {
        this.conexion = conexion;
    }

    public void conectar() {
        conexion = null;
        String urlDatabase = "jdbc:postgresql://localhost/cliente";
        String user = "postgres";
        String password = "chuo1997";
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(urlDatabase, user, password);
        } catch (Exception e) {
            System.out.print(e.toString());
        }

    }

    public void desconectar() {
        if (conexion != null) try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
    }


}
