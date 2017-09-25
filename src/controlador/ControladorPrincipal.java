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
import javax.swing.JDesktopPane;
import modelo.Conexion;
import modelo.dao.OrdenesDAO;
import modelo.vo.Usuarios;
import vista.JFListaAreaDeTrabajos;
import vista.JFListaCargos;
import vista.JFListaEmpleados;
import vista.JFListaOrdenes;
import vista.JFListaRestaurantes;
import vista.JFListaUsuario;
import vista.JFOrden;
import vista.JFPrincipal;

/**
 *
 * @author Usuario
 */
public class ControladorPrincipal implements ActionListener, MouseListener,MouseMotionListener {
        JFPrincipal vistaPrincipal;
        static Usuarios usuario;
        //Variables para controlar la cantidad de vistas abiertas por cada tipo
        public static JDesktopPane dp;
        static int form_usuario=0;
        static int lista_usuario=0;
        int x;
        int y;
       

    public ControladorPrincipal(JFPrincipal vistaPrincipal, Usuarios usuario) {
        ControladorPrincipal.usuario=usuario;
        ControladorPrincipal.dp=vistaPrincipal.desktopPane;
        this.vistaPrincipal = vistaPrincipal;
        this.vistaPrincipal.btnUsuarios.addActionListener(this);
        this.vistaPrincipal.btnEmpleados.addActionListener(this);
        this.vistaPrincipal.btnRestaurantes.addActionListener(this);       
        this.vistaPrincipal.btnSalir.addActionListener(this);  
        this.vistaPrincipal.btnCerrar.addActionListener(this); 
        this.vistaPrincipal.btnMaximizar.addActionListener(this); 
        this.vistaPrincipal.btnMinimizar.addActionListener(this); 
        this.vistaPrincipal.btnMenu.addActionListener(this); 
        this.vistaPrincipal.btnCargo.addActionListener(this); 
        this.vistaPrincipal.btnAreaDeTrabajo.addActionListener(this); 
        this.vistaPrincipal.btnOrdenes.addActionListener(this); 
        this.vistaPrincipal.btnListaOrdenes.addActionListener(this); 
        
        
        this.vistaPrincipal.labelMover.addMouseMotionListener(this);
        this.vistaPrincipal.labelMover.addMouseListener(this);       
        this.vistaPrincipal.btnMenu.addMouseListener(this);
        this.vistaPrincipal.btnCargo.addMouseListener(this);
        this.vistaPrincipal.btnAreaDeTrabajo.addMouseListener(this);
          this.vistaPrincipal.btnListaOrdenes.addMouseListener(this);
        this.vistaPrincipal.btnRestaurantes.addMouseListener(this);
         this.vistaPrincipal.btnSalir.addMouseListener(this);
        this.vistaPrincipal.btnUsuarios.addMouseListener(this);
        this.vistaPrincipal.btnEmpleados.addMouseListener(this);
         this.vistaPrincipal.desktopPane.addMouseListener(this);
        inicializar();
    }
    
