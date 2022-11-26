package ui.extraccionesydepositos;
import components.Validaciones;
import model.CtaBancaria;
import model.TitulosPantallas;
import ui.DepositoExtracciones;

import javax.swing.*;
public class Depositos {
    private Validaciones validaciones = new Validaciones();
    private DepositoExtracciones depositoExtracciones = new DepositoExtracciones();
    public void pantallaDepositos(CtaBancaria ctaBancaria) { String opcion="0";
        boolean bandera = false;
        do {

            opcion = (JOptionPane.showInputDialog(
                new StringBuilder().append("        MENU DE DEPOSITOS     \n")
                        .append("         SELECCIONE LA OPCION QUE DESEA REALIZAR      \n")
                        .append("        \n")
                        .append("1<---- INGRESAR DINERO    ")
                        .append("        \n")
                        .append("   0<---- VOLVER       ")
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
        switch (parseInt) {
            case 1:
                break;
            case 0: depositoExtracciones.menuDepoExtrac(ctaBancaria);
                break;
        }
    }

}


