/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import modelo.dao.RestaurantesDAO;
import modelo.dao.UsuariosDAO;
import modelo.logica.LogicaGeneral;
import modelo.vo.Restaurantes;
import modelo.vo.Usuarios;
import vista.JFRestaurante;

import vista.JFUsuario;

/**
 *
 * @author Usuario
 */
public class ControladorRestaurante implements ActionListener,InternalFrameListener,MouseListener,MouseMotionListener{
        JFRestaurante vistaVO;
        RestaurantesDAO modeloDAO; 
        ControladorListaRestaurantes controladorLista;
        Restaurantes objetoVO;
        String acción="";
        int x;
        int y;
           

    public ControladorRestaurante(ControladorListaRestaurantes controladorListaRestaurante,JFRestaurante vistaVO, RestaurantesDAO modeloDAO,Restaurantes objetoVO) {
        this.controladorLista=controladorListaRestaurante;
        this.objetoVO=objetoVO;
        this.vistaVO = vistaVO;
        this.modeloDAO = modeloDAO;
        this.vistaVO.btnGuardar.addActionListener(this);
        
        
            
            //Implementación de eventos para todas las vistas
            this.vistaVO.txtNombre.addActionListener(this);
            this.vistaVO.txtNit.addActionListener(this);
            this.vistaVO.btnCerrar.addActionListener(this);
            this.vistaVO.btnMinimizar.addActionListener(this);
            this.vistaVO.labelMover.addMouseMotionListener(this);
            this.vistaVO.labelMover.addMouseListener(this);
      
    }
    
    
    //Este metodo inicializa la vista de Usuario configurando algunas caracteristicas propias
    public void inicializar(){
          ((javax.swing.plaf.basic.BasicInternalFrameUI)vistaVO.getUI()).setNorthPane(null);
          ControladorGeneral.inicializar(vistaVO,"Restaurante");
          
         
          //Aqui asigno que solo se permitan 10 caracteres en los campos
          ControladorGeneral.formatoCantidadCaracteres(50, 
                  vistaVO.txtNombre);
           //Aqui asigno que solo se permitan 10 caracteres en los campos
          ControladorGeneral.formatoCantidadCaracteres(40, 
                  vistaVO.txtNit);
          
          if(acción.equalsIgnoreCase("EDITAR")){
//              vistaVO.btnGuardar.setText("Aceptar");
              llenarDatosObjetoVO();
          }
           vistaVO.txtNombre.requestFocus();
      }
    
    public void llenarDatosObjetoVO(){
            vistaVO.txtNombre.setText(objetoVO.getNombre());
            vistaVO.txtNit.setText(objetoVO.getNit());
        
     }
      
  
    
    //Este metodo guarda o edita un objetoVO
    public void guardar(){
        if(objetoVO==null){
         objetoVO=new Restaurantes();
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
                Logger.getLogger(ControladorRestaurante.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
           mensaje="Editar";
        }

       if(controladorLista.vistaLista!=null){
          controladorLista.actualizar_tabla();
        }
        ControladorGeneral.mostrarMensaje(null, LogicaGeneral.getMensaje(mensaje));
        ControladorGeneral.salirVista("FormularioRestaurante", vistaVO);
    }
    
    //Prepara el objeta para  ser guardado o editado
    public void prepararObjeto(Restaurantes objetoVO){
        objetoVO.setNombre(vistaVO.txtNombre.getText());
        objetoVO.setNit(vistaVO.txtNit.getText());    
       
    }
    

       //Valida que los campos no esten vacíos 
        public boolean validar(){
            String respuesta="";
        if(!(respuesta=ControladorGeneral.validarTxtVacios(vistaVO.txtNombre,
                 vistaVO.txtNit)).equalsIgnoreCase("OK")){
                return false;
        }
       
        return true;
    }

    //Este metodo se encarga de validar y guardar un nuevo Elemento
    public void eventoGuardar(){
        
      if(validar()){
          String campoUnicoVista= this.vistaVO.txtNit.getText();
          String nombreObjeto=objetoVO==null?"":objetoVO.getNit();
          if(ControladorGeneral.validarCampoUnico(acción, campoUnicoVista, nombreObjeto, modeloDAO)){          
              guardar();
          }else{
             ControladorGeneral.mostrarMensaje(null, LogicaGeneral.getMensaje("CampoUnico")+" "+"Nit");
             vistaVO.txtNit.requestFocus();
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
                  ControladorGeneral.salirVista("FormularioRestaurante", vistaVO);
               
            }
        if(e.getSource()==vistaVO.txtNombre){
                  vistaVO.txtNit.requestFocus();
               
            }
        if(e.getSource()==vistaVO.txtNit){
                  vistaVO.btnGuardar.requestFocus();
               
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
        ControladorGeneral.salirVista("FormularioRestaurante", vistaVO);
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

  
    
    
}
