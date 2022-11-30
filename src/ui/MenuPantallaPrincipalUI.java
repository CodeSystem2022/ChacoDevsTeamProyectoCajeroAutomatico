package ui;

import components.Validaciones;
import domain.TitulosPantallas;

import javax.swing.*;

public class MenuPantallaPrincipalUI {
    private Validaciones validaciones = new Validaciones();
    public Integer pantallaPrincipalOpciones(){
        String response="0";
        boolean bandera = false;
        Integer responseToInt=null;
    do {
        response=(JOptionPane.showInputDialog(null, new StringBuilder()
                .append("                   SELECCIONE EL TIPO DE               \n")
                .append("           OPERACION QUE DESEA EFECTUAR              \n")
                .append("\n").append("1<-TRANSFERENCIAS       EXTRACCIONES/    \n")
                .append("                                                 DEPOSITOS-------->2\n")
                .append("\n").append("3<------PRESTAMOS       PAGOS/RECARGAS-->4\n")
                .append("\n").append("           CONSULTAS/         EDITAR DATOS\n")
                .append("5<----MOVIMIENTOS       PERSONALES---------->6\n")
                .append("\n")
                .append("0<----SALIR ")
                .toString(), TitulosPantallas.TITULOCAJERO.descripcion,1));
        if((response== null || response.equals("0"))||validaciones.esUnNumero(response)) {
            bandera = true;
        }else {
            JOptionPane.showMessageDialog(null, "ERROR, INGRESO INCORRECTO ", TitulosPantallas.TITULOCAJERO.descripcion, JOptionPane.ERROR_MESSAGE);
            bandera = false;
        }
    }while(!bandera);
        responseToInt= response!=null?Integer.parseInt(response):0;
       return responseToInt;
    }
}




