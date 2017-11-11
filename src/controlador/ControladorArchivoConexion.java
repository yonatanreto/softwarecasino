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
import java.io.File;
import java.util.Locale;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import modelo.Conexion;

import vista.JFArchivoConexion;


/**
 *
 * @author Usuario
 */
public class ControladorArchivoConexion implements ActionListener,MouseListener,MouseMotionListener {
        JFArchivoConexion vistaVO;
         int x;
        int y;
           
       
           

    public ControladorArchivoConexion(JFArchivoConexion vistaVO) {
        this.vistaVO = vistaVO;
       
        this.vistaVO.btnGuardar.addActionListener(this);
        this.vistaVO.txtUsuario.addActionListener(this);
        this.vistaVO.txtUrl.addActionListener(this);
        this.vistaVO.txtBaseDeDatos.addActionListener(this);
        this.vistaVO.txtPassword.addActionListener(this);   
        this.vistaVO.btnCerrar.addActionListener(this);
        this.vistaVO.labelMover.addMouseListener(this);
        this.vistaVO.labelMover.addMouseMotionListener(this);
       
//        vistaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
       
        //Aqui se agrega el código de acción al botón acpetar del formulario Login
        if(e.getSource()==vistaVO.btnGuardar){
             //se busca el usuario y se valida            
             acciónGuardar();
        
        }else{
          //Aqui se agrega el código de acción al botón acpetar del formulario Login
          if(e.getSource()==vistaVO.btnCerrar){             
             System.exit(0);          
          } 
           if(e.getSource()==vistaVO.txtUsuario){
             vistaVO.txtPassword.requestFocus();
           
           }
           if(e.getSource()==vistaVO.txtPassword){
             vistaVO.txtBaseDeDatos.requestFocus();
           
           }
           if(e.getSource()==vistaVO.txtBaseDeDatos){
             vistaVO.txtUrl.requestFocus();
           
           }
           if(e.getSource()==vistaVO.txtUrl){
             vistaVO.btnGuardar.requestFocus();
           
           }
          
        
        }        
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       
    }
    
     public boolean validar(){
            String respuesta="";
        if(!(respuesta=ControladorGeneral.validarTxtVacios(vistaVO.txtUsuario,
                 vistaVO.txtPassword,vistaVO.txtBaseDeDatos,vistaVO.txtUrl)).equalsIgnoreCase("OK")){
                return false;
        }
        return true;
    }
     
     public void restaurarCampos(){
     
     }

    public void acciónGuardar(){
        if(validar()){
            
            //AQUI CARGO EL SELECCIONADOR DE FICHEROS
            vistaVO.jfileRutaGuardar.setDialogType(JFileChooser.SAVE_DIALOG);
            vistaVO.jfileRutaGuardar.setLocale(new Locale("es"));
            vistaVO.jfileRutaGuardar.setApproveButtonText("Guardar");
            //chooser.updateUI();
            vistaVO.jfileRutaGuardar.setDialogTitle("Seleccionar ruta de archivo");
            vistaVO.jfileRutaGuardar.setMultiSelectionEnabled(false);
            vistaVO.jfileRutaGuardar.setAcceptAllFileFilterUsed(false);
            vistaVO.jfileRutaGuardar.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
      
        int sel = vistaVO.jfileRutaGuardar.showDialog(vistaVO,"Guardar");           
        if (sel == JFileChooser.APPROVE_OPTION){
            try {               
                File selectedFile = vistaVO.jfileRutaGuardar.getSelectedFile();
                Conexion.crearObjetoParametros(vistaVO.txtUsuario.getText(), vistaVO.txtPassword.getText(),vistaVO.txtBaseDeDatos.getText(),vistaVO.txtUrl.getText(),selectedFile);      
                JOptionPane.showMessageDialog(vistaVO,"Configuración guardada con exito");
                ControladorGeneral.vaciarCampos(vistaVO.txtUsuario,vistaVO.txtPassword,vistaVO.txtBaseDeDatos,vistaVO.txtUrl);
            } catch (Exception ex) {
                ex.printStackTrace();
          
                }
            
        }else{
           JOptionPane.showMessageDialog(vistaVO,"Debe seleciconar una ruta");
        
        }
          
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
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
          if(e.getSource()==vistaVO.labelMover){                    
            ControladorGeneral.eventoDraggMovimientoVista(vistaVO, x, y, e);
           
         }
    
    }

    @Override
    public void mouseMoved(MouseEvent e) {
       
    }
    
}
