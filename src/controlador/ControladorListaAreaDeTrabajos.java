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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import modelo.dao.AreaDeTrabajosDAO;
import modelo.dao.CargosDAO;
import modelo.logica.LogicaGeneral;
import modelo.vo.AreaDeTrabajos;
import modelo.vo.Cargos;
import utilidades.MiTableRowSorter;
import vista.JFAreaDeTrabajo;
import vista.JFCargo;
import vista.JFListaAreaDeTrabajos;
import vista.JFListaCargos;


/**
 *
 * @author Usuario
 */
public class ControladorListaAreaDeTrabajos implements ActionListener , Runnable, MouseListener,KeyListener,MouseMotionListener{
            JFListaAreaDeTrabajos vistaLista;
            AreaDeTrabajosDAO modeloDAO; 
            AreaDeTrabajos objetoVO;
            Thread hilo=null;
            int x;
            int y;
           
            public DefaultTableModel dtm=new DefaultTableModel();
            public ListSelectionModel select;
            public MiTableRowSorter sorter=null;
        
        
    public ControladorListaAreaDeTrabajos(JFListaAreaDeTrabajos vistaLista) {
            this.vistaLista = vistaLista;
            this.modeloDAO = new  AreaDeTrabajosDAO(Conexion.f);
            this.vistaLista.btnNuevo.addActionListener(this);
            this.vistaLista.btnEditar.addActionListener(this);
            this.vistaLista.btnEliminar.addActionListener(this);
            this.vistaLista.btnSalir.addActionListener(this);
           
            this.vistaLista.txtFiltro.addKeyListener(this);            
           
            this.vistaLista.tabla.addMouseListener(this);
            
            
            //Implementación de eventos para todas las vistas
            this.vistaLista.btnCerrar.addActionListener(this);
            this.vistaLista.btnMinimizar.addActionListener(this);
            this.vistaLista.labelMover.addMouseMotionListener(this);
            this.vistaLista.labelMover.addMouseListener(this);
            
            inicializar();
      
    }
      
    public void inicializar(){
          ((javax.swing.plaf.basic.BasicInternalFrameUI)vistaLista.getUI()).setNorthPane(null);
          configurarTabla();
          ControladorGeneral.inicializar(vistaLista,"Listado de usuarios");
          ControladorGeneral.arrancarHilo(hilo, this);
          
          

      }
             
