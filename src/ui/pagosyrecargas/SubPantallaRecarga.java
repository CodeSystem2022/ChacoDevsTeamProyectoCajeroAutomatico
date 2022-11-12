package ui.pagosyrecargas;

public class SubPantallaRecarga {
    public void pantallasubmenurecargas(CtaBancaria ctaBancaria){
        int opcion= Integer.parseInt(JOptionPane.showInputDialog(new StringBuilder()
                .append("                   SELECCIONE EL RUBRO                    \n")
                .append("NO RUBRO                                                  \n")
                .append("01-TRANSPORTE PUBLICO                                     \n")
                .append("02-TELEFONIA CELULAR                                      \n")
                .append("00-VOLVER                                                 \n")                         
                .toString()));
        opcionSeleccion(opcion,ctaBancaria);
    }
    public void pantallasubmenurecargastelefonia(CtaBancaria ctaBancaria){
        int opcion= Integer.parseInt(JOptionPane.showInputDialog(new StringBuilder()
                .append("                   SELECCIONE LA EMPRESA                  \n")
                .append("                     TELEFONIA CELUCAR                    \n")
                .append("NO EMPRESA                                                \n")
                .append("01-PERSONAL                                               \n")
                .append("02-CLARO                                                  \n")
                .append("03-MOVISTAR                                               \n")
                .append("00-VOLVER                                                 \n")
        opcionSeleccion(opcion,ctaBancaria);
    }  
}
