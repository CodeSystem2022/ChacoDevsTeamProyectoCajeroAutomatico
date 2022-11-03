package ui;

import components.Validaciones;
import model.CtaBancaria;
import ui.movimientosConsultas.SubPantallasMovimientosConsultas;

import javax.swing.*;

public class SubMenuPantallaMovCons {

    public void pantallaSubMenuMovconsultas(CtaBancaria ctaBancaria){
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
    public void opcionSeleccion(int opcion, CtaBancaria ctaBancaria) {
        SubPantallasMovimientosConsultas subPantallasMovimientosConsultas = new SubPantallasMovimientosConsultas();
        Validaciones validaciones = new Validaciones();
        while (validaciones.validaIngMenuPrin(opcion)) {
            switch(opcion) {
                case 1:
                    subPantallasMovimientosConsultas.mostrarSaldo(ctaBancaria);
                    break;
                case 2: subPantallasMovimientosConsultas.tipoCambio(ctaBancaria);
                    break;
                case 3: subPantallasMovimientosConsultas.consultaCBU(ctaBancaria);
                    break;
                case 4:
                    subPantallasMovimientosConsultas.mostrarMovimientos(ctaBancaria);
                    break;
                case 0:
                    break;
            }
            opcion=-10;
        }
    }

}
