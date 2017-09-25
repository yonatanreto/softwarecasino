/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import modelo.Conexion;
import modelo.logica.LogicaGeneral;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.painter.CompoundPainter;
import org.jdesktop.swingx.painter.GlossPainter;
import org.jdesktop.swingx.painter.MattePainter;
import org.jdesktop.swingx.painter.PinstripePainter;
import sun.swing.table.DefaultTableCellHeaderRenderer;
import utilidades.CampoUnicoDAO;
import utilidades.FormatoTextField;
import utilidades.MiJDateChooser;
import utilidades.MiTableRowSorter;
import vista.JFPrincipal;
import vista.JFPrincipal;

/**
 *
 * @author Usuario
 */
public class ControladorGeneral {
      public static HashMap vistas=new HashMap();
     
      
      
    //Metodo que permite cambiar la apariencia de los paneles
    public  static  void setupPainters(JXPanel jXPanel1,String color) {
        //GlossPainter gloss = new GlossPainter(new Color(1.0f, 1.0f, 1.0f, 0.2f),GlossPainter.GlossPosition.TOP);
        GlossPainter gloss = new GlossPainter(new Color(1.0f, 1.0f, 1.0f, 0.4f),GlossPainter.GlossPosition.TOP);
        PinstripePainter stripes = new PinstripePainter();
        stripes.setPaint(new Color(1.0f, 1.0f, 1.0f, 0.4f));
        stripes.setSpacing(5.0);
        MattePainter matte = new MattePainter(new Color(235,234,233));
        jXPanel1.setBackgroundPainter(new CompoundPainter(matte, stripes, gloss));

       
      gloss=null;
      stripes=null;
      matte=null;
    }
    
    //Inicialización general de las vistas
    public static void inicializar(JInternalFrame vista, String titulo){
//          vista.setTitle(titulo);
          ControladorGeneral.centrarVista(vista);
          vista.setVisible(true);
    
    }
    
    public static void centrarVista(JInternalFrame vista){
      int x= (ControladorPrincipal.dp.getWidth()/2) - (vista.getWidth()/2);
      int y= (ControladorPrincipal.dp.getHeight()/2) - (vista.getHeight()/2);
      vista.setLocation(x,y);
    }
    
     public static void arrancarHilo(Thread hilo,Runnable target){
           if(hilo==null){
            hilo=new Thread(target);
            hilo.setPriority(Thread.NORM_PRIORITY);
            hilo.start();
          }
    
    }
     
