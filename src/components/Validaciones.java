package components;

import model.CtaBancaria;

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
    //TODO
    public boolean validaSaldos(CtaBancaria ctaBancaria){
        if(ctaBancaria.getSaldo()- ctaBancaria.getMovimientos().get(0).getMontoOperacion()<0) {
            return false;
        }else{
            return true;
        }
    }

}
