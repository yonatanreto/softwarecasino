
package vista;
/**
 *
 * @author Yonatan
 */




/**
 *
 * @author Yonatan
 */
public class JFPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JF_Principal
     */
   
    public JFPrincipal() {
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

        popupMenu = new javax.swing.JPopupMenu();
        panelMenu = new org.jdesktop.swingx.JXPanel();
        panelMenuCargo = new org.jdesktop.swingx.JXPanel();
        btnCargo = new javax.swing.JButton();
        panelMenuArea = new org.jdesktop.swingx.JXPanel();
        btnAreaDeTrabajo = new javax.swing.JButton();
        panelMenuListaOrdenes = new org.jdesktop.swingx.JXPanel();
        btnListaOrdenes = new javax.swing.JButton();
        desktopPane = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jXPanel3 = new org.jdesktop.swingx.JXPanel();
        jXPanel4 = new org.jdesktop.swingx.JXPanel();
        btnMinimizar = new javax.swing.JButton();
        btnMaximizar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jXPanel5 = new org.jdesktop.swingx.JXPanel();
        btnMenu = new javax.swing.JButton();
        labelMover = new javax.swing.JLabel();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        btnUsuarios = new javax.swing.JButton();
        btnEmpleados = new javax.swing.JButton();
        btnRestaurantes = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnOrdenes = new javax.swing.JButton();

        popupMenu.setBackground(new java.awt.Color(51, 204, 255));
        popupMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        popupMenu.setBorderPainted(false);

        panelMenu.setBackground(new java.awt.Color(51, 204, 255));
        panelMenu.setPaintBorderInsets(false);
        panelMenu.setLayout(new java.awt.GridLayout(3, 1));

        panelMenuCargo.setBackground(new java.awt.Color(52, 133, 254));

        btnCargo.setBackground(new java.awt.Color(52, 133, 254));
        btnCargo.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        btnCargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/id.png"))); // NOI18N
        btnCargo.setText("Cargo");
        btnCargo.setBorder(null);
        btnCargo.setContentAreaFilled(false);
        btnCargo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCargo.setForeground(new java.awt.Color(255, 255, 255));
        btnCargo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCargo.setIconTextGap(15);
        btnCargo.setMargin(new java.awt.Insets(2, 20, 2, 14));
        btnCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenuCargoLayout = new javax.swing.GroupLayout(panelMenuCargo);
        panelMenuCargo.setLayout(panelMenuCargoLayout);
        panelMenuCargoLayout.setHorizontalGroup(
            panelMenuCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuCargoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCargo, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
        );
        panelMenuCargoLayout.setVerticalGroup(
            panelMenuCargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuCargoLayout.createSequentialGroup()
                .addComponent(btnCargo)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelMenu.add(panelMenuCargo);

        panelMenuArea.setBackground(new java.awt.Color(52, 133, 254));

        btnAreaDeTrabajo.setBackground(new java.awt.Color(255, 255, 255));
        btnAreaDeTrabajo.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        btnAreaDeTrabajo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/factory.png"))); // NOI18N
        btnAreaDeTrabajo.setText("Área de trabajo");
        btnAreaDeTrabajo.setBorder(null);
        btnAreaDeTrabajo.setBorderPainted(false);
        btnAreaDeTrabajo.setContentAreaFilled(false);
        btnAreaDeTrabajo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAreaDeTrabajo.setFocusPainted(false);
        btnAreaDeTrabajo.setForeground(new java.awt.Color(255, 255, 255));
        btnAreaDeTrabajo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAreaDeTrabajo.setIconTextGap(15);
        btnAreaDeTrabajo.setMargin(new java.awt.Insets(2, 14, 2, 25));
        btnAreaDeTrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAreaDeTrabajoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenuAreaLayout = new javax.swing.GroupLayout(panelMenuArea);
        panelMenuArea.setLayout(panelMenuAreaLayout);
        panelMenuAreaLayout.setHorizontalGroup(
            panelMenuAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAreaDeTrabajo, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
        );
        panelMenuAreaLayout.setVerticalGroup(
            panelMenuAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuAreaLayout.createSequentialGroup()
                .addComponent(btnAreaDeTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelMenu.add(panelMenuArea);

        panelMenuListaOrdenes.setBackground(new java.awt.Color(52, 133, 254));

        btnListaOrdenes.setBackground(new java.awt.Color(255, 255, 255));
        btnListaOrdenes.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        btnListaOrdenes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/orden32.png"))); // NOI18N
        btnListaOrdenes.setText("Listado de ordenes");
        btnListaOrdenes.setBorder(null);
        btnListaOrdenes.setBorderPainted(false);
        btnListaOrdenes.setContentAreaFilled(false);
        btnListaOrdenes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnListaOrdenes.setFocusPainted(false);
        btnListaOrdenes.setForeground(new java.awt.Color(255, 255, 255));
        btnListaOrdenes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnListaOrdenes.setIconTextGap(15);
        btnListaOrdenes.setMargin(new java.awt.Insets(2, 14, 2, 25));
        btnListaOrdenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaOrdenesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenuListaOrdenesLayout = new javax.swing.GroupLayout(panelMenuListaOrdenes);
        panelMenuListaOrdenes.setLayout(panelMenuListaOrdenesLayout);
        panelMenuListaOrdenesLayout.setHorizontalGroup(
            panelMenuListaOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuListaOrdenesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnListaOrdenes, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
        );
        panelMenuListaOrdenesLayout.setVerticalGroup(
            panelMenuListaOrdenesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuListaOrdenesLayout.createSequentialGroup()
                .addComponent(btnListaOrdenes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelMenu.add(panelMenuListaOrdenes);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(52, 133, 254));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        desktopPane.setBackground(new java.awt.Color(255, 255, 255));
        desktopPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 233, 233)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo fx solutions.png"))); // NOI18N

        desktopPane.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktopPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktopPaneLayout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jXPanel1.setBackground(new java.awt.Color(52, 133, 254));
        jXPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(226, 226, 226)));
        jXPanel1.setLayout(new javax.swing.BoxLayout(jXPanel1, javax.swing.BoxLayout.Y_AXIS));

        jXPanel3.setBackground(new java.awt.Color(52, 133, 254));

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

        btnMaximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/materialDesign/ic_check_box_outline_blank_white_24px.png"))); // NOI18N
        btnMaximizar.setBorderPainted(false);
        btnMaximizar.setContentAreaFilled(false);
        btnMaximizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMaximizar.setFocusable(false);
        btnMaximizar.setMaximumSize(new java.awt.Dimension(40, 33));
        btnMaximizar.setMinimumSize(new java.awt.Dimension(40, 33));
        btnMaximizar.setPreferredSize(new java.awt.Dimension(40, 33));
        btnMaximizar.setRequestFocusEnabled(false);
        btnMaximizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/materialDesign/ic_check_box_outline_blank_white_24px_rollover.png"))); // NOI18N
        jXPanel4.add(btnMaximizar);

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

        jXPanel5.setBackground(new java.awt.Color(52, 133, 254));

        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/materialDesign/ic_menu_white_24dp_1x.png"))); // NOI18N
        btnMenu.setBorderPainted(false);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenu.setFocusable(false);
        btnMenu.setMaximumSize(new java.awt.Dimension(40, 33));
        btnMenu.setMinimumSize(new java.awt.Dimension(40, 33));
        btnMenu.setPreferredSize(new java.awt.Dimension(40, 33));
        btnMenu.setRequestFocusEnabled(false);
        btnMenu.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/materialDesign/ic_menu_white_24px_rollover.png"))); // NOI18N

        javax.swing.GroupLayout jXPanel5Layout = new javax.swing.GroupLayout(jXPanel5);
        jXPanel5.setLayout(jXPanel5Layout);
        jXPanel5Layout.setHorizontalGroup(
            jXPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel5Layout.createSequentialGroup()
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jXPanel5Layout.setVerticalGroup(
            jXPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        labelMover.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));

        javax.swing.GroupLayout jXPanel3Layout = new javax.swing.GroupLayout(jXPanel3);
        jXPanel3.setLayout(jXPanel3Layout);
        jXPanel3Layout.setHorizontalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel3Layout.createSequentialGroup()
                .addComponent(jXPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelMover, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jXPanel3Layout.setVerticalGroup(
            jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel3Layout.createSequentialGroup()
                .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jXPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(labelMover, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jXPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jXPanel1.add(jXPanel3);

        jXPanel2.setBackground(new java.awt.Color(83, 152, 255));

        btnUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        btnUsuarios.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/administrator48.png"))); // NOI18N
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setBorder(null);
        btnUsuarios.setContentAreaFilled(false);
        btnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarios.setFocusable(false);
        btnUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnUsuarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUsuarios.setIconTextGap(5);
        btnUsuarios.setMargin(new java.awt.Insets(10, 5, 7, 5));
        btnUsuarios.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/administrator48_rollover.png"))); // NOI18N
        btnUsuarios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        btnEmpleados.setBackground(new java.awt.Color(255, 255, 255));
        btnEmpleados.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        btnEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/operator48.png"))); // NOI18N
        btnEmpleados.setText("Empleados");
        btnEmpleados.setBorder(null);
        btnEmpleados.setContentAreaFilled(false);
        btnEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmpleados.setFocusable(false);
        btnEmpleados.setForeground(new java.awt.Color(255, 255, 255));
        btnEmpleados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEmpleados.setIconTextGap(5);
        btnEmpleados.setMargin(new java.awt.Insets(10, 5, 7, 5));
        btnEmpleados.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/operator48_rollover.png"))); // NOI18N
        btnEmpleados.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnRestaurantes.setBackground(new java.awt.Color(255, 255, 255));
        btnRestaurantes.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        btnRestaurantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/restaurante48.png"))); // NOI18N
        btnRestaurantes.setText("Restaurantes");
        btnRestaurantes.setBorder(null);
        btnRestaurantes.setContentAreaFilled(false);
        btnRestaurantes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRestaurantes.setFocusable(false);
        btnRestaurantes.setForeground(new java.awt.Color(255, 255, 255));
        btnRestaurantes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRestaurantes.setIconTextGap(5);
        btnRestaurantes.setMargin(new java.awt.Insets(10, 5, 7, 5));
        btnRestaurantes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/restaurante48_rollover.png"))); // NOI18N
        btnRestaurantes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close48.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setBorder(null);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setFocusable(false);
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setIconTextGap(5);
        btnSalir.setMargin(new java.awt.Insets(10, 5, 7, 5));
        btnSalir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close48_rollover.png"))); // NOI18N
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnOrdenes.setBackground(new java.awt.Color(255, 255, 255));
        btnOrdenes.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        btnOrdenes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/orden482.png"))); // NOI18N
        btnOrdenes.setText("Ordenes");
        btnOrdenes.setBorder(null);
        btnOrdenes.setContentAreaFilled(false);
        btnOrdenes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOrdenes.setFocusable(false);
        btnOrdenes.setForeground(new java.awt.Color(255, 255, 255));
        btnOrdenes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOrdenes.setIconTextGap(5);
        btnOrdenes.setMargin(new java.awt.Insets(10, 5, 7, 5));
        btnOrdenes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ordenRollOver.png"))); // NOI18N
        btnOrdenes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEmpleados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRestaurantes, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOrdenes, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(358, Short.MAX_VALUE))
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
            .addComponent(btnEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(btnRestaurantes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(btnOrdenes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jXPanel1.add(jXPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
            .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktopPane))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
//         Model2.cerra_conexion_JPA();
    }//GEN-LAST:event_formWindowClosed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCargoActionPerformed

    private void btnAreaDeTrabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAreaDeTrabajoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAreaDeTrabajoActionPerformed

    private void btnListaOrdenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaOrdenesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListaOrdenesActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAreaDeTrabajo;
    public javax.swing.JButton btnCargo;
    public javax.swing.JButton btnCerrar;
    public javax.swing.JButton btnEmpleados;
    public javax.swing.JButton btnListaOrdenes;
    public javax.swing.JButton btnMaximizar;
    public javax.swing.JButton btnMenu;
    public javax.swing.JButton btnMinimizar;
    public javax.swing.JButton btnOrdenes;
    public javax.swing.JButton btnRestaurantes;
    public javax.swing.JButton btnSalir;
    public javax.swing.JButton btnUsuarios;
    public javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel jLabel1;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    private org.jdesktop.swingx.JXPanel jXPanel3;
    private org.jdesktop.swingx.JXPanel jXPanel4;
    private org.jdesktop.swingx.JXPanel jXPanel5;
    public javax.swing.JLabel labelMover;
    public org.jdesktop.swingx.JXPanel panelMenu;
    public org.jdesktop.swingx.JXPanel panelMenuArea;
    public org.jdesktop.swingx.JXPanel panelMenuCargo;
    public org.jdesktop.swingx.JXPanel panelMenuListaOrdenes;
    public javax.swing.JPopupMenu popupMenu;
    // End of variables declaration//GEN-END:variables

}