     public static void actualizar_tabla(DefaultTableModel dtm,MiTableRowSorter sorter, JTable tabla, Thread hilo,Runnable target){
           try{

            dtm.getDataVector().removeAllElements();
           
            sorter = new MiTableRowSorter(dtm);
            tabla.setRowSorter(sorter);
            if(hilo==null){
                    hilo=new Thread(target);
                    hilo.setPriority(Thread.MAX_PRIORITY);
                    hilo.start();
                   
            }
           }catch(Exception ex){
                Logger.getLogger(ControladorListaOrdenes.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
           }
    }
     
     public static void  mostrarMensaje(Component vista,String mensaje){
         JOptionPane.showMessageDialog(vista,mensaje);
     }
     
     public static int filaSeleccionada(ListSelectionModel select, JTable tabla){
              int filaselect=select.getLeadSelectionIndex();
                  filaselect=tabla.convertRowIndexToModel(filaselect);
                 return filaselect;
     }
     
     public static void setVistaJDesktopPane(JInternalFrame vista){
           ControladorPrincipal.dp.add(vista,1);
           ControladorPrincipal.dp.setLayer(vista,1);
     }
     
     public static void filtrarTabla(JComboBox comboFiltro,ListSelectionModel select,MiTableRowSorter sorter, JTable tabla,String cadena){
               select.clearSelection();
               String nombreColumna=(String)comboFiltro.getSelectedItem();        
               sorter.setRowFilter(RowFilter.regexFilter("(?i)"+cadena,getColumna(tabla,nombreColumna)));
     
     }
     
     public static int getColumna(JTable tabla,String nombreColumna){
         int columna=1;
         for (int i = 0; i < tabla.getColumnCount(); i++) {
             if( tabla.getColumnName(i).equalsIgnoreCase(nombreColumna)){
               columna=i;
                break;             
             } 
         }
        
         return columna;
     
     } 
     
     public static void salirVista(String nombre,JInternalFrame vista){
       ControladorGeneral.vistas.remove(nombre);
       vista.dispose();
    }
     
     public static String validarTxtVacios(JTextField... textFields){
            for (JTextField textField : textFields) {
               if (textField.getText().isEmpty()) {
                   ControladorGeneral.mostrarMensaje(null, LogicaGeneral.getMensaje("CampoVacio")+" "+textField.getName());
                   textField.requestFocus();
                   return textField.getName();
               }
           }
           return "OK";
     
     }
     
     public static void formatoCantidadCaracteres(int cantidad,JTextField... textFields){
              for (JTextField textField : textFields) {
               textField.setDocument(new FormatoTextField(cantidad));
           }
            
     }
     
     public static boolean validarCampoUnico(String acción,String valorCampo,String valorObjeto,CampoUnicoDAO dao){
       boolean respuesta=true;
       Object objeto=dao.getElementoPorCampoUnico(valorCampo);
       
        if(acción.equalsIgnoreCase("EDITAR")){
                if(valorObjeto.equalsIgnoreCase(valorCampo)){
                   respuesta=true;
                }else{
                       if(objeto!=null){
                           
                                  respuesta=false;
                         }else{
                                  respuesta=true;
                         }
                }
            }else{
               if(objeto!=null){
                                   respuesta=false;
                         }else{
                                   respuesta=true;
                         }
            }
       
       
       return respuesta;
     
     }
     
     public static void personalizarTabla(JTable tabla){
         
         JTableHeader jTableHeader=tabla.getTableHeader();
         
         jTableHeader.setForeground( new java.awt.Color(100, 100, 100));  //  new java.awt.Color(52, 133, 254)
//         jTableHeader.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(218, 218, 218), 1, true));
         jTableHeader.setFont(new java.awt.Font("Calibri", 1, 17));
         jTableHeader.setSize(jTableHeader.getWidth(),14);
         ((DefaultTableCellHeaderRenderer)jTableHeader.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
         tabla.setRowHeight(22);
         
//         jTableHeader.updateUI();
//         tabla.updateUI();
        
     
     }
     
     public static void eventoDraggMovimientoVista(Component vista,int x, int y, MouseEvent evt){     
          vista.setLocation(vista.getLocation().x+evt.getX()-x,vista.getLocation().y+evt.getY()-y);
     }
     
     public static void salirAplicación(){
         Conexion.cerra_conexion_JPA();
         System.exit(0);     
     }
     
     //Función que maximiza o minimiza las interfaces
     public static void eventoMaximizarMinimizarPrincipal(JFrame vista,String acción){

         if(acción.equalsIgnoreCase("Maximizar")){
            vista.setExtendedState(JFrame.MAXIMIZED_BOTH);
         }else{
             if(acción.equalsIgnoreCase("Minimizar")){
               vista.setExtendedState(JFrame.ICONIFIED);
             }
         
         }
     }
     
     public static void eventoMinimizarVistas(JInternalFrame vista){
          try {
              vista.setIcon(true);
          } catch (PropertyVetoException ex) {
              Logger.getLogger(ControladorGeneral.class.getName()).log(Level.SEVERE, null, ex);
          }
         
     }
     
     public static void eventoPanelMenu(Container panel, String acción){
         if(acción.equalsIgnoreCase("ACTIVADO")){
            panel.setBackground(new java.awt.Color(51,204,255)); 

         }else{
            panel.setBackground(new java.awt.Color(52, 133, 254));
         }
         
     }
     
       public static void configurarJdateChooser (JDateChooser jdChooser,Date fechaSelección, Date fechaMaxima,boolean enabled){
     
       jdChooser.setLocale(new java.util.Locale("ES", "CO"));
       jdChooser.setDateFormatString("dd-MM-yyyy");
       jdChooser.setDate(fechaSelección);
//          this.vistaLista.jdcFechaInicial.putClientProperty(SubstanceLookAndFeel.WATERMARK_VISIBLE, Boolean.FALSE);
//          this.vistaLista.jdcFechaInicial.putClientProperty(SubstanceLookAndFeel.COLORIZATION_FACTOR, 1.0);
        jdChooser.getJCalendar().getDayChooser().setMaxDayCharacters(3);
        jdChooser.getJCalendar().setWeekOfYearVisible(false);
        //Color Cabecera
        jdChooser.getJCalendar().setDecorationBackgroundColor(Color.yellow);
        ((MiJDateChooser)   jdChooser).getPopup1().setPopupSize(310, 160);
//        ((MiJDateChooser)   jdChooser).get.setBackground(Color.red);
        jdChooser.setMaxSelectableDate(fechaMaxima);
        ((JTextFieldDateEditor)  jdChooser.getComponent(1)).setEditable(false);
        //Color JText
        ((JTextFieldDateEditor)  jdChooser.getComponent(1)).setBackground(Color.WHITE);
        jdChooser.getCalendarButton().setEnabled(enabled);
    
    
    }
    
}
