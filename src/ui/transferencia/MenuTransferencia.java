package ui.transferencia;

import components.Validaciones;
import model.CtaBancaria;
import ui.movimientosConsultas.SubPantallasMovimientosConsultas;

import javax.swing.*;

public class MenuTransferencia {
    public void pantallaSubMenuMovconsultas(CtaBancaria ctaBancaria) {
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(new StringBuilder()
                .append("                   TRANSFERENCIAS/DEPOSITOS              \n")
                .append("                     \n")
                .append("\n").append("         SELECCIONE EL TIPO DE OPERACION    \n")
                .append("1<--------TRANSFERENCIAS          \n")
                .append("0<--------VOLVER                                  ")
                .toString()));
        opcionSeleccion(opcion, ctaBancaria);
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
