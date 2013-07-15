/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zolbee2;

/**
 *
 * @author roberto
 */

import java.awt.Color;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Funciones
{
    //Hola Hector!!
    public static String conectar = "jdbc:mysql://207.210.64.221/zolbeec_zolbee?user=zolbeec_roberto&password=roberto";
    String subcadena;
    int bandera = 0;
    boolean bandera2 = false;
    String usuario = null;
    String contrasena = null;
    String encriptado = "";
    public static int i = 0;
    //public static Object m[][];

    public static void llenarSucursalesList ()
    {
       try
       {
          //Cargar clase de controlador de base de datos
         Class.forName("com.mysql.jdbc.Driver");
         //Establecer conexion a la base de datos

        Connection conexion = DriverManager.getConnection(conectar);
        //Crear objeto Statement para realizar queries a la base de datos
        Statement instruccion = conexion.createStatement();

        
        
         int id_afiliadas = Integer.parseInt(LoginConf.id);
         

         System.out.println("entro a funciones"+id_afiliadas);
        //Consultar a la base de datos
        ResultSet rs = instruccion.executeQuery("SELECT * FROM sucursal WHERE ide_afiliadas='"+id_afiliadas+"'");
        rs.last();
        //int cont = rs.getRow();
        //System.out.println(cont);
        Object m[] = new Object[rs.getRow()]; // creo array para guardar los campos
        int x = 0;
        int y = 0;
        rs.first();
        do
       {
          
          String idsucursal = rs.getString("idsucursal");
          String nombreSucursal = rs.getString("nombre");
          //System.out.println(idsucursal+nombreSucursal);
        
          m[x] = idsucursal+"-"+nombreSucursal;
          //System.out.println(m[x]);
        
          x++;
        }while(rs.next());

        SucursalesConf.vSucursalesConf.setModel(new javax.swing.DefaultComboBoxModel(m));
        SucursalesConf.vSucursalesConf.setName("vSucursalesConf");
       
      
        //La clase ResultSetMetaData contiene toda la información sobre los campos de base de datos contenidos en el ResultSet. Necesitamos preguntarle por el número de columnas y por la etiqueta para cada una de las columnas. Este es el código que lo hace
        //ResultSetMetaData metaDatos = rs.getMetaData();

       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, "No pudo conectarse a la base de datos ...", "Cuidado", JOptionPane.ERROR_MESSAGE);
           e.printStackTrace();
       }


    } // fin de método llenarSucursalesList



    public void validarTextCN (String cadena)
    {
        String input = cadena;
        //Pattern p = Pattern.compile("[A-Za-z0-9]+");
        Pattern p2 = Pattern.compile(":+|,+");
        //Matcher m = p.matcher(input);
        Matcher m2 = p2.matcher(input);

        //System.out.println(input);

        if (m2.find()){
         //System.out.println("cadena no valida");
        bandera = 1;
        int longitud = input.length()-1;
        subcadena = input.substring(0, longitud);
        //System.out.println(subcadena);
        //SucursalesConf.vUsuarioSistem.setText(subcadena);



        }
        else{
        bandera = 0;
         //System.out.println("cadena  valida");
        }

    } // fin de método validarTextCN

public static void imprimirMsj (String mensaje)
{

    JOptionPane.showMessageDialog(null, mensaje);

}



