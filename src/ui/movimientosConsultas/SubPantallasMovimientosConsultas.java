package ui.movimientosConsultas;

import model.CtaBancaria;
import model.Movimiento;
import ui.SubMenuPantallaMovCons;

import javax.swing.*;
import java.text.DecimalFormat;

public class SubPantallasMovimientosConsultas {
    //generador de numero aleatorio
    private static final double CAMBIO=(double) (Math.random() * (190 - 160)) + 160;
    SubMenuPantallaMovCons pantallaMovCon = new SubMenuPantallaMovCons();

    public void mostrarMovimientos(CtaBancaria ctaBancaria) {
        int cont=1;
        String listado=new String();
        for(Movimiento movimiento: ctaBancaria.getMovimientos()){
            listado+="\nN°:"+cont+" - FECHA: "+movimiento.getFecha().toInstant().toString() +" - CONCEPTO: "+movimiento.getTipoOperacion()+ " $ "+movimiento.getMontoOperacion()+"";
            cont+=1;}

        JOptionPane.showMessageDialog(null,"                                  ULTIMOS MOVIMIENTOS           \n" +
                        "\n" +
                        ""+ctaBancaria.getTipoCuentaBancaria()+" N°"+ctaBancaria.getNumCta()+"\n"+
                        "\n"+
                        ""+listado+"\n"+
                        "\n"+
                        "Saldo de la  "+ctaBancaria.getTipoCuentaBancaria()+" N°"+ctaBancaria.getNumCta()+" $"+ctaBancaria.getSaldo()
                ,"MOVIMIENTOS/CONSULTAS",1);
        pantallaMovCon.pantallaSubMenuMovconsultas(ctaBancaria);
    }

    public void mostrarSaldo(CtaBancaria ctaBancaria) {
        JOptionPane.showMessageDialog(null,"             CONSULTA SALDO CAJA DE AHORRO           \n" +
                "\n" +
                "Saldo de la "+ctaBancaria.getTipoCuentaBancaria()+" N°"+ctaBancaria.getNumCta()+
                " $"+ ctaBancaria.getSaldo()+"\n"+
                "\n");
        pantallaMovCon.pantallaSubMenuMovconsultas(ctaBancaria);
    }

    public void tipoCambio(CtaBancaria cuentaBancaria) {
       DecimalFormat df = new DecimalFormat("0.00");
       DecimalFormat dfUSD = new DecimalFormat("0.0000");

        JOptionPane.showMessageDialog(null,"              CONSULTA TIPO CAMBIO            \n" +
                "\n" +
                cuentaBancaria.getTipoCuentaBancaria()+" N° " + cuentaBancaria.getNumCta()+"\n" +
                "\n" +
                "El tipo de cambio de ARS a USD es:\n" +
                "\n" +
                "1 USD -"+df.format(CAMBIO)+" ARS\n" +
                "\n" +
                "1 ARS -"+dfUSD.format(1/CAMBIO)+" USD\n" );
        pantallaMovCon.pantallaSubMenuMovconsultas(cuentaBancaria);

    }
    public void consultaCBU(CtaBancaria cuentaBancaria){
        JOptionPane.showMessageDialog(null,"              CONSULTA CBU            \n" +
                "\n" +
                cuentaBancaria.getTipoCuentaBancaria()+" N° " + cuentaBancaria.getNumCta()+"\n" +
                "\n" +
                "CBU:"+cuentaBancaria.getCBU()+"\n");
        pantallaMovCon.pantallaSubMenuMovconsultas(cuentaBancaria);

    }
}