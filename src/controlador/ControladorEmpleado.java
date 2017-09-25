/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.nextic.filtercomponent.components.AbstractCodigo;
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
import modelo.Conexion;
import modelo.dao.AreaDeTrabajosDAO;
import modelo.dao.CargosDAO;
import modelo.dao.EmpleadosDAO;


import modelo.logica.LogicaGeneral;
import modelo.vo.AreaDeTrabajos;
import modelo.vo.Cargos;
import modelo.vo.Empleados;

import vista.JFCargo;
import vista.JFEmpleado;





/**
 *
 * @author Usuario
 */
public class ControladorEmpleado implements ActionListener,InternalFrameListener,MouseListener,MouseMotionListener,KeyListener{
        JFEmpleado vistaVO;
        EmpleadosDAO modeloDAO; 
        ControladorListaEmpleados controladorLista;
        Empleados objetoVO;
        String acción="";
        int x;
        int y;
           

    public ControladorEmpleado(ControladorListaEmpleados controladorLista,JFEmpleado vistaVO, EmpleadosDAO modeloDAO,Empleados objetoVO) {
        this.controladorLista=controladorLista;
        this.objetoVO=objetoVO;
        this.vistaVO = vistaVO;
        this.modeloDAO = modeloDAO;
        this.vistaVO.btnGuardar.addActionListener(this);
        
        
            
            //Implementación de eventos para todas las vistas
            this.vistaVO.txtNombre.addActionListener(this);
            this.vistaVO.txtDocumento.addActionListener(this);
            this.vistaVO.txtApellido1.addActionListener(this);
            this.vistaVO.txtApellido2.addActionListener(this);
            this.vistaVO.btnCerrar.addActionListener(this);
            this.vistaVO.btnMinimizar.addActionListener(this);
            this.vistaVO.labelMover.addMouseMotionListener(this);
            this.vistaVO.labelMover.addMouseListener(this);
             this.vistaVO.comboTipoDocumento.addKeyListener(this);
            this.vistaVO.comboTipoDocumento.addActionListener(this);
      
    }
    
    
    //Este metodo inicializa la vista de Usuario configurando algunas caracteristicas propias
    public void inicializar(){
          ((javax.swing.plaf.basic.BasicInternalFrameUI)vistaVO.getUI()).setNorthPane(null);
          ControladorGeneral.inicializar(vistaVO,"Empleado");
          
         
          //Aqui asigno que solo se permitan 50 caracteres en los campos
          ControladorGeneral.formatoCantidadCaracteres(50,vistaVO.txtNombre,vistaVO.txtApellido1,vistaVO.txtApellido2,vistaVO.txtDocumento);
           vistaVO.jfcAreaDeTrabajo.setNext_component(vistaVO.btnGuardar);
          vistaVO.jfcAreaDeTrabajo.setAuxiliar_component(vistaVO.txtAreaDeTrabajo);
          vistaVO.jfcCargo.setAuxiliar_component(vistaVO.txtCargo);
          vistaVO.jfcCargo.setNext_component(vistaVO.jfcAreaDeTrabajo.filter_campo);
          llenarFilterComponents();
          if(acción.equalsIgnoreCase("EDITAR")){

              llenarDatosObjetoVO();
          }
         
          vistaVO.txtNombre.requestFocus();
      }
    
    public void llenarFilterComponents(){

          CargosDAO   modeloCargo= new  CargosDAO(Conexion.f);
          AreaDeTrabajosDAO   modeloAreaDeTrabajo= new  AreaDeTrabajosDAO(Conexion.f);
          vistaVO.jfcAreaDeTrabajo.llenar_filter(modeloAreaDeTrabajo.findAreaDeTrabajoEntities());
          vistaVO.jfcCargo.llenar_filter(modeloCargo.findCargoEntities());
          
    
    
    }
    
    public void llenarDatosObjetoVO(){
            vistaVO.txtDocumento.setText(objetoVO.getCedula());
            vistaVO.comboTipoDocumento.setSelectedItem(objetoVO.getTipoDocumento());
            vistaVO.txtNombre.setText(objetoVO.getNombres());
            vistaVO.txtApellido1.setText(objetoVO.getApellido1());
            vistaVO.txtApellido2.setText(objetoVO.getApellido2());
            vistaVO.txtNombre.setText(objetoVO.getNombres());
            vistaVO.jfcCargo.setDato((AbstractCodigo)objetoVO.getCargo());
            vistaVO.jfcAreaDeTrabajo.setDato((AbstractCodigo)objetoVO.getAreaDeTrabajo());
            
           
        
     }
      
  
    
