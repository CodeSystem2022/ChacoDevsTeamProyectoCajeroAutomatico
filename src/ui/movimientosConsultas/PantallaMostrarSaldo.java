package ui.movimientosConsultas;

import model.CtaBancaria;
import ui.SubMenuPantallaMovCons;

import javax.swing.*;

public class PantallaMostrarSaldo {

    public void mostrarSaldo(CtaBancaria ctaBancaria) {
        SubMenuPantallaMovCons pantallaMovCon = new SubMenuPantallaMovCons();
        JOptionPane.showMessageDialog(null,"             CONSULTA SALDO CAJA DE AHORRO           \n" +
                "\n" +
                "Saldo de la "+ctaBancaria.getTipoCuentaBancaria()+" N°"+ctaBancaria.getNumCta()+
                " $"+ ctaBancaria.getSaldo()+"\n"+
                "\n");
        pantallaMovCon.pantallaSubMenuMovconsultas(ctaBancaria);
    }
}
