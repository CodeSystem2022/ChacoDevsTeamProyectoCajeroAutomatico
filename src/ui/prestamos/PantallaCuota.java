package ui.prestamos;

import javax.swing.JOptionPane;

import model.CtaBancaria;
import model.Movimiento;

public class PantallaCuota {
    
    public static void PantallaSeleccionCuota(CtaBancaria ctaBancaria){
        final int opcion = Integer.parseInt(JOptionPane.showInputDialog(
            "                      SOLICITUD DE PRESTAMOS              \n" +
            "           \n"+
            "                    INGRESE EL NRO. DE OPCIÓN      \n"+
            "  LAS CUOTAS DEL PRESTAMO QUE DESEA SOLICITAR    \n"+
            "                                 \n"+
            "OPCIONES        "+  "     CUOTAS      "+       "IMPORTE(*)      "+   "TASA       \n"+
            "OPCIÓN        "+                   
            "01=           "+      "1         "+       "   $5650        "+       "         13%        \n"+
            "OPCIÓN        "+           
            "02=           "+      "3         "+       "   $2083.33        "+    "   25%          \n"+
            "OPCIÓN        "+        
            "03=           "+      "6         "+       "   $1216.66        "+    "   46%         \n"+
            "OPCIÓN        "+        
            "04=           "+      "9         "+       "   $916.66         "+    "    65%        \n"+
            "OPCIÓN        "+        
            "05=           "+      "12        "+       "  $754.16          "+    "   81%          \n"+
            "OPCIÓN        "+        
            "06=           "+      "15        "+       "  $663.33        "+      "     99%         \n"+
            "              \n"+
            "OPCIÓN        "+        
            "07=           "+        "<-------------MODIFICAR         \n"+
            "OPCIÓN        "+        
            "00=           "+        "<-------------VOLVER            \n"+
                                     "              \n"+
            "                     IMPORTE PRIMER CUOTA(*)                        "     ));
    }
}