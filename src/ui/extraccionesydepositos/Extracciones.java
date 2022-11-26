package ui.extraccionesydepositos;

import components.Validaciones;
import model.CtaBancaria;
import model.TitulosPantallas;

import javax.swing.*;


public class Extracciones {
    private Validaciones validaciones = new Validaciones();

    public void pantallaExtracciones(CtaBancaria ctaBancaria) {
        String opcion="0";
        boolean bandera = false;
        do {
         opcion = (JOptionPane.showInputDialog(
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

    private void opciones(int parseInt, CtaBancaria ctaBancaria) {
        switch (parseInt){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 0:
                break;
        }
    }
    }


//DepositosExtracciones depositosextracciones = new DepositosExtracciones();
  //case 0:depositosextracciones.menuDepoExtrac(ctaBancaria);
