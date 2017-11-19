/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casino;



import controlador.ControladorPrincipalOrden;
import javax.swing.UIManager;
import modelo.Conexion;
import modelo.logica.LogicaGeneral;
import vista.JFPrincipalOrden;

/**
 *
 * @author Usuario
 */
public class CasinoPrincipalOrden {
    ControladorPrincipalOrden controladorPrincipalOrden;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                CasinoPrincipalOrden miCasino=new CasinoPrincipalOrden();
		miCasino.iniciar();
    }
    
    private void iniciar() {
		/*Se instancian las clases*/
                 //Esta linea de código crea el EntityManagerFactory
                 establecerLookAndFeel();
                 Conexion.establecer_Conexion_JPA();
                 JFPrincipalOrden vistaVO = new JFPrincipalOrden();
               
                 controladorPrincipalOrden = new  ControladorPrincipalOrden(vistaVO);
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
            java.util.logging.Logger.getLogger(JFPrincipalOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPrincipalOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPrincipalOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPrincipalOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    
    
    }
    
}
