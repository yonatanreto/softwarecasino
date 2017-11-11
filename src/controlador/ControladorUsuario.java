/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import modelo.Conexion;
import modelo.dao.PermisosDAO;
import modelo.dao.UsuariosDAO;
import modelo.dao.exceptions.NonexistentEntityException;
import modelo.logica.LogicaGeneral;
import modelo.vo.Permisos;
import modelo.vo.Usuarios;

import vista.JFUsuario;

/**
 *
 * @author Usuario
 */
public class ControladorUsuario implements ActionListener,InternalFrameListener,MouseListener,MouseMotionListener,KeyListener{
        JFUsuario vistaVO;
        UsuariosDAO modeloDAO; 
        PermisosDAO modeloPermisoDAO; 
        ControladorListaUsuario controladorLista;
        Usuarios objetoVO;
        String acción="";
        int x;
        int y;
        List<Permisos> listaPermisos = new ArrayList();
           

    public ControladorUsuario(ControladorListaUsuario controladorLista,JFUsuario vistaVO, UsuariosDAO modeloDAO,Usuarios objetoVO) {
        this.controladorLista=controladorLista;
        this.objetoVO=objetoVO;
        this.vistaVO = vistaVO;
        this.modeloDAO = modeloDAO;
        this.vistaVO.btnGuardar.addActionListener(this);
         modeloPermisoDAO = new PermisosDAO(Conexion.f); 
        
            
            //Implementación de eventos para todas las vistas
            this.vistaVO.txtUsuario.addActionListener(this);
            this.vistaVO.txtContraseña.addActionListener(this);
            this.vistaVO.txtConfirmarContraseña.addActionListener(this);
            this.vistaVO.btnCerrar.addActionListener(this);
            this.vistaVO.btnMinimizar.addActionListener(this);
            this.vistaVO.btnAtras.addActionListener(this);
            this.vistaVO.btnSiguiente.addActionListener(this);
           
            this.vistaVO.labelMover.addMouseMotionListener(this);
            this.vistaVO.labelMover.addMouseListener(this);
            this.vistaVO.comboTipo.addKeyListener(this);
            this.vistaVO.comboTipo.addActionListener(this);
      
    }
    
    
    //Este metodo inicializa la vista de Usuario configurando algunas caracteristicas propias
    public void inicializar(){
          ((javax.swing.plaf.basic.BasicInternalFrameUI)vistaVO.getUI()).setNorthPane(null);
          ControladorGeneral.inicializar(vistaVO,"Usuario");
          this.vistaVO.btnAtras.setVisible(false);
          this.vistaVO.btnSiguiente.setVisible(false);
          
         
          //Aqui asigno que solo se permitan 10 caracteres en los campos
          ControladorGeneral.formatoCantidadCaracteres(40, 
                  vistaVO.txtUsuario,
                  vistaVO.txtContraseña,
                  vistaVO.txtConfirmarContraseña);
          
          if(acción.equalsIgnoreCase("EDITAR")){
//              vistaVO.btnGuardar.setText("Aceptar");
              llenarDatosObjetoVO();
          }
          
        
         
      }
    
    public void llenarDatosObjetoVO(){
            vistaVO.txtUsuario.setText(objetoVO.getUsuario());
            vistaVO.txtContraseña.setText(objetoVO.getClave());
            vistaVO.txtConfirmarContraseña.setText(objetoVO.getClave());
            vistaVO.comboTipo.setSelectedItem(objetoVO.getTipo());
            visualizacionBotonesSiguienteAtras();
            cargarPermisos();
     }
      
    public void visualizacionBotonesSiguienteAtras(){
      if(((String)vistaVO.comboTipo.getSelectedItem()).equalsIgnoreCase("LIMITADO")){
         this.vistaVO.btnSiguiente.setVisible(true);
      }else{
         this.vistaVO.btnSiguiente.setVisible(false);
         this.vistaVO.btnAtras.setVisible(false);
      }
    
    }
    
