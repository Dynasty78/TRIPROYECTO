
package Interfaz;

import Controller.ConectorDb;
import Controller.Controladora;
import Dominio.Cliente;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class ListadeAviones extends javax.swing.JFrame {

    Controladora control;
    ConectorDb conector;
    Cliente cl;
    JFrame atras;
    
    public ListadeAviones() {
        initComponents();
        control = new Controladora();
        conector = new ConectorDb();
        conector.conectar();
        control.iniciaVentana(this);
        control.llenarTabla(listaAviones,control.getResultSet(conector,"select av_id,av_nombre from avion"));
    }
    
    public ListadeAviones(JFrame ventana,Cliente cl) {
        initComponents();
        control = new Controladora();
        conector = new ConectorDb();
        conector.conectar();
        control.iniciaVentana(this);
        atras = ventana;
        this.cl = cl;
        control.llenarTabla(listaAviones,control.getResultSet(conector,"select av_id,av_nombre from avion"));
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
        listaAviones = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        nombreAvionLbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblLongitud = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblEnvergadura = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblPeso = new javax.swing.JLabel();
        DetalleAvion = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(25, 118, 210));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Aviones en venta");

        jLabel98.setBackground(new java.awt.Color(255, 255, 255));
        jLabel98.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(255, 255, 255));
        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel98.setText("X");
        jLabel98.setToolTipText("");
        jLabel98.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                .addContainerGap(794, Short.MAX_VALUE)
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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 90));

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaAviones.setModel(new javax.swing.table.DefaultTableModel(
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
        listaAviones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaAvionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaAviones);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 48, 368, 415));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Add_User_Group_Man_Man_50px.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 48, 284, 167));

        nombreAvionLbl.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        nombreAvionLbl.setText("AIRUCAB XXX");
        jPanel2.add(nombreAvionLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 221, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setText("Caracteristicas:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 262, 156, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel6.setText("Longitud:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 291, 156, -1));

        lblLongitud.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblLongitud.setText("XXXXXXXXXXXXX");
        jPanel2.add(lblLongitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 291, -1, -1));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel8.setText("Envergadura:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 320, 156, -1));

        lblEnvergadura.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblEnvergadura.setText("XXXXXXXXX");
        jPanel2.add(lblEnvergadura, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 320, 156, -1));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel10.setText("Peso:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 349, 64, -1));

        lblPeso.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblPeso.setText("XXXXXXXX");
        jPanel2.add(lblPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, 261, -1));

        DetalleAvion.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        DetalleAvion.setForeground(new java.awt.Color(0, 51, 204));
        DetalleAvion.setText("Detalle de avion");
        DetalleAvion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DetalleAvion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DetalleAvionMouseClicked(evt);
            }
        });
        DetalleAvion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetalleAvionActionPerformed(evt);
            }
        });
        jPanel2.add(DetalleAvion, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 440, -1, -1));

        jButton2.setForeground(new java.awt.Color(0, 51, 204));
        jButton2.setText("Atras");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 440, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 67, 850, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void DetalleAvionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetalleAvionActionPerformed
        
    }//GEN-LAST:event_DetalleAvionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed


    private void jLabel99MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel99MouseClicked
       this.setState(ListadeAviones.ICONIFIED);
    }//GEN-LAST:event_jLabel99MouseClicked

    private void jLabel98MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel98MouseClicked
       int dialogButton = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Desea salir?","SALIR",dialogButton);
        if (result == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel98MouseClicked

    private void DetalleAvionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DetalleAvionMouseClicked
        DetalleDeAvion ventana = new DetalleDeAvion(this,control.getIndex(listaAviones),cl);
        control.activaVentana(ventana, this);
        
        
    }//GEN-LAST:event_DetalleAvionMouseClicked

    private void listaAvionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaAvionesMouseClicked
        control.buildCaracteristica(conector,listaAviones, nombreAvionLbl, lblEnvergadura, lblLongitud, lblPeso);
    }//GEN-LAST:event_listaAvionesMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        control.activaVentana(atras, this);
    }//GEN-LAST:event_jButton2MouseClicked

    
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
            java.util.logging.Logger.getLogger(ListadeAviones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadeAviones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadeAviones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadeAviones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ListadeAviones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DetalleAvion;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEnvergadura;
    private javax.swing.JLabel lblLongitud;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JTable listaAviones;
    private javax.swing.JLabel nombreAvionLbl;
    // End of variables declaration//GEN-END:variables
}
