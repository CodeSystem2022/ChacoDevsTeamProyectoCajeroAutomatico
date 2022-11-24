package ui.prestamos;

import javax.swing.JOptionPane;

import model.CtaBancaria;
import model.Movimiento;
import model.TitulosPantallas;

public class DestinoPrestamoSubPantalla {
    public static void destinoPrestamo(Movimiento movimiento, CtaBancaria ctaBancaria){
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
                // si la entrada es un caracter y no un numero para que la comprobacion de abajo no se rompa le asignamos
                // el numero 9 que este fuera del rango de las opciones para que no pase la comprobacion y vuelva a pedir
                // el ingreso de una opcion correcta
                respuesta = "9";
            }
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
        //escribirlo en su propio metodo luego
        String mov = movimiento.getTipoOperacion().replace(",", ".");
        System.out.println(mov);
        Integer nroCuotas = Integer.parseInt(mov.substring(20,22).trim());
        String stringMontoCuota = mov.substring(mov.indexOf("-")+1);
        double montCuota = Double.parseDouble(stringMontoCuota);
        double montoPrestamo = movimiento.getMontoOperacion();
        double montoPrestConInteres = montCuota * nroCuotas;
        double interesDec = (montoPrestConInteres - montoPrestamo)/montoPrestamo;
        Integer tasaInteres = (int)(interesDec * 100);
        StringBuilder sb = new StringBuilder();
        sb.append("                    SOLICITUD DE PRESTAMOS\n")
                .append("             UD SOLICITA UN PRÉSTAMO DE:\n")
                .append("                                   $").append(montoPrestamo).append("\n")
                .append("              DESTINADO PARA: ").append(respuesta).append("\n")
                .append("        QUE DEBERA CANCELAR EN ").append(nroCuotas).append(" CUOTAS\n")
                .append("           IMPORTE DE LAS CUOTAS $").append(montCuota).append("\n")
                .append("                     TASA DE INTERES: ").append(tasaInteres).append("%\n")
                .append("\n")
                .append("             VERIFIQUE LAS CONDICIÓNES EN EL\n")
                .append("           TICKET QUE SE ESTÁ IMPRIMIENDO Y\n")
                .append("          PRESIONE UNA TECLA PARA CONFIRMAR\n")
                .append("\n")
                .append("<01------------SI                                                   NO--------02>");
        Integer confirm = Integer.parseInt(JOptionPane.showInputDialog(sb));
        if(confirm == 1){
            StringBuilder bs = new StringBuilder();
            bs.append("SE ACREDITARA EN LA CAJA DE AHORRO N° ").append(ctaBancaria.getNumCta()).append("SU PRÉSTAMO DE ").append(movimiento.getMontoOperacion());
            JOptionPane.showMessageDialog(null, bs);
            if (ctaBancaria.guardarValidarMovimiento(movimiento))
                JOptionPane.showMessageDialog(null, "SU PRESTAMO HA SIDO ACREDITADO", TitulosPantallas.TITULOPRESTAMOS.descripcion, JOptionPane.INFORMATION_MESSAGE);
        }else if(confirm == 2){
            JOptionPane.showMessageDialog(null, "EL PRÉSTAMO SE HA RECHAZADO");
        }
    }
}
