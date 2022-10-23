package components;

import model.Movimientos;

import javax.swing.*;

public class Validaciones {

    public boolean validaIngMenuPrin(int opcion){
       if(opcion<1||opcion>5) {
           JOptionPane.showMessageDialog(null, "INGRESO ERRONEO");
           return false;
       }else{
          return true;
       }
    }

    public boolean validaSaldos(Movimientos movimientos){
        if(movimientos.getSaldo()-movimientos.getMontoOperacion()<0) {
            return false;
        }else{
            return true;
        }
    }

}
