package test;
import model.CtaBancaria;
import model.TitulosPantallas;
import ui.*;
import ui.transferencia.MenuTransferencia;
import javax.swing.*;

public class PruebaCajeroAutomatico {

    //Creacion de objetos con sus atributos para realizar pruebas
    public static MenuPantallaPrincipalUI menuPantallaPrincipalUI = new MenuPantallaPrincipalUI();
    private static CtaBancaria ctaBancaria = new CtaBancaria(0,"Caja de Ahorro");

    public static void main(String[] args) {
       init();
       System.exit(0);
    }
    //Metodo de inicializacion donde creo la pantalla de loggin y hasta que no se proporcion un valor correspondiente
    //no prosigue
    public static void init(){
        PantallaLogin pantallaLogin = new PantallaLogin();
        boolean bandera=false;
        do{
            bandera=pantallaLogin.login(ctaBancaria);
        }while(!bandera);
        Integer response = menuPantallaPrincipalUI.pantallaPrincipalOpciones();
        opcionSeleccion(response != null ? response : 0);
    }
    //se crea metodo de seleccion que recibe la opcion proporcionada por el usuario
    public static void opcionSeleccion(int opcion) {
        SubMenuPantallaMovCons pantallaMovCons = new SubMenuPantallaMovCons();
        DepositoExtracciones depositoExtracciones = new DepositoExtracciones();
        MenuTransferencia transferencias = new MenuTransferencia();
        SubMenuPantallaPR subMenuPantallaPR = new SubMenuPantallaPR();
        PantallaEditarVerDatos pantallaEdDatosPersonales = new PantallaEditarVerDatos();
        PantallaSubMenuPrestamos pantallaSubMenuPrestamos = new PantallaSubMenuPrestamos();
           switch(opcion) {
               case 1: transferencias.pantallaSubMenuMovconsultas(ctaBancaria);
                   break;
               case 2:depositoExtracciones.menuDepoExtrac(ctaBancaria);
                   break;
               case 3:pantallaSubMenuPrestamos.generarPantallaPrestamos(ctaBancaria);
                   break;
               case 4:subMenuPantallaPR.pantallaSubMenuPagosRecargas(ctaBancaria);
                   break;
               case 5:pantallaMovCons.pantallaSubMenuMovconsultas(ctaBancaria);
                    break;
               case 6:pantallaEdDatosPersonales.pantallaVerOEditarDatos(ctaBancaria);
                    break;
               case 0: JOptionPane.showMessageDialog(null,"ADIOS GRACIAS POR USAR NUESTROS SERVICIOS", TitulosPantallas.TITULOCAJERO.descripcion, JOptionPane.INFORMATION_MESSAGE);
               return;
               default:JOptionPane.showMessageDialog(null,"INGRESO ERRONEO",TitulosPantallas.TITULOCAJERO.descripcion,JOptionPane.ERROR_MESSAGE);
               opcion=menuPantallaPrincipalUI.pantallaPrincipalOpciones();
               opcionSeleccion(opcion);
           }
           opcion = menuPantallaPrincipalUI.pantallaPrincipalOpciones();
           opcionSeleccion(opcion);
        }
    }
