/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import modelo.dao.CargosDAO;
import modelo.dao.ConfiguracionImpresionOrdenDAO;
import modelo.dao.EmpleadosDAO;
import modelo.dao.OrdenesDAO;
import modelo.logica.LogicaGeneral;
import modelo.reportes.ModeloReportes;
import modelo.vo.Cargos;
import modelo.vo.ConfiguracionImpresionOrden;
import modelo.vo.Empleados;
import modelo.vo.Ordenes;
import utilidades.MiJDateChooser;
import utilidades.MiTableRowSorter;
import vista.JFCargo;
import vista.JFEmpleado;
import vista.JFListaCargos;
import vista.JFListaEmpleados;
import vista.JFListaOrdenes;


/**
 *
 * @author Usuario
 */
public class ControladorListaOrdenes implements ActionListener , Runnable, MouseListener,KeyListener,MouseMotionListener{
            JFListaOrdenes vistaLista;
            OrdenesDAO modeloDAO; 
            Ordenes objetoVO;
            Thread hilo=null;
            int x;
            int y;
            Date fechaIni;
            Date fechaFin;
            public DefaultTableModel dtm=new DefaultTableModel();
            public ListSelectionModel select;
            public MiTableRowSorter sorter=null;
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm a");
        
        
    public ControladorListaOrdenes(JFListaOrdenes vistaLista) {
            this.vistaLista = vistaLista;
            this.modeloDAO = new  OrdenesDAO(Conexion.f);
            this.vistaLista.btnSalir.addActionListener(this);   
            this.vistaLista.btnBuscar.addActionListener(this);
            this.vistaLista.btnImprimir.addActionListener(this);
            this.vistaLista.btnImprimirTicket.addActionListener(this);
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
          configurarJDateChoosers();
          ControladorGeneral.inicializar(vistaLista,"Listado de ordenes");
          ControladorGeneral.arrancarHilo(hilo, this);
          
          

      }
    public void configurarJDateChoosers(){
      ControladorGeneral.configurarJdateChooser(vistaLista.jdcFechaInicial, new Date(), new Date(),true);
      ControladorGeneral.configurarJdateChooser(vistaLista.jdcFechaFinal, new Date(), new Date(),true);
    }       
    public void configurarTabla(){
         dtm=(DefaultTableModel) vistaLista.tabla.getModel();
         vistaLista.tabla.getTableHeader().setReorderingAllowed(false);
         select= vistaLista.tabla.getSelectionModel();
         vistaLista.tabla.setSelectionMode(select.SINGLE_SELECTION);
         vistaLista.tabla.getColumnModel().getColumn(0).setPreferredWidth(10);
         vistaLista.tabla.getColumnModel().getColumn(1).setPreferredWidth(180);
         vistaLista.tabla.getColumnModel().getColumn(2).setPreferredWidth(220);
         vistaLista.tabla.getColumnModel().getColumn(3).setPreferredWidth(30);
         vistaLista.tabla.getColumnModel().getColumn(4).setPreferredWidth(10);
         vistaLista.tabla.getColumnModel().getColumn(5).setPreferredWidth(30);
         
         select.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent e) {
                }
          });
         ControladorGeneral.personalizarTabla(vistaLista.tabla);
    }
    
   public void imprimirTicket(){
      if(!select.isSelectionEmpty()) {
                        objetoVO=getObjetoVOSeleccionado();
                      
                             
                        ConfiguracionImpresionOrden objetoVoConfiguracion=ConfiguracionImpresionOrdenDAO.getConfiguracionImpresionOrden();
                        ModeloReportes modeloReportes = new ModeloReportes();
                        modeloReportes.imprimirOrdenTicket(objetoVO, objetoVoConfiguracion);
                        }else{
                     ControladorGeneral.mostrarMensaje(null, LogicaGeneral.getMensaje("SeleccionFila"));
                 }
   
   }

    //Metodo que implementa la interfaz Runnable
    @Override
    public void run(){
		try {
//                   if(dtm==null){
//                   configurarTabla();
//                   }    
                    fechaIni=vistaLista.jdcFechaInicial.getDate();
                    fechaFin=vistaLista.jdcFechaFinal.getDate();
                     List  listaObjetoVO=null;
                     if(ControladorPrincipal.usuario.getTipo().equals("RESTAURANTE")){
                         listaObjetoVO=(List) modeloDAO.findOrdenesEntitiesPorFechasRestaurante(vistaLista.jdcFechaInicial.getDate(),vistaLista.jdcFechaFinal.getDate(),ControladorPrincipal.usuario.getRestaurante());
                     
                      
                    }else{
                        listaObjetoVO=(List) modeloDAO.findOrdenesEntitiesPorFechas(vistaLista.jdcFechaInicial.getDate(),vistaLista.jdcFechaFinal.getDate());
                     
                     }
                  
                    LogicaGeneral.setListaEntidad("Ordenes",listaObjetoVO);
                   ////[Usuario], [Tipo]
                   for(int i=0;i<listaObjetoVO.size();i++){
                        Ordenes objetoVO_aux=(Ordenes) listaObjetoVO.get(i);
                        Object fila[]=new Object[6];
                        fila[0]=" "+objetoVO_aux.getCodigo();
                        fila[1]=" "+objetoVO_aux.getRestaurante().getNombre();     
                        fila[2]=" "+objetoVO_aux.getEmpleado().toString();   
                        fila[3]=" "+ formatoFecha.format(objetoVO_aux.getFecha());   
                        fila[4]=" "+ formatoHora.format(objetoVO_aux.getHora());                        
                        fila[5]=" "+(objetoVO_aux.getEstado()==0?"PENDIENTE":"ENTREGADA");     
                       dtm.addRow(fila);
                   }           
                    vistaLista.txtNumeroRegistros.setText("No registros: "+listaObjetoVO.size());
                    if(sorter==null){
				sorter = new MiTableRowSorter(dtm);
                                vistaLista.tabla.setRowSorter(sorter);
                        }
                }catch (Exception ex) {

		 Logger.getLogger(ControladorListaOrdenes.class.getName()).log(Level.SEVERE, null, ex);
                 ex.printStackTrace();

	    }finally{
                   
                 hilo=null;
                 if(LogicaGeneral.getListaEntidad("Ordenes").isEmpty()){
                 ControladorGeneral.mostrarMensaje(null, LogicaGeneral.getMensaje("NoDatosFechas"));
                 }
            }
    }
  
  
