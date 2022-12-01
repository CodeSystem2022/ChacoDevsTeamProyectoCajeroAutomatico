package ui.extraccionesydepositos;
import components.Validaciones;
import domain.CtaBancaria;
import domain.Movimiento;
import domain.TitulosPantallas;
import ui.DepositoExtracciones;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Date;
/*
 * Clase Depositos: Esta clase se encargara de crear la pantalla del submenu Depositos donde informara los montos
 * disponibles para depositar o la opcion de ingresar manualmente un monto
 */
public class Depositos {
    private Validaciones validaciones = new Validaciones();
    private DepositoExtracciones depositoExtracciones = new DepositoExtracciones();
    private final String DEPOSITO = "DEPOSITO";
    private final String ERROR = "ERROR, INGRESO INCORRECTO";
    public void pantallaDepositos(CtaBancaria ctaBancaria) {
        String opcion="0";
        boolean bandera = false;
        do {
            opcion = (JOptionPane.showInputDialog(
                    new StringBuilder().append("                                        MENU DE DEPOSITOS        \n")
                            .append("        SELECCIONE EL MONTO QUE DESEA DEPOSITAR EN SU CUENTA      \n")
                            .append("\n")
                            .append(" 1<-------- 10.000                                         8.000 -------->2 ")
                            .append("\n")
                            .append(" 3<-------- 6.000                                           4.000 -------->4")
                            .append("\n")
                            .append(" 5<-------- 2.000                                           1.000 -------->6")
                            .append("\n")
                            .append(" 0<-------- VOLVER                DIGITE UN MONTO ------->7\n")
                            .append("\n")
                            .toString()));
            opcion=opcion==null?"0":opcion;
            if(opcion.equals("0")||validaciones.esUnNumero(opcion)) {
                bandera = true;
            }else {
                JOptionPane.showMessageDialog(null, ERROR, TitulosPantallas.TITULOMOVIMIENTOCONSULTAS.descripcion, JOptionPane.ERROR_MESSAGE);
                bandera = false;
            }
        }while(!bandera);
        opciones(Integer.parseInt(opcion), ctaBancaria);
    }
    //Metodo opciones: dependiendo de la opcion ingresada por el usuario se creara un objeto movimiento con los datos
    //de la operacion realiza fecha tipo de operacion monto a depositar
    private void opciones(int parseInt, CtaBancaria ctaBancaria) {
        Movimiento movimiento =new Movimiento();

        switch (parseInt) {
            case 1 -> {
                movimiento.setFecha(new Date());
                movimiento.setMontoOperacion(10000);
                movimiento.setTipoOperacion(DEPOSITO);
                ctaBancaria.guardarValidarMovimiento(movimiento);
                mostrarMensajeDeposito(ctaBancaria, 10000);
            }
            case 2 -> {
                movimiento.setFecha(new Date());
                movimiento.setMontoOperacion(8000);
                movimiento.setTipoOperacion(DEPOSITO);
                ctaBancaria.guardarValidarMovimiento(movimiento);
                mostrarMensajeDeposito(ctaBancaria, 8000);
            }
            case 3 -> {
                movimiento.setFecha(new Date());
                movimiento.setMontoOperacion(6000);
                movimiento.setTipoOperacion(DEPOSITO);
                ctaBancaria.guardarValidarMovimiento(movimiento);
                mostrarMensajeDeposito(ctaBancaria, 6000);
            }
            case 4 -> {
                movimiento.setFecha(new Date());
                movimiento.setMontoOperacion(4000);
                movimiento.setTipoOperacion(DEPOSITO);
                ctaBancaria.guardarValidarMovimiento(movimiento);
                mostrarMensajeDeposito(ctaBancaria, 4000);
            }
            case 5 -> {
                movimiento.setFecha(new Date());
                movimiento.setMontoOperacion(2000);
                movimiento.setTipoOperacion(DEPOSITO);
                ctaBancaria.guardarValidarMovimiento(movimiento);
                mostrarMensajeDeposito(ctaBancaria, 2000);
            }
            case 6 -> {
                movimiento.setFecha(new Date());
                movimiento.setMontoOperacion(1000);
                movimiento.setTipoOperacion(DEPOSITO);
                ctaBancaria.guardarValidarMovimiento(movimiento);
                mostrarMensajeDeposito(ctaBancaria, 1000);
            }
            case 7 -> {
                double monto = ingresoManual();
                if (monto > 0) {
                    movimiento.setFecha(new Date());
                    movimiento.setMontoOperacion(monto);
                    movimiento.setTipoOperacion(DEPOSITO);
                    ctaBancaria.guardarValidarMovimiento(movimiento);
                    mostrarMensajeDeposito(ctaBancaria, monto);
                }
            }
            case 0 -> depositoExtracciones.menuDepoExtrac(ctaBancaria);

            default -> JOptionPane.showMessageDialog(null, ERROR, TitulosPantallas.TITULODEPTRANS.descripcion, JOptionPane.ERROR_MESSAGE);

        }

    }
    //metodo ingresoManual: este metodo solicitara al usuario el ingreso manual del monto a depositar
    public double ingresoManual(){

        String monto = JOptionPane.showInputDialog(null,
                new StringBuilder().append("INGRESE MONTO A DEPOSITAR")
                        .toString(), TitulosPantallas.TITULODEPTRANS.descripcion,1);
        if (validaciones.esUnNumero(monto))
            return Double.parseDouble(monto);
        else JOptionPane.showMessageDialog(null, ERROR, TitulosPantallas.TITULODEPTRANS.descripcion, JOptionPane.ERROR_MESSAGE);
    return 0;

    }
    //metodo mostrarMensajeDeposito: este metodo mostrara un mensaje final informando los datos de la cta bancaria
    // el monto depositado y el saldo de la cuenta
    public void mostrarMensajeDeposito(CtaBancaria ctaBancaria, double monto){
        DecimalFormat df = new DecimalFormat("0.00");
        JOptionPane.showMessageDialog(null,"                    DEPOSITO REALIZADO           \n" +
                "\n" +
                "SE REALIZO EL DEPOSITO DEL MONTO          $"+df.format(monto)+ "\n"+
                "\n"+
                "SALDO DE LA "+ctaBancaria.getTipoCuentaBancaria().toUpperCase()+" N°"+ctaBancaria.getNumCta()+
                " $"+ df.format (ctaBancaria.getSaldo())+"\n"+
                "\n", TitulosPantallas.TITULODEPTRANS.descripcion, JOptionPane.INFORMATION_MESSAGE);
    }
}


