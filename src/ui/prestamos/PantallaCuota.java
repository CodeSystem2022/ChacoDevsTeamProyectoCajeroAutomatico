package ui.prestamos;

import javax.swing.JOptionPane;
import java.util.Date;
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
            "                     IMPORTE PRIMER CUOTA(*)                        "));

            opcionSeleccionPrestamos(ctaBancaria, opcion);
            
    }
    public static void opcionSeleccionPrestamos(CtaBancaria ctaBancaria, int opcion){
        Movimiento movimiento = new Movimiento();
        switch (opcion) {
            case 1: movimiento.setFecha(new Date());
                    movimiento.setTipoOperacion("PRESTAMO/CUOTA Nº 1");
                    movimiento.setMontoOperacion(5650);
                    ctaBancaria.setMovimiento(movimiento);
                break;
            case 2: movimiento.setFecha(new Date());
                    movimiento.setTipoOperacion("PRESTAMO/CUOTA Nº 2");
                    movimiento.setMontoOperacion(2083);
                    ctaBancaria.setMovimiento(movimiento); 
                break;
            case 3: movimiento.setFecha(new Date());
                    movimiento.setTipoOperacion("PRESTAMO/CUOTA Nº 3");
                    movimiento.setMontoOperacion(1216.66);
                    ctaBancaria.setMovimiento(movimiento);       
                break;
            case 4: movimiento.setFecha(new Date());
                    movimiento.setTipoOperacion("PRESTAMO/CUOTA Nº 4");
                    movimiento.setMontoOperacion(916.66);
                    ctaBancaria.setMovimiento(movimiento);
                break;
            case 5: movimiento.setFecha(new Date());
                    movimiento.setTipoOperacion("PRESTAMO/CUOTA Nº 5");
                    movimiento.setMontoOperacion(754.16);
                    ctaBancaria.setMovimiento(movimiento);
                break;
            case 6: movimiento.setFecha(new Date());
                    movimiento.setTipoOperacion("PRESTAMO/CUOTA Nº 6");
                    movimiento.setMontoOperacion(663.33);
                    ctaBancaria.setMovimiento(movimiento);
                break;

            default: JOptionPane.showMessageDialog(null, "Ingreso erroneo");
                
                    
        }

    }
    
}