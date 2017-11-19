/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.dao.ConfiguracionImpresionOrdenDAO;
import modelo.dao.EmpleadosDAO;
import modelo.dao.OrdenesDAO;
import modelo.dao.RestaurantesDAO;
import modelo.dao.UsuariosDAO;
import modelo.logica.LogicaGeneral;
import modelo.reportes.ModeloReportes;
import modelo.vo.ConfiguracionImpresionOrden;
import modelo.vo.Empleados;
import modelo.vo.Ordenes;
import modelo.vo.Restaurantes;
import vista.JFPrincipalOrden;





/**
 *
 * @author Usuario
 */
public class ControladorPrincipalOrden implements ActionListener,MouseListener,MouseMotionListener,KeyListener{
        JFPrincipalOrden vistaVO;
        OrdenesDAO modeloDAO; 
        Ordenes objetoVO;
        String acción="";
        int x;
        int y;
        HashMap mapRestaurantes=new HashMap();
        ArrayList<JButton> listaBotones=new ArrayList<>();
        Restaurantes restaurante=null;
        EmpleadosDAO   empleadoDAO;
        Empleados empleadoVO;
        UsuariosDAO modeloUsuariosDAO; 
           

    public ControladorPrincipalOrden(JFPrincipalOrden vistaVO) {
       
        this.vistaVO = vistaVO;
        
         
        this.modeloDAO = new OrdenesDAO(Conexion.f);
         empleadoDAO=new  EmpleadosDAO(Conexion.f); 
         modeloUsuariosDAO = new UsuariosDAO(Conexion.f); 
        
        
            
            //Implementación de eventos para todas las vistas
            
            this.vistaVO.btnCerrar.addActionListener(this);
            this.vistaVO.btnMinimizar.addActionListener(this);
            this.vistaVO.btnMaximizar.addActionListener(this);
            this.vistaVO.txtCodigo.addActionListener(this);
            this.vistaVO.labelMover.addMouseMotionListener(this);
            this.vistaVO.labelMover.addMouseListener(this);
            inicializar();
      
    }
    
    
    //Este metodo inicializa la vista de Usuario configurando algunas caracteristicas propias
    public void inicializar(){
          cargarUsuarioDelSistema();
           vistaVO.popupMenu.add(vistaVO.panelMenu);           
           vistaVO.setExtendedState(vistaVO.MAXIMIZED_BOTH);
         
         
           crearBotonesRestaurantes();
           vistaVO.setVisible(true);
         
         
      }
    
  public void cargarUsuarioDelSistema(){
       ControladorPrincipal.usuario=modeloUsuariosDAO.getUsuario("default","usuario");
            if(ControladorPrincipal.usuario==null){
               JOptionPane.showMessageDialog(null,"Es necesario configurar el usuario del sistema","ERROR",JOptionPane.ERROR_MESSAGE);
               ControladorGeneral.salirAplicación();
            }
    }
    
 public void crearBotonesRestaurantes(){
     RestaurantesDAO   restauranteDAO= new  RestaurantesDAO(Conexion.f);
     List<Restaurantes>  lista=restauranteDAO.findRestaurantesEntities();
     int x=0, y=0;
     int altura=150;
     int ancho=158;
     
     for (int i = 0; i < lista.size(); i++) {
         JButton boton= new JButton();
         boton.setName(lista.get(i).getNombre());
         boton.setText(lista.get(i).getNombre());      
        
         boton.setBounds(x*ancho+20+20*x, y*altura+20+20*y,ancho,altura);
         configuraciónBotones(boton,x);
         vistaVO.panelRestaurantes.add(boton);

           if(x==3){
             y++;
             x=0;
           }else{
            x++;
           }
        
       
         mapRestaurantes.put(lista.get(i).getNombre(), lista.get(i));
         
         boton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 restaurante= (Restaurantes) mapRestaurantes.get(boton.getName());
                if(validar()){                  
                        guardar(restaurante);
                  }
             }
         });  
     }
     
       
        
      vistaVO.panelRestaurantes.setPreferredSize(new Dimension(740, y*altura+altura+y*20));

      
			

    
     
 
 
 }
      
