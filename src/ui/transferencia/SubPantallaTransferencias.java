package ui.transferencia;
import javax.swing.JOptionPane;

import components.Validaciones;
import model.CtaBancaria;
import model.TitulosPantallas;

import static javax.swing.JOptionPane.*;

// * La clase SubPantallaTransferencias mostrará la cuenta a la que se transferirá el monto

public class SubPantallaTransferencias {
    private Validaciones validaciones = new Validaciones();
    String opcionTransferencia="0";
    boolean bandera = false;

    // * Llama a la clase CtaBancaria para obtener los atributos getTipoCuentaBancaria y getNumCta
    public void transferencias(CtaBancaria ctaBancaria){
        SubMenuTransferencias subMenuTranferencias = new SubMenuTransferencias();
        do {
            opcionTransferencia = (showInputDialog( "                  TRANSFERENCIAS                   \n " +
                            "\n"+
                            "1-" + ctaBancaria.getTipoCuentaBancaria() +" N°: " + ctaBancaria.getNumCta() + "\n" +
                            "\n"+
                            "0-VOLVER"

        ));
            // * Se corre una pequeña verificación para que el usuario ingrese un numero correcto
            opcionTransferencia=opcionTransferencia==null?"0":opcionTransferencia;
            if((opcionTransferencia.equals("0")||opcionTransferencia.equals("1")) && validaciones.esUnNumero(opcionTransferencia)) {
                bandera = true;
            }else if(!validaciones.esUnNumero(opcionTransferencia)){
                showMessageDialog(null, "ERROR, INGRESO INCORRECTO-DEBE INGRESAR UN VALOR NÚMERICO ",TitulosPantallas.TITULODEPTRANS.descripcion, ERROR_MESSAGE);
                bandera = false;
            }else if(validaciones.esUnNumero(opcionTransferencia) && (Integer.parseInt(opcionTransferencia) > 1 || Integer.parseInt(opcionTransferencia)<0)) {
                showMessageDialog(null, "ERROR, INGRESO INCORRECTO-DEBE INGRESAR UNA OPCION ENTRE 1 o 0 ",TitulosPantallas.TITULODEPTRANS.descripcion, ERROR_MESSAGE);
                 bandera = false;
            }
        }while(!bandera);
    if (Integer.parseInt(opcionTransferencia) == 1)
        subMenuTranferencias.pantallaSubmenuTranferencia(ctaBancaria);
    }
}