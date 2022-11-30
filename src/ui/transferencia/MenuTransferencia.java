package ui.transferencia;

import components.Validaciones;
import domain.CtaBancaria;
import domain.TitulosPantallas;

import javax.swing.*;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
/*Menu principal de transferencias,en el cual el usuario visualiza dos opciones:
        La primera opcion permite al usuario ingresar para realizar la transferencia y la segunda
        opc nos devuelve al menu principal*/
public class MenuTransferencia {
    private Validaciones validaciones = new Validaciones();
    public void pantallaSubMenuMovconsultas(CtaBancaria ctaBancaria) {
        String opcion="0";
        boolean bandera = false;
        do {
        opcion = JOptionPane.showInputDialog(null,new StringBuilder()
                .append("                   TRANSFERENCIAS              \n")
                .append("                     \n")
                .append("\n").append(" SELECCIONE EL TIPO DE OPERACION    \n")
                .append("\n").append("1<--------TRANSFERENCIAS          \n")
                .append("0<--------VOLVER                                  ")
                .toString(),TitulosPantallas.TITULODEPTRANS.descripcion, INFORMATION_MESSAGE);
            opcion=opcion==null?"0":opcion;
            if(opcion.equals("0")||validaciones.esUnNumero(opcion)) {
                bandera = true;
            }else {
                JOptionPane.showMessageDialog(null, "ERROR, INGRESO INCORRECTO ", TitulosPantallas.TITULODEPTRANS.descripcion, JOptionPane.ERROR_MESSAGE);
                bandera = false;
            }
        }while(!bandera);
        opcionSeleccion(Integer.parseInt(opcion), ctaBancaria);
    }
//Metodo que llama al menu de transferencia y arroja error si el usuario ingresa otra opcion distinta
    public void opcionSeleccion(int opcion, CtaBancaria ctaBancaria) {
        SubPantallaTransferencias subPantallaTranferencias = new SubPantallaTransferencias();
        switch (opcion) {
            case 1:
                subPantallaTranferencias.transferencias(ctaBancaria);
                break;
            case 0:
                break;
            default:
                JOptionPane.showMessageDialog(null, "ERROR, INGRESO INCORRECTO ", TitulosPantallas.TITULODEPTRANS.descripcion, JOptionPane.ERROR_MESSAGE);
                break;
        }
        }
    }
