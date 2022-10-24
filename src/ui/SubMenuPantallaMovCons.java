package ui;

import components.Validaciones;
import model.CtaBancaria;
import test.PruebaCajeroAutomatico;
import ui.movimientosConsultas.PantallaMostrarSaldo;
import model.Movimientos;

import javax.swing.*;

import static test.PruebaCajeroAutomatico.menuPantallaPrincipalUI;

public class SubMenuPantallaMovCons {

    public static void pantallaSubMenuMovconsultas(CtaBancaria ctaBancaria){
        int opcion= Integer.parseInt(JOptionPane.showInputDialog("                   SELECCIONE EL TIPO DE               \n" +
                "           OPERACION QUE DESEA EFECTUAR              \n" +
                "\n" +
                "         CONSULTA DE      TIPO DE    \n" +
                "1<--------SALDOS          CAMBIO------------>2\n" +
                "\n" +
                "3<--CONSULTA CBU      ULTIMOS\n" +
                "                                           MOVIMIENTOS------->4\n" +
                "0<--------VOLVER                                  "));
        opcionSeleccion(opcion,ctaBancaria);
    }
    public static  void opcionSeleccion(int opcion, CtaBancaria ctaBancaria) {
        PantallaMostrarSaldo pantallaMostrarSaldo=new PantallaMostrarSaldo();
        Validaciones validaciones = new Validaciones();
        while (validaciones.validaIngMenuPrin(opcion)) {
            switch(opcion) {
                case 1:
                    pantallaMostrarSaldo.mostrarSaldo(ctaBancaria);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    break;
            }
            opcion=-10;
        }
    }

}
