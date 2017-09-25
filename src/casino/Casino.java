/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casino;

import controlador.ControladorLogin;
import javax.swing.UIManager;
import modelo.Conexion;
import modelo.dao.UsuariosDAO;
import modelo.logica.LogicaGeneral;
import vista.JFLogin;

/**
 *
 * @author Usuario
 */
public class Casino {
    ControladorLogin controladorLogin;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                Casino miCasino=new Casino();
		miCasino.iniciar();
    }
    
    private void iniciar() {
		/*Se instancian las clases*/
                 //Esta linea de código crea el EntityManagerFactory
                 establecerLookAndFeel();
                 Conexion.establecer_Conexion_JPA();
                 JFLogin vistaLogin = new JFLogin();
                 UsuariosDAO modeloUsuariosDAO = new UsuariosDAO(Conexion.f);
                 controladorLogin = new  ControladorLogin(vistaLogin, modeloUsuariosDAO);
                 vistaLogin.setLocationRelativeTo(null);
                 vistaLogin.setVisible(true);
                 LogicaGeneral.inicializarMensajes();
                
		
	}
    
    public void establecerLookAndFeel(){
      try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }

            

             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    
    
    }
    
}
