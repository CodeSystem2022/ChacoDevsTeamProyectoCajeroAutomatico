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












//Se requiere crear la pantalla con la siguiente estructura:
//
//         TRANSFERENCIAS/DEPOSITOS
//Indique la cuenta de origen desde la cual desea transferir
// 01-CA$ 1019584
// 00-VOLVER
//
//Donde 01-CA$ 1019584 debe ser compuesto por el tipo de cuenta (getTipoCuentaBancaria()) del objeto CtaBancaria y su numero tambien compuesto por
//el atributo numero de cuenta  (getNumCta()).

//Este debe ser un metodo VOID y debe recibir como parametro el objeto CtaBancaria y debe estar dentro de un paquete en UI->transferencia