package ui;

import components.Validaciones;
import domain.CtaBancaria;
import domain.TitulosPantallas;
import ui.prestamos.SubPantallaPrestamos;

import javax.swing.*;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

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
                        .append("1<----SOLICITUD DE PRESTAMOS               \n")
                        .append("0<--------------------VOLVER               \n")
                        .toString(), TitulosPantallas.TITULOPRESTAMOS.descripcion,1);
            opcion=opcion==null?"0":opcion;
            if(validaciones.esUnNumero(opcion) && (Integer.parseInt(opcion) >= 0 && Integer.parseInt(opcion) < 4)) {
                bandera = true;
            }else if(!validaciones.esUnNumero(opcion)){
                showMessageDialog(null, "ERROR, INGRESO INCORRECTO-DEBE INGRESAR UN VALOR NÚMERICO ",TitulosPantallas.TITULOPRESTAMOS.descripcion, ERROR_MESSAGE);
                bandera = false;
            }else if(validaciones.esUnNumero(opcion) && (Integer.parseInt(opcion) > 3 || Integer.parseInt(opcion)<0)) {
                showMessageDialog(null, "ERROR, INGRESO INCORRECTO-DEBE INGRESAR UNA OPCION ENTRE 0 o 1 ",TitulosPantallas.TITULOPRESTAMOS.descripcion, ERROR_MESSAGE);
                bandera = false;
            }
        }while(!bandera);
        opcionSeleccion(Integer.parseInt(opcion), ctaBancaria);
    }

    public  void opcionSeleccion(int opcion, CtaBancaria ctaBancaria) {
        SubPantallaPrestamos subPantallaPrestamos = new SubPantallaPrestamos();
            switch (opcion) {
                case 1:
                    subPantallaPrestamos.pantallaSubMenuPrestamosSelMonto(ctaBancaria);
                    break;
                case 0:
                    break;
                default:
                    generarPantallaPrestamos(ctaBancaria);
                    break;
            }
    }

}
