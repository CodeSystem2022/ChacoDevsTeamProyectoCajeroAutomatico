package ui;

import model.CtaBancaria;

import javax.swing.*;


public class DepositoExtracciones {

    public void menuDepoExtrac(CtaBancaria ctaBancaria){

        int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                new StringBuilder().append("        MENU DE DEPOSITOS Y EXTRACCIONES        \n")
                        .append("        SELECCIONE EL TIPO DE OPERACION QUE DESEA EFECTUAR      \n")
                        .append("        ")
                        .append("1<---- EXTRACCION                            DEPOSITO------------>2")
                        .append("        \n")
                        .append("   0<---- VOLVER                                                      ")
                        .toString()));
        Opciones(opcion, ctaBancaria);

    }

    public void Opciones(int opcion, CtaBancaria ctaBancaria) {
        switch (opcion){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
}