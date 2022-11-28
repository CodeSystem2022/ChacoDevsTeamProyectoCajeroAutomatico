package ui;

import components.Validaciones;
import model.CtaBancaria;
import model.User;
import javax.swing.*;
import java.awt.*;
import model.TitulosPantallas;
/*
 *Clase PantallaLogin: esta clase se encargar de crear la pantalla de logeo en la cual se podra ingresar con un
 * usuario administrador: usuario:admin password:1234, o bien da la posibilidad al usuario a dar de alta su
 * user y password
 */
public class PantallaLogin {
    Validaciones validaciones = new Validaciones();
    public boolean login(CtaBancaria ctaBancaria) {
        JFrame frame;
        JPanel pane;
        JTextField userField;
        JTextField passField;
        JTextField passValidacionField;
        frame = new JFrame("                  BIENVENIDO                  \n \n");
        pane = new JPanel();
        pane.setLayout(new GridLayout(0, 2, 2, 2));

        userField = new JTextField(5);

        passField =  new JPasswordField(10);
        passValidacionField = new JPasswordField(10);

        pane.add(new JLabel("Usuario: "));
        pane.add(userField);

        pane.add(new JLabel("Contraseña: "));
        pane.add(passField);
        //Primera pantalla de loggin con usuario y contraseña
        int option = JOptionPane.showConfirmDialog(frame, pane, TitulosPantallas.TITULOLOGIN.descripcion, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (option == JOptionPane.YES_OPTION) {
            String userInput = userField.getText();
            String passInput = passField.getText();
            if (!userInput.isEmpty() && !passInput.isEmpty()) {
                if ((userInput.toUpperCase().equalsIgnoreCase("Admin") && passInput.equalsIgnoreCase("1234")) ||
                        (userInput.toUpperCase().equalsIgnoreCase(ctaBancaria.getUser().getUsuario()) &&
                                passInput.toUpperCase().equalsIgnoreCase(ctaBancaria.getUser().getContraseña()))) {
                    JOptionPane.showMessageDialog(null, "BIENVENIDO " + (ctaBancaria.getPersona() != null ?
                                    ctaBancaria.getPersona().getNombre() : ctaBancaria.getUser() != null ? ctaBancaria.getUser().getUsuario() : "Invitado"),
                            TitulosPantallas.TITULOLOGIN.descripcion, JOptionPane.INFORMATION_MESSAGE);
                    return true;
                } else {
                    //En caso de suministrar datos erroneos (user y pass) se accede a la siguiente
                    //pantalla donde pregunta al usuario si desea crear su usuario y contraseña
                    String opcion;
                    boolean bandera;
                    //Se crea un bucle de evaluacion de ingreso de opcion
                    do {
                        opcion = JOptionPane.showInputDialog(null,
                                new StringBuilder().append("USUARIO Y CONTRASEÑA NO ENCONTRADO\n")
                                        .append("\n")
                                        .append("DESEA CREAR SU CUENTA?\n")
                                        .append("\n")
                                        .append("1<--------SI          \n")
                                        .append("0<--------VOLVER\n")
                                        .toString(), TitulosPantallas.TITULOLOGIN.descripcion, JOptionPane.QUESTION_MESSAGE);
                        bandera=validaciones.esUnNumero(opcion) && (opcion.equalsIgnoreCase("0") || opcion.equalsIgnoreCase("1"));
                        if(!bandera)
                            JOptionPane.showMessageDialog(null, "INGRESO ERRONEO",TitulosPantallas.TITULOLOGIN.descripcion, JOptionPane.ERROR_MESSAGE);
                    }while(!bandera);
                    if(opcion!=null) {
                        String passValidacionInput = "";
                        passInput="";
                        //Se crea un bucle de evaluacion de ingreso de informacion usuario contraseña y re ingreso de contraseña
                            do {
                                if (opcion.equalsIgnoreCase("1")) {
                                    pane.add(new JLabel("Re-Ingrese su contraseña"));
                                    pane.add(passValidacionField);
                                    userField.setText("");
                                    passField.setText("");
                                    passValidacionField.setText("");
                                    int option2 = JOptionPane.showConfirmDialog(frame, pane, TitulosPantallas.TITULOLOGNUEVACUENTA.descripcion, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                                    if (option2 == JOptionPane.YES_OPTION) {
                                        String userInput2 = userField.getText();
                                        String passInput2 = passField.getText();
                                        passValidacionInput = passValidacionField.getText();
                                        if (!userInput2.isEmpty() && !passInput2.isEmpty() && !passValidacionInput.isEmpty()) {
                                            if (passInput2.toUpperCase().trim().equalsIgnoreCase(passValidacionInput.toUpperCase().trim())) {
                                                ctaBancaria.setUser(new User(userInput2, passInput2));
                                                JOptionPane.showMessageDialog(null, "DEBE VOLVER A LOGEARSE", TitulosPantallas.TITULOLOGIN.descripcion, JOptionPane.INFORMATION_MESSAGE);
                                                return false;
                                            } else {
                                                JOptionPane.showMessageDialog(null, "CONTRASEÑAS DISTINTAS", TitulosPantallas.TITULOLOGIN.descripcion, JOptionPane.ERROR_MESSAGE);
                                            }
                                        } else
                                            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR TODOS LOS CAMPOS", TitulosPantallas.TITULOLOGIN.descripcion, JOptionPane.ERROR_MESSAGE);
                                    } else
                                        return false;
                                }else if(opcion.equalsIgnoreCase("0")){
                                    return false;
                                }else{
                                    JOptionPane.showMessageDialog(null, "INGRESO ERRONEO", TitulosPantallas.TITULOLOGIN.descripcion, JOptionPane.ERROR_MESSAGE);
                                }
                            } while (!passInput.trim().equalsIgnoreCase(passValidacionInput.trim()));
                    }
                    return false;
                }
                }else
                    JOptionPane.showMessageDialog(null, "DEBE COMPLETAR TODOS LOS CAMPOS",TitulosPantallas.TITULOLOGIN.descripcion, JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "ADIOS GRACIAS POR USAR NUESTROS SERVICIOS", TitulosPantallas.TITULOLOGIN.descripcion, JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
    return false;
    }

}
