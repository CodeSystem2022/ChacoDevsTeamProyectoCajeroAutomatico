package ui.movimientosConsultas;

import model.Movimientos;
import ui.SubMenuPantallaMovCons;

import javax.swing.*;

public class PantallaMostrarSaldo {

    public void mostrarSaldo(Movimientos movimientos) {
        JOptionPane.showMessageDialog(null,"             CONSULTA SALDO CAJA DE AHORRO           \n" +
                "\n" +
                "Saldo de la "+movimientos.getTipoCuentaBancaria()+" N°"+movimientos.getNumCta()+" $"+ movimientos.getSaldo()+"\n"+
                "\n");
        SubMenuPantallaMovCons.pantallaSubMenuMovconsultas(movimientos);
    }
}
