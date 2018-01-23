/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.reportes;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import modelo.vo.ConfiguracionImpresionOrden;
import modelo.vo.Ordenes;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author Usuario
 */
public class ModeloReportes {

    public ModeloReportes() {
    }
      public void imprimirOrdenTicket(Ordenes orden,ConfiguracionImpresionOrden objetoConfiguracion) {
          Calendar calendario = Calendar.getInstance();
//          calendario.set
        try {
             Map parametros = new HashMap();
            parametros.put("encabezado",objetoConfiguracion.getEncabezadoImpresionOrden());
            parametros.put("pie_de_pagina",objetoConfiguracion.getPiedepaginaImpresionOrden());
            parametros.put("empleado",orden.getEmpleado().toString());
            parametros.put("documento_empleado",orden.getEmpleado().getTipoDocumento()+" "+orden.getEmpleado().getCedula());
            parametros.put("restaurante",orden.getRestaurante().getNombre());
            parametros.put("nit",orden.getRestaurante().getNit());
            parametros.put("codigo",orden.getCodigo()+"");
            parametros.put("fecha",orden.getFecha());
            parametros.put("hora",orden.getHora());
            
//            EntityManager  entityManager = Conexion.f.createEntityManager();
//            entityManager.getTransaction().begin();
//            java.sql.Connection connection = entityManager.unwrap(java.sql.Connection.class);
//             entityManager.getTransaction().commit();
            
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(getClass().getResource("reporteOrdenTicket.jasper"));        
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros);
            JasperViewer.viewReport(jasperPrint, false);
           
            //JasperDesignViewer.viewReportDesign("pagoEgresos.jrxml",true);
        } catch (JRException e) {
            e.printStackTrace();
        }

    }
      
      public void imprimirListaOrdenes(DefaultTableModel modelo, Date fechaInicial, Date fechaFinal,String numeroDeRegistros){
		try{
			
                        JasperReport jasperReport;
                        Map parameters = new HashMap();
                        JRTableModelDataSource jrt=new JRTableModelDataSource(modelo);
                                              
			jasperReport = (JasperReport)JRLoader.loadObject(getClass().getResource("reportListaOrdenes.jasper"));
                        parameters.put("fechaInicial",fechaInicial);
                        parameters.put("fechaFinal",fechaFinal);   
                        parameters.put("numeroDeRegistros",numeroDeRegistros);  
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,(JRDataSource)jrt);
                        JasperViewer.viewReport(jasperPrint,false);

       
		}catch(Exception ex){
			ex.printStackTrace();
                        System.out.println("es aqui");
		}
                
     }
}
