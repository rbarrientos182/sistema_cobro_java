/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zolbee2;

/**
 *
 * @author Roberto
 */

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.*;
import net.sf.jasperreports.view.save.JRPdfSaveContributor.*;
import net.sf.jasperreports.view.JRViewer.*;
import net.sf.jasperreports.view.save.JRMultipleSheetsXlsSaveContributor.*;

public class IniciarReporteSocios
{

     Connection conn = null;
     String conexion = null;

    public IniciarReporteSocios ()
    {
        try
        {
            conexion = Funciones.conectar;
            Class.forName("com.mysql.jdbc.Driver"); // se carga el driver
            conn = DriverManager.getConnection(conexion);
            //JOptionPane.showMessageDialog(null, "Conexión Establecida");

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    } // fin de constructor

    public void ejecutarReporte(String idsocio)
    {
          try
          {
              String archivo = System.getProperty("user.dir")+"/Reportes/ReporteSocios.jasper";

              System.out.println("Cargando desde: "+archivo);
              if(archivo==null)
              {
                 System.out.println("No se encuentra el archivo");
                 System.exit(2);
              }//fin de if
              JasperReport masterReport = null;
              try
              {
                 masterReport = (JasperReport) JRLoader.loadObject(archivo);
              } // fin de try
              catch (JRException e)
              {
                  System.out.println("Hubo un problema al cargar el reporte"+" "+e.getMessage());
                  System.exit(3);
              } // fin de catch

              //estos son los paremetros
              Map parametro = new HashMap();
              //Map parametro2 = new HashMap();
              //Map parametro3 = new HashMap();
              parametro.put("idsocio",idsocio);


              JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro,conn);

              //se lanza el Viewer de jasper, no termina la aplicación al salir
              JasperViewer jviewer = new JasperViewer (jasperPrint,false);
              jviewer.setTitle("Reporte");
              jviewer.setVisible(true);

          } // fin de try


          catch(Exception j)
          {
              System.out.println("Mensaje de Error:"+ j.getMessage());

          } // fin de catch
    } // fin de método ejecutarReporte

    public void cerrar ()
    {
          try
          {
              conn.close();
          }
          catch (SQLException ex)
          {
               ex.printStackTrace();
          }
    } // fin de método cerrar

} // fin de la clase IniciarReporteSocios
