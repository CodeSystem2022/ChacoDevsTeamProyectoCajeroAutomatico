package ui.prestamos;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.Date;

import components.Validaciones;
import model.CtaBancaria;
import model.Movimiento;
import model.TitulosPantallas;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import static test.PruebaCajeroAutomatico.menuPantallaPrincipalUI;

public class Pantallacuota {
    private DecimalFormat df = new DecimalFormat("0.00");
    private Validaciones validaciones = new Validaciones();
    public  void pantallaSeleccionCuota(CtaBancaria ctaBancaria, double monto){
        String opcion="0";
        boolean bandera = false;
        do {
                opcion = JOptionPane.showInputDialog(null,
    
            "                      SOLICITUD DE PRESTAMOS              \n" +
            "           \n"+
            "                    INGRESE EL NRO. DE OPCIÓN      \n"+
            "  LAS CUOTAS DEL PRESTAMO QUE DESEA SOLICITAR    \n"+
            "                                 \n"+
            "OPCIONES        "+  "     CUOTAS      "+       "IMPORTE(*)      "+   "TASA       \n"+
            "OPCIÓN        "+                   
            "1=           "+      "1         "+           df.format(monto*1.13)        +       "         13%        \n"+
            "OPCIÓN        "+           
            "2=           "+      "3         "+           df.format((monto*1.25)/3)        +       "   25%          \n"+
            "OPCIÓN        "+        
            "3=           "+      "6         "+           df.format((monto*1.46)/6)        +           "   46%         \n"+
            "OPCIÓN        "+        
            "4=           "+      "9         "+           df.format((monto*1.65)/9)        +         "    65%        \n"+
            "OPCIÓN        "+        
            "5=           "+      "12        "+           df.format((monto*1.81)/12)        +         "   81%          \n"+
            "OPCIÓN        "+        
            "6=           "+      "15        "+           df.format((monto*1.99)/15)       +          "     99%         \n"+
            "              \n"+
            "OPCIÓN        "+
            "7=           "+        "<-------------MODIFICAR         \n"+
            "OPCIÓN        "+
            "8=           "+        "<------------VOLVER SELECCION MONTO            \n"+
            "OPCIÓN        "+
            "0=           "+        "<-------------VOLVER MENU PRINCIPAL            \n"+
                                     "              \n"+
            "                     IMPORTE PRIMER CUOTA(*)                        ", TitulosPantallas.TITULOPRESTAMOS.descripcion,1);

            opcion=opcion==null?"0":opcion;
            if(validaciones.esUnNumero(opcion) && (Integer.parseInt(opcion) >= 0 && Integer.parseInt(opcion) < 9)) {
                bandera = true;
            }else if(!validaciones.esUnNumero(opcion)){
                showMessageDialog(null, "ERROR, INGRESO INCORRECTO-DEBE INGRESAR UN VALOR NÚMERICO ", TitulosPantallas.TITULOPRESTAMOS.descripcion, ERROR_MESSAGE);
                bandera = false;
            }else if(validaciones.esUnNumero(opcion) && (Integer.parseInt(opcion) > 8 || Integer.parseInt(opcion)<0)) {
                showMessageDialog(null, "ERROR, INGRESO INCORRECTO-DEBE INGRESAR UNA OPCION ENTRE 8 y 0 ",TitulosPantallas.TITULOPRESTAMOS.descripcion, ERROR_MESSAGE);
                bandera = false;
            }
        }while(!bandera);
        opcionSeleccionPrestamos(ctaBancaria, Integer.parseInt(opcion), monto);
            
    }
    public void opcionSeleccionPrestamos(CtaBancaria ctaBancaria, int opcion,double monto){
        SubPantallaPrestamos pantallaPrestamos = new SubPantallaPrestamos();
        DestinoPrestamoSubPantalla pantallaDestinoPrestamos = new DestinoPrestamoSubPantalla();
        Movimiento movimiento = new Movimiento();
        switch (opcion) {
            case 1: movimiento.setFecha(new Date());
                    movimiento.setTipoOperacion("PRESTAMO/PLAN CUOTA 1 -"+df.format(monto*1.13));
                    movimiento.setMontoOperacion(monto);
                    pantallaDestinoPrestamos.destinoPrestamo(movimiento,ctaBancaria);
                break;
            case 2: movimiento.setFecha(new Date());
                    movimiento.setTipoOperacion("PRESTAMO/PLAN CUOTAS 3 -"+df.format((monto*1.25)/3));
                    movimiento.setMontoOperacion(monto);
                    pantallaDestinoPrestamos.destinoPrestamo(movimiento,ctaBancaria);
                break;
            case 3: movimiento.setFecha(new Date());
                    movimiento.setTipoOperacion("PRESTAMO/PLAN CUOTAS 6 -"+df.format((monto*1.46)/6));
                    movimiento.setMontoOperacion(monto);
                    pantallaDestinoPrestamos.destinoPrestamo(movimiento,ctaBancaria);
                break;
            case 4: movimiento.setFecha(new Date());
                    movimiento.setTipoOperacion("PRESTAMO/PLAN CUOTAS 9 -"+df.format((monto*1.65)/9));
                    movimiento.setMontoOperacion(monto);
                    pantallaDestinoPrestamos.destinoPrestamo(movimiento,ctaBancaria);
                break;
            case 5: movimiento.setFecha(new Date());
                    movimiento.setTipoOperacion("PRESTAMO/PLAN CUOTA 12 -"+df.format((monto*1.81)/12));
                    movimiento.setMontoOperacion(monto);
                    pantallaDestinoPrestamos.destinoPrestamo(movimiento,ctaBancaria);
                break;
            case 6: movimiento.setFecha(new Date());
                    movimiento.setTipoOperacion("PRESTAMO/PLAN CUOTA 15 -"+df.format((monto*1.99)/15));
                    movimiento.setMontoOperacion(monto);
                    pantallaDestinoPrestamos.destinoPrestamo(movimiento,ctaBancaria);
                break;
            case 8: pantallaPrestamos.pantallaSubMenuPrestamosSelMonto(ctaBancaria);
                break;
            case 0:
                break;
            default:
                JOptionPane.showMessageDialog(null, "INGRESO ERRONEO",TitulosPantallas.TITULOPRESTAMOS.descripcion, ERROR_MESSAGE);
                break;
        }

    }
    
}