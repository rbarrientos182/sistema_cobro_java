/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ReportesEmpleado.java
 *
 * Created on 12/04/2010, 01:33:41 PM
 */

package zolbee2;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class ReportesEmpleado extends javax.swing.JFrame {

    private IniciarReporteEmpleados jasper ;
    String conexion = Funciones.conectar;
     int in = 0;
     int registros = 20;
     int sum_rest = 20;

    /** Creates new form ReportesEmpleado */
    public ReportesEmpleado() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vEmpleados = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        B_realizarbus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        vTReportes = new javax.swing.JTable();
        VAnterior = new javax.swing.JButton();
        VSiguiente = new javax.swing.JButton();
        l_nomEmpleado = new javax.swing.JLabel();
        B_ImprimirEmpleados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(zolbee2.Zolbee2App.class).getContext().getResourceMap(ReportesEmpleado.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setName("Form"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        vEmpleados.setName("vEmpleados"); // NOI18N

        jLabel1.setForeground(resourceMap.getColor("jLabel1.foreground")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setFont(resourceMap.getFont("jLabel2.font")); // NOI18N
        jLabel2.setForeground(resourceMap.getColor("jLabel2.foreground")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        B_realizarbus.setText(resourceMap.getString("B_realizarbus.text")); // NOI18N
        B_realizarbus.setName("B_realizarbus"); // NOI18N
        B_realizarbus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                B_realizarbusMouseReleased(evt);
            }
        });
        B_realizarbus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B_realizarbusKeyReleased(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        vTReportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Movimientos", "Fecha", "Sucursal", "No. Tarjeta", "Nombre Socio", "Monto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        vTReportes.setName("vTReportes"); // NOI18N
        vTReportes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        vTReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                vTReportesMouseReleased(evt);
            }
        });
        vTReportes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                vTReportesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(vTReportes);
        vTReportes.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("vTReportes.columnModel.title0")); // NOI18N
        vTReportes.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("vTReportes.columnModel.title1")); // NOI18N
        vTReportes.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("vTReportes.columnModel.title2")); // NOI18N
        vTReportes.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("vTReportes.columnModel.title3")); // NOI18N
        vTReportes.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("vTReportes.columnModel.title4")); // NOI18N
        vTReportes.getColumnModel().getColumn(5).setHeaderValue(resourceMap.getString("vTReportes.columnModel.title5")); // NOI18N

        VAnterior.setText(resourceMap.getString("VAnterior.text")); // NOI18N
        VAnterior.setEnabled(false);
        VAnterior.setName("VAnterior"); // NOI18N
        VAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                VAnteriorMouseReleased(evt);
            }
        });
        VAnterior.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                VAnteriorKeyReleased(evt);
            }
        });

        VSiguiente.setText(resourceMap.getString("VSiguiente.text")); // NOI18N
        VSiguiente.setEnabled(false);
        VSiguiente.setName("VSiguiente"); // NOI18N
        VSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                VSiguienteMouseReleased(evt);
            }
        });
        VSiguiente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                VSiguienteKeyReleased(evt);
            }
        });

        l_nomEmpleado.setFont(resourceMap.getFont("l_nomEmpleado.font")); // NOI18N
        l_nomEmpleado.setForeground(resourceMap.getColor("l_nomEmpleado.foreground")); // NOI18N
        l_nomEmpleado.setText(resourceMap.getString("l_nomEmpleado.text")); // NOI18N
        l_nomEmpleado.setName("l_nomEmpleado"); // NOI18N

        B_ImprimirEmpleados.setIcon(resourceMap.getIcon("B_ImprimirEmpleados.icon")); // NOI18N
        B_ImprimirEmpleados.setText(resourceMap.getString("B_ImprimirEmpleados.text")); // NOI18N
        B_ImprimirEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        B_ImprimirEmpleados.setEnabled(false);
        B_ImprimirEmpleados.setName("B_ImprimirEmpleados"); // NOI18N
        B_ImprimirEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                B_ImprimirEmpleadosMouseReleased(evt);
            }
        });
        B_ImprimirEmpleados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B_ImprimirEmpleadosKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(jLabel2)
                .addGap(265, 265, 265))
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(VAnterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 456, Short.MAX_VALUE)
                .addComponent(VSiguiente)
                .addGap(103, 103, 103))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(l_nomEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(207, 207, 207)
                        .addComponent(B_ImprimirEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(47, 47, 47)
                        .addComponent(vEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(B_realizarbus)))
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(vEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(B_realizarbus))
                        .addGap(17, 17, 17)
                        .addComponent(l_nomEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(B_ImprimirEmpleados))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VAnterior)
                    .addComponent(VSiguiente))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      // TODO add your handling code here:
        
      llenarEmpleados();
      B_ImprimirEmpleados.disable();
      VAnterior.disable();
      VSiguiente.disable();

    }//GEN-LAST:event_formWindowOpened

    private void B_realizarbusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B_realizarbusKeyReleased
        
 if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
        try {
            // TODO add your handling code here:
            boolean actv = true;
            in = 0;
            
            reporteEmpleado(in,registros,actv);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportesEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
    }//GEN-LAST:event_B_realizarbusKeyReleased

    private void B_realizarbusMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_realizarbusMouseReleased
        try {
            // TODO add your handling code here:
            boolean actv = true;
            in = 0;
            reporteEmpleado(in,registros,actv);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportesEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_B_realizarbusMouseReleased

    private void VAnteriorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VAnteriorKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {     
          try
          {
             boolean actv = false;
             in = in - sum_rest;
             if(in>=0)
             {

               reporteEmpleado(in,registros,actv);
             }
             else
             {
                in=0;

             }
          }
          catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportesEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }//GEN-LAST:event_VAnteriorKeyReleased

    private void VAnteriorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VAnteriorMouseReleased
        // TODO add your handling code here:

         
          try
          {
             boolean actv = false;
             in = in - sum_rest;
             if(in>=0)
             {

               reporteEmpleado(in,registros,actv);
             }
             else
             {
                in=0;

             }
          }
          catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportesEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_VAnteriorMouseReleased

    private void VSiguienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VSiguienteKeyReleased
        // TODO add your handling code here:
         if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
           try {
                boolean actv = false;
                in = in + sum_rest;
               reporteEmpleado(in,registros,actv);
            }
           catch (ClassNotFoundException ex) {
               Logger.getLogger(ReportesFecha.class.getName()).log(Level.SEVERE, null, ex);
            }

         }
    }//GEN-LAST:event_VSiguienteKeyReleased

    private void VSiguienteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VSiguienteMouseReleased
        // TODO add your handling code here:
         try {
                boolean actv = false;
                in = in + sum_rest;
               reporteEmpleado(in,registros,actv);
            }
           catch (ClassNotFoundException ex) {
               Logger.getLogger(ReportesFecha.class.getName()).log(Level.SEVERE, null, ex);
            }
  
    }//GEN-LAST:event_VSiguienteMouseReleased

    private void B_ImprimirEmpleadosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B_ImprimirEmpleadosKeyReleased
        // TODO add your handling code here:
         
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {

           String empleado = (String) vEmpleados.getSelectedItem();
           System.out.println(empleado);
           String arrayemp[] = null;
           arrayemp = empleado.split("-");

            jasper = new IniciarReporteEmpleados ();
            jasper.ejecutarReporte(arrayemp[0]);        
        }// fin de if enter
    }//GEN-LAST:event_B_ImprimirEmpleadosKeyReleased

    private void B_ImprimirEmpleadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_ImprimirEmpleadosMouseReleased
        // TODO add your handling code here:
        String empleado = (String) vEmpleados.getSelectedItem();
        System.out.println(empleado);
        String arrayemp[] = null;
        arrayemp = empleado.split("-");

        jasper = new IniciarReporteEmpleados ();
        jasper.ejecutarReporte(arrayemp[0]);  
    }//GEN-LAST:event_B_ImprimirEmpleadosMouseReleased

    private void vTReportesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vTReportesKeyReleased
        // TODO add your handling code here:
         if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
             int fila = vTReportes.getSelectedRow();
             int columna = vTReportes.getSelectedColumn();
             if ((fila > -1) && (columna > -1))
             {
                System.out.println(vTReportes.getValueAt(fila,0));
                Object idmov =  vTReportes.getValueAt(fila,0);
                String idmovimiento = idmov.toString();
                String empleado = (String) vEmpleados.getSelectedItem();
                System.out.println(empleado);
                String arrayemp[] = null;
                arrayemp = empleado.split("-");
                System.out.println(idmovimiento+" "+"esta id elegiste");
                //Funciones.imprimirMsj("hiciste enter
                ReportesDetallesEmpleado detallesEmpleado = new ReportesDetallesEmpleado(idmovimiento,arrayemp[0],arrayemp[1]);
                //Menu f2 = new Menu();

                detallesEmpleado.setLocationRelativeTo(null);
                detallesEmpleado.getContentPane().setBackground(Color.decode("#7329ab"));
                //lo hacemos visible
                detallesEmpleado.setVisible(true);
             }
        } // fin de if enter
    }//GEN-LAST:event_vTReportesKeyReleased

    private void vTReportesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vTReportesMouseReleased
        // TODO add your handling code here:
         if (evt.getClickCount() == 2)
         {
             int fila = vTReportes.rowAtPoint(evt.getPoint());
             int columna = vTReportes.getSelectedColumn();
             if ((fila > -1) && (columna > -1))
             {
                System.out.println(vTReportes.getValueAt(fila,0));
                Object idmov =  vTReportes.getValueAt(fila,0);
                String idmovimiento = idmov.toString();
                String empleado = (String) vEmpleados.getSelectedItem();
                System.out.println(empleado);
                String arrayemp[] = null;
                arrayemp = empleado.split("-");
                //System.out.println(idmovimiento+" "+"esta id elegiste");
                //Funciones.imprimirMsj("hiciste enter
                ReportesDetallesEmpleado detallesEmpleado = new ReportesDetallesEmpleado(idmovimiento,arrayemp[0],arrayemp[1]);
                //Menu f2 = new Menu();

                detallesEmpleado.setLocationRelativeTo(null);
                detallesEmpleado.getContentPane().setBackground(Color.decode("#7329ab"));
                //lo hacemos visible
                detallesEmpleado.setVisible(true);
             }  
         } // fin if doble clic
    }//GEN-LAST:event_vTReportesMouseReleased

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportesEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_ImprimirEmpleados;
    private javax.swing.JButton B_realizarbus;
    private javax.swing.JButton VAnterior;
    private javax.swing.JButton VSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l_nomEmpleado;
    private static javax.swing.JComboBox vEmpleados;
    private javax.swing.JTable vTReportes;
    // End of variables declaration//GEN-END:variables


