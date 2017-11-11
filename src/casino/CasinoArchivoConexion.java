/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casino;


import controlador.ControladorArchivoConexion;
import javax.swing.UIManager;
import modelo.logica.LogicaGeneral;
import vista.JFArchivoConexion;

/**
 *
 * @author Usuario
 */
public class CasinoArchivoConexion {
    ControladorArchivoConexion controladorLogin;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                CasinoArchivoConexion miCasino=new CasinoArchivoConexion();
		miCasino.iniciar();
    }
    
    private void iniciar() {
		/*Se instancian las clases*/
                 //Esta linea de código crea el EntityManagerFactory
                 establecerLookAndFeel();
               
                 JFArchivoConexion vistaVO = new JFArchivoConexion();
               
                 controladorLogin = new  ControladorArchivoConexion(vistaVO);
                 vistaVO.setLocationRelativeTo(null);
                 vistaVO.setVisible(true);
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
            java.util.logging.Logger.getLogger(JFArchivoConexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFArchivoConexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFArchivoConexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFArchivoConexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    
    
    }
    
}
