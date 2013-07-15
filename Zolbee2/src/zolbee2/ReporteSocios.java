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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ReporteSocios.java
 *
 * Created on 12/04/2010, 01:33:53 PM
 */

/**
 *
 * @author Roberto
 */
public class ReporteSocios extends javax.swing.JFrame {

     private IniciarReporteSocios jasper ;
     String conexion = Funciones.conectar;
     int in = 0;
     int registros = 20;
     int rest_sum = 20;



    /** Creates new form ReporteSocios */
    public ReporteSocios() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        vTReportes = new javax.swing.JTable();
        VAnterior = new javax.swing.JButton();
        VSiguiente = new javax.swing.JButton();
        l_Nombre = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        vSocios = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        B_imprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(zolbee2.Zolbee2App.class).getContext().getResourceMap(ReporteSocios.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        vTReportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Movimientos", "Fecha", "Sucursal", "Clave Empleado", "No. Tarjeta", "Monto"
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

        l_Nombre.setFont(resourceMap.getFont("l_Nombre.font")); // NOI18N
        l_Nombre.setForeground(resourceMap.getColor("l_Nombre.foreground")); // NOI18N
        l_Nombre.setText(resourceMap.getString("l_Nombre.text")); // NOI18N
        l_Nombre.setName("l_Nombre"); // NOI18N

        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setName("jButton3"); // NOI18N
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton3MouseReleased(evt);
            }
        });
        jButton3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton3KeyReleased(evt);
            }
        });

        jLabel1.setForeground(resourceMap.getColor("jLabel1.foreground")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        vSocios.setName("vSocios"); // NOI18N

        jLabel2.setFont(resourceMap.getFont("jLabel2.font")); // NOI18N
        jLabel2.setForeground(resourceMap.getColor("jLabel2.foreground")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        B_imprimir.setIcon(resourceMap.getIcon("B_imprimir.icon")); // NOI18N
        B_imprimir.setText(resourceMap.getString("B_imprimir.text")); // NOI18N
        B_imprimir.setEnabled(false);
        B_imprimir.setName("B_imprimir"); // NOI18N
        B_imprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                B_imprimirMouseReleased(evt);
            }
        });
        B_imprimir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                B_imprimirKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(VAnterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 483, Short.MAX_VALUE)
                .addComponent(VSiguiente)
                .addGap(115, 115, 115))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(286, 286, 286)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(269, 269, 269))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(l_Nombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(40, 40, 40)
                        .addComponent(vSocios, 0, 291, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(87, 87, 87)
                .addComponent(B_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(vSocios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addGap(18, 18, 18)
                        .addComponent(l_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(B_imprimir)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(VSiguiente)
                    .addComponent(VAnterior))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        llenarSocios();

    }//GEN-LAST:event_formWindowOpened

    private void jButton3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyReleased
        // TODO add your handling code here:
         
       if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
        try {
             boolean actv = true;
            in = 0;
            reporteSocio(in, registros, actv);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReporteSocios.class.getName()).log(Level.SEVERE, null, ex);
        }
       }


    }//GEN-LAST:event_jButton3KeyReleased

    private void jButton3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseReleased
        // TODO add your handling code here:
      
        try {
            boolean actv = true;
            in = 0;
            reporteSocio(in, registros, actv);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReporteSocios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3MouseReleased

    private void VAnteriorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VAnteriorKeyReleased
        // TODO add your handling code here:
     if (evt.getKeyCode() == KeyEvent.VK_ENTER)
      {
          try {
             boolean actv = false;
             in = in - rest_sum;
             if(in>=0)
             {
               reporteSocio(in, registros, actv);
             }
             else
             {
                 in=0;
             }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReporteSocios.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    }//GEN-LAST:event_VAnteriorKeyReleased

    private void VAnteriorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VAnteriorMouseReleased
        // TODO add your handling code here:
         try {
             boolean actv = false;
             in = in - rest_sum;
             if(in>=0)
             {
               reporteSocio(in, registros, actv);
             }
             else
             {
                 in=0;
             }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReporteSocios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_VAnteriorMouseReleased

    private void VSiguienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VSiguienteKeyReleased
        // TODO add your handling code here:
         if (evt.getKeyCode() == KeyEvent.VK_ENTER)
      {
          try {
             boolean actv = false;
             in = in + rest_sum;
             reporteSocio(in, registros, actv);
                  
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReporteSocios.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    }//GEN-LAST:event_VSiguienteKeyReleased

    private void VSiguienteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VSiguienteMouseReleased
        // TODO add your handling code here:
         try {
             boolean actv = false;
             in = in + rest_sum;
             reporteSocio(in, registros, actv);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReporteSocios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_VSiguienteMouseReleased

    private void B_imprimirKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B_imprimirKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {

           String socio = (String) vSocios.getSelectedItem();
           System.out.println(socio);
           String arrayemp[] = null;
           arrayemp = socio.split("-");

            jasper = new IniciarReporteSocios ();
            jasper.ejecutarReporte(arrayemp[0]);
        }// fin de if enter
       
    }//GEN-LAST:event_B_imprimirKeyReleased

    private void B_imprimirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_imprimirMouseReleased
        // TODO add your handling code here:
           String empleado = (String) vSocios.getSelectedItem();
           System.out.println(empleado);
           String arrayemp[] = null;
           arrayemp = empleado.split("-");

           jasper = new IniciarReporteSocios ();
           jasper.ejecutarReporte(arrayemp[0]);

    }//GEN-LAST:event_B_imprimirMouseReleased

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
                String socio = (String) vSocios.getSelectedItem();
                System.out.println(socio);
                String arrayemp[] = null;
                arrayemp = socio.split("-");
                //System.out.println(idmovimiento+" "+"esta id elegiste");
                //Funciones.imprimirMsj("hiciste enter             
                ReportesDetallesSocio detallesSocio = new ReportesDetallesSocio(idmovimiento,arrayemp[0],arrayemp[1]);
                //Menu f2 = new Menu();

                detallesSocio.setLocationRelativeTo(null);
                detallesSocio.getContentPane().setBackground(Color.decode("#7329ab"));
                //lo hacemos visible
                detallesSocio.setVisible(true);
             }
        } // fin if enter
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
              String socio = (String) vSocios.getSelectedItem();
              System.out.println(socio);
              String arrayemp[] = null;
              arrayemp = socio.split("-");
              //System.out.println(idmovimiento+" "+"esta id elegiste");
              //Funciones.imprimirMsj("hiciste enter
              ReportesDetallesSocio detallesSocio = new ReportesDetallesSocio(idmovimiento,arrayemp[0],arrayemp[1]);
              //Menu f2 = new Menu();

              detallesSocio.setLocationRelativeTo(null);
              detallesSocio.getContentPane().setBackground(Color.decode("#7329ab"));
              //lo hacemos visible
              detallesSocio.setVisible(true);
         }
       }// fin if doble clic
    }//GEN-LAST:event_vTReportesMouseReleased

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReporteSocios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_imprimir;
    private javax.swing.JButton VAnterior;
    private javax.swing.JButton VSiguiente;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l_Nombre;
    private static javax.swing.JComboBox vSocios;
    private javax.swing.JTable vTReportes;
    // End of variables declaration//GEN-END:variables

    private void llenarSocios() 
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

        ResultSet rs = instruccion.executeQuery("SELECT idsocio, nombresocio FROM movimientos WHERE idsucursal="+idsucursal+" GROUP BY idsocio");
        rs.last();
        //int cont = rs.getRow();
        //System.out.println(cont);
        Object m[] = new Object[rs.getRow()]; // creo array para guardar los campos
        int x = 0;
        int y = 0;
        rs.first();
        do
       {

          String idempleado = rs.getString("idsocio");
          String nombreempleado = rs.getString("nombresocio");
          //System.out.println(idsucursal+nombreSucursal);

          m[x] = idempleado+"-"+nombreempleado;
          //System.out.println(m[x]);

          x++;
        }while(rs.next());

        ReporteSocios.vSocios.setModel(new javax.swing.DefaultComboBoxModel(m));
        ReporteSocios.vSocios.setName("vSocios");


        //La clase ResultSetMetaData contiene toda la información sobre los campos de base de datos contenidos en el ResultSet. Necesitamos preguntarle por el número de columnas y por la etiqueta para cada una de las columnas. Este es el código que lo hace
        //ResultSetMetaData metaDatos = rs.getMetaData();

       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, "No pudo conectarse a la base de datos ...", "Cuidado", JOptionPane.ERROR_MESSAGE);
           e.printStackTrace();
       }
    }// fin de método llenarListaSocios

    private void reporteSocio(int inc, int reg, boolean act)  throws ClassNotFoundException{

       String empleado = (String) vSocios.getSelectedItem();
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
        ResultSet rs = instruccion.executeQuery("SELECT * FROM movimientos WHERE idsocio="+arrayemp[0]+" ORDER BY idmovimientos");

         rs.last();
      int rowcont = rs.getRow();
      System.out.println(rowcont);
      if(inicios>rowcont)
      {
        in = in - rest_sum;
        inicios = inicios - rest_sum;
      }
      if(rowcont>0)
      {
          if(activarB==true)
          {
              VAnterior.setEnabled(true);
              VSiguiente.setEnabled(true);
              B_imprimir.setEnabled(true);
          }
      }
      else
      {
          VAnterior.setEnabled(false);
          VSiguiente.setEnabled(false);
          B_imprimir.setEnabled(false);
      }
      if(rowcont>0)
      {
        ResultSet rs2 = instruccion.executeQuery("SELECT * FROM movimientos WHERE idsocio="+arrayemp[0]+" ORDER BY idmovimientos LIMIT "+inicios+","+registro+"");


         ResultSetMetaData metaDatos2 = rs2.getMetaData();

      // Se obtiene el número de columnas.
      int numeroColumnas2 = metaDatos2.getColumnCount();

         System.out.println("Numero de Columnas= "+numeroColumnas2);


       //Cabecera
        String[] cabecera = new String[]
            {"Movimiento", "Fecha", "Sucursal", "Clave Empleado", "No. Tarjeta", "Monto"};
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
              m[i][3] = rs2.getObject("idempleado"); //nombre empleado
              m[i][4] = rs2.getObject("no_tarjetazolbee");// no. tarjeta zolbee
              m[i][5] = rs2.getObject("total");          // monto

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
          colum.setPreferredWidth(326);

          colum = vTReportes.getColumnModel().getColumn(3); // empleado
          colum.setPreferredWidth(100);

          colum = vTReportes.getColumnModel().getColumn(4); // tarjeta
          colum.setPreferredWidth(83);

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
               "Movimiento", "Fecha", "Sucursal", "Clave Empleado", "No. Tarjeta", "Monto"
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

          colum = vTReportes.getColumnModel().getColumn(2);
          colum.setPreferredWidth(326);

          colum = vTReportes.getColumnModel().getColumn(3); // empleado
          colum.setPreferredWidth(100);

          colum = vTReportes.getColumnModel().getColumn(4); // tarjeta
          colum.setPreferredWidth(83);

          colum = vTReportes.getColumnModel().getColumn(5);
          colum.setPreferredWidth(80);
       }
          l_Nombre.setText(arrayemp[1]); // nombre del empleado




    } // fin de try
    catch(SQLException es)
    {

           vTReportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
               "Movimiento", "Fecha", "Sucursal", "Clave Empleado", "No. Tarjeta", "Monto"
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

          colum = vTReportes.getColumnModel().getColumn(2);
          colum.setPreferredWidth(326);

          colum = vTReportes.getColumnModel().getColumn(3); // empleado
          colum.setPreferredWidth(100);

          colum = vTReportes.getColumnModel().getColumn(4); // tarjeta
          colum.setPreferredWidth(83);

          colum = vTReportes.getColumnModel().getColumn(5);
          colum.setPreferredWidth(80);

          es.printStackTrace();



    }// fin de catch
      
  }// fin de método reporteSocio

} // fin de la clase ReporteSocios
