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
public class JFUsuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form JFUsuario
     */
    public JFUsuario() {
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
        btnGuardar = new javax.swing.JButton();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        labelMover = new javax.swing.JLabel();
        labelTitulo = new javax.swing.JLabel();
        jXPanel4 = new org.jdesktop.swingx.JXPanel();
        btnMinimizar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        panelDatos = new org.jdesktop.swingx.JXPanel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        txtContraseña = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<>();
        txtConfirmarContraseña = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jfcRestaurante = new com.nextic.filtercomponent.components.JFilterComponent2();
        labelRestaurante = new javax.swing.JLabel();
        panelPermisos = new org.jdesktop.swingx.JXPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jCheckBox8 = new javax.swing.JCheckBox();
        btnSiguiente = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setIconifiable(true);

        jXPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jXPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jXPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 100, 70));

        jXPanel3.setBackground(new java.awt.Color(52, 133, 254));
        jXPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelMover.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jXPanel3.add(labelMover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 36));

        labelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labelTitulo.setFont(new java.awt.Font("Calibri Light", 0, 30)); // NOI18N
        labelTitulo.setText("USUARIO DEL SISTEMA");
        labelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jXPanel3.add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 290, 40));

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

        jXPanel2.setLayout(new java.awt.CardLayout());

        panelDatos.setBackground(new java.awt.Color(255, 255, 255));
        panelDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel4.setText("Confirmar contraseña");
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        panelDatos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 183, -1, 20));
        panelDatos.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 320, 355, 10));
        panelDatos.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 245, 355, 10));
        panelDatos.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 72, 355, 10));

        txtContraseña.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtContraseña.setBorder(null);
        txtContraseña.setName("contraseña"); // NOI18N
        panelDatos.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 136, 355, 20));

        txtUsuario.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtUsuario.setBorder(null);
        txtUsuario.setMargin(new java.awt.Insets(10, 2, 0, 2));
        txtUsuario.setName("usuario"); // NOI18N
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        panelDatos.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 51, 355, 20));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Tipo");
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        panelDatos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 258, 96, 20));

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMINISTRADOR", "LIMITADO", "RESTAURANTE" }));
        comboTipo.setFocusCycleRoot(true);
        comboTipo.setForeground(new java.awt.Color(102, 102, 102));
        panelDatos.add(comboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 284, 160, 30));

        txtConfirmarContraseña.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtConfirmarContraseña.setBorder(null);
        txtConfirmarContraseña.setName("confirmación de contraseña"); // NOI18N
        panelDatos.add(txtConfirmarContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 224, 355, 20));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel2.setText("Contraseña");
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        panelDatos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 97, -1, 20));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel1.setText("Usuario");
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        panelDatos.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 15, -1, 20));
        panelDatos.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 157, 355, 10));
        panelDatos.add(jfcRestaurante, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 284, 160, 30));

        labelRestaurante.setBackground(new java.awt.Color(255, 255, 255));
        labelRestaurante.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        labelRestaurante.setText("Restaurante");
        labelRestaurante.setForeground(new java.awt.Color(153, 153, 153));
        panelDatos.add(labelRestaurante, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 258, 150, 20));

        jXPanel2.add(panelDatos, "card2");

        panelPermisos.setBackground(new java.awt.Color(255, 255, 255));

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jCheckBox1.setText("Usuarios");
        jCheckBox1.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox1.setName("usuarios"); // NOI18N

        jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jCheckBox2.setText("Empleados");
        jCheckBox2.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox2.setName("empleados"); // NOI18N

        jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jCheckBox3.setText("Restaurantes");
        jCheckBox3.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox3.setName("restaurantes"); // NOI18N

        jCheckBox4.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jCheckBox4.setText("Ordenes");
        jCheckBox4.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox4.setName("ordenes"); // NOI18N

        jCheckBox5.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox5.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jCheckBox5.setText("Listado de Ordenes");
        jCheckBox5.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox5.setName("listado de ordenes"); // NOI18N

        jCheckBox6.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox6.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jCheckBox6.setText("Área de trabajo");
        jCheckBox6.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox6.setName("area de trabajo"); // NOI18N

        jCheckBox7.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox7.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jCheckBox7.setText("Cargo");
        jCheckBox7.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox7.setName("cargo"); // NOI18N

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel5.setText("Permisos");
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));

        jCheckBox8.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox8.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jCheckBox8.setText("Entrega de orden");
        jCheckBox8.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox8.setName("Entrega de orden"); // NOI18N

        javax.swing.GroupLayout panelPermisosLayout = new javax.swing.GroupLayout(panelPermisos);
        panelPermisos.setLayout(panelPermisosLayout);
        panelPermisosLayout.setHorizontalGroup(
            panelPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPermisosLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox8)
                    .addComponent(jLabel5)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox5)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox6)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelPermisosLayout.setVerticalGroup(
            panelPermisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPermisosLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox5)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jXPanel2.add(panelPermisos, "card3");

        jXPanel1.add(jXPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 430, 330));

        btnSiguiente.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arrow_right2.png"))); // NOI18N
        btnSiguiente.setBorder(null);
        btnSiguiente.setBorderPainted(false);
        btnSiguiente.setContentAreaFilled(false);
        btnSiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSiguiente.setForeground(new java.awt.Color(102, 102, 102));
        btnSiguiente.setMargin(new java.awt.Insets(5, 5, 5, 5));
        btnSiguiente.setMaximumSize(new java.awt.Dimension(85, 33));
        btnSiguiente.setMinimumSize(new java.awt.Dimension(85, 33));
        btnSiguiente.setPreferredSize(new java.awt.Dimension(85, 33));
        btnSiguiente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arrow_rightRollOver.png"))); // NOI18N
        jXPanel1.add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 460, 80, 80));

        btnAtras.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arrow_left2.png"))); // NOI18N
        btnAtras.setBorder(null);
        btnAtras.setBorderPainted(false);
        btnAtras.setContentAreaFilled(false);
        btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtras.setForeground(new java.awt.Color(102, 102, 102));
        btnAtras.setMargin(new java.awt.Insets(5, 5, 5, 5));
        btnAtras.setMaximumSize(new java.awt.Dimension(85, 33));
        btnAtras.setMinimumSize(new java.awt.Dimension(85, 33));
        btnAtras.setPreferredSize(new java.awt.Dimension(85, 33));
        btnAtras.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arrow_leftRollOver.png"))); // NOI18N
        jXPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 80, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAtras;
    public javax.swing.JButton btnCerrar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnMinimizar;
    public javax.swing.JButton btnSiguiente;
    public javax.swing.JComboBox<String> comboTipo;
    public javax.swing.JCheckBox jCheckBox1;
    public javax.swing.JCheckBox jCheckBox2;
    public javax.swing.JCheckBox jCheckBox3;
    public javax.swing.JCheckBox jCheckBox4;
    public javax.swing.JCheckBox jCheckBox5;
    public javax.swing.JCheckBox jCheckBox6;
    public javax.swing.JCheckBox jCheckBox7;
    public javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    public org.jdesktop.swingx.JXPanel jXPanel1;
    public org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private org.jdesktop.swingx.JXPanel jXPanel4;
    public com.nextic.filtercomponent.components.JFilterComponent2 jfcRestaurante;
    public javax.swing.JLabel labelMover;
    private javax.swing.JLabel labelRestaurante;
    private javax.swing.JLabel labelTitulo;
    private org.jdesktop.swingx.JXPanel panelDatos;
    public org.jdesktop.swingx.JXPanel panelPermisos;
    public javax.swing.JPasswordField txtConfirmarContraseña;
    public javax.swing.JPasswordField txtContraseña;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
