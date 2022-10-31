package ui.transferencia;

import javax.swing.JOptionPane;

import model.CtaBancaria;

public class SubPantallaTransferencias {

    public static void transferencias(CtaBancaria ctaBancaria){
        JOptionPane.showInputDialog( "                  TRANSFERENCIAS/DEPOSITOS                   \n " +
                            "\n"+
                            "1-" + ctaBancaria.getTipoCuentaBancaria() +" N°: " + ctaBancaria.getNumCta() + "\n" +
                            "2-VOLVER"

        );
    }
}