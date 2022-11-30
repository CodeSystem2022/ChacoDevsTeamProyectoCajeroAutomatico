package ui;

import components.Validaciones;
import domain.CtaBancaria;
import domain.TitulosPantallas;
import ui.movimientosConsultas.SubPantallasMovimientosConsultas;

import javax.swing.*;

public class SubMenuPantallaMovCons {
   private Validaciones validaciones = new Validaciones();
    public void pantallaSubMenuMovconsultas(CtaBancaria ctaBancaria){
       String opcion="0";
        boolean bandera = false;
        do {
            opcion = JOptionPane.showInputDialog(null, new StringBuilder()
                    .append("                   SELECCIONE EL TIPO DE               \n")
                    .append("           OPERACION QUE DESEA EFECTUAR              \n")
                    .append("\n").append("         CONSULTA DE      TIPO DE    \n")
                    .append("1<--------SALDOS          CAMBIO------------>2\n")
                    .append("\n").append("3<--CONSULTA CBU      ULTIMOS\n")
                    .append("                                           MOVIMIENTOS------->4\n")
                    .append("0<--------VOLVER                                  ")
                    .toString(), TitulosPantallas.TITULOMOVIMIENTOCONSULTAS.descripcion, 1);;
            opcion=opcion==null?"0":opcion;
            if(opcion.equals("0")||validaciones.esUnNumero(opcion)) {
                bandera = true;
            }else {
                JOptionPane.showMessageDialog(null, "ERROR, INGRESO INCORRECTO ", TitulosPantallas.TITULOMOVIMIENTOCONSULTAS.descripcion, JOptionPane.ERROR_MESSAGE);
                bandera = false;
            }
        }while(!bandera);
        opcionSeleccion(Integer.parseInt(opcion), ctaBancaria);
        }
    public void opcionSeleccion(int opcion, CtaBancaria ctaBancaria) {
        SubPantallasMovimientosConsultas subPantallasMovimientosConsultas = new SubPantallasMovimientosConsultas();

            switch(opcion) {
                case 1:
                    subPantallasMovimientosConsultas.mostrarSaldo(ctaBancaria);
                    break;
                case 2: subPantallasMovimientosConsultas.tipoCambio(ctaBancaria);
                    break;
                case 3: subPantallasMovimientosConsultas.consultaCBU(ctaBancaria);
                    break;
                case 4:
                    subPantallasMovimientosConsultas.mostrarMovimientos(ctaBancaria);
                    break;
                case 0:
                    break;
                default:
                    this.pantallaSubMenuMovconsultas(ctaBancaria);
                    break;
            }
    }

}
