package ui.prestamos;

import javax.swing.JOptionPane;

import model.CtaBancaria;

public class SubPantallaPrestamos {
  
    public static void pantallaSubMenuPrestamosSelMonto(){
        final int opcion = Integer.parseInt(JOptionPane.showInputDialog(
            "                        PRESTAMOS               \n" +
            "           \n"+
            "        INGRESE EL NRO. DE OPCIÓN      \n"+
            "  PRESTAMO QUE DESEA SOLICITAR   \n"+
            "                                  \n"+
            "OPCIONES        "+        "IMPORTE($)   \n"+
            "OPCIÓN        "+                   
            "01=           "+        "5000         \n"+
            "OPCIÓN        "+           
            "02=           "+        "4000         \n"+
            "OPCIÓN        "+        
            "03=           "+        "3000         \n"+
            "OPCIÓN        "+        
            "04=           "+        "2000         \n"+
            "OPCIÓN        "+        
            "05=           "+        "1500         \n"+
            "OPCIÓN        "+        
            "06=           "+        "1000         \n"+
            "              \n"+
            "OPCIÓN        "+        
            "07=           "+        "<-------------MODIFICAR         \n"+
            "OPCIÓN        "+        
            
    }
}
    

