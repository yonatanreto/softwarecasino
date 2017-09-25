/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import modelo.dao.UsuariosDAO;
import modelo.logica.LogicaGeneral;
import modelo.vo.Usuarios;

import vista.JFUsuario;

/**
 *
 * @author Usuario
 */
public class ControladorUsuario implements ActionListener,InternalFrameListener,MouseListener,MouseMotionListener,KeyListener{
        JFUsuario vistaVO;
        UsuariosDAO modeloDAO; 
        ControladorListaUsuario controladorLista;
        Usuarios objetoVO;
        String acción="";
        int x;
        int y;
           

    public ControladorUsuario(ControladorListaUsuario controladorLista,JFUsuario vistaVO, UsuariosDAO modeloDAO,Usuarios objetoVO) {
        this.controladorLista=controladorLista;
        this.objetoVO=objetoVO;
        this.vistaVO = vistaVO;
        this.modeloDAO = modeloDAO;
        this.vistaVO.btnGuardar.addActionListener(this);
        
        
            
            //Implementación de eventos para todas las vistas
            this.vistaVO.txtUsuario.addActionListener(this);
            this.vistaVO.txtContraseña.addActionListener(this);
            this.vistaVO.txtConfirmarContraseña.addActionListener(this);
            this.vistaVO.btnCerrar.addActionListener(this);
            this.vistaVO.btnMinimizar.addActionListener(this);
           
            this.vistaVO.labelMover.addMouseMotionListener(this);
            this.vistaVO.labelMover.addMouseListener(this);
            this.vistaVO.comboTipo.addKeyListener(this);
            this.vistaVO.comboTipo.addActionListener(this);
      
    }
    
    
    //Este metodo inicializa la vista de Usuario configurando algunas caracteristicas propias
    public void inicializar(){
          ((javax.swing.plaf.basic.BasicInternalFrameUI)vistaVO.getUI()).setNorthPane(null);
          ControladorGeneral.inicializar(vistaVO,"Usuario");
          
         
          //Aqui asigno que solo se permitan 10 caracteres en los campos
          ControladorGeneral.formatoCantidadCaracteres(40, 
                  vistaVO.txtUsuario,
                  vistaVO.txtContraseña,
                  vistaVO.txtConfirmarContraseña);
          
          if(acción.equalsIgnoreCase("EDITAR")){
              vistaVO.btnGuardar.setText("Aceptar");
              llenarDatosObjetoVO();
          }
         
      }
    
    public void llenarDatosObjetoVO(){
            vistaVO.txtUsuario.setText(objetoVO.getUsuario());
            vistaVO.txtContraseña.setText(objetoVO.getClave());
            vistaVO.txtConfirmarContraseña.setText(objetoVO.getClave());
            vistaVO.comboTipo.setSelectedItem(objetoVO.getTipo());
     }
      
  
    
    //Este metodo guarda o edita un objetoVO
    public void guardar(){
        if(objetoVO==null){
         objetoVO=new Usuarios();
        }
        prepararObjeto(objetoVO);
          
        String mensaje="";
        if(this.acción.equalsIgnoreCase("NUEVO")){
            mensaje="Guardar";
            modeloDAO.crear(objetoVO);
        }else{
            try {
                 modeloDAO.editar(objetoVO);
            } catch (Exception ex) {
                Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
           mensaje="Editar";
        }

       if(controladorLista.vistaLista!=null){
          controladorLista.actualizar_tabla();
        }
        ControladorGeneral.mostrarMensaje(null, LogicaGeneral.getMensaje(mensaje));
        ControladorGeneral.salirVista("FormularioUsuario", vistaVO);
    }
    
    //Prepara el objeta para  ser guardado o editado
    public void prepararObjeto(Usuarios usuario){
        usuario.setUsuario(vistaVO.txtUsuario.getText());
        usuario.setClave(vistaVO.txtContraseña.getText());    
        usuario.setTipo((String) vistaVO.comboTipo.getSelectedItem());  
    }
    

       //Valida que los campos no esten vacíos 
        public boolean validar(){
            String respuesta="";
        if(!(respuesta=ControladorGeneral.validarTxtVacios(vistaVO.txtUsuario,
                vistaVO.txtContraseña,
                vistaVO.txtConfirmarContraseña)).equalsIgnoreCase("OK")){
                return false;
        }else if(!vistaVO.txtContraseña.getText().equalsIgnoreCase(vistaVO.txtConfirmarContraseña.getText())){
        
                ControladorGeneral.mostrarMensaje(null, LogicaGeneral.getMensaje("CampoIgual")+" "+"Confirmar contraseña");
                return false;
        }
       
        return true;
    }

    //Este metodo se encarga de validar y guardar un nuevo Elemento
    public void eventoGuardar(){
        
      if(validar()){
          String nombreUsuario= this.vistaVO.txtUsuario.getText();
          String nombreObjeto=objetoVO==null?"":objetoVO.getUsuario();
          if(ControladorGeneral.validarCampoUnico(acción, nombreUsuario, nombreObjeto, modeloDAO)){          
              guardar();
          }else{
             ControladorGeneral.mostrarMensaje(null, LogicaGeneral.getMensaje("CampoUnico")+" "+"Usuario");
             vistaVO.txtUsuario.requestFocus();
          }
          
        }
    }
    

    
    //IMPLEMENTACION DE METODOS DE ESCUCHA               
    //INTERFACE ACTION LISTENER 
    @Override
    public void actionPerformed(ActionEvent e) {
       
        //Aqui se agrega el código de acción al botón acpetar del formulario Login
        if(e.getSource()==vistaVO.btnGuardar){             
             eventoGuardar();       
        }

        
        if(e.getSource()==vistaVO.btnCerrar){
                  ControladorGeneral.salirVista("FormularioUsuario", vistaVO);
               
        }
          if(e.getSource()==vistaVO.txtUsuario){             
                 vistaVO.txtContraseña.requestFocus();
        }
          if(e.getSource()==vistaVO.txtContraseña){             
                 vistaVO.txtConfirmarContraseña.requestFocus();
        }
          if(e.getSource()==vistaVO.txtConfirmarContraseña){             
                 vistaVO.comboTipo.requestFocus();
        }
          

             
             
        if(e.getSource()==vistaVO.btnMinimizar){
           ControladorGeneral.eventoMinimizarVistas(vistaVO);
        }
        
        
    }
    
    
    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
        
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
        ControladorGeneral.salirVista("FormularioUsuario", vistaVO);
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {
        
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {
       
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
       
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
        
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
         if(e.getSource()==vistaVO.comboTipo){ 
           
           if( e.getKeyCode()==KeyEvent.VK_ENTER){
              
              vistaVO.btnGuardar.requestFocus();    
           }
            if( e.getKeyCode()==e.VK_SPACE){
             
              vistaVO.comboTipo.showPopup();
           }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

  
    
    
}
