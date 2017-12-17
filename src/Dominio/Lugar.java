package Dominio;

public class Lugar {
    private int LU_id;
    private String LU_nombre;
    private String LU_tipo;

    public Lugar(int LU_id, String LU_nombre, String LU_tipo) {
        this.LU_id = LU_id;
        this.LU_nombre = LU_nombre;
        this.LU_tipo = LU_tipo;
    }

    public int getLU_id() {
        return LU_id;
    }

    public String getLU_nombre() {
        return LU_nombre;
    }

    public String getLU_tipo() {
        return LU_tipo;
    }


}