/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LoginEmpleado.java
 *
 * Created on 9/04/2010, 02:51:53 PM
 */

package zolbee2;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Roberto
 */
public class LoginEmpleado extends javax.swing.JFrame {
    static String url = Funciones.conectar;;
    static String id;
    static String nombre;
    static String nomsucu;

    /** Creates new form LoginEmpleado */
    public LoginEmpleado() {
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

        BIngresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        vClave = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(zolbee2.Zolbee2App.class).getContext().getResourceMap(LoginEmpleado.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setName("Form"); // NOI18N
        setResizable(false);

        BIngresar.setText(resourceMap.getString("BIngresar.text")); // NOI18N
        BIngresar.setName("BIngresar"); // NOI18N
        BIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BIngresarMouseReleased(evt);
            }
        });
        BIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BIngresarActionPerformed(evt);
            }
        });
        BIngresar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BIngresarKeyReleased(evt);
            }
        });

        jLabel2.setFont(resourceMap.getFont("jLabel2.font")); // NOI18N
        jLabel2.setForeground(resourceMap.getColor("jLabel2.foreground")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setFont(resourceMap.getFont("jLabel3.font")); // NOI18N
        jLabel3.setForeground(resourceMap.getColor("jLabel3.foreground")); // NOI18N
        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        vClave.setText(resourceMap.getString("vClave.text")); // NOI18N
        vClave.setName("vClave"); // NOI18N
        vClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                vClaveKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BIngresar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel2)
                        .addGap(29, 29, 29)
                        .addComponent(vClave, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)))
                .addGap(97, 97, 97))
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(111, 111, 111))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(vClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(BIngresar)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BIngresarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_BIngresarActionPerformed

    private void BIngresarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BIngresarMouseReleased
        // TODO add your handling code here:
         loguearse();
    }//GEN-LAST:event_BIngresarMouseReleased

    private void BIngresarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BIngresarKeyReleased
        // TODO add your handling code here:
         loguearse();
    }//GEN-LAST:event_BIngresarKeyReleased

    private void vClaveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vClaveKeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
         {
            loguearse();
         }




    }//GEN-LAST:event_vClaveKeyReleased

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BIngresar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private static javax.swing.JPasswordField vClave;
    // End of variables declaration//GEN-END:variables

public void loguearse ()
{

    String clave = vClave.getText();
    LeeFichero leerFichero = new LeeFichero();
    leerFichero.leerFichero();
    String idsucursal = leerFichero.vsucusal;


    Connection conn = null;

 try {
           Class.forName("com.mysql.jdbc.Connection");
           conn = (Connection) DriverManager.getConnection(url);
           if (conn != null)
           {
               System.out.println("Conexión a base de datos "+url+" ... Ok");
           }
       }
       catch(SQLException ex)
       {
           //JOptionPane.showMessageDialog(this,"Hubo un problema al intentar conectarse con la base de datos ..."+url);
           JOptionPane.showMessageDialog(this, "Hubo un problema al intentar conectarse con la base de datos ...", "Cuidado", JOptionPane.ERROR_MESSAGE);
           //System.out.println("Hubo un problema al intentar conectarse con la base de datos "+url);
       }
       catch(ClassNotFoundException ex)
       {
           System.out.println(ex);
       }

       Statement s;
          try
          {
           s =(Statement) conn.createStatement();
           
           System.out.println("Empezando a realizar la consulta"+" "+"SELECT * FROM sucu_empleados WHERE clave='"+clave+"' AND idsucursal="+idsucursal+" AND sucu.idsucursal=suc.idsucursal AND suc.estatus=1 AND sucu.estatus=1");
           ResultSet rs = s.executeQuery("SELECT * FROM sucu_empleados AS sucu, sucursal AS suc WHERE sucu.clave='"+clave+"' AND sucu.idsucursal="+idsucursal+" AND sucu.idsucursal=suc.idsucursal AND suc.estatus=1 AND sucu.estatus=1");
           rs.first();
           int cuantos = rs.getRow();

           //System.out.println(id);
           System.out.println(cuantos);


           if(cuantos != 0)
               {

                 id = rs.getString("sucu.idempleado");
                 nombre = rs.getString("sucu.nombre");
                 nomsucu= rs.getString("suc.nombre");
                 System.out.println("Se logueo con exito");
                

                 Consumos consumo = new Consumos (id,nombre,nomsucu);
                 consumo.setLocationRelativeTo(null);
                 consumo.getContentPane().setBackground(Color.decode("#7329ab"));
                 consumo.setVisible(true);



                 this.dispose();

               }
                else
                {
                   JOptionPane.showMessageDialog(this,"Lo sentimos pero tu  clave es incorrecta o  no pertenece a esta sucursal");
                }


       }
       catch (SQLException ex)
       {
           System.out.println("Hubo un problema al intentar obtener lo datos");
       }





    
} // fin de método loguearse








} // fin de la clase LoginEmpleado
