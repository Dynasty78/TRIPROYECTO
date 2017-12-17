package Interfaz;

import Controller.ConectorDb;
import Controller.Controladora;
import javax.swing.JOptionPane;

public class NuevoUsuarioCliente extends javax.swing.JFrame {

    Controladora control;
    ConectorDb conector;
    public NuevoUsuarioCliente() {
        initComponents();
        control = new Controladora();
        control.iniciaVentana(this);
        control.cargarEstado(estadoComboBox);
        control.cargarNumTlf(numTlf_1);
        control.cargarNumTlf(numTlf_2);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        primerNombreTxt = new javax.swing.JTextField();
        segundoNombreTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        segundoApellidoTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        primerApellidoTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cedulaTxt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        websiteTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tlf1 = new javax.swing.JTextField();
        tl2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        numTlf_2 = new javax.swing.JComboBox<>();
        numTlf_1 = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        calleTxt = new javax.swing.JTextField();
        jSeparator17 = new javax.swing.JSeparator();
        parroquiaComboBox = new javax.swing.JComboBox<>();
        estadoComboBox = new javax.swing.JComboBox<>();
        munComboBox = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        crearUserBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(25, 118, 210));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Crear Nuevo Usuario Cliente");

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("X");
        jLabel16.setToolTipText("");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("_");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(25, 118, 210));
        jButton3.setText("Editar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(260, 584, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18))
                .addGap(1, 1, 1)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(25, 118, 210), 2, true));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(25, 118, 210), 2, true));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setText("Primer Nombre");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel3.setText("Segundo Nombre");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, -1, -1));

        primerNombreTxt.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        primerNombreTxt.setText("Primer Nombre");
        primerNombreTxt.setBorder(null);
        primerNombreTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                primerNombreTxtFocusGained(evt);
            }
        });
        jPanel3.add(primerNombreTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 33, 113, 19));

        segundoNombreTxt.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        segundoNombreTxt.setText("Segundo Nombre");
        segundoNombreTxt.setBorder(null);
        jPanel3.add(segundoNombreTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 86, 110, 19));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setText("Primer Apellido");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        segundoApellidoTxt.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        segundoApellidoTxt.setText("Segundo Apellido");
        segundoApellidoTxt.setBorder(null);
        jPanel3.add(segundoApellidoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 110, 19));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setText("Segundo Apellido");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        primerApellidoTxt.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        primerApellidoTxt.setText("Primer Apellido");
        primerApellidoTxt.setBorder(null);
        jPanel3.add(primerApellidoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 110, 19));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel6.setText("Cedula");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        cedulaTxt.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cedulaTxt.setText("Cedula");
        cedulaTxt.setBorder(null);
        jPanel3.add(cedulaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 113, 19));

        jSeparator1.setBackground(new java.awt.Color(25, 118, 210));
        jSeparator1.setForeground(new java.awt.Color(25, 118, 210));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 58, 120, 10));

        jSeparator2.setBackground(new java.awt.Color(25, 118, 210));
        jSeparator2.setForeground(new java.awt.Color(25, 118, 210));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 111, 110, 10));

        jSeparator3.setBackground(new java.awt.Color(25, 118, 210));
        jSeparator3.setForeground(new java.awt.Color(25, 118, 210));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 110, 10));

        jSeparator4.setBackground(new java.awt.Color(25, 118, 210));
        jSeparator4.setForeground(new java.awt.Color(25, 118, 210));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 110, 10));

        jSeparator5.setBackground(new java.awt.Color(25, 118, 210));
        jSeparator5.setForeground(new java.awt.Color(25, 118, 210));
        jSeparator5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel3.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 110, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(25, 118, 210), 2, true));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel7.setText("Nombre de Empresa");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel8.setText("Pagina Web");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, -1, -1));

        jTextField6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextField6.setText("Nombre de empresa");
        jTextField6.setBorder(null);
        jPanel4.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 33, 730, 19));

        websiteTxt.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        websiteTxt.setText("Pagina Web");
        websiteTxt.setBorder(null);
        websiteTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                websiteTxtActionPerformed(evt);
            }
        });
        jPanel4.add(websiteTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 86, 730, 19));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel9.setText("Monto Acreditado");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jTextField9.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextField9.setText("Monto Acreditado");
        jTextField9.setBorder(null);
        jPanel4.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 190, 19));

        jSeparator6.setBackground(new java.awt.Color(25, 118, 210));
        jSeparator6.setForeground(new java.awt.Color(25, 118, 210));
        jPanel4.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 730, 10));

        jSeparator10.setBackground(new java.awt.Color(25, 118, 210));
        jSeparator10.setForeground(new java.awt.Color(25, 118, 210));
        jSeparator10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel4.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 110, -1));

        jSeparator11.setBackground(new java.awt.Color(25, 118, 210));
        jSeparator11.setForeground(new java.awt.Color(25, 118, 210));
        jPanel4.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 58, 730, 10));

        jSeparator12.setBackground(new java.awt.Color(25, 118, 210));
        jSeparator12.setForeground(new java.awt.Color(25, 118, 210));
        jPanel4.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 730, 10));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(25, 118, 210), 2, true));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel12.setText("Numero de telefono 1");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel13.setText("Numero de telefono 2");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, -1, -1));

        tlf1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tlf1.setText("9434721");
        tlf1.setBorder(null);
        jPanel5.add(tlf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 50, 19));

        tl2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tl2.setText("9434721");
        tl2.setBorder(null);
        jPanel5.add(tl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 50, 19));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel14.setText("Correo Electronico");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        email.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        email.setText("josejecr97@gmail.com");
        email.setBorder(null);
        jPanel5.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 180, 19));

        jSeparator13.setBackground(new java.awt.Color(25, 118, 210));
        jSeparator13.setForeground(new java.awt.Color(25, 118, 210));
        jPanel5.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 50, 10));

        jSeparator14.setBackground(new java.awt.Color(25, 118, 210));
        jSeparator14.setForeground(new java.awt.Color(25, 118, 210));
        jPanel5.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 50, 10));

        jSeparator15.setBackground(new java.awt.Color(25, 118, 210));
        jSeparator15.setForeground(new java.awt.Color(25, 118, 210));
        jPanel5.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 180, 10));

        numTlf_2.setBackground(new java.awt.Color(25, 118, 210));
        numTlf_2.setForeground(new java.awt.Color(25, 118, 210));
        jPanel5.add(numTlf_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        numTlf_1.setBackground(new java.awt.Color(25, 118, 210));
        numTlf_1.setForeground(new java.awt.Color(25, 118, 210));
        jPanel5.add(numTlf_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(25, 118, 210), 2, true));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel10.setText("Estado");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel11.setText("Municipio");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel15.setText("Parroquia");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel17.setText("Calle");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        calleTxt.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        calleTxt.setText("Calle");
        calleTxt.setBorder(null);
        jPanel6.add(calleTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 113, 19));

        jSeparator17.setBackground(new java.awt.Color(25, 118, 210));
        jSeparator17.setForeground(new java.awt.Color(25, 118, 210));
        jSeparator17.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel6.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 110, -1));

        parroquiaComboBox.setBackground(new java.awt.Color(25, 118, 210));
        parroquiaComboBox.setForeground(new java.awt.Color(25, 118, 210));
        parroquiaComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parroquiaComboBoxActionPerformed(evt);
            }
        });
        jPanel6.add(parroquiaComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 60, -1));

        estadoComboBox.setBackground(new java.awt.Color(25, 118, 210));
        estadoComboBox.setForeground(new java.awt.Color(25, 118, 210));
        estadoComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                estadoComboBoxItemStateChanged(evt);
            }
        });
        estadoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoComboBoxActionPerformed(evt);
            }
        });
        jPanel6.add(estadoComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        munComboBox.setBackground(new java.awt.Color(25, 118, 210));
        munComboBox.setForeground(new java.awt.Color(25, 118, 210));
        munComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                munComboBoxActionPerformed(evt);
            }
        });
        jPanel6.add(munComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(25, 118, 210));
        jButton1.setText("Atras");

        crearUserBtn.setBackground(new java.awt.Color(255, 255, 255));
        crearUserBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        crearUserBtn.setForeground(new java.awt.Color(25, 118, 210));
        crearUserBtn.setText("Crear Usuario");
        crearUserBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crearUserBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(crearUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(crearUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 117, 860, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void websiteTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_websiteTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_websiteTxtActionPerformed

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
       this.setState(NuevoUsuarioCliente.ICONIFIED);
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Desea salir?","SALIR",dialogButton);
        if (result == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel16MouseClicked

    
    private void estadoComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_estadoComboBoxItemStateChanged
    }//GEN-LAST:event_estadoComboBoxItemStateChanged

    private void estadoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoComboBoxActionPerformed
        String x = (String)estadoComboBox.getSelectedItem();
        control.cargarMunicipio(x,munComboBox);
    }//GEN-LAST:event_estadoComboBoxActionPerformed

    private void parroquiaComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parroquiaComboBoxActionPerformed

    }//GEN-LAST:event_parroquiaComboBoxActionPerformed

    private void munComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_munComboBoxActionPerformed
        String estado = (String)estadoComboBox.getSelectedItem();
        String municipio = (String)munComboBox.getSelectedItem();
        control.cargarParroquia(estado,municipio,parroquiaComboBox);
    }//GEN-LAST:event_munComboBoxActionPerformed

    private void crearUserBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearUserBtnMouseClicked
    String primerNombre = primerNombreTxt.getText();
    String segundoNombre = segundoNombreTxt.getText();
    String primerApellido = primerApellidoTxt.getText();
    String segundoApellido = segundoApellidoTxt.getText();
    String website = websiteTxt.getText();
    //int PE_lugar_id = (int) parroquiaComboBox.getSelectedItem();
    int cedula = Integer.parseInt(cedulaTxt.getText());
        
        
        
        
    //Persona p = new Persona();
