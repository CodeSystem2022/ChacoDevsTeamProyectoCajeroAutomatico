package ui.pagosyrecargas;

import model.CtaBancaria;
import ui.prestamos.PantallaCuota;

import javax.swing.*;

import static test.PruebaCajeroAutomatico.menuPantallaPrincipalUI;

public class SubPantallaPagos {
    public void pantallaSubMenuPagos(CtaBancaria ctabancaria) {
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                "                         INGRESE NRO DE ORDEN               \n" +
                        "           \n" +
                        "NUMERO RUBRO       \n" +

                        "OPCIÓN        " +
                        "01=           " + "SAMEEP         \n" +
                        "OPCIÓN        " +
                        "02=           " + "SECHEEP         \n" +
                        "OPCIÓN        " +
                        "03=           " + "IMPUESTOS MUNICIPALES         \n" +
                        "OPCIÓN        " +
                        "00=           " + "VOLVER          \n"));
        seleccionDeOpcion(ctabancaria, opcion);

    }

    public void seleccionDeOpcion(CtaBancaria ctaBancaria, int opcion) {

        switch (opcion) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 00:

                break;
            default:
                JOptionPane.showMessageDialog(null, "INGRESO ERRONEO");
                break;
        }

    }
}
