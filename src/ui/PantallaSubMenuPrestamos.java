package ui;

import components.Validaciones;
import model.CtaBancaria;
import model.TitulosPantallas;
import ui.prestamos.SubPantallaPrestamos;

import javax.swing.*;

import static test.PruebaCajeroAutomatico.menuPantallaPrincipalUI;

public class PantallaSubMenuPrestamos {
    private Validaciones validaciones = new Validaciones();
    public void generarPantallaPrestamos(CtaBancaria ctaBancaria){
        String opcion="0";
        boolean bandera = false;
        do {
            opcion = JOptionPane.showInputDialog(null,
                new StringBuilder().append("                   SOLICITUD DE PRESTAMOS               \n")
                        .append("               \n")
                        .append("             POR FAVOR SELECCIONE EL TIPO DE               \n")
                        .append("              OPERACION QUE DESEA EFECTUAR               \n")
                        .append("               \n")
                        .append("               \n")
                        .append("               \n")
                        .append("01<----SOLICITUD DE PRESTAMOS               \n")
                        .append("00<--------------------VOLVER               \n")
                        .toString(), TitulosPantallas.TITULOPRESTAMOS.descripcion,1);
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

    public  void opcionSeleccion(int opcion, CtaBancaria ctaBancaria) {
            switch (opcion) {
                case 1:
                    SubPantallaPrestamos.pantallaSubMenuPrestamosSelMonto(ctaBancaria);
                    break;
                case 0:
                    break;
                default:
                    generarPantallaPrestamos(ctaBancaria);
                    break;
            }
    }

}