public void llenarPromocion(String id)
{

    //System.out.println(id);
    String tarjeta_zolbee = id;

    try
    {

         //Cargar clase de controlador de base de datos
         Class.forName("com.mysql.jdbc.Driver");
         //Establecer conexion a la base de datos

        Connection conexion = DriverManager.getConnection(conectar);
        //Crear objeto Statement para realizar queries a la base de datos
        Statement instruccion = conexion.createStatement();

        instruccion.executeQuery("begin");

        ResultSet rs = instruccion.executeQuery("SELECT soc.*,tar.nombre AS nombretarjeta FROM socios soc,tipo_tarjetas tar WHERE soc.idtipo_tarjeta=tar.idtipo_tarjeta AND trim(no_tarjetazolbee)='"+tarjeta_zolbee+"'");

   
        rs.last();
        int cont = rs.getRow();
        System.out.println("numreo de registros"+" "+cont);
        //String
        rs.first();
        if(cont==1)
        {
          Consumos.l_nombre.setText(rs.getString("nombre").toUpperCase()+" "+rs.getString("paterno").toUpperCase()+" "+rs.getString("materno").toUpperCase());
          Consumos.IDsocio = rs.getString("idsocio");
          Consumos.NO_tar = tarjeta_zolbee;
          imprimirEstatus(rs.getString("estatus"));
          Consumos.l_tipotarjeta.setText(rs.getString("nombretarjeta").toUpperCase());
          //System.out.println(cont);
         
          if(rs.getString("estatus").equals("1") ||rs.getString("estatus").equals("2"))
          {
             LeeFichero ficha = new LeeFichero ();
             ficha.leerFichero();
             int idsucursal = Integer.parseInt(ficha.vsucusal);
             ResultSet rs2 = instruccion.executeQuery("SELECT pc.idpromociones, pro.descripcion FROM promo_sucur  pc,promociones  pro WHERE  pro.idpromociones=pc.idpromociones AND pc.idsucursal="+idsucursal+"");
             int cont2 = rs2.getRow();
             if(cont2>=0)
             {
                  bandera2=true;
             }

             rs2.last();
             Object m[] = new Object[rs2.getRow()]; // creo array para guardar los campos
             int x = 0;
             int y = 0;
             rs2.first();
             do
             {

                String idsuc = rs2.getString("idpromociones");
                String nombrepromo = rs2.getString("descripcion");
                System.out.println(idsuc+"-"+nombrepromo);

                m[x] = idsuc +"-"+nombrepromo;
                //System.out.println(m[x]);

                x++;
            }while(rs2.next());

            Consumos.vPromociones.setModel(new javax.swing.DefaultComboBoxModel(m));
            Consumos.vPromociones.setName("vPromociones");
         
          } // fin de if

          else
          {
               Funciones.imprimirMsj("EL No. de Tarjeta que Introdujo Esta Desactivado");
          }
     
       }   // fin de if cont

       else
       {
           
          Funciones.imprimirMsj("El No. de Tarjeta que Introdujo no Existe");

       }
   } // fin de try
   catch (Exception e){
       
 
       Funciones.imprimirMsj("Hubo un problema en la conexión de la base de datos");
       e.printStackTrace();


   }
} // fin de método llenarPromocion

