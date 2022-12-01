package ui.movimientosConsultas;

import components.Validaciones;
import domain.CtaBancaria;
import domain.Movimiento;
import domain.TitulosPantallas;
import ui.SubMenuPantallaMovCons;

import javax.swing.*;
import java.text.DecimalFormat;
//Clase SubPantallasMovimientosConsultas: esta clase se encargará de contener métodos relacionados a las consultas
//sobre la información de la cuenta bancaria.
public class SubPantallasMovimientosConsultas {

    //generador de numero aleatorio
    private static final double CAMBIO=(Math.random() * (190 - 160)) + 160;
    SubMenuPantallaMovCons pantallaMovCon = new SubMenuPantallaMovCons();
    private Validaciones validaciones = new Validaciones();
    //Método mostrarMovimientos: listará una colección de movimientos que se hayan generado.
    public void mostrarMovimientos(CtaBancaria ctaBancaria) {
        int cont=1;
        String listado= "";
        DecimalFormat df = new DecimalFormat("0.00");
        if(ctaBancaria.getMovimientos()!=null) {
            StringBuilder listadoBuilder = new StringBuilder();
            for (Movimiento movimiento : ctaBancaria.getMovimientos()) {
                listadoBuilder.append("\nN°:")
                        .append(cont)
                        .append(" - FECHA: ")
                        .append(validaciones.formatFecha(movimiento.getFecha()))
                        .append(" - CONCEPTO: ")
                        .append(movimiento.getTipoOperacion()).append(" $ ")
                        .append(df.format(movimiento.getMontoOperacion()));
                cont += 1;
            }
            listado = listadoBuilder.toString();
        }
            JOptionPane.showMessageDialog(null, "                                  ULTIMOS MOVIMIENTOS           \n" +
                            "\n" +
                            "" + ctaBancaria.getTipoCuentaBancaria() + " N°" + ctaBancaria.getNumCta() + "\n" +
                            "\n" +
                            "" + (listado!=null?listado:"NO EXISTEN MOVIMIENTOS") + "\n" +
                            "\n" +
                            "Saldo de la  " + ctaBancaria.getTipoCuentaBancaria() + " N°" + ctaBancaria.getNumCta() + " $" + df.format(ctaBancaria.getSaldo())
                    ,TitulosPantallas.TITULOMOVIMIENTOCONSULTAS.descripcion, JOptionPane.INFORMATION_MESSAGE);

        pantallaMovCon.pantallaSubMenuMovconsultas(ctaBancaria);
    }
    //Método mostrarSaldo: mostrará el saldo actual de la cuenta.
    public void mostrarSaldo(CtaBancaria ctaBancaria) {
        JOptionPane.showMessageDialog(null,"             CONSULTA SALDO CAJA DE AHORRO           \n" +
                "\n" +
                "Saldo de la "+ctaBancaria.getTipoCuentaBancaria()+" N°"+ctaBancaria.getNumCta()+
                " $"+ ctaBancaria.getSaldo()+"\n"+
                "\n", TitulosPantallas.TITULOMOVIMIENTOCONSULTAS.descripcion, JOptionPane.INFORMATION_MESSAGE);
        pantallaMovCon.pantallaSubMenuMovconsultas(ctaBancaria);
    }
    //Método tipoCambio: mostrará el tipo de cambio de USD a ARS; se creará una variable con un valor aleatorio
    //el cual simulará el tipo de cambio de  USD. Tendrá un mínimo y un máximo.
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
                "1 ARS -"+dfUSD.format(1/CAMBIO)+" USD\n", TitulosPantallas.TITULOMOVIMIENTOCONSULTAS.descripcion, JOptionPane.INFORMATION_MESSAGE );
        pantallaMovCon.pantallaSubMenuMovconsultas(cuentaBancaria);

    }
    //Métoso consultaCBU: mostrará el CBU armado en la clase CtaBancaria.
    public void consultaCBU(CtaBancaria cuentaBancaria){
        JOptionPane.showMessageDialog(null,"              CONSULTA CBU            \n" +
                "\n" +
                cuentaBancaria.getTipoCuentaBancaria()+" N° " + cuentaBancaria.getNumCta()+"\n" +
                "\n" +
                "CBU:"+cuentaBancaria.getCBU()+"\n", TitulosPantallas.TITULOMOVIMIENTOCONSULTAS.descripcion, JOptionPane.INFORMATION_MESSAGE);
        pantallaMovCon.pantallaSubMenuMovconsultas(cuentaBancaria);

    }
}