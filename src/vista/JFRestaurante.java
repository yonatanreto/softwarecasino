/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author Usuario
 */
public class JFRestaurante extends javax.swing.JInternalFrame {

    /**
     * Creates new form JFUsuario
     */
    public JFRestaurante() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jSeparator1 = new javax.swing.JSeparator();
        btnGuardar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        labelMover = new javax.swing.JLabel();
        labelTitulo = new javax.swing.JLabel();
        jXPanel4 = new org.jdesktop.swingx.JXPanel();
        btnMinimizar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtNit = new javax.swing.JTextField();
        txtDigitoVerificacíon = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setIconifiable(true);

        jXPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jXPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jXPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 182, 355, 10));

        btnGuardar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/diskette6472.png"))); // NOI18N
        btnGuardar.setBorder(null);
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setForeground(new java.awt.Color(102, 102, 102));
        btnGuardar.setMargin(new java.awt.Insets(5, 5, 5, 5));
        btnGuardar.setMaximumSize(new java.awt.Dimension(85, 33));
        btnGuardar.setMinimumSize(new java.awt.Dimension(85, 33));
        btnGuardar.setPreferredSize(new java.awt.Dimension(85, 33));
        btnGuardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/diskette72rollover.png"))); // NOI18N
        jXPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 100, 80));

        txtNombre.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtNombre.setBorder(null);
        txtNombre.setMargin(new java.awt.Insets(10, 2, 0, 2));
        txtNombre.setName("Nombre"); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jXPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 158, 355, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel1.setText("Nombre");
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jXPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 125, -1, 20));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel2.setText("Nit");
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jXPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 207, -1, 20));
        jXPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 267, 290, 10));

        jXPanel3.setBackground(new java.awt.Color(52, 133, 254));
        jXPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelMover.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jXPanel3.add(labelMover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 36));

        labelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labelTitulo.setFont(new java.awt.Font("Calibri Light", 0, 30)); // NOI18N
        labelTitulo.setText("RESTAURANTE");
        labelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jXPanel3.add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 240, 40));

        jXPanel4.setBackground(new java.awt.Color(52, 133, 254));
        jXPanel4.setLayout(new javax.swing.BoxLayout(jXPanel4, javax.swing.BoxLayout.LINE_AXIS));

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/materialDesign/ic_minm_white_24px.png"))); // NOI18N
        btnMinimizar.setBorderPainted(false);
        btnMinimizar.setContentAreaFilled(false);
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimizar.setFocusable(false);
        btnMinimizar.setMaximumSize(new java.awt.Dimension(40, 33));
        btnMinimizar.setMinimumSize(new java.awt.Dimension(40, 33));
        btnMinimizar.setPreferredSize(new java.awt.Dimension(40, 33));
        btnMinimizar.setRequestFocusEnabled(false);
        btnMinimizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/materialDesign/ic_minm_white_24px_rollover.png"))); // NOI18N
        jXPanel4.add(btnMinimizar);

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/materialDesign/ic_close_white_24px.png"))); // NOI18N
        btnCerrar.setBorderPainted(false);
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.setFocusable(false);
        btnCerrar.setMaximumSize(new java.awt.Dimension(40, 33));
        btnCerrar.setMinimumSize(new java.awt.Dimension(40, 33));
        btnCerrar.setPreferredSize(new java.awt.Dimension(40, 33));
        btnCerrar.setRequestFocusEnabled(false);
        btnCerrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/materialDesign/ic_close_white_24px_rollover.png"))); // NOI18N
        jXPanel4.add(btnCerrar);

        jXPanel3.add(jXPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 4, 90, 30));

        jXPanel1.add(jXPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 90));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Dv");
        jXPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 207, 20, 20));
        jXPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 267, 49, 10));

        txtNit.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtNit.setBorder(null);
        txtNit.setMargin(new java.awt.Insets(10, 2, 0, 2));
        txtNit.setName("Nit"); // NOI18N
        txtNit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNitActionPerformed(evt);
            }
        });
        jXPanel1.add(txtNit, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 243, 290, -1));

        txtDigitoVerificacíon.setEditable(false);
        txtDigitoVerificacíon.setBackground(new java.awt.Color(255, 255, 255));
        txtDigitoVerificacíon.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtDigitoVerificacíon.setBorder(null);
        txtDigitoVerificacíon.setMargin(new java.awt.Insets(10, 2, 0, 2));
        txtDigitoVerificacíon.setName("usuario"); // NOI18N
        txtDigitoVerificacíon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDigitoVerificacíonActionPerformed(evt);
            }
        });
        jXPanel1.add(txtDigitoVerificacíon, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 243, 40, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtNitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNitActionPerformed

    private void txtDigitoVerificacíonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDigitoVerificacíonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDigitoVerificacíonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCerrar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnMinimizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    public org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private org.jdesktop.swingx.JXPanel jXPanel4;
    public javax.swing.JLabel labelMover;
    private javax.swing.JLabel labelTitulo;
    public javax.swing.JTextField txtDigitoVerificacíon;
    public javax.swing.JTextField txtNit;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
