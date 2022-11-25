package ui.transferencia;

import components.Validaciones;
import model.CtaBancaria;
import model.TitulosPantallas;
import ui.movimientosConsultas.SubPantallasMovimientosConsultas;

import javax.swing.*;

public class MenuTransferencia {
    private Validaciones validaciones = new Validaciones();
    public void pantallaSubMenuMovconsultas(CtaBancaria ctaBancaria) {
        String opcion="0";
        boolean bandera = false;
        do {
        opcion = (JOptionPane.showInputDialog(new StringBuilder()
                .append("                   TRANSFERENCIAS/DEPOSITOS              \n")
                .append("                     \n")
                .append("\n").append("         SELECCIONE EL TIPO DE OPERACION    \n")
                .append("1<--------TRANSFERENCIAS          \n")
                .append("0<--------VOLVER                                  ")
                .toString()));
            opcion=opcion==null?"0":opcion;
            if(opcion.equals("0")||validaciones.esUnNumero(opcion)) {
                bandera = true;
            }else {
                JOptionPane.showMessageDialog(null, "ERROR, INGRESO INCORRECTO ", TitulosPantallas.TITULOMOVIMIENTOCONSULTAS.descripcion, JOptionPane.ERROR_MESSAGE);
                bandera = false;
            }
        }while(!bandera);
        opcionSeleccion(Integer.parseInt(opcion), ctaBancaria);
    }

    public void opcionSeleccion(int opcion, CtaBancaria ctaBancaria) {
        SubPantallaTransferencias subPantallaTranferencias = new SubPantallaTransferencias();
        switch (opcion) {
            case 1:
                subPantallaTranferencias.transferencias(ctaBancaria);
                break;
            case 0:
                break;
            default:
                JOptionPane.showMessageDialog(null, "Ingreso erroneo");
                break;
        }
        }
    }
