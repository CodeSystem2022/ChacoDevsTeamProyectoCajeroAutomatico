package ui.transferencia;

import javax.swing.*;

import model.*;

import ui.transferencia.SubPantallaTransferencias;

import java.awt.*;
import java.util.Date;

public class SubMenuTransferencias {

    public void pantallaSubmenuTranferencia(CtaBancaria ctaBancaria){
        int opcionTransferencia = Integer.parseInt(JOptionPane.showInputDialog( "                  TRANSFERENCIAS                  \n " +
                            "\n"+
                            "1- Cuotas \n" + "2- Alquiler \n" + "3- Varios \n" + "0- Volver"

        ));
        newPaneDialog(ctaBancaria,opcionTransferencia);
    }

    //METODO CREADO PARA TENER 2 TEXTBOX
    public void newPaneDialog(CtaBancaria ctaBancaria, int opcion) {
        JFrame frame;
        JPanel pane;
        JTextField cbuField;
        JTextField montoField;
        frame = new JFrame("                  TRANSFERENCIAS                  \n "+
                "\n");
        double monto = 0;
        long cbu = 0;
        pane = new JPanel();
        pane.setLayout(new GridLayout(0, 2, 2, 2));

        cbuField = new JTextField(5);
        montoField = new JTextField(5);

        pane.add(new JLabel("Ingrese el numero cbu de destino(10 digitos)"));
        pane.add(cbuField);

        pane.add(new JLabel("Ingrese el monto a Transferir"));
        pane.add(montoField);

        int option = JOptionPane.showConfirmDialog(frame, pane, "Transferencia", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.YES_OPTION) {

            String cbuInput = cbuField.getText();
            String montoInput = montoField.getText();

            try {
                monto = Double.parseDouble(montoInput);
                cbu = Long.parseLong(cbuInput);
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            String armadoMensaje="TRANSFERENCIA-DESTINO: ";
            switch(opcion){
                case 1:armadoMensaje+="Cuotas-";
                    break;
                case 2:armadoMensaje+="Alquiler-";
                    break;
                case 3:armadoMensaje+="Varios-";
                    break;
                default:armadoMensaje+="Otros-";
                    break;
            }
            armadoMensaje+="CBU: "+cbu;

            Movimiento movimiento= new Movimiento();
            movimiento.setFecha(new Date());
            movimiento.setTipoOperacion(armadoMensaje);
            movimiento.setMontoOperacion(-monto);
            ctaBancaria.setMovimiento(movimiento);
        }
    }

} 