public void imprimirEstatus (String estatus)
{
   String caso = estatus;

   switch(Integer.parseInt(caso)){

       case 0:
           Consumos.l_estatus.setText("Desactivado".toUpperCase());
           break;
       case 1:
           Consumos.l_estatus.setText("Vigente".toUpperCase());
           break;
       case 2:
           Consumos.l_estatus.setText("Vigente".toUpperCase());
           break;
       case 3:
           Consumos.l_estatus.setText("Desactivado".toUpperCase());
           break;
       case 4:
           Consumos.l_estatus.setText("Desactivado".toUpperCase());
           break;
     }
  } // fin de método imprimirEstatus



  public void EncriptCadena (String c, String t)
  {

         int i=0, j=0, ic=c.length(), it=t.length();
         int temp;
         int[] claveascii = new int[ic];
         int[] textoascii = new int[it];

         for (i=0; i<ic;i++){
             claveascii[i]=c.charAt(i);
         }

         for (i=0; i<it;i++){
             textoascii[i]=t.charAt(i);
         }

         for (i=0; i<it;i++)
         {
             j++;
             if (j>=ic)j=0;
             temp= textoascii[i]+claveascii[j];

             if (temp > 255) temp=temp-255;
             encriptado=encriptado + (char)temp;

         }
          //System.out.println(encriptado);
  } // fin método EncriptCadena


  public static void  agregarMontoPromo(String id, String [] array, float monto,boolean cont,int resta) throws Exception
  {

          double pv = Redondear(monto,2);
         
         
          double v_subtotal = 0;
          double v_desc = 0;
          double v_total = 0;
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn = null;
           String idpromociones = array[0];
          try
          {
             
            conn = DriverManager.getConnection(conectar);
            
            Statement st = conn.createStatement();
             
             
             //System.out.println("el ide la promo es:"+" "+idpromociones);
             //System.out.println("SELECT desc_porc FROM promociones WHERE idpromociones="+idpromociones+"");

             ResultSet rs =  st.executeQuery("SELECT desc_porc FROM promociones WHERE idpromociones="+idpromociones+"");
              rs.last();
             int cont2 = rs.getRow();
             
             //System.out.println(cont2);
             String descuent = rs.getString("desc_porc"); //obtengo el valor del descuento de esa promocion
             float descq = Float.parseFloat(descuent)/100; // la convierto a float
             double desc = Redondear(monto * descq,2);      // obtengo el descuento y redondeo con el método Redondear
             
             double total = Redondear(pv - desc,2);
               String[] cabecera = new String[]
            {"DESCRIPCION", "PRECIO VENTA","DESCUENTO","% DESCUENTO","TOTAL"};

            //System.out.println("Numero de Registros= "+rs.getRow());
            Object[][] m=new Object[Consumos.t_MontoPro.getRowCount()+1][Consumos.t_MontoPro.getColumnCount()];
            for(int i=0;i<Consumos.t_MontoPro.getColumnCount();i++)
            {
               for(int j=0;j<Consumos.t_MontoPro.getRowCount();j++)
               {
                 m[j][i]=Consumos.t_MontoPro.getValueAt(j, i);


                    if(i==1) //PRECIO VENTA
                    {
                        String consumo = Consumos.t_MontoPro.getValueAt(j, i).toString();
                        float cons = Float.parseFloat(consumo);
                        v_subtotal = v_subtotal + cons;
                    }
                    if(i==2) // DESCUENTO
                    {
                          String consumo = Consumos.t_MontoPro.getValueAt(j, i).toString();
                          float cons = Float.parseFloat(consumo);
                          v_desc = v_desc + cons;
                    }

               }
            }
            //System.out.println(Consumos.t_MontoPro.getRowCount()+1);
            //System.out.println(cont);
             if(cont==true){
               i=i-resta;

              }
            Consumos.t_MontoPro.setModel(new DefaultTableModel(m,cabecera));

              //System.out.println("NUmero de la posicion de la fila para insertar"+" "+i);


              m[i][0] = array[1];
              m[i][1] = pv;
              m[i][2] = desc;
              m[i][3] = descuent;
              m[i][4] = total;

                i++;




              v_subtotal = Redondear(v_subtotal + pv,2);
              v_desc = Redondear(v_desc + desc,2);
              v_total = Redondear( v_subtotal - v_desc,2);

              Consumos.l_Subtotal.setText(String.valueOf(v_subtotal));
              Consumos.l_Ahorro.setText(String.valueOf(v_desc));
              Consumos.l_Total.setText(String.valueOf(v_total));

              //System.out.println(m[i][1]);

            Consumos.t_MontoPro.setModel(new DefaultTableModel(m,cabecera){
            Class[] types = new Class [] {
                java.lang.String.class ,java.lang.String.class , java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false,false
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
          Consumos.t_MontoPro.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
          Consumos.t_MontoPro.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
          Consumos.t_MontoPro.setBackground(Color.decode("#BAD405"));
          Consumos.t_MontoPro.setRowHeight(17);
          Consumos.t_MontoPro.setEditingRow(1);
          javax.swing.table.TableColumn colum= null;


          colum = Consumos.t_MontoPro.getColumnModel().getColumn(0);
          colum.setPreferredWidth(500);

          colum = Consumos.t_MontoPro.getColumnModel().getColumn(1);
          colum.setPreferredWidth(120);


          colum = Consumos.t_MontoPro.getColumnModel().getColumn(2);
          colum.setPreferredWidth(120);

          colum = Consumos.t_MontoPro.getColumnModel().getColumn(3);
          colum.setPreferredWidth(120);

          colum = Consumos.t_MontoPro.getColumnModel().getColumn(4);
          colum.setPreferredWidth(120);

            //instruccion.close();
            //System.out.println("Se cargo correctamente la lista.");

          } // fin de try

          catch(SQLException e)
          {

              e.printStackTrace();


          } // fin de catch

  } // fin de método agregarMontoPromo


public static double Redondear(double numero,int digitos)
	{
	      int cifras=(int) Math.pow(10,digitos);
	      return Math.rint(numero*cifras)/cifras;
	}




public static void inicializarI ()
{
  i=0;
} // fin método inicialiazarI

 public void validarTextDec (String cadena)
    {
        String input = cadena;
        //Pattern p = Pattern.compile("[A-Za-z0-9]+");
        Pattern p2 = Pattern.compile("[0-9]+(\\.[0-9]+)?$");
        //Matcher m = p.matcher(input);
        Matcher m2 = p2.matcher(input);

        System.out.println(input);

        if (m2.find()){
         System.out.println("cadena valida");
         bandera = 0;
        //System.out.println(subcadena);
        //SucursalesConf.vUsuarioSistem.setText(subcadena);
        // subcadena=input;
       }
        else{

         bandera = 1;
         System.out.println("cadena no valida");
         
         //int longitud = input.length()-1;
         //subcadena = input.substring(0, longitud);
         //System.out.println("cadena  valida");
        }

    } // fin de método validarTextCN

   public void validarTextNum (String cadena)
   {

      String input = cadena;
        //Pattern p = Pattern.compile("[A-Za-z0-9]+");
        Pattern p2 = Pattern.compile("^([0-9]+)$");
        //Matcher m = p.matcher(input);
        Matcher m2 = p2.matcher(input);

        System.out.println(input);

        if (m2.find()){
         System.out.println("cadena valida");
         bandera = 0;
        //System.out.println(subcadena);
        //SucursalesConf.vUsuarioSistem.setText(subcadena);
        subcadena=input;
       }
        else{

         bandera = 1;
         System.out.println("cadena no valida");
         //System.out.println(input.length());

         if(input.length()>0){
         int longitud = input.length()-1;
         // System.out.println(longitud);
         subcadena = input.substring(0, longitud);
         }
         
         //System.out.println(subcadena);
        }

   } // fin de método validarTextNum




} // fin clase Funciones
