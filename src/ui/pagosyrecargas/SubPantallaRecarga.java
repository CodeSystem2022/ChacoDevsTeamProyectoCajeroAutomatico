package ui.pagosyrecargas;

import model.CtaBancaria;
import java.util.Date;
import javax.swing.*;
import model.Movimiento;
import ui.SubMenuPantallaPR;


public class SubPantallaRecarga {
    private static final Long NUMERO_SUBE = 141589L;  
    private static final Long NUMERO_TELEFONO = 140318L;    
    private Movimiento movimiento = new Movimiento();
    private SubMenuPantallaPR subMenuPantallaPR = new SubMenuPantallaPR();
    public void pantallasubmenurecargas(CtaBancaria ctaBancaria){
        int opcion= Integer.parseInt(JOptionPane.showInputDialog(new StringBuilder()
                .append("                   SELECCIONE EL RUBRO                   \n")
                .append("NO RUBRO                                                 \n")
                .append("1-TRANSPORTE PUBLICO                                     \n")
                .append("2-TELEFONIA CELULAR                                      \n")
                .append("0-VOLVER                                                 \n")                         
                .toString()));
            seleccionDeOpcion(ctaBancaria,opcion);
    }
    public void pantallaSubmenuRecargasTelefonia(CtaBancaria ctaBancaria){
        int opcion= Integer.parseInt(JOptionPane.showInputDialog(new StringBuilder()
                .append("                   SELECCIONE LA EMPRESA                  \n")
                .append("                     TELEFONIA CELUCAR                    \n")
                .append("NO EMPRESA                                               \n")
                .append("1-PERSONAL                                               \n")
                .append("2-CLARO                                                  \n")
                .append("3-MOVISTAR                                               \n")
                .append("0-VOLVER                                                 \n")));
        opcionSeleccionTelefonia(opcion,ctaBancaria);
    }  
    public void pantallaSubmenuRecargasTransporte(CtaBancaria ctaBancaria){
        int opcion= Integer.parseInt(JOptionPane.showInputDialog(new StringBuilder()
                .append("                   SELECCIONE LA OPCION                  \n")
                .append("                                        \n")
                .append("NO EMPRESA                                                \n")
                .append("1-TARJETA SUBE                                           \n")
                .append("0-VOLVER                                                 \n")));
    
        if (opcion == 1) { 
            Double monto = Double.parseDouble(JOptionPane.showInputDialog(new StringBuilder()
            .append("                   RECARGA SUBE                           \n")
            .append("                                                          \n")
            .append("NUMERO DE TARJETA " + NUMERO_SUBE + "                         \n")
            .append("                                                          \n")
            .append("Ingrese el monto que desea recargar:                      \n")
            ));
            movimiento.setFecha(new Date());
            movimiento.setTipoOperacion("RECARGA SUBE");
            movimiento.setMontoOperacion(-monto);
            if (ctaBancaria.guardarValidarMovimiento(movimiento))
            JOptionPane.showMessageDialog(null, "SE REALIZÓ LA RECARGA CON ÉXITO AL NUMERO DE TARJETA " + NUMERO_SUBE);
            else
            JOptionPane.showMessageDialog(null, "ERROR, LA CUENTA N° "+ctaBancaria.getNumCta()+" NO POSEE SALDO ");
        } else if(opcion == 0){
            subMenuPantallaPR.pantallaSubMenuPagosRecargas(ctaBancaria);
        } 
    } 
        public void seleccionDeOpcion(CtaBancaria ctaBancaria, int opcion) {

            switch (opcion) {
                case 1: pantallaSubmenuRecargasTransporte(ctaBancaria);
    
                    break;
                case 2: pantallaSubmenuRecargasTelefonia(ctaBancaria);
    
                    break;
                case 0: subMenuPantallaPR.pantallaSubMenuPagosRecargas(ctaBancaria);
    
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "INGRESO ERRONEO");
                    break;
            }

}

        public void opcionSeleccionTelefonia(int opcion,CtaBancaria ctaBancaria) {
            switch (opcion) {
                case 1: pantallaSubmenuRecargasTelefonia("PERSONAL",ctaBancaria);

                    break;
                case 2: pantallaSubmenuRecargasTelefonia("CLARO",ctaBancaria);

                    break;
                case 3: pantallaSubmenuRecargasTelefonia("MOVISTAR",ctaBancaria);

                    break;
                case 0: subMenuPantallaPR.pantallaSubMenuPagosRecargas(ctaBancaria);

                    break;
                default:
                    JOptionPane.showMessageDialog(null, "INGRESO ERRONEO");
                    break;
    }

}   
public void pantallaSubmenuRecargasTelefonia(String compañia, CtaBancaria ctaBancaria){
    Double monto = Double.parseDouble(JOptionPane.showInputDialog(new StringBuilder()
    .append("                   RECARGA                           \n")
    .append("                                                     \n")
    .append("NUMERO DE TELEFONO " + NUMERO_TELEFONO + "               \n")
    .append("COMPAÑIA " + compañia + "               \n")
    .append("                                                     \n")
    .append("Ingrese el monto que desea recargar:                 \n")));
    movimiento.setFecha(new Date());
    movimiento.setTipoOperacion("RECTEL- "+NUMERO_TELEFONO+"-"+compañia);
    movimiento.setMontoOperacion(-monto);
    if (ctaBancaria.guardarValidarMovimiento(movimiento))
    JOptionPane.showMessageDialog(null, "SE REALIZÓ LA RECARGA CON ÉXITO AL NUMERO DE TELEFONO " + NUMERO_TELEFONO);
    else
    JOptionPane.showMessageDialog(null, "ERROR, LA CUENTA N° "+ctaBancaria.getNumCta()+" NO POSEE SALDO ");
}
}