    public void cargarPermisos(){
        //Aqui se listan los permisos y se asignan a los CheckBox
    listaPermisos = modeloPermisoDAO.findPermisosEntitiesPorUsuario(objetoVO);
     
        for (int i = 0; i < vistaVO.panelPermisos.getComponentCount(); i++) {            
            String nombre=vistaVO.panelPermisos.getComponent(i).getName();
            System.out.println("");
            for (int j = 0; j < listaPermisos.size(); j++) {
                if(listaPermisos.get(j).getNombrePermiso().equalsIgnoreCase(nombre)){
                    ((JCheckBox)vistaVO.panelPermisos.getComponent(i)).setSelected(true);
                     listaPermisos.remove(j);
                     break;
                }
            }
        }
     
    }
    
    public void guardarPermisos(){
        List<Permisos> listaPermisos_aux= new ArrayList<>();
        List<Permisos> listaPermisos_guardados=  modeloPermisoDAO.findPermisosEntitiesPorUsuario(objetoVO);
        int sw=0;
         String nombre="";
       for (int i = 0; i < vistaVO.panelPermisos.getComponentCount(); i++) {            
           
            
            //Aqui valido que sea un componente CHeckBox
            if(vistaVO.panelPermisos.getComponent(i).getClass().getSimpleName().equalsIgnoreCase("JCheckBox")&& ((JCheckBox)vistaVO.panelPermisos.getComponent(i)).isSelected()){
             nombre=vistaVO.panelPermisos.getComponent(i).getName();
                System.out.println("Permiso "+nombre);
            }else{
            continue;
            }
            
            //Aqui comparo si el permiso seleccionado estaba en la lista, si esta se guarda en una auxiliar y se quita de la lista principal
            for (int j = 0; j < listaPermisos_guardados.size(); j++) {
                if(listaPermisos_guardados.get(j).getNombrePermiso().equalsIgnoreCase(nombre)){
                    listaPermisos_aux.add(listaPermisos_guardados.remove(j));
                    sw=1;
                    break;
                }
            }            
            
            if(sw==1){
              sw=0;
            
            }else{
              //Si no estaba en la lista 
              //Aqui creo el nuevo permiso
                Permisos permiso=new Permisos();
                permiso.setUsuario(objetoVO);
                permiso.setNombrePermiso(nombre);
                modeloPermisoDAO.crear(permiso);
            
            }
            
           
        }
       
        eliminarPermisos(listaPermisos_guardados);
    
    }
    
    public void eliminarPermisos(List<Permisos> listaPermisos_guardados){
    
          for (int j = 0; j < listaPermisos_guardados.size(); j++) {
              System.out.println("PErmisos a eliminar "+listaPermisos_guardados.get(j).getNombrePermiso());
              try {
                  modeloPermisoDAO.eliminar(listaPermisos_guardados.get(j).getId());
              } catch (NonexistentEntityException ex) {
                  Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
              }
            }
    
    
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
        
        guardarPermisos();

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
          if(ControladorGeneral.validarCampoUnico1(acción, nombreUsuario, nombreObjeto, modeloDAO)){          
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
           if(e.getSource()==vistaVO.btnAtras){             
                 vistaVO.txtConfirmarContraseña.requestFocus();
                  this.vistaVO.btnSiguiente.setVisible(true);
                  this.vistaVO.btnAtras.setVisible(false);
                  ((CardLayout)this.vistaVO.jXPanel2.getLayout()).show(vistaVO.jXPanel2,"card2");
        }
          if(e.getSource()==vistaVO.btnSiguiente){             
                 this.vistaVO.btnAtras.setVisible(true);
                 this.vistaVO.btnSiguiente.setVisible(false);
                  ((CardLayout)this.vistaVO.jXPanel2.getLayout()).show(vistaVO.jXPanel2,"card3");
        }
          if(e.getSource()==vistaVO.comboTipo){             
               visualizacionBotonesSiguienteAtras();
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