    public void inicializar(){
            vistaPrincipal.popupMenu.add(vistaPrincipal.panelMenu);
//            vistaPrincipal.popupMenu.
            vistaPrincipal.setExtendedState(vistaPrincipal.MAXIMIZED_BOTH);
            vistaPrincipal.setVisible(true);

    }
    //IMPLEMENTACION DE METODOS DE ESCUCHA               
    //INTERFACE ACTION LISTENER
    @Override
    public void actionPerformed(ActionEvent e) {
        
       //Aqui se agrega el código de acción al boton empleados
      if(e.getSource()==vistaPrincipal.btnUsuarios){
         
          //Valido si la vista esta en el hasMap , si no agrego la clave y la registro para validar 
            if(ControladorGeneral.vistas.get("ListaUsuarios")==null){
                    JFListaUsuario vistaLista= new JFListaUsuario();
                     
                    ControladorListaUsuario controladorLista =new ControladorListaUsuario(vistaLista);
                    ControladorPrincipal.dp.add(vistaLista);
                    ControladorGeneral.vistas.put("ListaUsuarios",controladorLista);
                    
                   
               }
             
      } 
        
       
      //Aqui se agrega el código de acción al boton empleados
      if(e.getSource()==vistaPrincipal.btnEmpleados){
             
      } 
      
      //Aqui se agrega el código de acción al boton empleados
      if(e.getSource()==vistaPrincipal.btnRestaurantes){
              //Valido si la vista esta en el hasMap , si no agrego la clave y la registro para validar 
            if(ControladorGeneral.vistas.get("ListaRestaurantes")==null){
                    JFListaRestaurantes vistaLista= new JFListaRestaurantes();
                     
                    ControladorListaRestaurantes controladorLista =new ControladorListaRestaurantes(vistaLista);
                    ControladorPrincipal.dp.add(vistaLista);
                    ControladorGeneral.vistas.put("ListaRestaurantes",controladorLista);
                    
                   
               }
      } 
      
       //Aqui se agrega el código de acción al boton empleados
      if(e.getSource()==vistaPrincipal.btnCargo){
              //Valido si la vista esta en el hasMap , si no agrego la clave y la registro para validar 
            if(ControladorGeneral.vistas.get("ListaCargos")==null){
                    JFListaCargos vistaLista= new JFListaCargos();
                     
                    ControladorListaCargos controladorLista =new ControladorListaCargos(vistaLista);
                    ControladorPrincipal.dp.add(vistaLista);
                    ControladorGeneral.vistas.put("ListaCargos",controladorLista);
                    
                   
               }
      } 
      
       if(e.getSource()==vistaPrincipal.btnAreaDeTrabajo){
           //Valido si la vista esta en el hasMap , si no agrego la clave y la registro para validar 
            if(ControladorGeneral.vistas.get("ListaAreaDeTrabajos")==null){
                    JFListaAreaDeTrabajos vistaLista= new JFListaAreaDeTrabajos();
                     
                    ControladorListaAreaDeTrabajos controladorLista =new ControladorListaAreaDeTrabajos(vistaLista);
                    ControladorPrincipal.dp.add(vistaLista);
                    ControladorGeneral.vistas.put("ListaAreaDeTrabajos",controladorLista);
                    
                   
               }
      } 
       
        if(e.getSource()==vistaPrincipal.btnEmpleados){
           //Valido si la vista esta en el hasMap , si no agrego la clave y la registro para validar 
            if(ControladorGeneral.vistas.get("ListaEmpleados")==null){
                    JFListaEmpleados vistaLista= new JFListaEmpleados();                     
                    ControladorListaEmpleados controladorLista =new ControladorListaEmpleados(vistaLista);
                    ControladorPrincipal.dp.add(vistaLista);
                    ControladorGeneral.vistas.put("ListaEmpleados",controladorLista);                   
                   
               }
      } 
        
          if(e.getSource()==vistaPrincipal.btnListaOrdenes){
           //Valido si la vista esta en el hasMap , si no agrego la clave y la registro para validar 
            if(ControladorGeneral.vistas.get("ListaOrdenes")==null){
                    JFListaOrdenes vistaLista= new JFListaOrdenes();                     
                    ControladorListaOrdenes controladorLista =new ControladorListaOrdenes(vistaLista);
                    ControladorPrincipal.dp.add(vistaLista);
                    ControladorGeneral.vistas.put("ListaOrdenes",controladorLista);                   
                   
               }
      } 
        if(e.getSource()==vistaPrincipal.btnOrdenes){
           //Valido si la vista esta en el hasMap , si no agrego la clave y la registro para validar 
            if(ControladorGeneral.vistas.get("FormularioOrden")==null){
                    JFOrden vistaVO= new JFOrden();               
                    ControladorOrden controladorObjetoVO =new ControladorOrden(vistaVO);
                    controladorObjetoVO.inicializar();
                    ControladorPrincipal.dp.add(vistaVO);
                    ControladorGeneral.vistas.put("FormularioOrden",controladorObjetoVO);      
                    vistaVO.jfcEmpleado.filter_campo.requestFocus();
                   
               }
      } 
             
    //Aqui se agrega el código de acción al botón salir
      if(e.getSource()==vistaPrincipal.btnSalir){
         ControladorGeneral.salirAplicación();
      } 
      if(e.getSource()==vistaPrincipal.btnCerrar){
         ControladorGeneral.salirAplicación();
      } 
      
      //Evento Minimizar
       if(e.getSource()==vistaPrincipal.btnMinimizar){
             ControladorGeneral.eventoMaximizarMinimizarPrincipal(vistaPrincipal, "Minimizar");
      } 
        //Evento Maximizar
      if(e.getSource()==vistaPrincipal.btnMaximizar){
               ControladorGeneral.eventoMaximizarMinimizarPrincipal(vistaPrincipal, "Maximizar");
      } 
      //Evento Menu
      if(e.getSource()==vistaPrincipal.btnMenu){
          vistaPrincipal.popupMenu.show(vistaPrincipal.btnMenu, vistaPrincipal.btnMenu.getX()+10, vistaPrincipal.btnMenu.getY()+vistaPrincipal.btnMenu.getHeight());
               
      } 
      
      
      
      
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //Se asignan las coordenadas para calcular el movimiento
         if(e.getSource()==vistaPrincipal.labelMover){             
               x=e.getX();
               y=e.getY();            
                          
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
         
         
           //Evento Menu
      if(e.getSource()==vistaPrincipal.btnMenu){
          vistaPrincipal.popupMenu.show(vistaPrincipal.btnMenu, vistaPrincipal.btnMenu.getX()+10, vistaPrincipal.btnMenu.getY()+vistaPrincipal.btnMenu.getHeight());
               
      } 
      if(e.getSource()==vistaPrincipal.btnCargo){
         ControladorGeneral.eventoPanelMenu(vistaPrincipal.btnCargo.getParent(),"ACTIVADO");
               
      } 
      if(e.getSource()==vistaPrincipal.btnAreaDeTrabajo){
         ControladorGeneral.eventoPanelMenu(vistaPrincipal.btnAreaDeTrabajo.getParent(),"ACTIVADO");
      } 
       if(e.getSource()==vistaPrincipal.btnListaOrdenes){
         ControladorGeneral.eventoPanelMenu(vistaPrincipal.btnListaOrdenes.getParent(),"ACTIVADO");
      } 
      
      
     if(e.getSource()==vistaPrincipal.btnRestaurantes){                    
             vistaPrincipal.popupMenu.setVisible(false);

      }
     if(e.getSource()==vistaPrincipal.btnUsuarios){                    
              vistaPrincipal.popupMenu.setVisible(false);

      }
     if(e.getSource()==vistaPrincipal.btnEmpleados){                    
            vistaPrincipal.popupMenu.setVisible(false);

     }
     if(e.getSource()==vistaPrincipal.btnSalir){                    
            vistaPrincipal.popupMenu.setVisible(false);

     }
      if(e.getSource()==vistaPrincipal.desktopPane){                    
            vistaPrincipal.popupMenu.setVisible(false);

     }
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
        
        if(e.getSource()==vistaPrincipal.btnCargo){
         ControladorGeneral.eventoPanelMenu(vistaPrincipal.btnCargo.getParent(),"NOACTIVADO");
               
        }
        
      if(e.getSource()==vistaPrincipal.btnAreaDeTrabajo){
         ControladorGeneral.eventoPanelMenu(vistaPrincipal.btnAreaDeTrabajo.getParent(),"NOACTIVADO");
      }
      if(e.getSource()==vistaPrincipal.btnListaOrdenes){
         ControladorGeneral.eventoPanelMenu(vistaPrincipal.btnListaOrdenes.getParent(),"NOACTIVADO");
      }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
         if(e.getSource()==vistaPrincipal.labelMover){                    
            ControladorGeneral.eventoDraggMovimientoVista(vistaPrincipal, x, y, e);           
         }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
         
    }
    
}
