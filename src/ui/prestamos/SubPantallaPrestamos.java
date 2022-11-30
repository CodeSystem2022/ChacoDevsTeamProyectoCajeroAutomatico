package ui.prestamos;

import javax.swing.JOptionPane;

import model.CtaBancaria;

import static test.PruebaCajeroAutomatico.menuPantallaPrincipalUI;

//La clase SubPantallaPrestamos al iniciarse mostrará por pantalla el menú con la opción
//para solicitar un prestamo.

public class SubPantallaPrestamos {
  
    public static void pantallaSubMenuPrestamosSelMonto(CtaBancaria ctabancaria){
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(

//Al ingresar el "1" en el menú anterior, se mostrará por pantalla las siguientes opciones a elegir.

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

    //Al seleccionar un monto determinado, el menú entrará en la siguiente sección donde
    //se redireccionará a la PantallaSeleccionCuota, donde se verá el importe y la tasa de interes. 

    public static void procesarMonto(CtaBancaria ctaBancaria, int opcion) {
        double monto = 0;
        switch (opcion) {
            case 1:
                monto = 5000;
                PantallaCuota.PantallaSeleccionCuota(ctaBancaria,monto);
                break;
            case 2:
                monto = 4000;
                PantallaCuota.PantallaSeleccionCuota(ctaBancaria,monto);
                break;
            case 3:
                monto = 3000;
                PantallaCuota.PantallaSeleccionCuota(ctaBancaria,monto);
                break;
            case 4:
                monto = 2000;
                PantallaCuota.PantallaSeleccionCuota(ctaBancaria,monto);
                break;
            case 5:
                monto = 1500;
                PantallaCuota.PantallaSeleccionCuota(ctaBancaria,monto);
                break;
            case 6:
                monto = 1000;
                PantallaCuota.PantallaSeleccionCuota(ctaBancaria,monto);
                break;

//Al ingresar el "7", el menú desplegará la opción de ingresar un monto elegido por el usuario.

            case 7:
                monto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el monto de prestamo"));
                PantallaCuota.PantallaSeleccionCuota(ctaBancaria,monto);
                break;
            case 0:menuPantallaPrincipalUI.pantallaPrincipalOpciones();
            break;

//Y si ocurre un error al digitar el monto, o esta fuera del rango que lo permite
//mostrará el siguiente mensaje.

            default:
                JOptionPane.showMessageDialog(null,"INGRESO ERRONEO");
                break;
        }

    }
}
    

