package ui.prestamos;

import javax.swing.JOptionPane;

import model.CtaBancaria;

public class SubPantallaPrestamos {
  
    public static void pantallaSubMenuPrestamosSelMonto(){
        final int opcion = Integer.parseInt(JOptionPane.showInputDialog(
            "               PRESTAMOS               \n" +
            "           \n"+
            "        INGRESE EL NRO. DE OPCIÓN      \n"+
            "       PRESTAMO QUE DESEA SOLICITAR   \n"+

            "OPCIÓN        \n"+        "IMPORTE($)         \n"+
            "01=           \n"+        "5000         \n"+
            "OPCIÓN        \n"+           
            "02=           \n"+        "4000         \n"+
            "OPCIÓN        \n"+        
            "03=           \n"+        "3000         \n"+
            "OPCIÓN        \n"+        
            "04=           \n"+        "2000         \n"+
            "OPCIÓN        \n"+        
            "05=           \n"+        "1500         \n"+
            "OPCIÓN        \n"+        
            "06=           \n"+        "1000         \n"+
            "              \n"+        
            "OPCIÓN        \n"+        
            "07=           \n"+        "<-------------MODIFICAR         \n"+
            "OPCIÓN        \n"+        
            "00=           \n"+        "<-------------VOLVER            \n"));
    }
}
    

