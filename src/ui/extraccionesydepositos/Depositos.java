package ui.extraccionesydepositos;
import model.CtaBancaria;

import javax.swing.*;
public class Depositos {

    public void PantallaDepositos(CtaBancaria ctaBancaria) {

        int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                new StringBuilder().append("        MENU DE DEPOSITOS     \n")
                        .append("         SELECCIONE LA OPCION QUE DESEA REALIZAR      \n")
                        .append("        \n")
                        .append("1<---- INGRESAR DINERO    ")
                        .append("        \n")
                        .append("   0<---- VOLVER       ")
                        .toString()));

    }
}

