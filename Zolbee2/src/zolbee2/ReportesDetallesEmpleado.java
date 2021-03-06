/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ReportesDetallesEmpleado.java
 *
 * Created on 19/04/2010, 12:48:03 PM
 */

package zolbee2;

/**
 *
 * @author Roberto
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.*;
import net.sf.jasperreports.view.save.JRPdfSaveContributor.*;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.save.JRMultipleSheetsXlsSaveContributor;


    public class ReportesDetallesEmpleado extends javax.swing.JFrame {
    public static String idmov = null;
    public static String cva_empleado = null;
    public static String nom_empleado = null;

    String conexion = Funciones.conectar;
    int in = 0;
    int registros = 20;
    int rest_sum = 20;

    /** Creates new form ReportesDetallesEmpleado */
    public ReportesDetallesEmpleado(String idmovi, String cva_emp, String nom_emp) {
        idmov = idmovi;
        cva_empleado = cva_emp;
        nom_empleado = nom_emp;
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
        B_ImprimirFechas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        l_Mov = new javax.swing.JLabel();
        l_CvaEmpleado = new javax.swing.JLabel();
        l_NombreEmpleado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(zolbee2.Zolbee2App.class).getContext().getResourceMap(ReportesDetallesEmpleado.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
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
                "Descripción", "Precio Venta", "Ahorro", "Monto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        vTReportes.setName("vTReportes"); // NOI18N
        jScrollPane1.setViewportView(vTReportes);
        vTReportes.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("vTReportes.columnModel.title0")); // NOI18N
        vTReportes.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("vTReportes.columnModel.title1")); // NOI18N
        vTReportes.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("vTReportes.columnModel.title2")); // NOI18N
        vTReportes.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("vTReportes.columnModel.title3")); // NOI18N

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

        B_ImprimirFechas.setIcon(resourceMap.getIcon("B_ImprimirFechas.icon")); // NOI18N
        B_ImprimirFechas.setText(resourceMap.getString("B_ImprimirFechas.text")); // NOI18N
        B_ImprimirFechas.setEnabled(false);
        B_ImprimirFechas.setName("B_ImprimirFechas"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        l_Mov.setText(resourceMap.getString("l_Mov.text")); // NOI18N
        l_Mov.setName("l_Mov"); // NOI18N

        l_CvaEmpleado.setText(resourceMap.getString("l_CvaEmpleado.text")); // NOI18N
        l_CvaEmpleado.setName("l_CvaEmpleado"); // NOI18N

        l_NombreEmpleado.setText(resourceMap.getString("l_NombreEmpleado.text")); // NOI18N
        l_NombreEmpleado.setName("l_NombreEmpleado"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(VAnterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 400, Short.MAX_VALUE)
                .addComponent(VSiguiente)
                .addGap(138, 138, 138))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_NombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(l_CvaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(l_Mov, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 454, Short.MAX_VALUE)
                            .addComponent(B_ImprimirFechas, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(l_Mov, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(l_CvaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(l_NombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(B_ImprimirFechas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VSiguiente)
                    .addComponent(VAnterior))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        l_Mov.setText(idmov);
        l_CvaEmpleado.setText(cva_empleado);
        l_NombreEmpleado.setText(nom_empleado);
        boolean actv = true;
        in=0;
        cargarDetallesEmpleado(idmov,in,registros,actv);
        
    }//GEN-LAST:event_formWindowOpened

    private void VAnteriorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VAnteriorKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
       {
            boolean actv = false;
           in = in - rest_sum;
             if(in>=0)
             {
                 cargarDetallesEmpleado(idmov,in,registros,actv);
             }
             else
             {
                 in=0;
             }

       } // fin if enter
    }//GEN-LAST:event_VAnteriorKeyReleased

    private void VAnteriorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VAnteriorMouseReleased
        // TODO add your handling code here:
           boolean actv = false;
           in = in - rest_sum;
             if(in>=0)
             {
                 cargarDetallesEmpleado(idmov,in,registros,actv);
             }
             else
             {
                 in=0;
             }
    }//GEN-LAST:event_VAnteriorMouseReleased

    private void VSiguienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VSiguienteKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
       {
           boolean actv = false;
           in = in + rest_sum;
           cargarDetallesEmpleado(idmov,in,registros,actv);
       } //fin if enter
    }//GEN-LAST:event_VSiguienteKeyReleased

    private void VSiguienteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VSiguienteMouseReleased
        // TODO add your handling code here:
           boolean actv = false;
           in = in + rest_sum;
           cargarDetallesEmpleado(idmov,in,registros,actv);
    }//GEN-LAST:event_VSiguienteMouseReleased

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportesDetallesEmpleado(idmov,cva_empleado,nom_empleado).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_ImprimirFechas;
    private javax.swing.JButton VAnterior;
    private javax.swing.JButton VSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l_CvaEmpleado;
    private javax.swing.JLabel l_Mov;
    private javax.swing.JLabel l_NombreEmpleado;
    private javax.swing.JTable vTReportes;
    // End of variables declaration//GEN-END:variables

    private void cargarDetallesEmpleado(String idmovimiento, int inc, int reg, boolean act)
    {

        String idmovi = idmovimiento;
        int inicios = inc;
        int registro = reg;
        boolean activarB = act;
       //System.out.println(inicios+" "+registro);
      try
     {
        Class.forName("com.mysql.jdbc.Driver");
        //Establecer conexion a la base de datos
        //LeeFichero leerFichero = new LeeFichero();
        //leerFichero.leerFichero();
        //idsucursal=leerFichero.vsucusal;
        Connection conectar = DriverManager.getConnection(conexion);
        //Crear objeto Statement para realizar queries a la base de datos
        Statement instruccion = conectar.createStatement();
        //Consultar a la base de datos para saber cuantos registros tenemos
        ResultSet rs = instruccion.executeQuery("SELECT * FROM des_movimientos   WHERE idmovimiento="+idmovi+"  ORDER BY idmovimiento");
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
              B_ImprimirFechas.setEnabled(true);
          }
        }
        else
        {
          VAnterior.setEnabled(false);
          VSiguiente.setEnabled(false);
          B_ImprimirFechas.setEnabled(false);
        }
        //rs.first();

        //La clase ResultSetMetaData contiene toda la información sobre los campos de base de datos contenidos en el ResultSet. Necesitamos preguntarle por el número de columnas y por la etiqueta para cada una de las columnas. Este es el código que lo hace
        //ResultSetMetaData metaDatos = rs.getMetaData();


       //int numeroColumnas = metaDatos.getColumnCount();

       ResultSet rs2 = instruccion.executeQuery("SELECT * FROM des_movimientos  WHERE idmovimiento="+idmovi+"  ORDER BY idmovimiento LIMIT "+inicios+","+registro+" ");

       ResultSetMetaData metaDatos2 = rs2.getMetaData();

       // Se obtiene el número de columnas.
       int numeroColumnas2 = metaDatos2.getColumnCount();

         System.out.println("Numero de Columnas= "+numeroColumnas2);


       //Cabecera
        String[] cabecera = new String[]
            {"Descripcion", "Precio Venta","Ahorro","Monto"/*,"IVA","Precio Descuento"*/};
            rs2.last();
            System.out.println("Numero de Registros= "+rs2.getRow());
            Object[][] m=new Object[rs2.getRow()][4];
            int i=0;
            rs2.first();
            do
            {

              m[i][0] = rs2.getObject("descripcion"); // descripcion
              m[i][1] = rs2.getObject("p_venta");         // precio venta
              m[i][2] = rs2.getObject("ahorro");    // ahorro
              m[i][3] = rs2.getObject("total"); // monto
              //m[i][4] = rs2.getObject("iva"); // iva
              //m[i][5] = rs2.getObject("p_descuento"); // p_descuento
              //System.out.println(m[i][1]);
             i++;
             }while(rs2.next());
            vTReportes.setModel(new javax.swing.table.DefaultTableModel(m,cabecera){
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class/*, java.lang.String.class, java.lang.String.class*/
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

          colum = vTReportes.getColumnModel().getColumn(0); //descripcion
          colum.setPreferredWidth(280);

          colum = vTReportes.getColumnModel().getColumn(1); // precio venta
          colum.setPreferredWidth(120);

          colum = vTReportes.getColumnModel().getColumn(2); // ahorro
          colum.setPreferredWidth(120);

          colum = vTReportes.getColumnModel().getColumn(3); // monto
          colum.setPreferredWidth(100);

          //colum = vTReportes.getColumnModel().getColumn(4); // iva
          //colum.setPreferredWidth(83);

          //colum = vTReportes.getColumnModel().getColumn(5); // p_descuento
          //colum.setPreferredWidth(243);

          instruccion.close();
          System.out.println("Se cargo correctamente la lista.");

   } // fin de try
   catch(Exception es)
   {
       vTReportes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
              "Descripcion", "Precio Venta","Ahorro","Monto"/*,"IVA","Precio Descuento"*/
            }
            ) {

            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class/*, java.lang.String.class, java.lang.String.class*/
            };

           boolean[] canEdit = new boolean [] {
                false, false, false, false/*, false, false*/
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

          colum = vTReportes.getColumnModel().getColumn(0); //descripcion
          colum.setPreferredWidth(280);

          colum = vTReportes.getColumnModel().getColumn(1); // precio venta
          colum.setPreferredWidth(120);

          colum = vTReportes.getColumnModel().getColumn(2); // ahorro
          colum.setPreferredWidth(120);

          colum = vTReportes.getColumnModel().getColumn(3); // monto
          colum.setPreferredWidth(100);

          //colum = vTReportes.getColumnModel().getColumn(4);
          //colum.setPreferredWidth(83);

          //colum = vTReportes.getColumnModel().getColumn(5);
          //colum.setPreferredWidth(243);

         es.printStackTrace();

   } // fin de catch

       
    }// fin de método cargarDetallesEmpleado

} // fin de la clase ReportesDetallesEmpleado
