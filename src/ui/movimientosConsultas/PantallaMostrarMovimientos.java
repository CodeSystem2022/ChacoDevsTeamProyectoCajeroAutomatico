package ui.movimientosConsultas;

import model.CtaBancaria;
import model.Movimiento;
import ui.SubMenuPantallaMovCons;

import javax.swing.*;

public class PantallaMostrarMovimientos {

    public void mostrarMoviemientos(CtaBancaria ctaBancaria) {
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
        SubMenuPantallaMovCons.pantallaSubMenuMovconsultas(ctaBancaria);
    }
}