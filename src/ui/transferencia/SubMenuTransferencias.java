package ui.transferencia;

import javax.swing.JOptionPane;

import model.*;

import ui.transferencia.SubPantallaTransferencias;

public class SubMenuTransferencias {
    public void pantallaSubmenuTranferencia(CtaBancaria ctaBancaria){
        int opcionTransferencia = Integer.parseInt(JOptionPane.showInputDialog( "                  TRANSFERENCIAS                  \n " +
                            "\n"+
                            "1- Cuotas \n" + "2- Alquiler \n" + "3- Varios \n" + "0- Volver"

        ));
    }
    
} 