//int PE_cedula, String PE_nombre, String PE_segundo_nombre, String PE_apellido, String PE_segundo_apellido, String PE_website, int PE_lugar_id, Date PE_fecha_nacimiento        
        
        
        
        
    }//GEN-LAST:event_crearUserBtnMouseClicked

    private void primerNombreTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_primerNombreTxtFocusGained
    }//GEN-LAST:event_primerNombreTxtFocusGained

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NuevoUsuarioCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoUsuarioCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoUsuarioCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoUsuarioCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoUsuarioCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField calleTxt;
    private javax.swing.JTextField cedulaTxt;
    private javax.swing.JButton crearUserBtn;
    private javax.swing.JTextField email;
    private javax.swing.JComboBox<String> estadoComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JComboBox<String> munComboBox;
    private javax.swing.JComboBox<String> numTlf_1;
    private javax.swing.JComboBox<String> numTlf_2;
    private javax.swing.JComboBox<String> parroquiaComboBox;
    private javax.swing.JTextField primerApellidoTxt;
    private javax.swing.JTextField primerNombreTxt;
    private javax.swing.JTextField segundoApellidoTxt;
    private javax.swing.JTextField segundoNombreTxt;
    private javax.swing.JTextField tl2;
    private javax.swing.JTextField tlf1;
    private javax.swing.JTextField websiteTxt;
    // End of variables declaration//GEN-END:variables
}
