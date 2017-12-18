package Interfaz;
import Interfaz.Cliente.*;
import Controller.ConectorDb;
import Controller.Controladora;
import Dominio.Cliente;
import Dominio.Empleado;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

    public class SolicitudesDeAviones extends javax.swing.JFrame {

    Controladora control;
    ConectorDb conector;
    JFrame ventana;
    Cliente cl;
    Empleado em;
    public SolicitudesDeAviones() {
        initComponents();
        control = new Controladora();
        conector = new ConectorDb();
        conector.conectar();
        control.iniciaVentana(this);
       
    }
    
    public SolicitudesDeAviones(JFrame x,Empleado em) {
        initComponents();
        control = new Controladora();
        conector = new ConectorDb();
        conector.conectar();
        ventana = x;
        this.em = em;
        this.cl = cl;
        control.iniciaVentana(this);
        control.llenarTabla(listaSolicitudes,control.getResultSet(conector,"select sa_id,av_nombre from solicitud_avion, avion where sa_avion_id = av_id"));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaSolicitudes = new javax.swing.JTable();
        nombreAvion = new javax.swing.JLabel();
        tiempoEstimadoLbl = new javax.swing.JLabel();
        tiempoRealLbl = new javax.swing.JLabel();
        estatusLbl = new javax.swing.JLabel();
        solicitudLbl = new javax.swing.JLabel();
        mispiezasBtn = new javax.swing.JButton();
        atrasBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(25, 118, 210));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Lista de Solicitudes de Aviones");

        jLabel98.setBackground(new java.awt.Color(255, 255, 255));
        jLabel98.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(255, 255, 255));
        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel98.setText("X");
        jLabel98.setToolTipText("");
        jLabel98.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel98MouseClicked(evt);
            }
        });

        jLabel99.setBackground(new java.awt.Color(255, 255, 255));
        jLabel99.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(255, 255, 255));
        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setText("_");
        jLabel99.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel99.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel99MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(558, Short.MAX_VALUE)
                .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel98)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel98)
                    .addComponent(jLabel99))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(0, 28, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 90));

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaSolicitudes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        listaSolicitudes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaSolicitudesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaSolicitudes);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 550, 420));

        nombreAvion.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jPanel2.add(nombreAvion, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 221, -1, -1));

        tiempoEstimadoLbl.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jPanel2.add(tiempoEstimadoLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(444, 239, -1, -1));

        tiempoRealLbl.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jPanel2.add(tiempoRealLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(444, 245, -1, -1));

        estatusLbl.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jPanel2.add(estatusLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 251, -1, -1));

        solicitudLbl.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jPanel2.add(solicitudLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(444, 257, -1, -1));

        mispiezasBtn.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        mispiezasBtn.setForeground(new java.awt.Color(0, 102, 255));
        mispiezasBtn.setText("Mis Piezas");
        mispiezasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mispiezasBtnActionPerformed(evt);
            }
        });
        jPanel2.add(mispiezasBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 470, -1, -1));

        atrasBtn.setText("Atras");
        atrasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBtnActionPerformed(evt);
            }
        });
        jPanel2.add(atrasBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 67, 610, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel99MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel99MouseClicked
        this.setState(SolicitudesDeAviones.ICONIFIED);
    }//GEN-LAST:event_jLabel99MouseClicked

    private void jLabel98MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel98MouseClicked
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Desea salir?","SALIR",dialogButton);
        if (result == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel98MouseClicked

    private void atrasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBtnActionPerformed
        control.activaVentana(ventana, this);
    }//GEN-LAST:event_atrasBtnActionPerformed

    private void mispiezasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mispiezasBtnActionPerformed
        MisPiezas ventana = new MisPiezas(this,em,control.getIndex(listaSolicitudes));
        control.activaVentana(ventana, this);
    }//GEN-LAST:event_mispiezasBtnActionPerformed

    private void listaSolicitudesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaSolicitudesMouseClicked
     
        
        
        
        
        
        
        
    }//GEN-LAST:event_listaSolicitudesMouseClicked

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
            java.util.logging.Logger.getLogger(SolicitudesDeAviones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SolicitudesDeAviones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SolicitudesDeAviones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SolicitudesDeAviones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new SolicitudesDeAviones().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atrasBtn;
    private javax.swing.JLabel estatusLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listaSolicitudes;
    private javax.swing.JButton mispiezasBtn;
    private javax.swing.JLabel nombreAvion;
    private javax.swing.JLabel solicitudLbl;
    private javax.swing.JLabel tiempoEstimadoLbl;
    private javax.swing.JLabel tiempoRealLbl;
    // End of variables declaration//GEN-END:variables
}
