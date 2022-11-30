package ui.transferencia;
import javax.swing.*;

import components.Validaciones;
import domain.*;
import java.awt.*;
import java.util.Date;

import static javax.swing.JOptionPane.*;

/* 
* la clase SubMenuTransferencias es la continuación de SubPantallaTransferencias y mostrará un cuadro de opciones en
* las que el usuario deberá elegir el motivo de la transferencia
*/

public class SubMenuTransferencias {
    private Validaciones validaciones = new Validaciones();
    boolean bandera = false;
    public void pantallaSubmenuTranferencia(CtaBancaria ctaBancaria){
        String opcionTransferencia="0";
        do {
            opcionTransferencia = JOptionPane.showInputDialog(null,new StringBuilder().
                    append("                  TRANSFERENCIAS                  \n \n").
                    append("1- Cuotas \n2- Alquiler \n3- Varios \n0- Volver").
                    toString().toUpperCase(),TitulosPantallas.TITULODEPTRANS.descripcion, INFORMATION_MESSAGE);
            opcionTransferencia=opcionTransferencia==null?"0":opcionTransferencia;
            if(validaciones.esUnNumero(opcionTransferencia) && (Integer.parseInt(opcionTransferencia) >= 0 && Integer.parseInt(opcionTransferencia) < 4)) {
                bandera = true;
            }else if(!validaciones.esUnNumero(opcionTransferencia)){
                showMessageDialog(null, "ERROR, INGRESO INCORRECTO-DEBE INGRESAR UN VALOR NÚMERICO ",TitulosPantallas.TITULODEPTRANS.descripcion, ERROR_MESSAGE);
                bandera = false;
            }else if(validaciones.esUnNumero(opcionTransferencia) && (Integer.parseInt(opcionTransferencia) > 3 || Integer.parseInt(opcionTransferencia)<0)) {
                showMessageDialog(null, "ERROR, INGRESO INCORRECTO-DEBE INGRESAR UNA OPCION ENTRE 0 o 3 ",TitulosPantallas.TITULODEPTRANS.descripcion, ERROR_MESSAGE);
                bandera = false;
            }
        }while(!bandera);
        if(Integer.parseInt(opcionTransferencia)!=0)
            newPaneDialog(ctaBancaria,Integer.parseInt(opcionTransferencia));
    }

    // * Se muestra un cuadro de doble entrada donde se deberá ingresar el CBU de destino y
    // * el monto a transferir
    public void newPaneDialog(CtaBancaria ctaBancaria, int opcion) {
        JFrame frame;
        JPanel pane;
        JTextField cbuField;
        JTextField montoField;
        frame = new JFrame(new StringBuilder().append("                  TRANSFERENCIAS                  \n ")
                .append("\n")
                .toString());
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
        bandera=false;
        //Ingresera a un bucle de validacion de ingreso de datos no nulos
        do {
        int option = JOptionPane.showConfirmDialog(frame, pane, "Transferencia", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.YES_OPTION) {

            String cbuInput = cbuField.getText();
            String montoInput = montoField.getText();

                if (!cbuInput.isEmpty() && !montoInput.isEmpty()) {
                    bandera=true;
                    try {
                        monto = Double.parseDouble(montoInput);
                        cbu = Long.parseLong(cbuInput);
                    } catch (NumberFormatException nfe) {
                        nfe.printStackTrace();
                    }

                    String armadoMensaje = "TRANSFERENCIA-DESTINO: ";
                    switch (opcion) {
                        case 1:
                            armadoMensaje += "Cuotas-";
                            break;
                        case 2:
                            armadoMensaje += "Alquiler-";
                            break;
                        case 3:
                            armadoMensaje += "Varios-";
                            break;
                        default:
                            armadoMensaje += "Otros-";
                            break;
                    }
                    armadoMensaje += "CBU: " + cbu;


                    Movimiento movimiento = new Movimiento();
                    movimiento.setFecha(new Date());
                    movimiento.setTipoOperacion(armadoMensaje);
                    movimiento.setMontoOperacion(-monto);
                    if (ctaBancaria.guardarValidarMovimiento(movimiento))
                        JOptionPane.showMessageDialog(null, "SE REALIZÓ LA TRANSFERENCIA CON ÉXITO AL CBU N° " + cbu);
                    // Si no posee saldo la cuenta informara al usuario
                    else
                        JOptionPane.showMessageDialog(null, "ERROR, LA CUENTA N° " + ctaBancaria.getNumCta() + " NO POSEE SALDO "); // * Si la cuenta no posee el saldo necesario
                    // mandará un mensaje de error si los campos no estan completos
                } else {
                    JOptionPane.showMessageDialog(null, "DEBE COMPLETAR TODOS LOS CAMPOS", TitulosPantallas.TITULODEPTRANS.descripcion, JOptionPane.ERROR_MESSAGE);
                }
            }
        }while(!bandera);
        
    }

}