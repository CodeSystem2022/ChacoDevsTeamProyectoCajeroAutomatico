package ui.extraccionesydepositos;
import components.Validaciones;
import model.CtaBancaria;
import model.Movimiento;
import model.TitulosPantallas;
import ui.DepositoExtracciones;

import javax.swing.*;
import java.lang.reflect.Modifier;
import java.rmi.MarshalledObject;
import java.text.DecimalFormat;
import java.util.Date;

public class Depositos {
    private Validaciones validaciones = new Validaciones();
    private DepositoExtracciones depositoExtracciones = new DepositoExtracciones();
    public void pantallaDepositos(CtaBancaria ctaBancaria) {
        String opcion="0";
        boolean bandera = false;
        do {
            opcion = (JOptionPane.showInputDialog(
                    new StringBuilder().append("                                        MENU DE DEPOSITOS        \n")
                            .append("        SELECCIONE EL MONTO QUE DESEA DEPOSITAR EN SU CUENTA      \n")
                            .append("\n")
                            .append(" 1<-------- 10.000                                         8.000 -------->2 ")
                            .append("        \n")
                            .append(" 3<-------- 6.000                                           4.000 -------->4")
                            .append("        \n")
                            .append(" 5<-------- 2.000                                           1.000 -------->6")
                            .append("        \n")
                            .append(" 0<-------- VOLVER                DIGITE UN MONTO ------->7\n")
                            .append("\n")
                            .toString()));
            opcion=opcion==null?"0":opcion;
            if(opcion.equals("0")||validaciones.esUnNumero(opcion)) {
                bandera = true;
            }else {
                JOptionPane.showMessageDialog(null, "ERROR, INGRESO INCORRECTO ", TitulosPantallas.TITULOMOVIMIENTOCONSULTAS.descripcion, JOptionPane.ERROR_MESSAGE);
                bandera = false;
            }
        }while(!bandera);
        opciones(Integer.parseInt(opcion), ctaBancaria);
    }

    private void opciones(int parseInt, CtaBancaria ctaBancaria) {
        Movimiento movimiento =new Movimiento();

        switch (parseInt) {
            case 1:
                movimiento.setFecha(new Date());
                movimiento.setMontoOperacion(10000);
                movimiento.setTipoOperacion("DEPOSITO");
                ctaBancaria.guardarValidarMovimiento(movimiento);
                mostrarMensajeDeposito(ctaBancaria,10000);
                break;
            case 2:
                movimiento.setFecha(new Date());
                movimiento.setMontoOperacion(8000);
                movimiento.setTipoOperacion("DEPOSITO");
                ctaBancaria.guardarValidarMovimiento(movimiento);
                mostrarMensajeDeposito(ctaBancaria,8000);
                break;
            case 3:
                movimiento.setFecha(new Date());
                movimiento.setMontoOperacion(6000);
                movimiento.setTipoOperacion("DEPOSITO");
                ctaBancaria.guardarValidarMovimiento(movimiento);
                mostrarMensajeDeposito(ctaBancaria,6000);
                break;
            case 4:
                movimiento.setFecha(new Date());
                movimiento.setMontoOperacion(4000);
                movimiento.setTipoOperacion("DEPOSITO");
                ctaBancaria.guardarValidarMovimiento(movimiento);
                mostrarMensajeDeposito(ctaBancaria,4000);
                break;
            case 5:
                movimiento.setFecha(new Date());
                movimiento.setMontoOperacion(2000);
                movimiento.setTipoOperacion("DEPOSITO");
                ctaBancaria.guardarValidarMovimiento(movimiento);
                mostrarMensajeDeposito(ctaBancaria,2000);
                break;
            case 6:
                movimiento.setFecha(new Date());
                movimiento.setMontoOperacion(1000);
                movimiento.setTipoOperacion("DEPOSITO");
                ctaBancaria.guardarValidarMovimiento(movimiento);
                mostrarMensajeDeposito(ctaBancaria,1000);
                break;
                case 7:
                    double monto=ingresoManual();
                    if (monto>0) {
                        movimiento.setFecha(new Date());
                        movimiento.setMontoOperacion(monto);
                        movimiento.setTipoOperacion("DEPOSITO");
                        ctaBancaria.guardarValidarMovimiento(movimiento);
                        mostrarMensajeDeposito(ctaBancaria,monto);
                    }
                break;
            case 0: depositoExtracciones.menuDepoExtrac(ctaBancaria);
                break;

        }

    }
public double ingresoManual(){

    String monto = JOptionPane.showInputDialog(null,
            new StringBuilder().append("INGRESE MONTO A DEPOSITAR")
                    .toString(), TitulosPantallas.TITULODEPTRANS.descripcion,1);
    if (validaciones.esUnNumero(monto))
        return Double.parseDouble(monto);
    else JOptionPane.showMessageDialog(null, "ERROR, INGRESO INCORRECTO ", TitulosPantallas.TITULODEPTRANS.descripcion, JOptionPane.ERROR_MESSAGE);
return 0;

}
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


