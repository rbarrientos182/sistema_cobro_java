/*
 * Zolbee2App.java
 */

package zolbee2;

import java.awt.Color;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class Zolbee2App extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {

        LeeFichero fichero = new LeeFichero ();
       
        fichero.leerFichero();
        //fichero.obtenerValorBandera();
if (!fichero.vbandera.equals("null"))
{       if(fichero.vbandera.equals("0"))
        {
            //System.out.printf("Entro a cero");
            LoginConf formLoginConf = new LoginConf();
            formLoginConf.setLocationRelativeTo(null);
            formLoginConf.getContentPane().setBackground(Color.decode("#7329ab"));
            formLoginConf.setVisible(true);// Tratando de abrir el formulario paciente
        }

        if(fichero.vbandera.equals("1"))
        {
            //System.out.printf("Entro a uno");
            Login formLogin = new Login();
            formLogin.setLocationRelativeTo(null);
            formLogin.getContentPane().setBackground(Color.decode("#7329ab"));
            formLogin.setVisible(true);// Tratando de abrir el formulario paciente
        }

} // fin de if
        //show(new Menu(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of Zolbee2App
     */
    public static Zolbee2App getApplication() {
        return Application.getInstance(Zolbee2App.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(Zolbee2App.class, args);
    }
}
