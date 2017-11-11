
package vista;

/**
 *
 * @author Yonatan
 */
public class JFArchivoConexion extends javax.swing.JFrame {

    /**
     * Creates new form InicioSesion
     */
    public JFArchivoConexion() {
       
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

        jfileRutaGuardar = new javax.swing.JFileChooser();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        txtUsuario = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnCerrar = new javax.swing.JButton();
        labelMover = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtPassword = new javax.swing.JPasswordField();
        txtBaseDeDatos = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        txtUrl = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jXPanel4 = new org.jdesktop.swingx.JXPanel();
        jLabel4 = new javax.swing.JLabel();

        jfileRutaGuardar.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jXPanel2.setBackground(new java.awt.Color(52, 133, 254));
        jXPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        jXPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jXPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsuario.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtUsuario.setBorder(null);
        txtUsuario.setName("Usuario"); // NOI18N
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jXPanel3.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 122, 180, 32));
        jXPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 238, 180, 10));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("Base de datos");
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jXPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 189, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Usuario");
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jXPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 105, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel3.setText("Configuración de conexión");
        jLabel3.setForeground(new java.awt.Color(52, 133, 254));
        jXPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 40, 410, 40));

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonLoginAzul.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBorder(null);
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setFocusPainted(false);
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setMargin(new java.awt.Insets(5, 5, 5, 5));
        btnGuardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botonLoginAzulOscuro.png"))); // NOI18N
        jXPanel3.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 280, 50));
        jXPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 155, 180, 10));

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/materialDesign/ic_close_grayLigth_24px.png"))); // NOI18N
        btnCerrar.setBorderPainted(false);
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.setFocusable(false);
        btnCerrar.setMaximumSize(new java.awt.Dimension(40, 33));
        btnCerrar.setMinimumSize(new java.awt.Dimension(40, 33));
        btnCerrar.setPreferredSize(new java.awt.Dimension(40, 33));
        btnCerrar.setRequestFocusEnabled(false);
        btnCerrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/materialDesign/ic_close_gray_24px.png"))); // NOI18N
        jXPanel3.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 40, 30));

        labelMover.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        labelMover.setFocusable(false);
        jXPanel3.add(labelMover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 30));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Password");
        jXPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 105, 70, -1));
        jXPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 155, 210, 10));

        txtPassword.setBorder(null);
        txtPassword.setName("Password"); // NOI18N
        jXPanel3.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 122, 210, 32));

        txtBaseDeDatos.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtBaseDeDatos.setBorder(null);
        txtBaseDeDatos.setName("Base de datos"); // NOI18N
        txtBaseDeDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBaseDeDatosActionPerformed(evt);
            }
        });
        jXPanel3.add(txtBaseDeDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 207, 180, 30));
        jXPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 238, 210, 10));

        txtUrl.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtUrl.setBorder(null);
        txtUrl.setName("URL"); // NOI18N
        txtUrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUrlActionPerformed(evt);
            }
        });
        jXPanel3.add(txtUrl, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 207, 210, 30));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("URL Servidor");
        jXPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 189, 120, -1));

        jXPanel4.setBackground(new java.awt.Color(52, 133, 254));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/database (1).png"))); // NOI18N

        javax.swing.GroupLayout jXPanel4Layout = new javax.swing.GroupLayout(jXPanel4);
        jXPanel4.setLayout(jXPanel4Layout);
        jXPanel4Layout.setHorizontalGroup(
            jXPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jXPanel4Layout.setVerticalGroup(
            jXPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel2Layout.createSequentialGroup()
                .addComponent(jXPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jXPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addComponent(jXPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtBaseDeDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBaseDeDatosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBaseDeDatosActionPerformed

    private void txtUrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUrlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUrlActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCerrar;
    public javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    public org.jdesktop.swingx.JXPanel jXPanel3;
    private org.jdesktop.swingx.JXPanel jXPanel4;
    public javax.swing.JFileChooser jfileRutaGuardar;
    public javax.swing.JLabel labelMover;
    public javax.swing.JTextField txtBaseDeDatos;
    public javax.swing.JPasswordField txtPassword;
    public javax.swing.JTextField txtUrl;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
