package ui.prestamos;

import model.CtaBancaria;

import javax.swing.JOptionPane;
import components.Validaciones;

public class DestinoPrestamoSubPantalla {
    public static String destinoPrestamo(CtaBancaria ctaBancaria){
        String respuesta;
        boolean error = false;
        do{
            String mensajeError = "";
            if(error){
                mensajeError = "Ingreso erroneo, debe ingresar una de las opciones listadas";
            }
            error = true;
            respuesta = JOptionPane.showInputDialog(
                    "                   SOLICITUD DE PRESTAMOS\n" +
                            "\n" +
                            "         DECLARO QUE EL PRÉSTAMO SE APLICARA\n" +
                            " A LA ADQUISICION DEL BIEN O SERVICIO SELECCIONADO   \n" +
                            "               (informacion requerida por BCRA)\n" +
                            "\n" +mensajeError+"\n"+
                            "              01 INMUEBLES\n" +
                            "              02 REFACCIÓN/CONSTRUCCIÓN INMUEBLE\n" +
                            "              03 AUTOMOTOR USO PERSONAL/FLIAR\n" +
                            "              04 AUTOMOTORES PARA OTROS USOS\n" +
                            "              05 ELECTRODOMESTICOS/ARTIC. HOGAR\n" +
                            "              06 MAQUINAS/EQUIPOS/HERRAMIENTAS\n" +
                            "              07 TURISMO\n" +
                            "              08 REFINANCIACIÓN/CANCEL PASIVOS\n");
            try{
                Integer.parseInt(respuesta);
            }catch (NumberFormatException nfe){
                // Si la entrada no se puede parsear, por lo tanto no es un numero asi que
                // le asignamos a la fuerza un numero fuera de rango para que la comprobacion no se
                // rompa y vuelva a pedir el ingreso de la opción
                // si la entrada es un caracter y no un numero para que la comprobacion de abajo no se rompa le asignamos
                // el numero 9 que este fuera del rango de las opciones para que no pase la comprobacion y vuelva a pedir
                // el ingreso de una opcion correcta
                respuesta = "9";
            }
            //comprobar que es un numero->true-->seguir  false---no hacer comprobacion de abajo
        }while(Integer.parseInt(respuesta) < 1 || Integer.parseInt(respuesta) > 8);


        int nroOpcion = Integer.parseInt(respuesta);
        switch (nroOpcion){
            case 1:
                respuesta = "INMUEBLES";
                break;
            case 2:
                respuesta = "REFACCIÓN/CONSTRUCCIÓN INMUEBLE";
                break;
            case 3:
                respuesta = "AUTOMOTOR USO PERSONAL/FLIAR";
                break;
            case 4:
                respuesta = "AUTOMOTORES PARA OTROS USOS";
                break;
            case 5:
                respuesta = "ELECTRODOMESTICOS/ARTIC. HOGAR";
                break;
            case 6:
                respuesta = "MAQUINAS/EQUIPOS/HERRAMIENTAS";
                break;
            case 7:
                respuesta = "TURISMO";
                break;
            case 8:
                respuesta = "REFINANCIACIÓN/CANCEL PASIVOS";
                break;
        }
        JOptionPane.showMessageDialog(null, "su respuesta ha sido "+respuesta);
        return respuesta;
    }
}
