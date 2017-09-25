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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.dao.UsuariosDAO;
import modelo.vo.Usuarios;
import vista.JFLogin;
import vista.JFPrincipal;

/**
 *
 * @author Usuario
 */
public class ControladorLogin implements ActionListener,MouseListener,MouseMotionListener {
        JFLogin vistaLogin;
        UsuariosDAO modeloUsuariosDAO; 
        Usuarios usuario;
        int x;
        int y;
           

    public ControladorLogin(JFLogin vistaLogin, UsuariosDAO modeloUsuariosDAO) {
        this.vistaLogin = vistaLogin;
        this.modeloUsuariosDAO = modeloUsuariosDAO;
        this.vistaLogin.txtUsuario.addActionListener(this);
        this.vistaLogin.txtClave.addActionListener(this);
        this.vistaLogin.btnAceptar.addActionListener(this);
        this.vistaLogin.btnCerrar.addActionListener(this);
        this.vistaLogin.labelMover.addMouseListener(this);
        this.vistaLogin.labelMover.addMouseMotionListener(this);
       
//        vistaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
       
        //Aqui se agrega el código de acción al botón acpetar del formulario Login
        if(e.getSource()==vistaLogin.btnAceptar){
             //se busca el usuario y se valida            
             acciónLogin();
        
        }else{
          //Aqui se agrega el código de acción al botón acpetar del formulario Login
          if(e.getSource()==vistaLogin.btnCerrar){
             Conexion.cerra_conexion_JPA();
             System.exit(0);          
          } 
           if(e.getSource()==vistaLogin.txtUsuario){
             vistaLogin.txtClave.requestFocus();
           
           }
           if(e.getSource()==vistaLogin.txtClave){
              acciónLogin();
           
           }
        
        }        
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       
    }

    public void acciónLogin(){
       usuario=modeloUsuariosDAO.getUsuario(vistaLogin.txtUsuario.getText(), vistaLogin.txtClave.getText());
            if(usuario!=null){
               //Se inicial el principal junto a su controlador 
              JFPrincipal jf_principal =new JFPrincipal();
              ControladorPrincipal controladorPrincipal= new ControladorPrincipal(jf_principal,usuario);
              vistaLogin.dispose();
            }else{
                 JOptionPane.showMessageDialog(vistaLogin,"Usuario o contraseña incorrectos");

            }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource()==vistaLogin.labelMover){  
             
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
          if(e.getSource()==vistaLogin.labelMover){                    
            ControladorGeneral.eventoDraggMovimientoVista(vistaLogin, x, y, e);
           
         }
    
    }

    @Override
    public void mouseMoved(MouseEvent e) {
       
    }
    
}