public void configuraciónBotones(JButton boton,int columna){
        String urlIcon="",urlIconRollOver="";
         if(columna==0){
           urlIcon="/img/restaurante1.png";
           urlIconRollOver="/img/restaurante12.png";
        }
        if(columna==1){
           urlIcon="/img/restaurante2.png";
           urlIconRollOver="/img/restaurante22.png";
        }
        if(columna==2){
           urlIcon="/img/restaurante3.png";
           urlIconRollOver="/img/restaurante32.png";
        }
        if(columna==3){
           urlIcon="/img/restaurante4.png";
           urlIconRollOver="/img/restaurante42.png";
        }

        boton.setBackground(new java.awt.Color(255, 255, 255));
        boton.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        
        boton.setBorder(null);
//        boton.setContentAreaFilled(false);
        boton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boton.setFocusable(false);
        boton.setForeground(new java.awt.Color(80, 80, 80));
        boton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boton.setIconTextGap(5);
        boton.setMargin(new java.awt.Insets(10, 5, 7, 5));
        
        boton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boton.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlIcon))); // NOI18N
        boton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource(urlIconRollOver))); // NOI18N
}  
    
    //Este metodo guarda o edita un objetoVO
    public void guardar(Restaurantes restaurante){
        if(objetoVO==null){
         objetoVO=new Ordenes();
        }
        prepararObjeto(objetoVO,restaurante);         
        ConfiguracionImpresionOrden objetoVoConfiguracion=ConfiguracionImpresionOrdenDAO.getConfiguracionImpresionOrden();
        objetoVO.setCodigo(objetoVoConfiguracion.getConsecutivoOrden()+"");
        objetoVoConfiguracion.setConsecutivoOrden(objetoVoConfiguracion.getConsecutivoOrden()+1);
            try {
                ConfiguracionImpresionOrdenDAO.editarStatic(objetoVoConfiguracion);
            } catch (Exception ex) {
                Logger.getLogger(ControladorPrincipalOrden.class.getName()).log(Level.SEVERE, null, ex);
            }
        modeloDAO.crear(objetoVO);        
        ModeloReportes modeloReportes = new ModeloReportes();
        modeloReportes.imprimirOrdenTicket(objetoVO, objetoVoConfiguracion);
        ControladorGeneral.vaciarCampos(vistaVO.txtDocumento,vistaVO.txtNombreCompleto,vistaVO.txtTipoDocumento,vistaVO.txtCodigo);
        vistaVO.txtCodigo.requestFocus();
       
    }
    
    //Prepara el objeta para  ser guardado o editado
    public void prepararObjeto(Ordenes objetoVO,Restaurantes restaurante){
        objetoVO.setEmpleado(empleadoVO);
        objetoVO.setRestaurante(restaurante);
        objetoVO.setEstado(0);
        objetoVO.setFecha(new Date());
        objetoVO.setHora(new Date());
        objetoVO.setUsuario(ControladorPrincipal.usuario);   
       
    }
    
    public void llenarDatosEmpleado(){
       vistaVO.txtDocumento.setText(empleadoVO.getCedula());
       vistaVO.txtTipoDocumento.setText(empleadoVO.getTipoDocumento());
       vistaVO.txtNombreCompleto.setText(empleadoVO.toString());
    
    }

       //Valida que los campos no esten vacíos 
        public boolean validar(){
            String respuesta="";
            
         if(!(respuesta=ControladorGeneral.validarTxtVacios(vistaVO.txtCodigo
                 )).equalsIgnoreCase("OK")){
                return false;
        }else{
            
                if(empleadoVO==null){
                        ControladorGeneral.vaciarCampos(vistaVO.txtDocumento,vistaVO.txtNombreCompleto,vistaVO.txtTipoDocumento);
                        ControladorGeneral.mostrarMensaje(null, LogicaGeneral.getMensaje("CodigoInvalido"));
                        vistaVO.txtCodigo.requestFocus();
                        return false;
                }else{
                        //CANTIDAD DE ORDENES GENERADAS EN EL MES
                        Calendar ca=Calendar.getInstance();
                        ca.set(Calendar.DAY_OF_MONTH, 1);
                        int cantidad=modeloDAO.findOrdenesEntitiesPorFechasEmpleado(ca.getTime(),new Date(), empleadoVO); 
                        if(cantidad>=empleadoVO.getCupoOrdenes()){
                            ControladorGeneral.mostrarMensaje(null, LogicaGeneral.getMensaje("CantidadMayor")+" "+empleadoVO.getCupoOrdenes()+" ordenes mensuales");
                             ControladorGeneral.vaciarCampos(vistaVO.txtDocumento,vistaVO.txtNombreCompleto,vistaVO.txtTipoDocumento,vistaVO.txtCodigo);
                            vistaVO.txtCodigo.requestFocus();
                        
                        }else{
                            List<Ordenes> listaOrdenes= modeloDAO.findOrdenesEntitiesPorFechaEmpleado(new Date(), empleadoVO);
                            if(listaOrdenes.size()>0){
                                 ControladorGeneral.mostrarMensaje(null, LogicaGeneral.getMensaje("RegistroEnFecha")+" "+"para este Empleado , Cant:"+listaOrdenes.size());
                                 ControladorGeneral.vaciarCampos(vistaVO.txtDocumento,vistaVO.txtNombreCompleto,vistaVO.txtTipoDocumento,vistaVO.txtCodigo);
                                 vistaVO.txtCodigo.requestFocus();
                                return false;
                            }
                        }
                        
                }
         }
        
        return true;
    }

   
    

    
    //IMPLEMENTACION DE METODOS DE ESCUCHA               
    //INTERFACE ACTION LISTENER 
    @Override
    public void actionPerformed(ActionEvent e) {
       
        //Aqui se agrega el código de acción al botón acpetar del formulario Login
//        if(e.getSource()==vistaVO.btnGuardar){             
//             eventoGuardar();       
//        }

        
        if(e.getSource()==vistaVO.btnCerrar){
         ControladorGeneral.salirAplicación();
      } 
        
       
                     
        
      //Evento Minimizar
       if(e.getSource()==vistaVO.btnMinimizar){
             ControladorGeneral.eventoMaximizarMinimizarPrincipal(vistaVO, "Minimizar");
      } 
        //Evento Maximizar
      if(e.getSource()==vistaVO.btnMaximizar){
          System.out.println("Entro evento Maximinzar");
               ControladorGeneral.eventoMaximizarMinimizarPrincipal(vistaVO, "Maximizar");
      } 
      
      
         //Evento Maximizar
      if(e.getSource()==vistaVO.txtCodigo){
            Empleados empleado= this.empleadoDAO.getEmpleadoCódigo(vistaVO.txtCodigo.getText().trim());
            if(empleado==null){
                ControladorGeneral.vaciarCampos(vistaVO.txtDocumento,vistaVO.txtNombreCompleto,vistaVO.txtTipoDocumento,vistaVO.txtCodigo);
                ControladorGeneral.mostrarMensaje(null, LogicaGeneral.getMensaje("CodigoInvalido"));
            }else{
                this.empleadoVO=empleado;
                llenarDatosEmpleado();
            }
      } 
       
        
        
    }
    
 
    @Override
    public void mouseClicked(MouseEvent e) {
      
    }

     @Override
    public void mousePressed(MouseEvent e) {
           //Aqui se capturan las coordenadas x y y cuando se presiona sobre el label para mover
           if(e.getSource()==vistaVO.labelMover){  
             
               x=e.getX();
               y=e.getY();
             
                          
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
   
    }

    @Override
    public void mouseEntered(MouseEvent e) {
      
    }

    @Override
    public void mouseExited(MouseEvent e) {
     
    }
    @Override
    public void mouseDragged(MouseEvent e) {
       
         //Aqui se controla el evento para mover la vista
         if(e.getSource()==vistaVO.labelMover){                    
            ControladorGeneral.eventoDraggMovimientoVista(vistaVO, x, y, e);
           
         }
    }
    @Override
    public void mouseMoved(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
     
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }

  
    
    
}
