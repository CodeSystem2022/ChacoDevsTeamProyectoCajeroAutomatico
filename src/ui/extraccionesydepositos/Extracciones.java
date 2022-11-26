package ui.extraccionesydepositos;

import model.CtaBancaria;

import javax.swing.*;


public class Extracciones {

    public void pantallaExtracciones(CtaBancaria ctaBancaria) {

        int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                new StringBuilder().append("        MENU DE EXTRACCIONES        \n")
                        .append("        SELECCIONE EL MONTO QUE DESEA RETIRAR DE SU CUENTA      \n")
                        .append(" 1<-------- 10.000                                          8.000 -------->2 ")
                        .append("        \n")
                        .append(" 3<-------- 6.000                                           4.000 -------->4")
                        .append("        \n")
                        .append(" 5<-------- 2.000                                    Ingrese un Monto ------->7")
                        .append("        \n")
                        .append(" 0<-------- VOLVER")
                        .toString()));
    }
}