public void llenarEmpleados()
{
    
    LeeFichero leeficha = new LeeFichero();
    leeficha.leerFichero();
    String idsucursal = leeficha.vsucusal;

    try
       {
          //Cargar clase de controlador de base de datos
         Class.forName("com.mysql.jdbc.Driver");
         //Establecer conexion a la base de datos

        Connection conectar = DriverManager.getConnection(conexion);
        //Crear objeto Statement para realizar queries a la base de datos
        Statement instruccion = conectar.createStatement();

        ResultSet rs = instruccion.executeQuery("SELECT idempleado, nombre FROM sucu_empleados WHERE idsucursal="+idsucursal+"");
        rs.last();
        //int cont = rs.getRow();
        //System.out.println(cont);
        Object m[] = new Object[rs.getRow()]; // creo array para guardar los campos
        int x = 0;
        int y = 0;
        rs.first();
        do
       {
          
          String idempleado = rs.getString("idempleado");
          String nombreempleado = rs.getString("nombre");
          //System.out.println(idsucursal+nombreSucursal);
        
          m[x] = idempleado+"-"+nombreempleado;
          //System.out.println(m[x]);
        
          x++;
        }while(rs.next());

        ReportesEmpleado.vEmpleados.setModel(new javax.swing.DefaultComboBoxModel(m));
        ReportesEmpleado.vEmpleados.setName("vEmpleados");
       
      
        //La clase ResultSetMetaData contiene toda la información sobre los campos de base de datos contenidos en el ResultSet. Necesitamos preguntarle por el número de columnas y por la etiqueta para cada una de las columnas. Este es el código que lo hace
        //ResultSetMetaData metaDatos = rs.getMetaData();

       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, "No pudo conectarse a la base de datos ...", "Cuidado", JOptionPane.ERROR_MESSAGE);
           e.printStackTrace();
       }

} // fin de método llenrEmpleado

