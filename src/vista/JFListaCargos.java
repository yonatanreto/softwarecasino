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
public class JFListaCargos extends javax.swing.JInternalFrame {

    /**
     * Creates new form JFListaUsuario
     */
    
    
    public JFListaCargos() {
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

        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new utilidades.MiTabla();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();
        comboFiltro = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        labelMover = new javax.swing.JLabel();
        labelTitulo = new javax.swing.JLabel();
        jXPanel4 = new org.jdesktop.swingx.JXPanel();
        btnMinimizar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setIconifiable(true);

        jXPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jXPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(229, 229, 229)));
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jScrollPane1.setForeground(new java.awt.Color(0, 0, 153));

        tabla.setBackground(new java.awt.Color(226, 226, 226));
        tabla.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Código"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setForeground(new java.awt.Color(84, 84, 84));
        tabla.setGridColor(new java.awt.Color(234, 234, 234));
        tabla.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tabla);

        jXPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 480, 290));

        btnNuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add6472.png"))); // NOI18N
        btnNuevo.setOpaque(false);
        btnNuevo.setToolTipText("Nuevo");
        btnNuevo.setBorder(null);
        btnNuevo.setBorderPainted(false);
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btnNuevo.setFocusPainted(false);
        btnNuevo.setFocusable(false);
        btnNuevo.setForeground(new java.awt.Color(102, 102, 102));
        btnNuevo.setIconTextGap(0);
        btnNuevo.setMargin(new java.awt.Insets(5, 5, 5, 5));
        btnNuevo.setMaximumSize(new java.awt.Dimension(85, 33));
        btnNuevo.setMinimumSize(new java.awt.Dimension(85, 33));
        btnNuevo.setPreferredSize(new java.awt.Dimension(85, 33));
        btnNuevo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add72rollover.png"))); // NOI18N
        jXPanel2.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 499, 70, 80));

        btnEditar.setBackground(new java.awt.Color(255, 255, 255));
        btnEditar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit6472.png"))); // NOI18N
        btnEditar.setOpaque(false);
        btnEditar.setToolTipText("Editar");
        btnEditar.setBorder(null);
        btnEditar.setBorderPainted(false);
        btnEditar.setContentAreaFilled(false);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btnEditar.setFocusPainted(false);
        btnEditar.setFocusable(false);
        btnEditar.setForeground(new java.awt.Color(102, 102, 102));
        btnEditar.setMargin(new java.awt.Insets(5, 5, 5, 5));
        btnEditar.setMaximumSize(new java.awt.Dimension(85, 33));
        btnEditar.setMinimumSize(new java.awt.Dimension(85, 33));
        btnEditar.setPreferredSize(new java.awt.Dimension(85, 33));
        btnEditar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit72rollover.png"))); // NOI18N
        jXPanel2.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 501, 70, 80));

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close6472.png"))); // NOI18N
        btnSalir.setOpaque(false);
        btnSalir.setToolTipText("Salir");
        btnSalir.setBorder(null);
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btnSalir.setFocusPainted(false);
        btnSalir.setFocusable(false);
        btnSalir.setForeground(new java.awt.Color(102, 102, 102));
        btnSalir.setIconTextGap(0);
        btnSalir.setMargin(new java.awt.Insets(5, 5, 5, 5));
        btnSalir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close72rollover.png"))); // NOI18N
        jXPanel2.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 501, 70, 80));

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete6472.png"))); // NOI18N
        btnEliminar.setOpaque(false);
        btnEliminar.setToolTipText("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.setBorderPainted(false);
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btnEliminar.setFocusPainted(false);
        btnEliminar.setFocusable(false);
        btnEliminar.setForeground(new java.awt.Color(102, 102, 102));
        btnEliminar.setMargin(new java.awt.Insets(5, 5, 5, 5));
        btnEliminar.setMaximumSize(new java.awt.Dimension(85, 33));
        btnEliminar.setMinimumSize(new java.awt.Dimension(85, 33));
        btnEliminar.setPreferredSize(new java.awt.Dimension(85, 33));
        btnEliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete72rollover.png"))); // NOI18N
        jXPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 501, 70, 80));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("Buscar por");
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jXPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 132, -1, -1));

        txtFiltro.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtFiltro.setBorder(null);
        jXPanel2.add(txtFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 155, 269, 30));

        comboFiltro.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        comboFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Código" }));
        comboFiltro.setFocusable(false);
        comboFiltro.setForeground(new java.awt.Color(102, 102, 102));
        jXPanel2.add(comboFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 155, 104, 30));
        jXPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 189, 290, 10));

        jXPanel1.setBackground(new java.awt.Color(52, 133, 254));
        jXPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelMover.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jXPanel1.add(labelMover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 36));

        labelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labelTitulo.setFont(new java.awt.Font("Calibri Light", 0, 30)); // NOI18N
        labelTitulo.setText("Listado de CARGOS");
        labelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jXPanel1.add(labelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 361, 40));

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

        jXPanel1.add(jXPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 4, 80, 30));

        jXPanel2.add(jXPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCerrar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnMinimizar;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnSalir;
    public javax.swing.JComboBox comboFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    public org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel4;
    public javax.swing.JLabel labelMover;
    private javax.swing.JLabel labelTitulo;
    public javax.swing.JTable tabla;
    public javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
