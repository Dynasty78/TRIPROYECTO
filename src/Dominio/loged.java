package Dominio;

public class loged {

    private int codigo,cedula;
    private String tipo;
    private static loged unique;

    // El constructor es privado, no permite que se genere un constructor por defecto.
    private loged(int codigo,String tipo,int cedula) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.cedula = cedula;
    }

    public loged() {
    }
    
    public static loged getSingletonInstance(int codigo,String tipo,int cedula) {
        if (unique == null){
            unique = new loged(codigo,tipo,cedula);
        }
        return unique;
    }

    public static loged getUnique() {
        return unique;
    }    

    public int getCodigo() {
        return codigo;
    }    

    public String getTipo() {
        return tipo;
    }    

    public int getCedula() {
        return cedula;
    }
    
}