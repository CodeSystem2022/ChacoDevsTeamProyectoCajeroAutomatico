package ui;

import components.Validaciones;
import domain.CtaBancaria;
import domain.TitulosPantallas;
import ui.extraccionesydepositos.Depositos;
import ui.extraccionesydepositos.Extracciones;

import javax.swing.*;


public class DepositoExtracciones {
private Validaciones validaciones = new Validaciones();


    public void menuDepoExtrac(CtaBancaria ctaBancaria){
        String opcion="0";
        boolean bandera = false;
        do {

         opcion = (JOptionPane.showInputDialog(null,
                new StringBuilder().append("                        MENU DE DEPOSITOS Y EXTRACCIONES        \n")
                        .append("        SELECCIONE EL TIPO DE OPERACION QUE DESEA EFECTUAR      \n")
                        .append("\n")
                        .append("1<---- EXTRACCION                                              DEPOSITO------------>2")
                        .append("        \n")
                        .append("0<---- VOLVER                                                      ")
                        .toString(), TitulosPantallas.TITULODEPTRANS.descripcion,1));
            opcion=opcion==null?"0":opcion;
            if(opcion.equals("0")||validaciones.esUnNumero(opcion)) {
                bandera = true;
            }else {
                JOptionPane.showMessageDialog(null, "ERROR, INGRESO INCORRECTO ", TitulosPantallas.TITULOMOVIMIENTOCONSULTAS.descripcion, JOptionPane.ERROR_MESSAGE);
                bandera = false;
            }
        }while(!bandera);
        opciones(Integer.parseInt(opcion), ctaBancaria);
    }

    public void opciones(int opcion, CtaBancaria ctaBancaria) {
        Extracciones extracciones = new Extracciones();
        Depositos depositos = new  Depositos();

        switch(opcion) {
            case 1: extracciones.pantallaExtracciones(ctaBancaria);
                break;
            case 2: depositos.pantallaDepositos(ctaBancaria);
                break;
            case 0:
                break;

        }
    }
}