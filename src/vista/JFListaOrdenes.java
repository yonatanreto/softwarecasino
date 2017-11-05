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
public class JFListaOrdenes extends javax.swing.JInternalFrame {

    /**
     * Creates new form JFListaUsuario
     */
    
    
    public JFListaOrdenes() {
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
        btnSalir = new javax.swing.JButton();
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
        jdcFechaInicial = new utilidades.MiJDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jdcFechaFinal = new utilidades.MiJDateChooser();
        jLabel3 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnImprimirTicket = new javax.swing.JButton();
        txtNumeroRegistros = new javax.swing.JLabel();

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
                "No Orden", "Restaurante", "Empleado", "Fecha", "Hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setForeground(new java.awt.Color(84, 84, 84));
        tabla.setGridColor(new java.awt.Color(234, 234, 234));
        tabla.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tabla);

        jXPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 890, 290));

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
        jXPanel2.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(816, 501, 70, 80));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("Buscar por");
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jXPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 132, -1, -1));

        txtFiltro.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtFiltro.setBorder(null);
        jXPanel2.add(txtFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 155, 190, 30));

        comboFiltro.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        comboFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Orden", "Restaurante", "Empleado" }));
        comboFiltro.setFocusable(false);
        comboFiltro.setForeground(new java.awt.Color(102, 102, 102));
        jXPanel2.add(comboFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 155, 160, 30));
        jXPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 189, 190, 10));

        jXPanel1.setBackground(new java.awt.Color(52, 133, 254));
        jXPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelMover.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jXPanel1.add(labelMover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 36));

        labelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        labelTitulo.setFont(new java.awt.Font("Calibri Light", 0, 30)); // NOI18N
        labelTitulo.setText("Listado de ORDENES");
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

        jXPanel1.add(jXPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 4, 80, 30));

        jXPanel2.add(jXPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 100));

        jdcFechaInicial.setBackground(new java.awt.Color(255, 255, 255));
        jdcFechaInicial.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jXPanel2.add(jdcFechaInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 155, 110, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Fecha inicial");
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jXPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 132, 80, -1));

        jdcFechaFinal.setBackground(new java.awt.Color(255, 255, 255));
        jdcFechaFinal.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jXPanel2.add(jdcFechaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 155, 110, 30));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Fecha final");
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jXPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 132, 70, -1));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/binoculars_icon.png"))); // NOI18N
        btnBuscar.setToolTipText("Salir");
        btnBuscar.setBorder(null);
        btnBuscar.setBorderPainted(false);
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btnBuscar.setFocusPainted(false);
        btnBuscar.setFocusable(false);
        btnBuscar.setForeground(new java.awt.Color(102, 102, 102));
        btnBuscar.setIconTextGap(0);
        btnBuscar.setMargin(new java.awt.Insets(5, 5, 5, 5));
        btnBuscar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/binoculars_rollover.png"))); // NOI18N
        jXPanel2.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 130, 80, 70));

        btnImprimir.setBackground(new java.awt.Color(255, 255, 255));
        btnImprimir.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/print.png"))); // NOI18N
        btnImprimir.setToolTipText("Imprimir listado");
        btnImprimir.setBorder(null);
        btnImprimir.setBorderPainted(false);
        btnImprimir.setContentAreaFilled(false);
        btnImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImprimir.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btnImprimir.setFocusPainted(false);
        btnImprimir.setFocusable(false);
        btnImprimir.setForeground(new java.awt.Color(102, 102, 102));
        btnImprimir.setIconTextGap(0);
        btnImprimir.setMargin(new java.awt.Insets(5, 5, 5, 5));
        btnImprimir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/printer72.png"))); // NOI18N
        jXPanel2.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 501, 70, 80));

        btnImprimirTicket.setBackground(new java.awt.Color(255, 255, 255));
        btnImprimirTicket.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnImprimirTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fax.png"))); // NOI18N
        btnImprimirTicket.setToolTipText("Imprimir Ticket");
        btnImprimirTicket.setBorder(null);
        btnImprimirTicket.setBorderPainted(false);
        btnImprimirTicket.setContentAreaFilled(false);
        btnImprimirTicket.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImprimirTicket.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btnImprimirTicket.setFocusPainted(false);
        btnImprimirTicket.setFocusable(false);
        btnImprimirTicket.setForeground(new java.awt.Color(102, 102, 102));
        btnImprimirTicket.setIconTextGap(0);
        btnImprimirTicket.setMargin(new java.awt.Insets(5, 5, 5, 5));
        btnImprimirTicket.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fax72.png"))); // NOI18N
        jXPanel2.add(btnImprimirTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 501, 80, 80));

        txtNumeroRegistros.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        txtNumeroRegistros.setForeground(new java.awt.Color(102, 102, 102));
        txtNumeroRegistros.setText("No registros: 0");
        jXPanel2.add(txtNumeroRegistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 520, 260, -1));

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
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnCerrar;
    public javax.swing.JButton btnImprimir;
    public javax.swing.JButton btnImprimirTicket;
    public javax.swing.JButton btnMinimizar;
    public javax.swing.JButton btnSalir;
    public javax.swing.JComboBox comboFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    public org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel4;
    public com.toedter.calendar.JDateChooser jdcFechaFinal;
    public com.toedter.calendar.JDateChooser jdcFechaInicial;
    public javax.swing.JLabel labelMover;
    private javax.swing.JLabel labelTitulo;
    public javax.swing.JTable tabla;
    public javax.swing.JTextField txtFiltro;
    public javax.swing.JLabel txtNumeroRegistros;
    // End of variables declaration//GEN-END:variables
}
