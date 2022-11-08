package ui;

import model.CtaBancaria;
import model.Domicilio;
import model.Persona;

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
                .append("\n").append("           CONSULTAS/                                 \n")
                .append("5<----MOVIMIENTOS                   SALIR----------->0")
                .toString(),"CAJERO AUTOMATICO CDT",1));
        responseToInt= response!=null?Integer.parseInt(response):null;
       return responseToInt;
    }
}




