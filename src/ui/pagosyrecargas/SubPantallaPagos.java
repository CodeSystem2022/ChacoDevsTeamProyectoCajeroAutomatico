package ui.pagosyrecargas;

import components.Validaciones;
import model.CtaBancaria;
import model.Movimiento;
import model.TitulosPantallas;
import ui.SubMenuPantallaPR;
import ui.prestamos.PantallaCuota;

import javax.swing.*;

import java.util.Date;

import static test.PruebaCajeroAutomatico.menuPantallaPrincipalUI;

public class SubPantallaPagos {
    private SubMenuPantallaPR subMenuPantallaPR = new SubMenuPantallaPR();
    private Validaciones validaciones = new Validaciones();
    //Creamos variables constantes con valores aleatorios para cada pago de servicio
    private static final double MONTO_SAMEEP=(double) (Math.random() * (1500 - 1000)) + 1000;
    private static final double MONTO_SECHEEP=(double) (Math.random() * (8000 - 3000)) + 3000;
    private static final double MONTO_IMPUESTOS_MUN=(double) (Math.random() * (1500 - 100)) + 100;
    //Creamos metodos para generar la pantalla
    public void pantallaSubMenuPagos(CtaBancaria ctabancaria) {
        String opcion="0";
        boolean bandera = false;
        do {
            opcion = JOptionPane.showInputDialog(
                new StringBuilder().append("                         INGRESE NRO DE ORDEN               \n")
                        .append("           \n")
                        .append("NUMERO RUBRO       \n")
                        .append("OPCIÓN        ")
                        .append("01=           ").append("SAMEEP         \n")
                        .append("OPCIÓN        ")
                        .append("02=           ").append("SECHEEP         \n")
                        .append("OPCIÓN        ")
                        .append("03=           ").append("IMPUESTOS MUNICIPALES         \n")
                        .append("OPCIÓN        ")
                        .append("00=           ").append("VOLVER          \n").toString());
            opcion=opcion==null?"0":opcion;
            if(opcion.equals("0")||validaciones.esUnNumero(opcion)) {
                bandera = true;
            }else {
                JOptionPane.showMessageDialog(null, "ERROR, INGRESO INCORRECTO ", TitulosPantallas.TITULOMOVIMIENTOCONSULTAS.descripcion, JOptionPane.ERROR_MESSAGE);
                bandera = false;
            }
        }while(!bandera);
        seleccionDeOpcion(ctabancaria,Integer.parseInt(opcion));
    }
//Creamos metodos donde se recibe la opcion ingresada por el usuario
    public void seleccionDeOpcion(CtaBancaria ctaBancaria, int opcion) {
        Movimiento movimiento = new Movimiento();
        switch (opcion) {
            case 1: movimiento.setFecha(new Date());
                    movimiento.setTipoOperacion("PAGOS-SAMEEP");
                    movimiento.setMontoOperacion(-MONTO_SAMEEP);
                if (ctaBancaria.guardarValidarMovimiento(movimiento))
                    JOptionPane.showMessageDialog(null, "SE REALIZÓ EL PAGO CON ÉXITO",TitulosPantallas.TITULOPAGOSRECARGAS.descripcion, JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "ERROR, LA CUENTA N° "+ctaBancaria.getNumCta()+" NO POSEE SALDO ",TitulosPantallas.TITULOPAGOSRECARGAS.descripcion,JOptionPane.ERROR_MESSAGE);
                        break;
            case 2:
                    movimiento.setFecha(new Date());
                    movimiento.setTipoOperacion("PAGOS-SECHEEP");
                    movimiento.setMontoOperacion(-MONTO_SECHEEP);
                if (ctaBancaria.guardarValidarMovimiento(movimiento))
                    JOptionPane.showMessageDialog(null, "SE REALIZÓ EL PAGO CON ÉXITO",TitulosPantallas.TITULOPAGOSRECARGAS.descripcion, JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "ERROR, LA CUENTA N° "+ctaBancaria.getNumCta()+" NO POSEE SALDO ",TitulosPantallas.TITULOPAGOSRECARGAS.descripcion,JOptionPane.ERROR_MESSAGE);
                break;
            case 3: movimiento.setFecha(new Date());
                movimiento.setTipoOperacion("PAGOS-IMPUESTOS-MUN");
                movimiento.setMontoOperacion(-MONTO_IMPUESTOS_MUN);
                if (ctaBancaria.guardarValidarMovimiento(movimiento))
                    JOptionPane.showMessageDialog(null, "SE REALIZÓ EL PAGO CON ÉXITO",TitulosPantallas.TITULOPAGOSRECARGAS.descripcion, JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "ERROR, LA CUENTA N° "+ctaBancaria.getNumCta()+" NO POSEE SALDO ",TitulosPantallas.TITULOPAGOSRECARGAS.descripcion,JOptionPane.ERROR_MESSAGE);
                break;
            case 0: subMenuPantallaPR.pantallaSubMenuPagosRecargas(ctaBancaria);
                break;
            default:
                JOptionPane.showMessageDialog(null, "INGRESO ERRONEO", TitulosPantallas.TITULOPAGOS.descripcion,JOptionPane.ERROR_MESSAGE);
                this.pantallaSubMenuPagos(ctaBancaria);
                break;
        }

    }
}
