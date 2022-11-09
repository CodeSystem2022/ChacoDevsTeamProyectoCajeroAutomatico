package ui.transferencia;

import javax.swing.JOptionPane;

import model.CtaBancaria;

public class SubPantallaTransferencias {

    public static void transferencias(CtaBancaria ctaBancaria){
        int OpcionTransferencia = Integer.parseInt(JOptionPane.showInputDialog( "                  TRANSFERENCIAS/DEPOSITOS                   \n " +
                            "\n"+
                            "1-" + ctaBancaria.getTipoCuentaBancaria() +" N°: " + ctaBancaria.getNumCta() + "\n" +
                            "2-VOLVER"

        ));
    }
}