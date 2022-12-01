package ui;

import components.Validaciones;
import domain.CtaBancaria;
import domain.TitulosPantallas;
import ui.datospersonales.PantallaSubMenuDatPersonales;

import javax.swing.*;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
/*
 * Clase PantallDatosPersonales: Esta clase se encarga de crear la pantalla principal del submenu Datos personales
 * la cual derivara a su posterior edicion/creacion y visualizacion
 */
public class PantallaDatosPersonales {
    private Validaciones validaciones = new Validaciones();
    public void pantallaVerOEditarDatos(CtaBancaria ctaBancaria){
        String opcion="0";
        boolean bandera = false;
        do { opcion = (JOptionPane.showInputDialog(null,
                new StringBuilder().append("                   DATOS PERSONALES               \n")
                        .append("\n")
                        .append("             POR FAVOR SELECCIONE EL TIPO DE               \n")
                        .append("              OPERACION QUE DESEA EFECTUAR               \n")
                        .append("\n")
                        .append("\n")
                        .append("\n")
                        .append("01<----VER DATOS PERSONALES       EDITAR DATOS PERSONALES---->02 \n")
                        .append("00<--------------------VOLVER               \n")
                        .toString(), TitulosPantallas.TITULODATOSPERSONALES.descripcion,1));
            opcion=opcion==null?"0":opcion;
            if(validaciones.esUnNumero(opcion) && (Integer.parseInt(opcion) >= 0 && Integer.parseInt(opcion) < 3)) {
                bandera = true;
            }else if(!validaciones.esUnNumero(opcion)){
                showMessageDialog(null, "ERROR, INGRESO INCORRECTO-DEBE INGRESAR UN VALOR NÚMERICO ",TitulosPantallas.TITULODATOSPERSONALES.descripcion, ERROR_MESSAGE);
                bandera = false;
            }else if(validaciones.esUnNumero(opcion) && (Integer.parseInt(opcion) > 2 || Integer.parseInt(opcion)<0)) {
                showMessageDialog(null, "ERROR, INGRESO INCORRECTO-DEBE INGRESAR UNA OPCION ENTRE 0 o 2",TitulosPantallas.TITULODATOSPERSONALES.descripcion, ERROR_MESSAGE);
                bandera = false;
            }
        }while(!bandera);
        opcionSeleccion(Integer.parseInt(opcion), ctaBancaria);
    }
    //Metodo opcionSeleccion: este metodo se encargara de derivar al usuario a la edicion creacion o ver los datos
    //cargados del usuario
    public static void opcionSeleccion(int opcion, CtaBancaria ctaBancaria) {
        PantallaSubMenuDatPersonales pantallaEditarVerDatos = new PantallaSubMenuDatPersonales();
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
