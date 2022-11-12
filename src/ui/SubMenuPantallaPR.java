package ui;
import javax.swing.JOptionPane;

import components.Validaciones;
import model.CtaBancaria;
import ui.pagosyrecargas.SubPantallaPagos;
public class SubMenuPantallaPR {
  
    public void pantallaSubMenuPagosRecargas(CtaBancaria ctaBancaria){
        int opcion= Integer.parseInt(JOptionPane.showInputDialog(new StringBuilder()
                .append("                   SELECCIONE EL TIPO DE                  \n")
                .append("           OPERACION QUE DESEA EFECTUAR                   \n")
                .append("                                                          \n")
                .append("1<---- PAGOS                        RECARGAS------------>2\n")
                .append("                                                          \n")
                .append("0<---- VOLVER                                             \n")                            
                .toString()));
        opcionSeleccion(opcion,ctaBancaria);
    }

  
    public void opcionSeleccion(int opcion, CtaBancaria ctaBancaria) {
        SubPantallaPagos subpantallaPagos = new SubPantallaPagos();
        Validaciones validaciones = new Validaciones();
        while (validaciones.validaIngMenuPrin(opcion,5)) {
            switch(opcion) {
                case 1:
                    subpantallaPagos.pantallaSubMenuPagos(ctaBancaria);
                    break;
                case 2: 
                    break;
                case 0:
                    break;
            }
            opcion=-10;
        }
    }
}

  
