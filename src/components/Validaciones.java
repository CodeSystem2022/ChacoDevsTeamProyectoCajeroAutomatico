package components;

import model.CtaBancaria;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validaciones {

    public boolean validaIngMenuPrin(int opcion,int rangoOpcion){
       if((opcion<0||opcion>rangoOpcion-1)&&opcion!=-10) {
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

    public  boolean esUnNumero(String n){
        try{
            Integer.parseInt(n);
            return true;
        }catch (NumberFormatException nfe){
            return false;
        }
    }

    public String formatFecha(Date date){
        String pattern ="dd/MM/YYYY hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

}
