/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class LogicaGeneral {
       //Map que contiene los mensajes que se usarán en el sistema
       private static HashMap mensajes=new HashMap();
       //Map que contiene las listados generados de entidades en las pantallas de listas
       public static HashMap listasEntidades=new HashMap();
       
       
       //Aqui se cargan los mensajes , este metodo debe ser llamado al inicio de la apliación
       public static void  inicializarMensajes(){
           mensajes.put("SeleccionFila","Seleccione una fila primero");
           mensajes.put("Eliminar","Registro eliminado con éxito");
           mensajes.put("NoEliminar","No es posible eliminar el registro \n debido a relaciones con la entidad ");
           mensajes.put("Guardar","Datos  guardados con éxito");
           mensajes.put("Editar","Datos actualizados con éxito");
           mensajes.put("CampoVacio","Por favor ingrese un dato en el campo");
           mensajes.put("CampoUnico","Ya existe un registro con igual valor para el campo");
           mensajes.put("CampoIgual","No coincide el valor ingresado para el campo");
           mensajes.put("NoDatosFechas","No hay registros relacionados a las fechas ingresadas");
           mensajes.put("NoConexion","Error de conexión");
           mensajes.put("RegistroEnFecha","Ya existen registros en la fecha indicada");
           
       
       }
       //Retorna el mensaje correspondiente a la llave ingresada
       public static String getMensaje(String llave){
         return (String) LogicaGeneral.mensajes.get(llave);
       }
       
       
       //Metodos relacionados con las listas de entidades, quienes 
       public static void setListaEntidad(String llave,List listaEntidad){
          listasEntidades.put(llave, listaEntidad);       
       }
       
       public static List  getListaEntidad(String llave){
         return  (List) LogicaGeneral.listasEntidades.get(llave);
       }
       
       public static void borrarListaEntidad(String llave){
           LogicaGeneral.listasEntidades.remove(llave);
       }
}
