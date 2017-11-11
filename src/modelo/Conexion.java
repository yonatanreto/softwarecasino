/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import controlador.ControladorGeneral;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import modelo.logica.LogicaGeneral;
import utilidades.ParametrosConexion;
/**
 *
 * @author Yonatan
 */
public class Conexion {
    
    public static EntityManagerFactory f;
    public static ParametrosConexion pc;
    public Conexion() {

    }
    
    
     public static void establecer_Conexion_JPA() {
        try {
            prepararConexion();
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
          Map parameters = new HashMap();
        parameters.put("hibernate.connection.username", pc.getUsuario());
        parameters.put("hibernate.connection.password", pc.getPassword());
      //parameters.put("hibernate.connection.url","jdbc:mysql://"+this.getDatabaseURL()+"/nextventas");
      //parameters.put("hibernate.connection.url","jdbc:mysql://"+this.getDatabaseURL()+"/"+this.getDataBase());
      //parameters.put("hibernate.connection.is-connection-validation-required","true");
      //<property name = "connection.is-connection-validation-required" value = "true" />
        parameters.put("hibernate.connection.url", "jdbc:mysql://" + pc.getUrl() + "/" + pc.getDataBase() + "?autoReconnect=true");
         System.out.println(" URL "+pc.getUrl());
        try {
             f= Persistence.createEntityManagerFactory("CasinoPU", parameters);

        } catch (Exception e) {
            e.printStackTrace();
             ControladorGeneral.mostrarMensaje(null, LogicaGeneral.getMensaje("NoConexion"));
             System.exit(0);
        }
        
    }
     
     public static ParametrosConexion obtenerParametrosConexion() {
        //"../conexion/parametrosConexion.parameters"
//      ParametrosConexion pc=null;
      ObjectInputStream entrada = null;
    try {
      entrada=new ObjectInputStream(new FileInputStream("../conexion/parametrosConexion.parameters"));
        
                pc = (ParametrosConexion) entrada.readObject();
            } catch (ClassNotFoundException ex) {
                 System.out.println(" es nulo 1 ");
                pc=null;
            }catch (IOException ex) {
                 System.out.println(" es nulo 2 ");
                pc=null;
            }
        try {
            entrada.close();
        } catch (NullPointerException | IOException ex) {
             System.out.println(" es nulo 3 ");
            pc=null;
        }
      return pc;
}
     
      public static void guardarParametrosConexion(ParametrosConexion pc, File folder) throws IOException {
        //"../conexion/parametrosConexion.parameters"
        
//        File folder = new File("..\\conexion");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("../conexion/parametrosConexion.parameters"));
        salida.writeObject(pc);
        salida.close();

    }
     public static void crearObjetoParametros(String usuario,String password,String baseDeDatos,String url,File folder){
           ParametrosConexion pc = new ParametrosConexion();
            pc.setUsuario(usuario);
            pc.setPassword(password);
            pc.setDataBase(baseDeDatos);
            pc.setUrl(url);           
            pc.setServer_name("");
            try {
                guardarParametrosConexion(pc,folder);
            } catch (IOException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
     
     }
     
     public static void prepararConexion() throws IOException{
        pc= obtenerParametrosConexion();
        if(pc==null){
            JOptionPane.showMessageDialog(null,"Error de conexión");
            System.exit(0);
        }
     
     }
      public static void cerra_conexion_JPA() {
       
        if (f.isOpen()) {
            f.close();
        }
    }
}
