package ui.prestamos;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.Date;
import model.CtaBancaria;
import model.Movimiento;

import static test.PruebaCajeroAutomatico.menuPantallaPrincipalUI;

public class PantallaCuota {
    static DecimalFormat df = new DecimalFormat("0.00");
    public static void PantallaSeleccionCuota(CtaBancaria ctaBancaria,double monto){

        final int opcion = Integer.parseInt(JOptionPane.showInputDialog(
    
            "                      SOLICITUD DE PRESTAMOS              \n" +
            "           \n"+
            "                    INGRESE EL NRO. DE OPCIÓN      \n"+
            "  LAS CUOTAS DEL PRESTAMO QUE DESEA SOLICITAR    \n"+
            "                                 \n"+
            "OPCIONES        "+  "     CUOTAS      "+       "IMPORTE(*)      "+   "TASA       \n"+
            "OPCIÓN        "+                   
            "01=           "+      "1         "+           df.format(monto*1.13)        +       "         13%        \n"+
            "OPCIÓN        "+           
            "02=           "+      "3         "+           df.format((monto*1.25)/3)        +       "   25%          \n"+
            "OPCIÓN        "+        
            "03=           "+      "6         "+           df.format((monto*1.46)/6)        +           "   46%         \n"+
            "OPCIÓN        "+        
            "04=           "+      "9         "+           df.format((monto*1.65)/9)        +         "    65%        \n"+
            "OPCIÓN        "+        
            "05=           "+      "12        "+           df.format((monto*1.81)/12)        +         "   81%          \n"+
            "OPCIÓN        "+        
            "06=           "+      "15        "+           df.format((monto*1.99)/15)       +          "     99%         \n"+
            "              \n"+
            "OPCIÓN        "+
            "07=           "+        "<-------------MODIFICAR         \n"+
            "OPCIÓN        "+        
            "00=           "+        "<-------------VOLVER            \n"+
                                     "              \n"+
            "                     IMPORTE PRIMER CUOTA(*)                        "));


            opcionSeleccionPrestamos(ctaBancaria, opcion, monto);
            
    }
    public static void opcionSeleccionPrestamos(CtaBancaria ctaBancaria, int opcion,double monto){
        Movimiento movimiento = new Movimiento();
        switch (opcion) {
            case 1: movimiento.setFecha(new Date());
                    movimiento.setTipoOperacion("PRESTAMO/PLAN CUOTA 1 -"+df.format(monto*1.13));
                    movimiento.setMontoOperacion(monto);
                    ctaBancaria.setMovimiento(movimiento);
                break;
            case 2: movimiento.setFecha(new Date());
                    movimiento.setTipoOperacion("PRESTAMO/PLAN CUOTAS 3-"+df.format((monto*1.25)/3));
                    movimiento.setMontoOperacion(monto);
                    ctaBancaria.setMovimiento(movimiento); 
                break;
            case 3: movimiento.setFecha(new Date());
                    movimiento.setTipoOperacion("PRESTAMO/PLAN CUOTAS 6-"+df.format((monto*1.46)/6));
                    movimiento.setMontoOperacion(monto);
                    ctaBancaria.setMovimiento(movimiento);       
                break;
            case 4: movimiento.setFecha(new Date());
                    movimiento.setTipoOperacion("PRESTAMO/PLAN CUOTAS 9-"+df.format((monto*1.65)/9));
                    movimiento.setMontoOperacion(monto);
                    ctaBancaria.setMovimiento(movimiento);
                break;
            case 5: movimiento.setFecha(new Date());
                    movimiento.setTipoOperacion("PRESTAMO/PLAN CUOTA 12-"+df.format((monto*1.81)/12));
                    movimiento.setMontoOperacion(monto);
                    ctaBancaria.setMovimiento(movimiento);
                break;
            case 6: movimiento.setFecha(new Date());
                    movimiento.setTipoOperacion("PRESTAMO/PLAN CUOTA 15 -"+df.format((monto*1.99)/15));
                    movimiento.setMontoOperacion(monto);
                    ctaBancaria.setMovimiento(movimiento);
                break;
            case 0:
            break;
            default:
                JOptionPane.showMessageDialog(null, "Ingreso erroneo");
                break;
        }

        DestinoPrestamoSubPantalla.destinoPrestamo(movimiento);

    }
    
}