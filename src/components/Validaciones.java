package components;

import model.Movimientos;

import javax.swing.*;

public class Validaciones {

    public boolean validaIngMenuPrin(int opcion){
       if((opcion<0||opcion>5)&&opcion!=-10) {
           JOptionPane.showMessageDialog(null, "INGRESO ERRONEO");
           return false;
       }else if(opcion==-10) {
           return false;
       }
          else{return true;
       }
    }

    public boolean validaSaldos(Movimientos movimientos){
        if(movimientos.getCtaBancaria().getSaldo()-movimientos.getMontoOperacion()<0) {
            return false;
        }else{
            return true;
        }
    }

}
