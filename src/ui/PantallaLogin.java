package ui;

import model.CtaBancaria;
import model.User;

import javax.swing.*;
import java.awt.*;

import model.TitulosPantallas;

public class PantallaLogin {
    public boolean login(CtaBancaria ctaBancaria) {
        JFrame frame;
        JPanel pane;
        JTextField userField;
        JTextField passField;
        JTextField passValidacionField;
        frame = new JFrame("                  BIENVENIDO                  \n " +
                "\n");
        pane = new JPanel();
        pane.setLayout(new GridLayout(0, 2, 2, 2));

        userField = new JTextField(5);
        passField = new JTextField(5);
        passValidacionField = new JTextField(5);

        pane.add(new JLabel("Usuario: "));
        pane.add(userField);

        pane.add(new JLabel("Contraseña: "));
        pane.add(passField);

        int option = JOptionPane.showConfirmDialog(frame, pane, TitulosPantallas.TITULOLOGIN.descripcion, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.YES_OPTION) {
            String userInput = userField.getText();
            String passInput = passField.getText();
            if ((userInput.toUpperCase().equalsIgnoreCase("Admin") && passInput.equalsIgnoreCase("1234"))||
                    (userInput.toUpperCase().equalsIgnoreCase(ctaBancaria.getUser().getUsuario())&&
                            passInput.toUpperCase().equalsIgnoreCase(ctaBancaria.getUser().getContraseña()))) {
                JOptionPane.showMessageDialog(null, "BIENVENIDO "+ctaBancaria.getPersona().getNombre()+","+ctaBancaria.getPersona().getApellido(),TitulosPantallas.TITULOLOGIN.descripcion, JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                String opcion = JOptionPane.showInputDialog(null,
                        new StringBuilder().append("Desea crear su usuario y contraseña (Si-Para continuar/No-Para Salir)?     \n")
                                .toString(), TitulosPantallas.TITULOERROR.descripcion,3);
                if (opcion.toUpperCase().equalsIgnoreCase("SI")) {
                    pane.add(new JLabel("Re-Ingrese su contraseña"));
                    pane.add(passValidacionField);
                    String passValidacionInput=null;
                    do {
                        userField.setText("");
                        passField.setText("");
                        passValidacionField.setText("");
                        int option2 = JOptionPane.showConfirmDialog(frame, pane, TitulosPantallas.TITULOLOGNUEVACUENTA.descripcion,JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                        if (option2 == JOptionPane.YES_OPTION) {
                            String userInput2 = userField.getText();
                            String passInput2 = passField.getText();
                            passValidacionInput = passValidacionField.getText();
                            if (passInput2.toUpperCase().trim().equalsIgnoreCase(passValidacionInput.toUpperCase().trim())) {
                                ctaBancaria.setUser(new User(userInput2, passInput2));
                                JOptionPane.showMessageDialog(null, "Debe volver al loggin principal ",TitulosPantallas.TITULOLOGIN.descripcion, JOptionPane.INFORMATION_MESSAGE);
                                return false;
                            }else {
                                JOptionPane.showMessageDialog(null, "CONTRASEÑAS DISTINTAS");
                            }
                        }else return false;
                    }while(!passInput.equalsIgnoreCase(passValidacionInput));
                    } else return false;
                }
            }else return false;
    return false;
    }

}
