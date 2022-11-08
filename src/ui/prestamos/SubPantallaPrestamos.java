package ui.prestamos;

import javax.swing.JOptionPane;

import model.CtaBancaria;

public class SubPantallaPrestamos {
  
    public static void pantallaSubMenuPrestamosSelMonto(CtaBancaria ctabancaria){
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(
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
            "00=           "+        "<-------------VOLVER            \n"));
        procesarMonto(ctabancaria,opcion);
    }
    public static int procesarMonto(CtaBancaria ctaBancaria, int opcion) {
        int monto = 0;
        switch (opcion) {
            case 1:
                monto = 5000;
                break;
            case 2:
                monto = 4000;
                break;
            case 3:
                monto = 3000;
                break;
            case 4:
                monto = 2000;
                break;
            case 5:
                monto = 1500;
                break;
            case 6:
                monto = 1000;
                break;
            case 7:
                monto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el monto de prestamo"));
                break;
            default:
                JOptionPane.showMessageDialog(null,"INGRESO ERRONEO");
                break;
        }
        return monto;
    }
}
    