    public void configurarTabla(){
         dtm=(DefaultTableModel) vistaLista.tabla.getModel();
         vistaLista.tabla.getTableHeader().setReorderingAllowed(false);
         select= vistaLista.tabla.getSelectionModel();
         vistaLista.tabla.setSelectionMode(select.SINGLE_SELECTION);
         vistaLista.tabla.getColumnModel().getColumn(0).setPreferredWidth(150);
         vistaLista.tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
         
         select.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                }
          });
         ControladorGeneral.personalizarTabla(vistaLista.tabla);
    }

    //Metodo que implementa la interfaz Runnable
    @Override
    public void run(){
		try {
                   if(dtm==null){
                   configurarTabla();
                   }                   
                    List  listaObjetoVO=(List) modeloDAO.findAreaDeTrabajoEntities();
                    LogicaGeneral.setListaEntidad("AreaDeTrabajos",listaObjetoVO);
                   ////[Usuario], [Tipo]
                   for(int i=0;i<listaObjetoVO.size();i++){
                        AreaDeTrabajos objetoVO_aux=(AreaDeTrabajos) listaObjetoVO.get(i);
                        Object fila[]=new Object[2];
                        fila[0]=" "+objetoVO_aux.getNombre();
                        fila[1]=" "+objetoVO_aux.getCodigo();                      
                       dtm.addRow(fila);
                   }           
                           
                    if(sorter==null){
				sorter = new MiTableRowSorter(dtm);
                                vistaLista.tabla.setRowSorter(sorter);
                        }
                }catch (Exception ex) {

		 Logger.getLogger(ControladorListaAreaDeTrabajos.class.getName()).log(Level.SEVERE, null, ex);
                 ex.printStackTrace();

	    }finally{

                 hilo=null;
            }
    }
  
  
    public void iniciarVistaObjetoVO(String acción){      

                if(ControladorGeneral.vistas.get("FormularioAreaDeTrabajo")==null){
                 JFAreaDeTrabajo vistaVO= new JFAreaDeTrabajo();
                 ControladorAreaDeTrabajo controladorObjetoVO =new ControladorAreaDeTrabajo(this,vistaVO,modeloDAO,objetoVO);
                 controladorObjetoVO.acción=acción;
                 controladorObjetoVO.inicializar();
                 ControladorGeneral.setVistaJDesktopPane(vistaVO);
                 ControladorGeneral.vistas.put("FormularioAreaDeTrabajo",controladorObjetoVO);
                  vistaVO.txtNombre.requestFocus();
               }    

         
    }
                
                
    public void actualizar_tabla(){
           try{

            dtm.getDataVector().removeAllElements();
            sorter = new MiTableRowSorter(dtm);
            vistaLista.tabla.setRowSorter(sorter);
            if(hilo==null){
                    hilo=new Thread(this);
                    hilo.setPriority(Thread.MAX_PRIORITY);
                    hilo.start();
                   
            }
           }catch(Exception ex){
                Logger.getLogger(ControladorListaAreaDeTrabajos.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
           }
    }
   
     
   //Este metodo obtiene el objetoVO selecccionado en la Tabla.
    public AreaDeTrabajos getObjetoVOSeleccionado(){   
     return objetoVO=(AreaDeTrabajos)LogicaGeneral.getListaEntidad("AreaDeTrabajos").get(ControladorGeneral.filaSeleccionada(select,vistaLista.tabla));
   }
    public void ejecutarFiltrado(){              
               ControladorGeneral.filtrarTabla(vistaLista.comboFiltro,select,sorter,vistaLista.tabla,vistaLista.txtFiltro.getText().trim());
   
   }
   
    
  
    
    
    //IMPLEMENTACION DE METODOS DE ESCUCHA               
    //INTERFACE ACTION LISTENER
                
     @Override
    public void actionPerformed(ActionEvent e) {


               //Aqui se agrega el código de acción al botón Nuevo Formulario Lista
            if(e.getSource()==vistaLista.btnNuevo){                
                iniciarVistaObjetoVO("NUEVO");                
            }
            
               //Aqui se agrega el código de acción al botón Editar Formulario Lista
            if(e.getSource()==vistaLista.btnEditar){
                  if(!select.isSelectionEmpty()) {
                        objetoVO=getObjetoVOSeleccionado();
                        iniciarVistaObjetoVO("EDITAR");                
                        }else{
                     ControladorGeneral.mostrarMensaje(null, LogicaGeneral.getMensaje("SeleccionFila"));
                 }

            }
               //Aqui se agrega el código de acción al botón Eliminar Formulario Lista
            if(e.getSource()==vistaLista.btnEliminar){
                    if(!select.isSelectionEmpty()) {
                         objetoVO =getObjetoVOSeleccionado();
                         String mensaje="";
                            if((mensaje=modeloDAO.relacionOtrasEntidades(objetoVO)).equalsIgnoreCase("OK")){
                                try{
                                    modeloDAO.eliminar(objetoVO.getId());
                                    this.actualizar_tabla();
                                    ControladorGeneral.mostrarMensaje(null, LogicaGeneral.getMensaje("Eliminar"));
                                }catch(Exception ex){
                                     Logger.getLogger(ControladorListaAreaDeTrabajos.class.getName()).log(Level.SEVERE, null, ex);
                                     ex.printStackTrace();
                                }
                            }else{
                              ControladorGeneral.mostrarMensaje(null, LogicaGeneral.getMensaje("NoEliminar"));
                            }
                       }else{
                        ControladorGeneral.mostrarMensaje(null, LogicaGeneral.getMensaje("SeleccionFila"));
                    }
            }
               //Aqui se agrega el código de acción al botón Salir Formulario Lista
            if(e.getSource()==vistaLista.btnSalir){
                 ControladorGeneral.salirVista("ListaAreaDeTrabajos", vistaLista);
               
            }
            
            if(e.getSource()==vistaLista.btnCerrar){
                ControladorGeneral.salirVista("ListaAreaDeTrabajos", vistaLista);
               
            }
            
             if(e.getSource()==vistaLista.comboFiltro){
               ejecutarFiltrado();
             }
             
             if(e.getSource()==vistaLista.btnMinimizar){
                ControladorGeneral.eventoMinimizarVistas(vistaLista);
             }
            
            
    }            
   //MOUSE LISTENER

    @Override
    public void mouseClicked(MouseEvent e) {
        
          if(e.getSource()==vistaLista.tabla){
             if(e.getClickCount()==2){
                  if(!select.isSelectionEmpty()) {
                        objetoVO=getObjetoVOSeleccionado();
                        iniciarVistaObjetoVO("EDITAR");                
                        }else{
                     ControladorGeneral.mostrarMensaje(null, LogicaGeneral.getMensaje("SeleccionFila"));
                 }
           }
          
          }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
           //Aqui se capturan las coordenadas x y y cuando se presiona sobre el label para mover
           if(e.getSource()==vistaLista.labelMover){  
             
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
    
    
  

    //KEY LISTENER
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
       if(e.getSource()==vistaLista.txtFiltro){ 
           
               ejecutarFiltrado();
                          
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
       
         //Aqui se controla el evento para mover la vista
         if(e.getSource()==vistaLista.labelMover){                    
            ControladorGeneral.eventoDraggMovimientoVista(vistaLista, x, y, e);
           
         }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
