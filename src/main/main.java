package main;

import Controller.ConectorDb;
import Controller.Controladora;
import Dominio.*;

import java.util.Calendar;


public class main {
    public static void main(String[] args) {
        ConectorDb conector = new ConectorDb();
        conector.conectar();
        Controladora control = new Controladora();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1990);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.MONTH, 4); // Assuming you wanted May 1st
        java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
        Solicitud_Avion SA = new Solicitud_Avion(2,1);
        SA.generarSolicitud(conector);

    }
}