//    public void iniciarVistaObjetoVO(String acción){      
//
//                if(ControladorGeneral.vistas.get("FormularioEmpleado")==null){
//                 JFEmpleado vistaVO= new JFEmpleado();
//                 ControladorEmpleado controladorObjetoVO =new ControladorEmpleado(this,vistaVO,modeloDAO,objetoVO);
//                 controladorObjetoVO.acción=acción;
//                 controladorObjetoVO.inicializar();
//                 ControladorGeneral.setVistaJDesktopPane(vistaVO);
//                 ControladorGeneral.vistas.put("FormularioEmpleado",controladorObjetoVO);
//                  vistaVO.txtDocumento.requestFocus();
//               }    
//
//         
//    }
                
                
    
   
     
   //Este metodo obtiene el objetoVO selecccionado en la Tabla.
    public Ordenes getObjetoVOSeleccionado(){   
     return objetoVO=(Ordenes)LogicaGeneral.getListaEntidad("Ordenes").get(ControladorGeneral.filaSeleccionada(select,vistaLista.tabla));
   }
    public void ejecutarFiltrado(){              
               ControladorGeneral.filtrarTabla(vistaLista.comboFiltro,select,sorter,vistaLista.tabla,vistaLista.txtFiltro.getText().trim());
                 vistaLista.txtNumeroRegistros.setText("No registros: "+ControladorGeneral.tabla_para_imprimir(dtm, sorter,vistaLista.tabla).getRowCount());
   }
   
    
   public  void actualizar_tabla(){
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
                Logger.getLogger(ControladorListaOrdenes.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
           }
    }
    
    
    //IMPLEMENTACION DE METODOS DE ESCUCHA               
    //INTERFACE ACTION LISTENER
                
     @Override
    public void actionPerformed(ActionEvent e) {


               //Aqui se agrega el código de acción al botón Nuevo Formulario Lista
            if(e.getSource()==vistaLista.btnBuscar){                

               actualizar_tabla();
               
               
            }
            if(e.getSource()==vistaLista.btnImprimir){                
                 ModeloReportes modeloReportes = new ModeloReportes();
                 modeloReportes.imprimirListaOrdenes(ControladorGeneral.tabla_para_imprimir(dtm, sorter,vistaLista.tabla),fechaIni,fechaFin,vistaLista.txtNumeroRegistros.getText());
                 
                 
            }
            
            if(e.getSource()==vistaLista.btnImprimirTicket){                
                 imprimirTicket();
            }
          
//            
               //Aqui se agrega el código de acción al botón Salir Formulario Lista
            if(e.getSource()==vistaLista.btnSalir){
                 ControladorGeneral.salirVista("ListaOrdenes", vistaLista);
               
            }
            
            if(e.getSource()==vistaLista.btnCerrar){
                ControladorGeneral.salirVista("ListaOrdenes", vistaLista);
               
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
                 imprimirTicket();
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
