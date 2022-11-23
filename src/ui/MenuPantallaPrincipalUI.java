package ui;

import model.CtaBancaria;
import model.Domicilio;
import model.Persona;
import model.TitulosPantallas;

import javax.swing.*;

public class MenuPantallaPrincipalUI {

    public Integer pantallaPrincipalOpciones(){
        Integer responseToInt=null;
        String response=(JOptionPane.showInputDialog(null, new StringBuilder()
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
        responseToInt= response!=null?Integer.parseInt(response):null;
       return responseToInt;
    }
}




