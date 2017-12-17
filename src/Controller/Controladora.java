package Controller;

import Dominio.Avion;
import Dominio.Cliente;
import Dominio.Empleado;
import Dominio.Persona;
import Dominio.Planta;
import Dominio.Proveedor;
import Dominio.loged;
import java.sql.Connection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controladora {
    loged log;

    public Controladora() {
    }

    /*-------> Ventanas <-------*/
    public void iniciaVentana(JFrame ventana) {
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
    }

    public void activaVentana(JFrame ventana, JFrame ventana2) {
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana2.dispose();
    }
    /*-----COMBOBOX-----*/
    public void cargarNumTlf(JComboBox combo){
        combo.addItem("0414");
        combo.addItem("0424");
        combo.addItem("0416");
        combo.addItem("0426");
        combo.addItem("0412");
    }
    public void cargarEstado(JComboBox combo){
        String driver = "org.postgresql.Driver";
        String ruta = "jdbc:postgresql://localhost:5432/newdata";
        String user = "postgres";
        String password = "m1l6o9q41m";
        
        try{
            Class.forName(driver);
            Connection conne=(Connection) DriverManager.getConnection(ruta,user,password);
            Statement consulta=(Statement) conne.createStatement();
            ResultSet rs;
            rs = consulta.executeQuery("SELECT * FROM lugar where lu_tipo_id = 'Estado'");
                while (rs.next()){
                    combo.addItem(rs.getString("lu_nombre"));
                }            
         } catch(SQLException e){
             JOptionPane.showMessageDialog(null,e.toString());
        } catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,e);
        } 
    }
    public void cargarMunicipio(String s,JComboBox combo){
        String driver = "org.postgresql.Driver";
        String ruta = "jdbc:postgresql://localhost:5432/newdata";
        String user = "postgres";
        String password = "m1l6o9q41m";
        combo.removeAllItems();
        try{
            Class.forName(driver);
            Connection conne=(Connection) DriverManager.getConnection(ruta,user,password);
            Statement consulta=(Statement) conne.createStatement();
            ResultSet rs;
            rs = consulta.executeQuery("SELECT mu.lu_nombre FROM lugar mu,lugar es WHERE mu.lu_lugar_id = es.lu_id and es.lu_nombre = '"+s+"' ");
                while (rs.next()){
                    combo.addItem(rs.getString("lu_nombre"));
                }            
         } catch(SQLException e){
             JOptionPane.showMessageDialog(null,e);
        } catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,e);
        } 
    }
    public void cargarParroquia(String estado,String municipio,JComboBox combo){
        String driver = "org.postgresql.Driver";
        String ruta = "jdbc:postgresql://localhost:5432/newdata";
        String user = "postgres";
        String password = "m1l6o9q41m";
        combo.removeAllItems();
        try{
            Class.forName(driver);
            Connection conne=(Connection) DriverManager.getConnection(ruta,user,password);
            Statement consulta=(Statement) conne.createStatement();
            ResultSet rs;
            rs = consulta.executeQuery("SELECT pa.lu_nombre FROM lugar mu,lugar es,lugar pa WHERE mu.lu_lugar_id = es.lu_id and pa.lu_lugar_id = mu.lu_id and es.lu_nombre = '"+estado+"' and mu.lu_nombre = '"+municipio+"'");
                while (rs.next()){
                    combo.addItem(rs.getString("lu_nombre"));
                }            
         } catch(SQLException e){
             JOptionPane.showMessageDialog(null,e);
        } catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,e);
        } 
    }   
    public static ResultSet getResultSet(ConectorDb conector, String query) {
        try {
            PreparedStatement pst = conector.conexion.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
        return null;
    }
    public static Planta buscarCodigoPlanta(ConectorDb conector,int id){
        Planta x = null;
        try {
            PreparedStatement pst = conector.conexion.prepareStatement("SELECT PL_ID,PL_NOMBRE,PL_LUGAR WHERE PL_ID = '"+id+"'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int PL_ID = rs.getInt("PL_ID");
                int PL_LUGAR = rs.getInt("PL_LUGAR");
                String PL_NOMBRE = rs.getString("PL_NOMBRE");
                x = new Planta(PL_ID,PL_NOMBRE,PL_LUGAR);
            }
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
        return x;
    }
    
    
    
       public String getUbicacion(ConectorDb conector, int index, String nombreP){
          String ubicacion = "";
        try {
            PreparedStatement pst = conector.conexion.prepareStatement("SELECT LU_NOMBRE AS UBICACION FROM LUGAR, PLANTA WHERE PL_ID = '"+index+"' AND LU_ID = PL_LUGAR_ID");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ubicacion = rs.getString("UBICACION");
                return ubicacion;
            }
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
        return ubicacion;
    }
    
    
    public static void llenarTabla(JTable x, ResultSet rs) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        x.setModel(modelo);
        try {
            while (rs.next()) {
                Object[] fila = new Object[2];

                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                for (int i = 0; i < 2; i++)
                    fila[i] = rs.getObject(i + 1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.

                // Se añade al modelo la fila completa.
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static Persona buscaCodigoPersona(ConectorDb conector, int CEDULA) {
        Persona x = null;
        try { //int PE_id, int PE_cedula, String PE_nombre, String PE_segundo_nombre
            PreparedStatement pst = conector.conexion.prepareStatement("SELECT PE_ID,PE_CEDULA,PE_NOMBRE,PE_SEGUNDO_NOMBRE,PE_APELLIDO,PE_SEGUNDO_APELLIDO,PE_WEBSITE,PE_LUGAR_ID,PE_FECHA_NACIMIENTO FROM PERSONA WHERE PE_CEDULA = '" + CEDULA + "'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int PE_ID = rs.getInt("PE_ID");
                int PE_CEDULA = rs.getInt("PE_CEDULA");
                String PE_NOMBRE = rs.getString("PE_NOMBRE");
                String PE_SEGUNDO_NOMBRE = rs.getString("PE_SEGUNDO_NOMBRE");
                String PE_APELLIDO = rs.getString("PE_APELLIDO");
                String PE_SEGUNDO_APELLIDO = rs.getString("PE_SEGUNDO_APELLIDO");
                String PE_WEBSITE = rs.getString("PE_WEBSITE");
                int PE_LUGAR_ID = rs.getInt("PE_LUGAR_ID");
                Date PE_FECHA_NACIMIENTO = rs.getDate("PE_FECHA_NACIMIENTO");
                x = new Persona(PE_ID, PE_CEDULA, PE_NOMBRE, PE_SEGUNDO_NOMBRE, PE_APELLIDO, PE_SEGUNDO_APELLIDO, PE_WEBSITE, PE_LUGAR_ID, PE_FECHA_NACIMIENTO);
            }
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
        return x;
    }
    
    public String getEnvergadura(ConectorDb conector,int id){
        String envergadura = "";
        try {
            PreparedStatement pst = conector.conexion.prepareStatement("select ac_valor from avion_caracteristica,avion,caracteristica where av_id = ac_avion_id and av_id = '"+id+"' and ca_id = ac_caracteristica_id and ca_nombre = 'Envergadura'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                envergadura = rs.getString("ac_valor");
                return envergadura;
            }
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
        return envergadura;
    }

    public String getLogitud(ConectorDb conector,int id){
        String longitud = "";
        try {
            PreparedStatement pst = conector.conexion.prepareStatement("select ac_valor from avion_caracteristica,avion,caracteristica where av_id = ac_avion_id and av_id = '"+id+"' and ca_id = ac_caracteristica_id and ca_nombre = 'Longitud'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                longitud = rs.getString("ac_valor");
                return longitud;
            }
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
        return longitud;
    }

    public String getPeso(ConectorDb conector,int id){
        String peso = "";
        try {
            PreparedStatement pst = conector.conexion.prepareStatement("select ac_valor from avion_caracteristica,avion,caracteristica where av_id = ac_avion_id and av_id = '"+id+"' and ca_id = ac_caracteristica_id and ca_nombre = 'Peso vacio'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                peso = rs.getString("ac_valor");
                return peso;
            }
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
        return peso;
    }

    public void buildCaracteristica(ConectorDb conector, JTable table, JLabel nombrex, JLabel x, JLabel y, JLabel z){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectedRowIndex = table.getSelectedRow();
        int id = Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());      
        String nombreP = model.getValueAt(selectedRowIndex, 1).toString();     
        nombrex.setText(nombreP);
        String envergadura = getEnvergadura(conector,id);
        String longitud = getLogitud(conector,id);
        String peso = getPeso(conector,id);
        x.setText(envergadura);
        y.setText(longitud);
        z.setText(peso);
    }
    
    public String getDescripcion(ConectorDb conector, int index){
        String descripcion = "";
        try {
            PreparedStatement pst = conector.conexion.prepareStatement("select av_descripcion from avion where av_id ='"+index+"'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                descripcion = rs.getString("av_descripcion");
                return descripcion;
            }
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
        return descripcion;
    }
    
    public String getNombre(ConectorDb conector, int index){
        String nombre = "";
        try {
            PreparedStatement pst = conector.conexion.prepareStatement("select av_nombre from avion where av_id ='"+index+"'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                nombre = rs.getString("av_nombre");
                return nombre;
            }
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
        return nombre;
    }
    
        public int getIndex(JTable x){
        DefaultTableModel model = (DefaultTableModel) x.getModel();
        int selectedRowIndex = x.getSelectedRow();
        int indice = Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());  
        return indice;
    }
    
        public void buildDescripcionCaracteristicas(ResultSet rs,ConectorDb conector,JTable table, int index, JTextArea describir, JLabel nombreP){
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Caracteristica");
        modelo.addColumn("Valor");
        table.setModel(modelo);
        try {
            while (rs.next()) {
                Object[] fila = new Object[2];


                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                for (int i = 0; i < 2; i++)
                    fila[i] = rs.getObject(i + 1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.

                // Se añade al modelo la fila completa.
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
            String descripcion = getDescripcion(conector,index);
            String nombre = getNombre(conector,index);
            describir.setText(descripcion);
            nombreP.setText(nombre); 
        }
        
        public void limpiarCampo(JTextField x){
             x.setText("");
        }
    
   public void build_SA(ConectorDb conector,JTable table,int cl_id,JLabel tiempoEstimado,JLabel tiempoReal,JLabel estatus,JLabel solicitado_por,JLabel nombreAvion){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectedRowIndex = table.getSelectedRow();
        int indice = Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());        
       try {
            PreparedStatement pst = conector.conexion.prepareStatement("SELECT av_nombre,esa_nombre,pe_cedula FROM persona,cliente,solicitud_avion,avion,estatus_solicitud_avion WHERE cl_id = sa_cliente_id AND sa_avion_id = av_id AND cl_persona_id = pe_id AND sa_estatus_id = esa_id AND cl_id = '"+cl_id+"' and sa_id = '"+indice+"'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String av_nombre = rs.getString("av_nombre");
                String esa_nombre = rs.getString("esa_nombre");
                int pe_cedula = rs.getInt("pe_cedula");
                nombreAvion.setText(av_nombre);
                tiempoEstimado.setText("2 MONTHS");
                tiempoReal.setText("2 MONTHS ");
                estatus.setText(esa_nombre);
                solicitado_por.setText(Integer.toString(pe_cedula));               
            }
        } catch (SQLException ex) {
                
                System.out.print(ex.toString());
        }
    }
   
   public void actualizarVentanaplanta(JTable listaP,JLabel nombrePx,JLabel ubicacion, ConectorDb conector, JTable listaE ){
        DefaultTableModel model = (DefaultTableModel) listaP.getModel();
        int selectedRowIndex = listaP.getSelectedRow();
        int indice = Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());      
        String nombreP = model.getValueAt(selectedRowIndex, 1).toString();     
        nombrePx.setText(nombreP);
        String lugar = getUbicacion (conector,indice,nombreP);
        ubicacion.setText(lugar);
        
        Controladora control = new Controladora();
        
        llenarTablaEmpleados(listaE, control.getResultSet(conector,"SELECT zo.zo_nombre as zona, CONCAT(COALESCE(pe_nombre, ''), ' ', COALESCE(pe_segundo_nombre, ''), ' ', COALESCE(pe_apellido, ' '), ' ', COALESCE(pe_segundo_apellido, ' ')) as nombre \n" +
"FROM planta pl \n" +
"INNER JOIN zona_planta zp ON pl.pl_id = zp.zp_planta_id \n" +
"INNER JOIN zona zo ON zp.zp_zona_id = zo.zo_id\n" +
"LEFT JOIN empleado em ON  zo.zo_id = em.em_zona_planta_id\n" +
"LEFT JOIN persona pe ON em.em_persona_id = pe.pe_id\n" +
"WHERE em.em_cargo_id = 1 and pl_id = '"+indice+"'; "));
        
    }  
   
   public static void llenarTablaEmpleados(JTable x, ResultSet rs) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Encargado");
        x.setModel(modelo);
        try {
            while (rs.next()) {
                Object[] fila = new Object[2];

                // Se rellena cada posgetción del array con una de las columnas de la tabla en base de datos.
                for (int i = 0; i < 2; i++)
                    fila[i] = rs.getObject(i + 1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.

                // Se añade al modelo la fila completa.
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
   
   public String castToString(JTextField toCast){
        return toCast.getText().toString();
    }
   
   public int login(String usr,String pw){
        String driver = "org.postgresql.Driver";
        String ruta = "jdbc:postgresql://localhost:5432/newdata";
        String user = "postgres";
        String password = "m1l6o9q41m";
        int i = 0;
        String t;
        int cedula;
         try{
            Class.forName(driver);
            Connection conne=(Connection) DriverManager.getConnection(ruta,user,password);
            Statement consulta=(Statement) conne.createStatement();
            ResultSet rs;
            rs = consulta.executeQuery("select us_persona,us_tipo,pe_cedula from usuario,persona where us_persona = pe_id and us_email = '"+usr+"' and us_password = '"+pw+"'");
            while (rs.next()){
                i = rs.getInt("us_persona");
                t = rs.getString("us_tipo");
                cedula = rs.getInt("pe_cedula");
                log.getSingletonInstance(i,t,cedula);
                return i;
            }

         } catch(SQLException e){
             JOptionPane.showMessageDialog(null,e);
        } catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,e);
        } 
         return i;
    }
   
   public static Cliente buscaCodigoCliente(ConectorDb conector, int codigo) {
        Cliente x = null;
        try {
            PreparedStatement pst = conector.conexion.prepareStatement("SELECT CL_ID,CL_MONTO_ACREDITADO,CL_FECHA_INICIO_OPERACIONES,CL_PERSONA_ID FROM CLIENTE, PERSONA WHERE CL_PERSONA_ID = '"+codigo+"'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("CL_ID");
                int MONTO_ACREDITADO = rs.getInt("CL_MONTO_ACREDITADO");
                Date FECHA_INICIO = rs.getDate("CL_FECHA_INICIO_OPERACIONES");
                int CL_PERSONA_ID = rs.getInt("CL_PERSONA_ID");
                x = new Cliente(ID,MONTO_ACREDITADO,FECHA_INICIO,CL_PERSONA_ID);
            }
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
        return x;
    }
   
   public static Proveedor buscaCodigoProveedor(ConectorDb conector, int codigo) {
        Proveedor x = null;
            try {
                PreparedStatement pst = conector.conexion.prepareStatement("SELECT PR_ID,PR_MONTO_ACREDITADO,PR_FECHA_INICIO_OPERACIONES,PR_PERSONA_ID FROM PROVEEDOR WHERE PR_PERSONA_ID = '" + codigo + "'");
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    int PR_ID = rs.getInt("PR_ID");
                    double PR_MONTO_ACREDITADO = rs.getDouble("PR_MONTO_ACREDITADO");
                    Date fechaInicio = rs.getDate("PR_FECHA_INICIO_OPERACIONES");
                    int PR_PERSONA_ID = rs.getInt("PR_PERSONA_ID");
                    x = new Proveedor(PR_ID, PR_MONTO_ACREDITADO, fechaInicio, PR_PERSONA_ID);
                }
            } catch (SQLException ex) {
                System.out.print(ex.toString());
            }
            return x;
    } 
   
   public static Empleado buscaCodigoEmp(ConectorDb conector, int codigo) {
        Empleado x = null;
        try {
            PreparedStatement pst = conector.conexion.prepareStatement("SELECT EM_ID,EM_FECHA_INICIO,EM_TITULO,EM_PERSONA_ID,EM_ZONA_PLANTA_ID,EM_CARGO_ID FROM EMPLEADO WHERE EM_PERSONA_ID = '"+codigo+"'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("EM_ID");
                Date fechaInicio = rs.getDate("EM_FECHA_INICIO");
                String titulo = rs.getString("EM_TITULO");
                int EM_PER_ID = rs.getInt("EM_PERSONA_ID");
                int EM_ZONA_PLANTA_ID = rs.getInt("EM_ZONA_PLANTA_ID");
                int EM_CARGO_ID = rs.getInt("EM_CARGO_ID");
                x = new Empleado(ID,fechaInicio,titulo,EM_PER_ID,EM_ZONA_PLANTA_ID,EM_CARGO_ID);
            }
        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }
        return x;
    }
   
   
}