public void reporteEmpleado(int inc, int reg, boolean act) throws ClassNotFoundException
{
    String empleado = (String) vEmpleados.getSelectedItem();
    System.out.println(empleado);
    String arrayemp[] = null;
    arrayemp = empleado.split("-");
    int inicios = inc;
    int registro = reg;
    boolean activarB = act;
    System.out.println(inicios+" "+registro);
    try
    {
        Class.forName("com.mysql.jdbc.Driver");

        Connection conectar = DriverManager.getConnection(conexion);

        //Crear objeto Statement para realizar queries a la base de datos
        Statement instruccion = conectar.createStatement();
        ResultSet rs = instruccion.executeQuery("SELECT * FROM movimientos WHERE idempleado="+arrayemp[0]+" ORDER BY idmovimientos");

         rs.last();
      int rowcont = rs.getRow();
      System.out.println(rowcont);
      if(inicios>rowcont)
      {
        in = in - sum_rest;
        inicios = inicios - sum_rest;
      }
      if(rowcont>0)
      {
          if(activarB==true)
          {
              VAnterior.setEnabled(true);
              VSiguiente.setEnabled(true);
              B_ImprimirEmpleados.setEnabled(true);
          }
      }
      else
      {
          VAnterior.setEnabled(false);
          VSiguiente.setEnabled(false);
          B_ImprimirEmpleados.setEnabled(false);
      }
      if(rowcont>0)
      {
        ResultSet rs2 = instruccion.executeQuery("SELECT * FROM movimientos WHERE idempleado="+arrayemp[0]+" ORDER BY idmovimientos LIMIT "+inicios+","+registro+"");


         ResultSetMetaData metaDatos2 = rs2.getMetaData();

      // Se obtiene el número de columnas.
      int numeroColumnas2 = metaDatos2.getColumnCount();

         System.out.println("Numero de Columnas= "+numeroColumnas2);


       //Cabecera
        String[] cabecera = new String[]
            {"Movimiento", "Fecha", "Sucursal", "No. Tarjeta", "Nombre Socio", "Monto"};
            rs2.last();
            System.out.println("Numero de Registros= "+rs2.getRow());
            Object[][] m=new Object[rs2.getRow()][6];
            int i=0;
            rs2.first();
            do
            {

              m[i][0] = rs2.getObject("idmovimientos"); // movimiento
              m[i][1] = rs2.getObject("fecha");         // fecha
              m[i][2] = rs2.getObject("nombresucu");    // nombre de la sucursal
              m[i][3] = rs2.getObject("no_tarjetazolbee"); // no. tarjeta zolbe
              m[i][4] = rs2.getObject("nombresocio");// nombre del socio
              m[i][5] = rs2.getObject("total");
            
             i++;
             }while(rs2.next());
            vTReportes.setModel(new javax.swing.table.DefaultTableModel(m,cabecera){
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

                @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

                @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
          });

          //configuracion de mi lista
          vTReportes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
          vTReportes.setBackground(Color.decode("#BAD405"));
          vTReportes.setRowHeight(14);
          vTReportes.setEditingRow(5);
          javax.swing.table.TableColumn colum= null;

          colum = vTReportes.getColumnModel().getColumn(0); //movimientos
          colum.setPreferredWidth(80);

          colum = vTReportes.getColumnModel().getColumn(1); // fecha
          colum.setPreferredWidth(120);

          colum = vTReportes.getColumnModel().getColumn(2); // sucursal
          colum.setPreferredWidth(183);

          colum = vTReportes.getColumnModel().getColumn(3); // tarjeta
          colum.setPreferredWidth(83);

          colum = vTReportes.getColumnModel().getColumn(4); // socio
          colum.setPreferredWidth(233);

          colum = vTReportes.getColumnModel().getColumn(5); // monto
          colum.setPreferredWidth(80);

          

          instruccion.close();
          System.out.println("Se cargo correctamente la lista.");
      }// fin de if

      else
      {
         Funciones.imprimirMsj("El Empleado que Busca no ha Realizado Ningún Movimiento");
         
         vTReportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
               "Movimiento", "Fecha","Sucursal","No. Tarjeta","Nombre Socio", "Monto"
            }
            ) {

            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

           boolean[] canEdit = new boolean [] {
                false, false, false, false,  false, false
            };

                @Override
              public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

                @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        vTReportes.setName("vTReportes"); // NOI18N
        jScrollPane1.setViewportView(vTReportes);
         vTReportes.setRowHeight(14);
          vTReportes.setEditingRow(5);
          javax.swing.table.TableColumn colum= null;

          colum = vTReportes.getColumnModel().getColumn(0);
          colum.setPreferredWidth(80);

          colum = vTReportes.getColumnModel().getColumn(1);
          colum.setPreferredWidth(120);

          colum = vTReportes.getColumnModel().getColumn(2); // sucursal
          colum.setPreferredWidth(183);

          colum = vTReportes.getColumnModel().getColumn(3); // tarjeta
          colum.setPreferredWidth(83);

          colum = vTReportes.getColumnModel().getColumn(4);
          colum.setPreferredWidth(243);

          colum = vTReportes.getColumnModel().getColumn(5);
          colum.setPreferredWidth(80);
       }
          l_nomEmpleado.setText(arrayemp[1]); // nombre del empleado




    } // fin de try
    catch(SQLException es)
    {

            vTReportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
               "Movimiento", "Fecha","Sucursal","No. Tarjeta","Nombre Socio", "Monto"
            }
            ) {

            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

           boolean[] canEdit = new boolean [] {
                false, false, false, false,  false, false
            };

                @Override
              public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

                @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        vTReportes.setName("vTReportes"); // NOI18N
        jScrollPane1.setViewportView(vTReportes);
         vTReportes.setRowHeight(14);
          vTReportes.setEditingRow(5);
          javax.swing.table.TableColumn colum= null;

          colum = vTReportes.getColumnModel().getColumn(0);
          colum.setPreferredWidth(80);

          colum = vTReportes.getColumnModel().getColumn(1);
          colum.setPreferredWidth(120);

          colum = vTReportes.getColumnModel().getColumn(2); // sucursal
          colum.setPreferredWidth(183);

          colum = vTReportes.getColumnModel().getColumn(3); // tarjeta
          colum.setPreferredWidth(83);

          colum = vTReportes.getColumnModel().getColumn(4);
          colum.setPreferredWidth(243);

          colum = vTReportes.getColumnModel().getColumn(5);
          colum.setPreferredWidth(80);

          
          es.printStackTrace();



    }// fin de catch

}// fin de método reporteEmpleado

}// fin de la clase ReportesEmpleado
