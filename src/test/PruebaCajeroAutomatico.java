package test;
import components.ValidaIngresoMenu;

import model.CtaBancaria;
import model.Domicilio;
import model.Persona;
import ui.*;

public class PruebaCajeroAutomatico {
    //Creacion de objetos con sus atributos para realizar pruebas
    private static MenuPantallaPrincipalUI menuPantallaPrincipalUI = new MenuPantallaPrincipalUI();
    private static Domicilio domicilio = new Domicilio("Barrio Guiraldes manzana1","Chaco","Resistencia");
    private static Persona persona = new Persona("Espinola","Renzo",domicilio,"33074277");
    private static CtaBancaria ctaBancaria = new CtaBancaria(persona,333225,5000,"Caja de Ahorro");


    public static void main(String[] args) {
        int response= menuPantallaPrincipalUI.pantallaPrincipalOpciones(ctaBancaria);
        opcionSeleccion(response);
    }
    public static void opcionSeleccion(int opcion) {
        ValidaIngresoMenu validaIngresoMenu = new ValidaIngresoMenu();
        while (validaIngresoMenu.validaIngMenuPrin(opcion)) {
           switch(opcion) {
               case 1:
                   break;
               case 2:
                   break;
               case 3:
                   break;
               case 4:
                   break;
               case 5:SubMenuPantallaMovCons.pantallaSubMenuMovconsultas(ctaBancaria);
               break;
           }
        }
    }
}
