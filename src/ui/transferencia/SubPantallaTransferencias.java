package ui.transferencia;
import javax.swing.JOptionPane;
import model.CtaBancaria;

// * La clase SubPantallaTransferencias mostrará la cuenta a la que se transferirá el monto

public class SubPantallaTransferencias {

    // * Llama a la clase CtaBancaria para obtener los atributos getTipoCuentaBancaria y getNumCta
    public void transferencias(CtaBancaria ctaBancaria){
        int opcionTransferencia = Integer.parseInt(JOptionPane.showInputDialog( "                  TRANSFERENCIAS/DEPOSITOS                   \n " +
                            "\n"+
                            "1-" + ctaBancaria.getTipoCuentaBancaria() +" N°: " + ctaBancaria.getNumCta() + "\n" +
                            "0-VOLVER"

        ));


// * Se corre una pequeña verificación para que el usuario ingrese un numero correcto
// * caso contrario le mandará un mensaje de error

    SubMenuTransferencias subMenuTranferencias = new SubMenuTransferencias(); 
    if (opcionTransferencia == 1)
    subMenuTranferencias.pantallaSubmenuTranferencia(ctaBancaria);
        else if (opcionTransferencia > 1 || opcionTransferencia<0)
        JOptionPane.showMessageDialog(null, "Ingreso erroneo");
    }

}