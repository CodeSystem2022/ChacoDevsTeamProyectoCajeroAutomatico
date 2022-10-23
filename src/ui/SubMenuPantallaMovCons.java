package ui;

import model.CtaBancaria;

import javax.swing.*;

public class SubMenuPantallaMovCons {

    public static int pantallaSubMenuMovconsultas(CtaBancaria ctaBancaria){
        return Integer.parseInt(JOptionPane.showInputDialog("                   SELECCIONE EL TIPO DE               \n" +
                "           OPERACION QUE DESEA EFECTUAR              \n" +
                "\n" +
                "         CONSULTA DE      TIPO DE    \n" +
                "1<--------SALDOS                                                 CAMBIO------------>2\n" +
                "\n" +
                "3<--CONSULTA CBU      ULTIMOS\n" +
                "                      MOVIMIENTOS------->4\n" +
                "0<--------VOLVER                                  "));
    }


}
