package Interfaz;

import Controller.ConectorDb;
import Controller.Controladora;
import Dominio.*;
import java.sql.ResultSet;

public class PiezasPorPlanta extends javax.swing.JFrame {
    Controladora control;
    ConectorDb conector;
    
    public PiezasPorPlanta(int idPlanta) {
        initComponents();
        control = new Controladora();
        conector = new ConectorDb();
        conector.conectar();   
    }
    
    public PiezasPorPlanta() {
        initComponents();
        control = new Controladora();
        conector = new ConectorDb();
        conector.conectar();   
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
        listaPlantas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblUbicacion = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jlTiempoReal = new javax.swing.JLabel();
        tiempoEstimado = new javax.swing.JLabel();
        tiempoReal = new javax.swing.JLabel();
        jlTiempoEstimado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(25, 118, 210));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Lista de Plantas");

        jLabel98.setBackground(new java.awt.Color(255, 255, 255));
        jLabel98.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(255, 255, 255));
        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel98.setText("X");
        jLabel98.setToolTipText("");

        jLabel99.setBackground(new java.awt.Color(255, 255, 255));
        jLabel99.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(255, 255, 255));
        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setText("_");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 752, Short.MAX_VALUE)
                .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel98)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel98)
                    .addComponent(jLabel99))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 100));

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaPlantas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        listaPlantas.setModel(new javax.swing.table.DefaultTableModel(
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
        listaPlantas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaPlantasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaPlantas);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 32, 322, 572));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/av.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 543, 270));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setText("PIEZA");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(513, 328, -1, 20));

        lblNombre.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblNombre.setText("XXXXXXXX");
        jPanel2.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 328, -1, 20));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setText("Caracteristicas Generales");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(513, 366, -1, -1));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel6.setText("Ubicacion:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, -1, -1));

        lblUbicacion.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblUbicacion.setText("XXXXXX");
        jPanel2.add(lblUbicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 400, -1, -1));

        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jButton1.setText("Ver Pieza");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 543, -1, -1));

        jlTiempoReal.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jlTiempoReal.setText("XXXXXX");
        jPanel2.add(jlTiempoReal, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 460, -1, -1));

        tiempoEstimado.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        tiempoEstimado.setText("Tiempo estimado:");
        jPanel2.add(tiempoEstimado, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 430, -1, -1));

        tiempoReal.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        tiempoReal.setText("Tiempo real:");
        jPanel2.add(tiempoReal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 460, -1, -1));

        jlTiempoEstimado.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jlTiempoEstimado.setText("XXXXXX");
        jPanel2.add(jlTiempoEstimado, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 430, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1000, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaPlantasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaPlantasMouseClicked
        
    }//GEN-LAST:event_listaPlantasMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PiezasPorPlanta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PiezasPorPlanta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PiezasPorPlanta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PiezasPorPlanta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PiezasPorPlanta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlTiempoEstimado;
    private javax.swing.JLabel jlTiempoReal;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblUbicacion;
    private javax.swing.JTable listaPlantas;
    private javax.swing.JLabel tiempoEstimado;
    private javax.swing.JLabel tiempoReal;
    // End of variables declaration//GEN-END:variables
}
