package ui;
import javax.swing.JOptionPane;

import components.Validaciones;
import domain.CtaBancaria;
import domain.TitulosPantallas;
import ui.pagosyrecargas.SubPantallaPagos;
import ui.pagosyrecargas.SubPantallaRecarga;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

/*
 *Clase SubMenuPantallaPR: esta clase crea la pantalla principal del submenu pagos y recargas
 */
public class SubMenuPantallaPR {
    private Validaciones validaciones = new Validaciones();
    public void pantallaSubMenuPagosRecargas(CtaBancaria ctaBancaria){
        String opcion="0";
        boolean bandera = false;
        do {
            opcion= JOptionPane.showInputDialog(null,new StringBuilder()
                .append("                   SELECCIONE EL TIPO DE                  \n")
                .append("           OPERACION QUE DESEA EFECTUAR                   \n")
                .append("                                                          \n")
                .append("1<---- PAGOS                        RECARGAS------------>2\n")
                .append("                                                          \n")
                .append("0<---- VOLVER                                             \n")                            
                .toString(), TitulosPantallas.TITULOPAGOSRECARGAS.descripcion,1);
            opcion=opcion==null?"0":opcion;
            if(validaciones.esUnNumero(opcion) && (Integer.parseInt(opcion) >= 0 && Integer.parseInt(opcion) < 3)) {
                bandera = true;
            }else if(!validaciones.esUnNumero(opcion)){
                showMessageDialog(null, "ERROR, INGRESO INCORRECTO-DEBE INGRESAR UN VALOR NÚMERICO ",TitulosPantallas.TITULOPAGOSRECARGAS.descripcion, ERROR_MESSAGE);
                bandera = false;
            }else if(validaciones.esUnNumero(opcion) && (Integer.parseInt(opcion) > 2 || Integer.parseInt(opcion)<0)) {
                showMessageDialog(null, "ERROR, INGRESO INCORRECTO-DEBE INGRESAR UNA OPCION ENTRE 0 o 2 ",TitulosPantallas.TITULOPAGOSRECARGAS.descripcion, ERROR_MESSAGE);
                bandera = false;
            }
        }while(!bandera);
        opcionSeleccion(Integer.parseInt(opcion), ctaBancaria);
    }
    //Metodo de seleccion de opcion de usuario
    public void opcionSeleccion(int opcion, CtaBancaria ctaBancaria) {
        SubPantallaRecarga subPantallaRecarga = new SubPantallaRecarga();
        SubPantallaPagos subpantallaPagos = new SubPantallaPagos();
        Validaciones validaciones = new Validaciones();
        while (validaciones.validaIngMenuPrin(opcion,3)) {
            switch(opcion) {
                case 1:
                    subpantallaPagos.pantallaSubMenuPagos(ctaBancaria);
                    break;
                case 2: 
                    subPantallaRecarga.pantallaSubMenuRecargas(ctaBancaria);
                    break;
                case 0:
                    break;
            }
            opcion=-10;
        }
    }
}

  
