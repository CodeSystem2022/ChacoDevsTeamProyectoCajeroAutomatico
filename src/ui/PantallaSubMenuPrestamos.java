package ui;

import model.CtaBancaria;
import model.TitulosPantallas;
import ui.prestamos.SubPantallaPrestamos;

import javax.swing.*;

import static test.PruebaCajeroAutomatico.menuPantallaPrincipalUI;

public class PantallaSubMenuPrestamos {

    public static void generarPantallaPrestamos(CtaBancaria ctaBancaria){
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                new StringBuilder().append("                   SOLICITUD DE PRESTAMOS               \n")
                        .append("               \n")
                        .append("             POR FAVOR SELECCIONE EL TIPO DE               \n")
                        .append("              OPERACION QUE DESEA EFECTUAR               \n")
                        .append("               \n")
                        .append("               \n")
                        .append("               \n")
                        .append("01<----SOLICITUD DE PRESTAMOS               \n")
                        .append("00<--------------------VOLVER               \n")
                        .toString(), TitulosPantallas.TITULOPRESTAMOS.descripcion,1));
        opcionSeleccion(opcion, ctaBancaria);
    }

    public static void opcionSeleccion(int opcion, CtaBancaria ctaBancaria) {
            switch (opcion) {
                case 1:
                    SubPantallaPrestamos.pantallaSubMenuPrestamosSelMonto(ctaBancaria);
                    break;
                case 0:
                    break;
                default:
                    generarPantallaPrestamos(ctaBancaria);
                    break;
            }
    }

}
