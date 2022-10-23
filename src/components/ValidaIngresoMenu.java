package components;

import javax.swing.*;

public class ValidaIngresoMenu {

    public boolean validaIngMenuPrin(int opcion){
       if(opcion<1||opcion>5) {
           JOptionPane.showMessageDialog(null, "INGRESO ERRONEO");
           return false;
       }else{
          return true;
       }
    }
}
