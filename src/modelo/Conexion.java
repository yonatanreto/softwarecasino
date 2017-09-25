/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author Yonatan
 */
public class Conexion {
    
    public static EntityManagerFactory f;
    public Conexion() {

    }
    
    
     public static void establecer_Conexion_JPA() {
       f= Persistence.createEntityManagerFactory("CasinoPU");
    }
     
      public static void cerra_conexion_JPA() {
       
        if (f.isOpen()) {
            f.close();
        }
    }
}
