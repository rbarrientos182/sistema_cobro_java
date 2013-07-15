/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zolbee2;

import java.io.*;
import java.net.URL;
import javax.swing.JOptionPane;
import java.lang.*;

/**
 *
 * @author roberto
 */
public class EscribeFichero
{
     String ruta = "conf.txt";

    public void determinarFichero (String usr, String pas, String suc[])
    {
       
        String [] array = null;
        String usuario = usr;
        String pass = pas;
        String sucu = suc[0];
       
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {


           
            String ruta2 = System.getProperty("user.dir")+"/zolbee/conf.txt";
            fichero = new FileWriter(ruta2);
            pw = new PrintWriter(fichero);
            Funciones funcion = new Funciones();
            Funciones funcion2 = new Funciones();
            String clave = "zolbee";
            funcion.EncriptCadena(clave, usuario);
            funcion2.EncriptCadena(clave, pass);

            pw.print("a"+":"+"0"+","+"s"+":"+sucu+","+"u"+":"+funcion.encriptado+","+"c"+":"+funcion2.encriptado+","+"b"+":"+"1");
            Funciones.imprimirMsj("Los datos de configuración han sido guardados correctamente");

        } catch (Exception e) {
            e.printStackTrace();
            Funciones.imprimirMsj("Hubo un error al querer guardar el archivo");
        } finally {
           try {
           // Nuevamente aprovechamos el finally para
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        } // fin de finally



    } // fin de método determinarFichero
    
} //fin de la clase EscribeFichero
