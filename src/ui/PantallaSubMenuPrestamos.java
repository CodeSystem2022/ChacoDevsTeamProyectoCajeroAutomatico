package ui;

import model.CtaBancaria;
import ui.prestamos.SubPantallaPrestamos;

import javax.swing.*;

public class PantallaSubMenuPrestamos {

    public static void generarPantallaPrestamos(CtaBancaria ctaBancaria){
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                new StringBuilder().append("                   SOLICITUD DE PRESTAMOS               \n")
                        .append("               \n")
                        .append("             POR FAVOR SELECCIONE EL TIPO DE               \n")
                        .append("              OPERACION QUE DESEA EFECTUAR               \n")
                        .append("               \n")
                        .append("               \n")
                        .append("               \n")
                        .append("01<----SOLICITUD DE PRESTAMOS               \n")
                        .append("00<--------------------VOLVER               \n")
                        .toString()));
        opcionSeleccion(opcion, ctaBancaria);
    }

    public static void opcionSeleccion(int opcion, CtaBancaria ctaBancaria){
        while (opcion >= 0 && opcion <= 1){
            switch(opcion) {
                case 0:
                    opcion = -10;
                    break;
                case 1:
                    SubPantallaPrestamos.pantallaSubMenuPrestamosSelMonto(ctaBancaria);
                    break;
            }
        }
    }
}
