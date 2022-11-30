package ui;
import javax.swing.JOptionPane;

import components.Validaciones;
import domain.CtaBancaria;
import domain.TitulosPantallas;
import ui.pagosyrecargas.SubPantallaPagos;
import ui.pagosyrecargas.SubPantallaRecarga;
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
            if(opcion.equals("0")||validaciones.esUnNumero(opcion)) {
                bandera = true;
            }else {
                JOptionPane.showMessageDialog(null, "ERROR, INGRESO INCORRECTO ", TitulosPantallas.TITULOMOVIMIENTOCONSULTAS.descripcion, JOptionPane.ERROR_MESSAGE);
                bandera = false;
            }
        }while(!bandera);
        opcionSeleccion(Integer.parseInt(opcion), ctaBancaria);
    }

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

  
