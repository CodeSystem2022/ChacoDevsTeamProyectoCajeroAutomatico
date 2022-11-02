package ui.prestamos;

import javax.swing.JOptionPane;

import model.CtaBancaria;

public class PantallaCuota {
    
    public static void PantallaSeleccionCuota(CtaBancaria ctaBancaria){
        final int opcion = Integer.parseInt(JOptionPane.showInputDialog(
            "                      SOLICITUD DE PRESTAMOS              \n" +
            "           \n"+
            "                   INGRESE EL NRO. DE OPCIÓN      \n"+
            "           LAS CUOTAS DEL PRESTAMO QUE DESEA SOLICITAR    \n"+
            "                                 \n"+
            "OPCIONES        "+  "CUOTAS      \n"+       "IMPORTE($)      "+
            "OPCIÓN        "+                   
            "01=           "+      "1         "+       "5000         \n"+
            "OPCIÓN        "+           
            "02=           "+      "3         "+       "4000         \n"+
            "OPCIÓN        "+        
            "03=           "+      "6         "+       "3000         \n"+
            "OPCIÓN        "+        
            "04=           "+      "9         "+       "2000         \n"+
            "OPCIÓN        "+        
            "05=           "+      "12        "+       "1500         \n"+
            "OPCIÓN        "+        
            "06=           "+      "15        "+       "1000         \n"+
            "              \n"+
            "OPCIÓN        "+        
            "07=           "+        "<-------------MODIFICAR         \n"+
            "OPCIÓN        "+        
            "00=           "+        "<-------------VOLVER            \n"));
    }
}
    


















//                      SOLICITUD DE PRESTAMOS

//                   INGRESE EL NRO. DE OPCIÓN DE
//            LAS CUOTAS DEL PRESTAMO QUE DESEA SOLICITAR

//   OPCIÓN       CUOTAS        IMPORTE(*)       TASA
//    01            1           $5650            13%
//    02            3           $2083.33         25%
//    03            6           $1216.66         46%
//    04            9           $916.66          65%
//    05            12          $754.16          81%
//    06            15          $663.33          99%

//                 (*)IMPORTE PRIMER CUOTA 