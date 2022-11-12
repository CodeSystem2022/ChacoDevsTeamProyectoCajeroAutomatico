package ui;
import model.*;
public class SubMenuPantallaPR {
  
    public void pantallaSubMenuPagosRecargas(CtaBancaria ctaBancaria){
        int opcion= Integer.parseInt(JOptionPane.showInputDialog(new StringBuilder()
                .append("                   SELECCIONE EL TIPO DE                  \n")
                .append("           OPERACION QUE DESEA EFECTUAR                   \n")
                .append("                                                          \n")
                .append("1<---- PAGOS                        RECARGAS------------>2\n")
                .append("                                                          \n")
                .append("0<---- VOLVER                                             \n")                            
                .toString()));
        opcionSeleccion(opcion,ctaBancaria);
    }

  
    public void opcionSeleccion(int opcion, CtaBancaria ctaBancaria) {
        SubPantallasMovimientosConsultas subPantallasMovimientosConsultas = new SubPantallasMovimientosConsultas();
        Validaciones validaciones = new Validaciones();
        while (validaciones.validaIngMenuPrin(opcion,5)) {
            switch(opcion) {
                case 1:
                    subPantallasMovimientosConsultas.mostrarSaldo(ctaBancaria);
                    break;
                case 2: subPantallasMovimientosConsultas.tipoCambio(ctaBancaria);
                    break;
                case 3: subPantallasMovimientosConsultas.consultaCBU(ctaBancaria);
                    break;
                case 4:
                    subPantallasMovimientosConsultas.mostrarMovimientos(ctaBancaria);
                    break;
                case 0:
                    break;
            }
            opcion=-10;
        }
    }

}

  
  
  
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
  
  
  
  
  
  
  
 
  
  
  
 


  
  
  
  
  
  
  
  
  
  
  
  