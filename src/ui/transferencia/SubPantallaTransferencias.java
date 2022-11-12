package ui.transferencia;

import javax.swing.JOptionPane;

import components.Validaciones;
import model.CtaBancaria;
import ui.movimientosConsultas.SubPantallasMovimientosConsultas;

public class SubPantallaTransferencias {

    public void transferencias(CtaBancaria ctaBancaria){
        int opcionTransferencia = Integer.parseInt(JOptionPane.showInputDialog( "                  TRANSFERENCIAS/DEPOSITOS                   \n " +
                            "\n"+
                            "1-" + ctaBancaria.getTipoCuentaBancaria() +" N°: " + ctaBancaria.getNumCta() + "\n" +
                            "0-VOLVER"

        ));

    SubMenuTransferencias subMenuTranferencias = new SubMenuTransferencias();
    if (opcionTransferencia == 1)
    subMenuTranferencias.pantallaSubmenuTranferencia(ctaBancaria);
        else if (opcionTransferencia > 1 || opcionTransferencia<0)
        JOptionPane.showMessageDialog(null, "Ingreso erroneo");
    }

}