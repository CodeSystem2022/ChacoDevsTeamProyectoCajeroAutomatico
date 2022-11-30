package ui.prestamos;

import javax.swing.JOptionPane;

import components.Validaciones;
import model.CtaBancaria;
import model.Movimiento;
import model.TitulosPantallas;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

public class DestinoPrestamoSubPantalla {
    private Validaciones validaciones = new Validaciones();
    private SubPantallaPrestamos pantallaPrestamos = new SubPantallaPrestamos();
    public void destinoPrestamo(Movimiento movimiento, CtaBancaria ctaBancaria){
        String respuesta="0";
        boolean bandera = false;
        do {
            respuesta = JOptionPane.showInputDialog(null,
                    new StringBuilder()
                            .append("                   SOLICITUD DE PRESTAMOS\n")
                            .append("\n")
                            .append("         DECLARO QUE EL PRÉSTAMO SE APLICARA\n")
                            .append(" A LA ADQUISICION DEL BIEN O SERVICIO SELECCIONADO   \n")
                            .append("               (informacion requerida por BCRA)\n")
                            .append("\n")
                            .append("              1 INMUEBLES\n")
                            .append("              2 REFACCIÓN/CONSTRUCCIÓN INMUEBLE\n")
                            .append("              3 AUTOMOTOR USO PERSONAL/FLIAR\n")
                            .append("              4 AUTOMOTORES PARA OTROS USOS\n")
                            .append("              5 ELECTRODOMESTICOS/ARTIC. HOGAR\n")
                            .append("              6 MAQUINAS/EQUIPOS/HERRAMIENTAS\n")
                            .append("              7 TURISMO\n")
                            .append("              8 REFINANCIACIÓN/CANCEL PASIVOS\n")
                            .append("              0 VOLVER MENU PRINCIPAL\n")
                            .append("              9 VOLVER MENU PRESTAMOS\n")
                            .toString(),TitulosPantallas.TITULOPRESTAMOS.descripcion,JOptionPane.INFORMATION_MESSAGE);
            respuesta=respuesta==null?"0":respuesta;
            if(validaciones.esUnNumero(respuesta) && (Integer.parseInt(respuesta) >= 0 && Integer.parseInt(respuesta) < 10)) {
                bandera = true;
            }else if(!validaciones.esUnNumero(respuesta)){
                showMessageDialog(null, "ERROR, INGRESO INCORRECTO-DEBE INGRESAR UN VALOR NÚMERICO ", TitulosPantallas.TITULOPRESTAMOS.descripcion, ERROR_MESSAGE);
                bandera = false;
            }else if(validaciones.esUnNumero(respuesta) && (Integer.parseInt(respuesta) > 8 || Integer.parseInt(respuesta)<0)) {
                showMessageDialog(null, "ERROR, INGRESO INCORRECTO-DEBE INGRESAR UNA OPCION ENTRE 9 y 0 ",TitulosPantallas.TITULOPRESTAMOS.descripcion, ERROR_MESSAGE);
                bandera = false;
            }
        }while(!bandera);
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
            case 8:respuesta = "REFINANCIACIÓN/CANCEL PASIVOS";
                break;
            case 9:respuesta="";
                pantallaPrestamos.pantallaSubMenuPrestamosSelMonto(ctaBancaria);
                break;
            case 0:
                respuesta="";
                break;
        }
        //escribirlo en su propio metodo luego
        if(!respuesta.isEmpty()){
            String mov = movimiento.getTipoOperacion().replace(",", ".");
            System.out.println(mov);
            Integer nroCuotas = Integer.parseInt(mov.substring(20, 22).trim());
            String stringMontoCuota = mov.substring(mov.indexOf("-") + 1);
            double montCuota = Double.parseDouble(stringMontoCuota);
            double montoPrestamo = movimiento.getMontoOperacion();
            double montoPrestConInteres = montCuota * nroCuotas;
            double interesDec = (montoPrestConInteres - montoPrestamo) / montoPrestamo;
            Integer tasaInteres = (int) (interesDec * 100);
            StringBuilder sb = new StringBuilder();
            sb.append("                    SOLICITUD DE PRESTAMOS\n")
                    .append("\n")
                    .append("             UD SOLICITA UN PRÉSTAMO DE: $"+montoPrestamo+("\n"))
                    .append(" DESTINADO PARA: ").append(respuesta).append("\n")
                    .append("        QUE DEBERA CANCELAR EN ").append(nroCuotas).append(" CUOTAS\n")
                    .append("           IMPORTE DE LAS CUOTAS $").append(montCuota).append("\n")
                    .append("                     TASA DE INTERES: ").append(tasaInteres).append("%\n")
                    .append("\n")
                    .append("             VERIFIQUE LAS CONDICIÓNES EN EL\n")
                    .append("           TICKET QUE SE ESTÁ IMPRIMIENDO Y\n")
                    .append("          PRESIONE UNA TECLA PARA CONFIRMAR\n")
                    .append("\n")
                    .append("<01------------SI                                                   NO--------02>");
            Integer confirm = Integer.parseInt(JOptionPane.showInputDialog(null,sb,TitulosPantallas.TITULOPRESTAMOS.descripcion, JOptionPane.INFORMATION_MESSAGE));
            if (confirm == 1) {
                StringBuilder bs = new StringBuilder();
                bs.append("SE ACREDITARA EN LA CAJA DE AHORRO N° ").append(ctaBancaria.getNumCta()).append(" SU PRÉSTAMO DE ").append(movimiento.getMontoOperacion());
                showMessageDialog(null, bs,TitulosPantallas.TITULOPRESTAMOS.descripcion, JOptionPane.INFORMATION_MESSAGE);
                if (ctaBancaria.guardarValidarMovimiento(movimiento))
                    showMessageDialog(null, "SU PRESTAMO HA SIDO ACREDITADO ", TitulosPantallas.TITULOPRESTAMOS.descripcion, JOptionPane.INFORMATION_MESSAGE);
            } else if (confirm == 2) {
                showMessageDialog(null, "EL PRÉSTAMO SE HA RECHAZADO");
            }
        }
    }
}
