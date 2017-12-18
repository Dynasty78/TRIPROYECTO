package Interfaz.Cliente;

import Controller.ConectorDb;
import Controller.Controladora;
import Dominio.Cliente;
import Dominio.Empleado;
import Dominio.Solicitud_pieza_actividad_fabricacion;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DetallePiezaConcreta extends javax.swing.JFrame {
    
    Controladora control;
    ConectorDb conector;
    JFrame ventana;
    int indice,indice2;
    Empleado em;
    Solicitud_pieza_actividad_fabricacion spaf;
    public DetallePiezaConcreta() {
        initComponents();
    }
    //this,cliente,solicitud,control.getIndex(listaPiezas)
    public DetallePiezaConcreta(JFrame ventanas,Cliente cl,int solicitud,int codigoPieza) {
        initComponents();
        this.control = new Controladora();
        this.conector = new ConectorDb();
        this.ventana = ventanas;
        panelEdit.setVisible(false);
        conector.conectar();
        control.llenarTabla3(tablaPieza,control.getResultSet(conector,"SELECT sp_id,af_id,af_nombre\n" +
                                                                    "FROM solicitud_pieza,pieza,pieza_actividad_fabricacion,solicitud_pieza_actividad_fabricacion,actividad_fabricacion\n" +
                                                                    "WHERE sp_pieza_id = pi_id and paf_pieza_id = '"+codigoPieza+"' and spaf_solicitud_pieza_id = sp_id and paf_id = spaf_pieza_actividad_fabricacion_id and paf_actividad_id = af_id"));
    
    }
    
    public DetallePiezaConcreta(JFrame ventanas,Empleado em,int solicitud,int codigoPieza){
        initComponents();
        this.control = new Controladora();
        this.conector = new ConectorDb();
        this.ventana = ventanas;
        this.em = em;
        conector.conectar();
        control.llenarTabla7(otraTabla, control.getResultSet(conector,"SELECT SPAF_SOLICITUD_PIEZA_ID,SPAF_PIEZA_ACTIVIDAD_FABRICACION_ID,pl_nombre,zo_nombre,spaf_fecha_inicio,spaf_fecha_fin,pe_nombre,pi_id "
                                                                    + "FROM pieza,pieza_actividad_fabricacion,zona_planta,zona,planta,actividad_fabricacion,solicitud_pieza_actividad_fabricacion,empleado,cargo_empleado,persona "
                                                                    + "WHERE pi_id = paf_pieza_id AND paf_zona_planta_id = zp_id AND af_id = paf_actividad_id AND zp_zona_id = zo_id AND zp_planta_id = pl_id AND spaf_pieza_actividad_fabricacion_id = paf_id AND zp_id = em_zona_planta_id AND ce_id = em_cargo_id AND em_cargo_id = 1 AND em_persona_id = pe_id and pi_id = '"+codigoPieza+"'"));
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaPieza = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        otraTabla = new javax.swing.JTable();
        panelEdit = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        endCheck = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(25, 118, 210));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pruebas");

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
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 807, Short.MAX_VALUE)
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
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel98)
                    .addComponent(jLabel99))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 118, 210), 2));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(25, 118, 210));
        jButton1.setText("Atras");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 510, 100, 31));

        tablaPieza.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablaPieza.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane3.setViewportView(tablaPieza);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 37, 310, 500));

        otraTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        otraTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                otraTablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(otraTabla);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 560, 230));

        panelEdit.setBackground(new java.awt.Color(255, 255, 255));
        panelEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 118, 210), 2));
        panelEdit.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel2.setText("Editar");

        saveBtn.setText("Guardar");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        endCheck.setText("Finalizado");

        javax.swing.GroupLayout panelEditLayout = new javax.swing.GroupLayout(panelEdit);
        panelEdit.setLayout(panelEditLayout);
        panelEditLayout.setHorizontalGroup(
            panelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(endCheck)
                    .addComponent(jLabel2)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        panelEditLayout.setVerticalGroup(
            panelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(17, 17, 17)
                .addComponent(endCheck)
                .addGap(18, 18, 18)
                .addComponent(saveBtn)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel2.add(panelEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, 110, 130));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 960, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel99MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel99MouseClicked
        this.setState(DetallePiezaConcreta.ICONIFIED);
    }//GEN-LAST:event_jLabel99MouseClicked

    private void jLabel98MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel98MouseClicked
       int dialogButton = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Desea salir?","EXIT",dialogButton);
        if (result == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel98MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        control.activaVentana(ventana, this);
    }//GEN-LAST:event_jButton1MouseClicked

    private void otraTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_otraTablaMouseClicked
        if (em != null){
            int indice = control.getIndex(otraTabla);
            int indice2 = control.getIndexY(otraTabla);
            System.out.println(indice);
            System.out.println(indice2);
            spaf = control.buscaCodigoSPAF(conector,indice,indice2);
            System.out.println(spaf.toString());
        }
    }//GEN-LAST:event_otraTablaMouseClicked

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        if (endCheck.isSelected()){
            spaf.setSPAF_aprobado();
            spaf.setSPAF_fecha_fin();
        }
        spaf.modificarDb(conector);
    }//GEN-LAST:event_saveBtnActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(DetallePiezaConcreta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetallePiezaConcreta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetallePiezaConcreta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetallePiezaConcreta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new DetallePiezaConcreta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox endCheck;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable otraTabla;
    private javax.swing.JPanel panelEdit;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTable tablaPieza;
    // End of variables declaration//GEN-END:variables
}
