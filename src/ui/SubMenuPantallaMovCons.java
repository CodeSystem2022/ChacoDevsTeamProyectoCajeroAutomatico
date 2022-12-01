package ui;

import components.Validaciones;
import domain.CtaBancaria;
import domain.TitulosPantallas;
import ui.movimientosConsultas.SubPantallasMovimientosConsultas;

import javax.swing.*;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
/*
*Clase SubMenuPantallaMovCons: Esta clase se encargará de crear un menu, para que el usuario
* ingrese una opción para seleccionar un proceso en relación a los datos guardados en la
* cuenta bancaria.
 */
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
            if(validaciones.esUnNumero(opcion) && (Integer.parseInt(opcion) >= 0 && Integer.parseInt(opcion) < 5)) {
                bandera = true;
            }else if(!validaciones.esUnNumero(opcion)){
                showMessageDialog(null, "ERROR, INGRESO INCORRECTO-DEBE INGRESAR UN VALOR NÚMERICO ",TitulosPantallas.TITULOMOVIMIENTOCONSULTAS.descripcion, ERROR_MESSAGE);
                bandera = false;
            }else if(validaciones.esUnNumero(opcion) && (Integer.parseInt(opcion) > 5 || Integer.parseInt(opcion)<0)) {
                showMessageDialog(null, "ERROR, INGRESO INCORRECTO-DEBE INGRESAR UNA OPCION ENTRE 0 o 4 ",TitulosPantallas.TITULOMOVIMIENTOCONSULTAS.descripcion, ERROR_MESSAGE);
                bandera = false;
            }
        }while(!bandera);
        opcionSeleccion(Integer.parseInt(opcion), ctaBancaria);
        }
    //Métoto opcionSeleccion: este método se encargará de derivar al usuario a los diferentes procesos.
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
