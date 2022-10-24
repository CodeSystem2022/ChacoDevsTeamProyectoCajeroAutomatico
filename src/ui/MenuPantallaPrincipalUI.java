package ui;

import model.CtaBancaria;
import model.Domicilio;
import model.Persona;

import javax.swing.*;

public class MenuPantallaPrincipalUI {

    public Integer pantallaPrincipalOpciones(){
        String response=(JOptionPane.showInputDialog(null,"                   SELECCIONE EL TIPO DE               \n" +
                "           OPERACION QUE DESEA EFECTUAR              \n" +
                "\n" +
                "1<-TRANSFERENCIAS       EXTRACCIONES/    \n" +
                "                                                 DEPOSITOS-------->2\n" +
                "\n" +
                "3<------PRESTAMOS       PAGOS/RECARGAS-->4\n" +
                "\n" +
                "           CONSULTAS/                                 \n" +
                "5<----MOVIMIENTOS                   SALIR----------->0","CAJERO AUTOMATICO CDT",1));
       Integer responseToInt= response!=null?Integer.parseInt(response):null;
       return responseToInt;
    }
}




