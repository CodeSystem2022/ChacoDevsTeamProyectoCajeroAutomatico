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
 * Clase Extracciones: Esta clase se encargara de crear la pantalla del submenu Extracciones donde informara los montos
 * disponibles para Extraer o la opcion de ingresar manualmente un monto siempre y cuando tenga saldo disponible
 */
public class Extracciones {
    private Validaciones validaciones = new Validaciones();
    private DepositoExtracciones depositoExtracciones = new DepositoExtracciones();
    private final String ERROR = "ERROR, LA CUENTA N° ";
    public void pantallaExtracciones(CtaBancaria ctaBancaria) {
        String opcion="0";
        boolean bandera = false;
        do {
            opcion = (JOptionPane.showInputDialog(
                    new StringBuilder().append("                                        MENU DE EXTRACCIONES        \n")
                            .append("        SELECCIONE EL MONTO QUE DESEA EXTRAER DE SU CUENTA      \n")
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
                JOptionPane.showMessageDialog(null, "ERROR, INGRESO INCORRECTO ", TitulosPantallas.TITULOMOVIMIENTOCONSULTAS.descripcion, JOptionPane.ERROR_MESSAGE);
                bandera = false;
            }
        }while(!bandera);
        opciones(Integer.parseInt(opcion), ctaBancaria);
    }
    //Metodo opciones: dependiendo de la opcion ingresada por el usuario se creara un objeto movimiento con los datos
    //de la operacion realiza fecha tipo de operacion monto a Extraer
    private void opciones(int parseInt, CtaBancaria ctaBancaria) {
        Movimiento movimiento =new Movimiento();

        switch (parseInt) {
            case 1:
                movimiento.setFecha(new Date());
                movimiento.setMontoOperacion(-10000);
                movimiento.setTipoOperacion("EXTRACCIONES");
                if(ctaBancaria.guardarValidarMovimiento(movimiento))
                    mostrarMensajeExtraccion(ctaBancaria,10000);
                else
                    JOptionPane.showMessageDialog(null, armarMensajeError(ctaBancaria),TitulosPantallas.TITULODEPTRANS.descripcion,JOptionPane.ERROR_MESSAGE);
                break;
            case 2:
                movimiento.setFecha(new Date());
                movimiento.setMontoOperacion(-8000);
                movimiento.setTipoOperacion("EXTRACCIONES");
                if(ctaBancaria.guardarValidarMovimiento(movimiento))
                    mostrarMensajeExtraccion(ctaBancaria,8000);
                else
                    JOptionPane.showMessageDialog(null, armarMensajeError(ctaBancaria),TitulosPantallas.TITULODEPTRANS.descripcion,JOptionPane.ERROR_MESSAGE);
                break;
            case 3:
                movimiento.setFecha(new Date());
                movimiento.setMontoOperacion(-6000);
                movimiento.setTipoOperacion("EXTRACCIONES");
                if(ctaBancaria.guardarValidarMovimiento(movimiento))
                    mostrarMensajeExtraccion(ctaBancaria,6000);
                else
                    JOptionPane.showMessageDialog(null, armarMensajeError(ctaBancaria),TitulosPantallas.TITULODEPTRANS.descripcion,JOptionPane.ERROR_MESSAGE);
                break;
            case 4:
                movimiento.setFecha(new Date());
                movimiento.setMontoOperacion(-4000);
                movimiento.setTipoOperacion("EXTRACCIONES");
                if(ctaBancaria.guardarValidarMovimiento(movimiento))
                    mostrarMensajeExtraccion(ctaBancaria,4000);
                else
                    JOptionPane.showMessageDialog(null, armarMensajeError(ctaBancaria),TitulosPantallas.TITULODEPTRANS.descripcion,JOptionPane.ERROR_MESSAGE);
                break;
            case 5:
                movimiento.setFecha(new Date());
                movimiento.setMontoOperacion(-2000);
                movimiento.setTipoOperacion("EXTRACCIONES");
                if(ctaBancaria.guardarValidarMovimiento(movimiento))
                    mostrarMensajeExtraccion(ctaBancaria,2000);
                else
                    JOptionPane.showMessageDialog(null, armarMensajeError(ctaBancaria),TitulosPantallas.TITULODEPTRANS.descripcion,JOptionPane.ERROR_MESSAGE);
                break;
            case 6:
                movimiento.setFecha(new Date());
                movimiento.setMontoOperacion(-1000);
                movimiento.setTipoOperacion("EXTRACCIONES");
                if(ctaBancaria.guardarValidarMovimiento(movimiento))
                    mostrarMensajeExtraccion(ctaBancaria,1000);
                else
                    JOptionPane.showMessageDialog(null, armarMensajeError(ctaBancaria),TitulosPantallas.TITULODEPTRANS.descripcion,JOptionPane.ERROR_MESSAGE);
                break;
            case 7:
                double monto=ingresoManual();
                if (monto>0) {
                    movimiento.setFecha(new Date());
                    movimiento.setMontoOperacion(-monto);
                    movimiento.setTipoOperacion("EXTRACCIONES");
                    if(ctaBancaria.guardarValidarMovimiento(movimiento))
                        mostrarMensajeExtraccion(ctaBancaria,monto);
                    else
                        JOptionPane.showMessageDialog(null, armarMensajeError(ctaBancaria),TitulosPantallas.TITULODEPTRANS.descripcion,JOptionPane.ERROR_MESSAGE);
                    }
                break;
            case 0: depositoExtracciones.menuDepoExtrac(ctaBancaria);
                break;

        }

    }
    //metodo ingresoManual: este metodo solicitara al usuario el ingreso manual del monto a extraer
    public double ingresoManual() {
        String monto = JOptionPane.showInputDialog(null,
                new StringBuilder().append("INGRESE MONTO A EXTRAER")
                        .toString(), TitulosPantallas.TITULODEPTRANS.descripcion, 1);
        if (validaciones.esUnNumero(monto))
            return Double.parseDouble(monto);
        else
            JOptionPane.showMessageDialog(null, "ERROR, INGRESO INCORRECTO ", TitulosPantallas.TITULODEPTRANS.descripcion, JOptionPane.ERROR_MESSAGE);
        return 0;
    }
    //metodo mostrarMensajeExtraccion: este metodo mostrara un mensaje final informando los datos de la cta bancaria
    // el monto a extraer y el saldo de la cuenta
    public void mostrarMensajeExtraccion(CtaBancaria ctaBancaria, double monto){
        DecimalFormat df = new DecimalFormat("0.00");
        JOptionPane.showMessageDialog(null,"             EXTRACCION REALIZADA           \n" +
                "\n" +
                "SE REALIZO LA EXTRACCION DEL MONTO         $"+df.format(monto)+"\n"+
                "\n"+
                "SALDO DE LA "+ctaBancaria.getTipoCuentaBancaria().toUpperCase()+" N°"+ctaBancaria.getNumCta()+
                " $"+ df.format (ctaBancaria.getSaldo())+"\n"+
                "\n", TitulosPantallas.TITULODEPTRANS.descripcion, JOptionPane.INFORMATION_MESSAGE);
    }
    //metodo armarMensajeError: este metodo se encargara de crear un String que se usara para no repetir tanto codigo
    public String armarMensajeError(CtaBancaria ctaBancaria){
        return "ERROR, LA CUENTA N° "+ctaBancaria.getNumCta()+" NO POSEE SALDO ";
    }
    }


