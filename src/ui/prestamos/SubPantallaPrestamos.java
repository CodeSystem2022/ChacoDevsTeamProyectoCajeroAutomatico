package ui.prestamos;

import javax.swing.JOptionPane;

import components.Validaciones;
import model.CtaBancaria;
import model.TitulosPantallas;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

//La clase SubPantallaPrestamos al iniciarse mostrará por pantalla el menú con la opción
//para solicitar un prestamo.

public class SubPantallaPrestamos {
    private Validaciones validaciones = new Validaciones();
    public void pantallaSubMenuPrestamosSelMonto(CtaBancaria ctabancaria){
        String opcion="0";
        boolean bandera = false;
        do {
            //Al ingresar el "1" en el menú anterior, se mostrará por pantalla las siguientes opciones a elegir.
        opcion = (JOptionPane.showInputDialog(null,
                new StringBuilder().append("                        PRESTAMOS               \n")
                        .append("           \n")
                        .append("        INGRESE EL NRO. DE OPCIÓN      \n")
                        .append("  PRESTAMO QUE DESEA SOLICITAR   \n")
                        .append("                                  \n")
                        .append("OPCIONES        ")
                        .append("IMPORTE($)   \n")
                        .append("OPCIÓN        ")
                        .append("1=           ").append("5000         \n")
                        .append("OPCIÓN        ")
                        .append("2=           ").append("4000         \n")
                        .append("OPCIÓN        ")
                        .append("3=           ").append("3000         \n")
                        .append("OPCIÓN        ")
                        .append("4=           ").append("2000         \n")
                        .append("OPCIÓN        ")
                        .append("5=           ").append("1500         \n")
                        .append("OPCIÓN        ")
                        .append("6=           ").append("1000         \n")
                        .append("              \n").append("OPCIÓN        ")
                        .append("7=           ").append("<-------------MODIFICAR         \n")
                        .append("OPCIÓN        ")
                        .append("0=           ").append("<-------------VOLVER            \n").toString(), TitulosPantallas.TITULOPRESTAMOS.descripcion,1));
            opcion=opcion==null?"0":opcion;
            if(validaciones.esUnNumero(opcion) && (Integer.parseInt(opcion) >= 0 && Integer.parseInt(opcion) < 8)) {
                bandera = true;
            }else if(!validaciones.esUnNumero(opcion)){
                showMessageDialog(null, "ERROR, INGRESO INCORRECTO-DEBE INGRESAR UN VALOR NÚMERICO ", TitulosPantallas.TITULOPRESTAMOS.descripcion, ERROR_MESSAGE);
                bandera = false;
            }else if(validaciones.esUnNumero(opcion) && (Integer.parseInt(opcion) > 7 || Integer.parseInt(opcion)<0)) {
                showMessageDialog(null, "ERROR, INGRESO INCORRECTO-DEBE INGRESAR UNA OPCION ENTRE 7 y 0 ",TitulosPantallas.TITULOPRESTAMOS.descripcion, ERROR_MESSAGE);
                bandera = false;
            }
        }while(!bandera);

        procesarMonto(ctabancaria,Integer.parseInt(opcion));
    }

    //Al seleccionar un monto determinado, el menú entrará en la siguiente sección donde
    //se redireccionará a la PantallaSeleccionCuota, donde se verá el importe y la tasa de interes.
    public void procesarMonto(CtaBancaria ctaBancaria, int opcion) {
        Pantallacuota pantallaCuota= new Pantallacuota();
        double monto = 0;
        switch (opcion) {
            case 1:
                monto = 5000;
                pantallaCuota.pantallaSeleccionCuota(ctaBancaria,monto);
                break;
            case 2:
                monto = 4000;
                pantallaCuota.pantallaSeleccionCuota(ctaBancaria,monto);
                break;
            case 3:
                monto = 3000;
                pantallaCuota.pantallaSeleccionCuota(ctaBancaria,monto);
                break;
            case 4:
                monto = 2000;
                pantallaCuota.pantallaSeleccionCuota(ctaBancaria,monto);
                break;
            case 5:
                monto = 1500;
                pantallaCuota.pantallaSeleccionCuota(ctaBancaria,monto);
                break;
            case 6:
                monto = 1000;
                pantallaCuota.pantallaSeleccionCuota(ctaBancaria,monto);
                break;
            //Al ingresar el "7", el menú desplegará la opción de ingresar un monto elegido por el usuario.
            case 7:
                monto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el monto de prestamo"));
                pantallaCuota.pantallaSeleccionCuota(ctaBancaria,monto);
                break;
            case 0:
            break;
            //Y si ocurre un error al digitar el monto, o esta fuera del rango que lo permite
            //mostrará el siguiente mensaje.
            default:
                JOptionPane.showMessageDialog(null,"INGRESO ERRONEO", TitulosPantallas.TITULOPRESTAMOS.descripcion, ERROR_MESSAGE);
                break;
        }

    }
}
    

