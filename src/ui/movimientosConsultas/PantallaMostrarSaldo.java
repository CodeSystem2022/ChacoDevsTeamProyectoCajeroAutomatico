package ui.movimientosConsultas;

import model.CtaBancaria;
import model.Movimientos;
import ui.SubMenuPantallaMovCons;

import javax.swing.*;

public class PantallaMostrarSaldo {

    public void mostrarSaldo(CtaBancaria ctaBancaria) {
        JOptionPane.showMessageDialog(null,"             CONSULTA SALDO CAJA DE AHORRO           \n" +
                "\n" +
                "Saldo de la "+ctaBancaria.getTipoCuentaBancaria()+" N°"+ctaBancaria.getNumCta()+
                " $"+ ctaBancaria.getSaldo()+"\n"+
                "\n");
        SubMenuPantallaMovCons.pantallaSubMenuMovconsultas(ctaBancaria);
    }
}
