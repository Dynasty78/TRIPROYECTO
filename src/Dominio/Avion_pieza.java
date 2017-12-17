package Dominio;

public class Avion_pieza {
    private int AP_avion_id;
    private int AP_pieza_id;
    private int AP_cantidad_pieza;

    public Avion_pieza(int AP_avion_id, int AP_pieza_id, int AP_cantidad_pieza) {
        this.AP_avion_id = AP_avion_id;
        this.AP_pieza_id = AP_pieza_id;
        this.AP_cantidad_pieza = AP_cantidad_pieza;
    }

    public Avion_pieza(int AP_pieza_id, int AP_cantidad_pieza) {
        this.AP_pieza_id = AP_pieza_id;
        this.AP_cantidad_pieza = AP_cantidad_pieza;
    }

    public int getAP_avion_id() {
        return AP_avion_id;
    }

    public void setAP_avion_id(int AP_avion_id) {
        this.AP_avion_id = AP_avion_id;
    }

    public int getAP_pieza_id() {
        return AP_pieza_id;
    }

    public void setAP_pieza_id(int AP_pieza_id) {
        this.AP_pieza_id = AP_pieza_id;
    }

    public int getAP_cantidad_pieza() {
        return AP_cantidad_pieza;
    }

    public void setAP_cantidad_pieza(int AP_cantidad_pieza) {
        this.AP_cantidad_pieza = AP_cantidad_pieza;
    }



}
