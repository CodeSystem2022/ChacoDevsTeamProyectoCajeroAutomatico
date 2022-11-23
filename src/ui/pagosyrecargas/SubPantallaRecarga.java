package ui.pagosyrecargas;

import model.CtaBancaria;

import java.awt.*;
import java.util.Date;
import javax.swing.*;
import model.Movimiento;
import model.TitulosPantallas;
import ui.SubMenuPantallaPR;


public class SubPantallaRecarga {

    private Movimiento movimiento = new Movimiento();
    private SubMenuPantallaPR subMenuPantallaPR = new SubMenuPantallaPR();
    //Creo las pantallas
    public void pantallaSubMenuRecargas(CtaBancaria ctaBancaria){
        int opcion= Integer.parseInt(JOptionPane.showInputDialog(null,new StringBuilder()
                .append("                   SELECCIONE EL RUBRO                   \n")
                .append("NO RUBRO                                                 \n")
                .append("1-TRANSPORTE PUBLICO                                     \n")
                .append("2-TELEFONIA CELULAR                                      \n")
                .append("0-VOLVER                                                 \n")                         
                .toString(),TitulosPantallas.TITULOPAGOSRECARGAS.descripcion, 1));
            seleccionDeOpcion(ctaBancaria,opcion);
    }
    public void pantallaSubmenuRecargasTelefonia(CtaBancaria ctaBancaria){
        int opcion= Integer.parseInt(JOptionPane.showInputDialog(null,new StringBuilder()
                .append("                   SELECCIONE LA EMPRESA                  \n")
                .append("                     TELEFONIA CELUCAR                    \n")
                .append("NO EMPRESA                                               \n")
                .append("1-PERSONAL                                               \n")
                .append("2-CLARO                                                  \n")
                .append("3-MOVISTAR                                               \n")
                .append("0-VOLVER                                                 \n"),
                TitulosPantallas.TITULOPAGOSRECARGAS.descripcion, 1));
        opcionSeleccionTelefonia(opcion,ctaBancaria);
    }

    //Metodo para guardar el movimiento de transporte
    public void pantallaSubmenuRecargasTransporte(CtaBancaria ctaBancaria){
        int opcion= Integer.parseInt(JOptionPane.showInputDialog(null,new StringBuilder()
                .append("                   SELECCIONE LA OPCION                  \n")
                .append("                                        \n")
                .append("NO EMPRESA                                                \n")
                .append("1-TARJETA SUBE                                           \n")
                .append("0-VOLVER                                                 \n"),
                TitulosPantallas.TITULOPAGOSRECARGAS.descripcion, 1));
    
        if (opcion == 1) {
            if (ctaBancaria.guardarValidarMovimiento(oPaneDosInputs("RECARGA SUBE")))
                JOptionPane.showMessageDialog(null, "SE REALIZÓ LA RECARGA CON ÉXITO",TitulosPantallas.TITULOPAGOSRECARGAS.descripcion, JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "ERROR, LA CUENTA N° "+ctaBancaria.getNumCta()+" NO POSEE SALDO ",TitulosPantallas.TITULOPAGOSRECARGAS.descripcion,JOptionPane.ERROR_MESSAGE);
        } else if(opcion == 0){
            subMenuPantallaPR.pantallaSubMenuPagosRecargas(ctaBancaria);
        } 
    }
    //Metodo de seleccion TRANSPORTE de opcion ingresada
        public void seleccionDeOpcion(CtaBancaria ctaBancaria, int opcion) {

            switch (opcion) {
                case 1: pantallaSubmenuRecargasTransporte(ctaBancaria);
    
                    break;
                case 2: pantallaSubmenuRecargasTelefonia(ctaBancaria);
    
                    break;
                case 0: subMenuPantallaPR.pantallaSubMenuPagosRecargas(ctaBancaria);
    
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "INGRESO ERRONEO",TitulosPantallas.TITULOPAGOSRECARGAS.descripcion,JOptionPane.ERROR_MESSAGE);
                    break;
            }
    }
        //Metodo de seleccion Telefonia de opcion ingresada
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
                    JOptionPane.showMessageDialog(null, "INGRESO ERRONEO",TitulosPantallas.TITULOPAGOSRECARGAS.descripcion,JOptionPane.ERROR_MESSAGE);
                    break;
        }

    }
    //Metodo para guardar el movimiento de telefonia
    public void pantallaSubmenuRecargasTelefonia(String compañia, CtaBancaria ctaBancaria){
        if (ctaBancaria.guardarValidarMovimiento(oPaneDosInputs(compañia)))
        JOptionPane.showMessageDialog(null, "SE REALIZÓ LA RECARGA CON ÉXITO",TitulosPantallas.TITULOPAGOSRECARGAS.descripcion, JOptionPane.INFORMATION_MESSAGE);
        else
        JOptionPane.showMessageDialog(null, "ERROR, LA CUENTA N° "+ctaBancaria.getNumCta()+" NO POSEE SALDO ",TitulosPantallas.TITULOPAGOSRECARGAS.descripcion,JOptionPane.ERROR_MESSAGE);
    }

    //Metodo de creacion de pantalla con 2 inputs
    private Movimiento oPaneDosInputs(String accion) {
        JFrame frame;
        JPanel pane;
        JTextField nroField;
        JTextField montoField;
        frame = new JFrame("         " + TitulosPantallas.TITULOPAGOSRECARGAS.descripcion +
                "\n");
        pane = new JPanel();
        pane.setLayout(new GridLayout(0, 2, 2, 2));

        nroField = new JTextField(5);
        montoField = new JTextField(5);

        pane.add(new JLabel("NUMERO: "));
        pane.add(nroField);

        pane.add(new JLabel("MONTO: "));
        pane.add(montoField);
        boolean bandera =false;
        do {
            int option = JOptionPane.showConfirmDialog(frame, pane, TitulosPantallas.TITULOPAGOSRECARGAS.descripcion, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

            if (option == JOptionPane.YES_OPTION) {
                try {
                    if (!montoField.getText().isEmpty() && !nroField.getText().isEmpty()) {
                        bandera = true;
                        Long nroInput = Long.parseLong(nroField.getText());
                        double montoInput = Double.parseDouble(montoField.getText());
                        movimiento.setFecha(new Date());
                        movimiento.setTipoOperacion(accion + "-Numero-" + nroInput);
                        movimiento.setMontoOperacion(-montoInput);
                        return movimiento;
                    } else
                        bandera = false;
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "ERROR, Ocurrio un error al cargar los datos", TitulosPantallas.TITULOPAGOSRECARGAS.descripcion, JOptionPane.ERROR_MESSAGE);
                    bandera = false;
                }
            }else
                return null;
            JOptionPane.showMessageDialog(null, "ERROR, Debe ingresar el Número y Monto", TitulosPantallas.TITULOPAGOSRECARGAS.descripcion, JOptionPane.ERROR_MESSAGE);
        }while(!bandera);
        return null;
        }
}


