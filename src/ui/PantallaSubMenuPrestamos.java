package ui;

import model.CtaBancaria;
import ui.prestamos.SubPantallaPrestamos;

import javax.swing.*;

public class PantallaSubMenuPrestamos {

    public static void generarPantallaPrestamos(CtaBancaria ctaBancaria){
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                "                   SOLICITUD DE PRESTAMOS               \n" +
                "               \n"+
                "             POR FAVOR SELECCIONE EL TIPO DE               \n"+
                "              OPERACION QUE DESEA EFECTUAR               \n"+
                "               \n"+
                "               \n"+
                "               \n"+
                "01<----SOLICITUD DE PRESTAMOS               \n"+
                "00<--------------------VOLVER               \n"));
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
