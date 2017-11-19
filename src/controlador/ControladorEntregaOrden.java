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
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import modelo.Conexion;
import modelo.dao.AreaDeTrabajosDAO;
import modelo.dao.CargosDAO;
import modelo.dao.OrdenesDAO;


import modelo.logica.LogicaGeneral;
import modelo.vo.AreaDeTrabajos;
import modelo.vo.Cargos;
import modelo.vo.Ordenes;
import vista.JFAreaDeTrabajo;

import vista.JFCargo;
import vista.JFEntregaOrden;





/**
 *
 * @author Usuario
 */
public class ControladorEntregaOrden implements ActionListener,InternalFrameListener,MouseListener,MouseMotionListener{
        JFEntregaOrden vistaVO;
        OrdenesDAO modeloDAO; 
     
        Ordenes objetoVO;
        String acción="";
        int x;
        int y;
           

    public ControladorEntregaOrden(JFEntregaOrden vistaVO) {
        this.vistaVO = vistaVO;
        this.modeloDAO = new OrdenesDAO(Conexion.f) ;
        this.vistaVO.btnGuardar.addActionListener(this);
        
        
            
            //Implementación de eventos para todas las vistas
           
            this.vistaVO.txtNumeroOrden.addActionListener(this);
            this.vistaVO.btnCerrar.addActionListener(this);
            this.vistaVO.btnMinimizar.addActionListener(this);
            this.vistaVO.labelMover.addMouseMotionListener(this);
            this.vistaVO.labelMover.addMouseListener(this);
      
    }
    
    
    //Este metodo inicializa la vista de Usuario configurando algunas caracteristicas propias
    public void inicializar(){
          ((javax.swing.plaf.basic.BasicInternalFrameUI)vistaVO.getUI()).setNorthPane(null);
          ControladorGeneral.inicializar(vistaVO,"EntregarOrden");
          
         
          //Aqui asigno que solo se permitan 10 caracteres en los campos
          ControladorGeneral.formatoCantidadCaracteres(99, 
                  vistaVO.txtNumeroOrden);
          
           if(ControladorPrincipal.usuario.getTipo().equals("RESTAURANTE")){
                      vistaVO.txtRestaurante.setText(ControladorPrincipal.usuario.getRestaurante().getNombre());
                      
                }
          
      }
    
   
      
  
    
    //Este metodo guarda o edita un objetoVO
    public void guardar(){
        
        //ESTADO IGUAL A 1 ES ENTREGADO
               objetoVO.setEstado(1);
      
            try {
                 modeloDAO.editar(objetoVO);
            } catch (Exception ex) {
                Logger.getLogger(ControladorEntregaOrden.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        
       
        ControladorGeneral.mostrarMensaje(null,"Orden procesada con exito");
        ControladorGeneral.vaciarCampos(vistaVO.txtRestaurante,vistaVO.txtDocumento,vistaVO.txtEmpleado,vistaVO.txtNumeroOrden);
         if(ControladorPrincipal.usuario.getTipo().equals("RESTAURANTE")){
                      vistaVO.txtRestaurante.setText(ControladorPrincipal.usuario.getRestaurante().getNombre());
                      
                }
         
           vistaVO.txtNumeroOrden.requestFocus();
        
    }
    
   
    

       //Valida que los campos no esten vacíos 
        public boolean validar(){
            String respuesta="";
        if(!(respuesta=ControladorGeneral.validarTxtVacios(vistaVO.txtNumeroOrden)).equalsIgnoreCase("OK")){
                return false;
        }else{
          objetoVO=this.modeloDAO.findOrdenesNumeroOrden(vistaVO.txtNumeroOrden.getText());
            if(objetoVO==null){
                ControladorGeneral.mostrarMensaje(null, LogicaGeneral.getMensaje("RegistroNoEcontrado"));
                vistaVO.txtNumeroOrden.setText("");
                   return false;
            }else{
                
                if(ControladorPrincipal.usuario.getTipo().equals("RESTAURANTE")&&!(objetoVO.getRestaurante().equals(ControladorPrincipal.usuario.getRestaurante()))){
                       JOptionPane.showMessageDialog(vistaVO,"La orden ingresada corresponde a otro restaurante");
                       return false;
                }else{
                 if(objetoVO.getEstado()==1){
                    JOptionPane.showMessageDialog(vistaVO,"La orden seleccionada ya fue entregada");
                    vistaVO.txtNumeroOrden.setText("");
                       return false;
                }
                }
            
            
            }
        
        }
       
        return true;
    }

    public void cargarOrden(){
        if(validar()){
         this.vistaVO.txtRestaurante.setText(objetoVO.getRestaurante().getNombre());
         this.vistaVO.txtDocumento.setText(objetoVO.getEmpleado().getCedula());
         this.vistaVO.txtEmpleado.setText(objetoVO.getEmpleado().toString());
          vistaVO.btnGuardar.requestFocus();
        }else{
        
        ControladorGeneral.vaciarCampos(vistaVO.txtRestaurante,vistaVO.txtDocumento,vistaVO.txtEmpleado);
         if(ControladorPrincipal.usuario.getTipo().equals("RESTAURANTE")){
                      vistaVO.txtRestaurante.setText(ControladorPrincipal.usuario.getRestaurante().getNombre());
                      
                }
          vistaVO.txtNumeroOrden.requestFocus();
        }
    
    }
    //Este metodo se encarga de validar y guardar un nuevo Elemento
    public void eventoGuardar(){
        
      if(validar()){
                 
              guardar();
          
          
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
                  ControladorGeneral.salirVista("FormularioEntregaOrden", vistaVO);
               
            }
        
        if(e.getSource()==vistaVO.txtNumeroOrden){
              cargarOrden();
             

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
        ControladorGeneral.salirVista("FormularioEntregaOrden", vistaVO);
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