    //Este metodo guarda o edita un objetoVO
    public void guardar(){
        if(objetoVO==null){
         objetoVO=new Empleados();
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
                Logger.getLogger(ControladorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
           mensaje="Editar";
        }

       if(controladorLista.vistaLista!=null){
          controladorLista.actualizar_tabla();
        }
        ControladorGeneral.mostrarMensaje(null, LogicaGeneral.getMensaje(mensaje));
        ControladorGeneral.salirVista("FormularioEmpleado", vistaVO);
    }
    
    //Prepara el objeta para  ser guardado o editado
    public void prepararObjeto(Empleados objetoVO){
        objetoVO.setCedula(vistaVO.txtDocumento.getText());
        objetoVO.setTipoDocumento((String) vistaVO.comboTipoDocumento.getSelectedItem());  
        objetoVO.setNombres(vistaVO.txtNombre.getText());
        objetoVO.setApellido1(vistaVO.txtApellido1.getText());
        objetoVO.setApellido2(vistaVO.txtApellido2.getText());
        objetoVO.setCargo((Cargos) vistaVO.jfcCargo.getDato());
        objetoVO.setAreaDeTrabajo((AreaDeTrabajos) vistaVO.jfcAreaDeTrabajo.getDato());
        
       
       
    }
    

       //Valida que los campos no esten vacíos 
        public boolean validar(){
            String respuesta="";
        if(!(respuesta=ControladorGeneral.validarTxtVacios(vistaVO.txtNombre,
                 vistaVO.txtApellido1,vistaVO.txtApellido2)).equalsIgnoreCase("OK")){
                return false;
        }else if(vistaVO.jfcCargo.getDato()==null){
                ControladorGeneral.mostrarMensaje(null, LogicaGeneral.getMensaje("CampoVacio")+" "+"Cargo");
                vistaVO.jfcCargo.filter_campo.requestFocus();
                return false;
        }else if(vistaVO.jfcAreaDeTrabajo.getDato()==null){
                ControladorGeneral.mostrarMensaje(null, LogicaGeneral.getMensaje("CampoVacio")+" "+"Área de trabajo");
                vistaVO.jfcAreaDeTrabajo.filter_campo.requestFocus();
                return false;
        }
       
        return true;
    }

    //Este metodo se encarga de validar y guardar un nuevo Elemento
    public void eventoGuardar(){
        
      if(validar()){
          String campoUnicoVista= this.vistaVO.txtDocumento.getText();
          String nombreObjeto=objetoVO==null?"":objetoVO.getCedula();
          if(ControladorGeneral.validarCampoUnico(acción, campoUnicoVista, nombreObjeto, modeloDAO)){          
              guardar();
          }else{
             ControladorGeneral.mostrarMensaje(null, LogicaGeneral.getMensaje("CampoUnico")+" "+"Documento");
             vistaVO.txtDocumento.requestFocus();
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
                  ControladorGeneral.salirVista("FormularioEmpleado", vistaVO);
               
            }
        
        if(e.getSource()==vistaVO.txtDocumento){
              vistaVO.comboTipoDocumento.requestFocus();

         }
           
           
        if(e.getSource()==vistaVO.txtNombre){
            vistaVO.txtApellido1.requestFocus();

        }
        
        if(e.getSource()==vistaVO.txtApellido1){
            vistaVO.txtApellido2.requestFocus();

        }
        
        if(e.getSource()==vistaVO.txtApellido2){
            vistaVO.jfcCargo.filter_campo.requestFocus();
        }
        
        if(e.getSource()==vistaVO.txtApellido2){
            vistaVO.jfcCargo.filter_campo.requestFocus();
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
        ControladorGeneral.salirVista("FormularioEmpleado", vistaVO);
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
       if(e.getSource()==vistaVO.comboTipoDocumento){ 
           
           if( e.getKeyCode()==KeyEvent.VK_ENTER){
              
              vistaVO.txtNombre.requestFocus();    
           }
            if( e.getKeyCode()==e.VK_SPACE){
             
              vistaVO.comboTipoDocumento.showPopup();
           }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }

  
    
    
}
