package ui;

import model.CtaBancaria;

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
    }

}
