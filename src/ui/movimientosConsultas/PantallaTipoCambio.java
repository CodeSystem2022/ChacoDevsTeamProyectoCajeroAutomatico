package ui.movimientosConsultas;

import model.CtaBancaria;

import javax.swing.*;
import java.text.DecimalFormat;


public class PantallaTipoCambio {
    //generador de numero aleatorio
    private static final double CAMBIO=(double) (Math.random() * (190 - 160)) + 160;;
    private DecimalFormat df = new DecimalFormat("0.00");
    private DecimalFormat dfUSD = new DecimalFormat("0.0000");
    public void tipoCambio(CtaBancaria cuentaBancaria) {


        JOptionPane.showMessageDialog(null,"              CONSULTA TIPO CAMBIO            \n" +
                "\n" +
                cuentaBancaria.getTipoCuentaBancaria()+" N° " + cuentaBancaria.getNumCta()+"\n" +
                "\n" +
                "El tipo de cambio de ARS a USD es:\n" +
                "\n" +
                "1 USD -"+df.format(CAMBIO)+" ARS\n" +
                "\n" +
                "1 ARS -"+dfUSD.format(1/CAMBIO)+" USD\n" );

    }
}
