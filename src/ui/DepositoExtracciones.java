package ui;

import components.Validaciones;
import domain.CtaBancaria;
import domain.TitulosPantallas;
import ui.extraccionesydepositos.Depositos;
import ui.extraccionesydepositos.Extracciones;

import javax.swing.*;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
/*
 * Clase DepositosExtracciones: esta clase se encargara de crear la pantalla del submenu Depositos y extracciones
 * donde muestra las opciones que podra seleccionar el usuario
 */
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
            if(validaciones.esUnNumero(opcion) && (Integer.parseInt(opcion) >= 0 && Integer.parseInt(opcion) < 3)) {
                bandera = true;
            }else if(!validaciones.esUnNumero(opcion)){
                showMessageDialog(null, "ERROR, INGRESO INCORRECTO-DEBE INGRESAR UN VALOR NÚMERICO ",TitulosPantallas.TITULOPAGOSRECARGAS.descripcion, ERROR_MESSAGE);
                bandera = false;
            }else if(validaciones.esUnNumero(opcion) && (Integer.parseInt(opcion) > 2 || Integer.parseInt(opcion)<0)) {
                showMessageDialog(null, "ERROR, INGRESO INCORRECTO-DEBE INGRESAR UNA OPCION ENTRE 0 o 2 ",TitulosPantallas.TITULOPAGOSRECARGAS.descripcion, ERROR_MESSAGE);
                bandera = false;
            }
        }while(!bandera);
        opciones(Integer.parseInt(opcion), ctaBancaria);
    }
    //Metodo opciones: se encargara de derivar al usuario a las siguientes subpantallas
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