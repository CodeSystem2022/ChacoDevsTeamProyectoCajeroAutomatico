package ui;

import javax.swing.*;

public class MenuPantallaPrincipalUI {

    public int pantallaPrincipalOpciones(){
        return Integer.parseInt(JOptionPane.showInputDialog("                   SELECCIONE EL TIPO DE               \n" +
                "           OPERACION QUE DESEA EFECTUAR              \n" +
                "\n" +
                "1<-TRANSFERENCIAS       EXTRACCIONES/    \n" +
                "                                                 DEPOSITOS-------->2\n" +
                "\n" +
                "3<------PRESTAMOS       PAGOS/RECARGAS-->4\n" +
                "\n" +
                "           CONSULTAS/                                 \n" +
                "5<----MOVIMIENTOS                   SALIR----------->0"));
    }
}




