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
     
      public static void guardarParametrosConexion(ParametrosConexion pc) throws IOException {
        //"../conexion/parametrosConexion.parameters"
        
        File folder = new File("..\\conexion");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("../conexion/parametrosConexion.parameters"));
        salida.writeObject(Conexion.crearObjetoParametros());
        salida.close();

    }
     public static ParametrosConexion crearObjetoParametros(){
           ParametrosConexion pc = new ParametrosConexion();
            pc.setUsuario("root");
            pc.setUrl("qweqw");
            pc.setPassword("1234");
            pc.setDataBase("casino");
            pc.setServer_name("");
            return pc;
     
     }
     
     public static void prepararConexion() throws IOException{
        pc= obtenerParametrosConexion();
        if(pc==null){
            pc= crearObjetoParametros();
            guardarParametrosConexion(pc);
        }else{
            System.out.println("No es nulo "+pc.getUrl());
        }
     
     }
      public static void cerra_conexion_JPA() {
       
        if (f.isOpen()) {
            f.close();
        }
    }
}
