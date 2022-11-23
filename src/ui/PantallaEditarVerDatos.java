package ui;

import model.CtaBancaria;
import model.TitulosPantallas;
import ui.editardatos.PantallaSubMenuEdDatPersonal;
import ui.prestamos.SubPantallaPrestamos;

import javax.swing.*;

public class PantallaEditarVerDatos {
    public void pantallaVerOEditarDatos(CtaBancaria ctaBancaria){
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                new StringBuilder().append("                   DATOS PERSONALES               \n")
                        .append("\n")
                        .append("             POR FAVOR SELECCIONE EL TIPO DE               \n")
                        .append("              OPERACION QUE DESEA EFECTUAR               \n")
                        .append("\n")
                        .append("\n")
                        .append("\n")
                        .append("01<----VER DATOS PERSONALES       EDITAR DATOS PERSONALES---->02 \n")
                        .append("00<--------------------VOLVER               \n")
                        .toString(), TitulosPantallas.TITULOPRESTAMOS.descripcion,1));
        opcionSeleccion(opcion, ctaBancaria);
    }
    public static void opcionSeleccion(int opcion, CtaBancaria ctaBancaria) {
        PantallaSubMenuEdDatPersonal pantallaEditarVerDatos = new PantallaSubMenuEdDatPersonal();
        switch (opcion) {
            case 1:
                pantallaEditarVerDatos.verDatos(ctaBancaria);
                break;
            case 2:
                pantallaEditarVerDatos.editarDatos(ctaBancaria);
                break;
            case 0:
                break;
            default:
                break;
        }
    }

}
