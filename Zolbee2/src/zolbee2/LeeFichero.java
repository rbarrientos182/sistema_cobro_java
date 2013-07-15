/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zolbee2;

import java.io.*;
import java.lang.reflect.Array;
import java.net.URL;
import javax.swing.JOptionPane;


/**
 *
 * @author roberto
 */
public class LeeFichero
{
    String vbandera = "null";
    String vsucusal = "null";
    String vusuario = "null";
    String vpaswd = "null";
    String[] array = null;
    String[] array2 = null;
   

    public void leerFichero()
    {
      
   
      FileReader fr = null;
      BufferedReader br = null;
      File archivo = null;
      String linea;

      try
      {
           String ruta = System.getProperty("user.dir")+"/zolbee/conf.txt";
           archivo = new File (ruta);
           //Funciones.imprimirMsj(ruta);
               
           fr = new FileReader (ruta);
           // Apertura del fichero y creacion de BufferedReader para poder
           // hacer una lectura comoda (disponer del metodo readLine()).
           br = new BufferedReader(fr);
 
           // Lectura del fichero
           while((linea=br.readLine())!=null)
           {
                //System.out.println(linea);
                 array = linea.split(","); // realizamos un split para dividir la cadena
         
           } // fin de while

           String [] sucursal = array[1].split(":");
           String [] usuario = array[2].split(":");
           String [] paswd = array[3].split(":");
           String [] bandera = array[4].split(":"); // realizamos otro split para obtener el valor de bandera

      
           vsucusal = sucursal[1];
           vusuario = usuario[1];
           vpaswd = paswd[1];
           vbandera = bandera[1];

        } // fin de try
      
     catch(Exception e){

      JOptionPane.showMessageDialog(null, "El archivo no se encontro o no Existe ...", "Cuidado", JOptionPane.ERROR_MESSAGE);
      e.printStackTrace();
     }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta
         // una excepcion.
         try{
               if( null != fr ){
               fr.close();
            }
         }catch (Exception e2){
               e2.printStackTrace();
         }
      }
   } // fin de método leerFichero

public String obtenerValorBandera( )
{
    return vbandera;
} // fin de método obtenerValorBandera


} // fin de clase LeeFichero
