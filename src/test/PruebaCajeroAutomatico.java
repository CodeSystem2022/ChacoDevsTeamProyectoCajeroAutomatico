package test;
import components.Validaciones;

import model.CtaBancaria;
import model.Domicilio;
import model.Movimientos;
import model.Persona;
import ui.*;

import javax.swing.*;
import java.util.Date;

public class PruebaCajeroAutomatico {

    //Creacion de objetos con sus atributos para realizar pruebas
    public static MenuPantallaPrincipalUI menuPantallaPrincipalUI = new MenuPantallaPrincipalUI();
    private static Domicilio domicilio = new Domicilio("Barrio Guiraldes manzana1","Chaco","Resistencia");
    private static Persona persona = new Persona("Espinola","Renzo",domicilio,"33074277");
    private static CtaBancaria ctaBancaria = new CtaBancaria(persona,333225,5000,"Caja de Ahorro");

    private static Movimientos movimiento = new Movimientos(ctaBancaria,"TRANSFERENCIA",new Date(),2500.50);

    public static void main(String[] args) {
        int response= menuPantallaPrincipalUI.pantallaPrincipalOpciones()!=null?menuPantallaPrincipalUI.pantallaPrincipalOpciones():0;
        opcionSeleccion(response);
    }
    public static void opcionSeleccion(int opcion) {
        Validaciones validaciones = new Validaciones();
        while (validaciones.validaIngMenuPrin(opcion)) {
           switch(opcion) {
               case 1:
                   break;
               case 2:
                   break;
               case 3:
                   break;
               case 4:
                   break;
               case 5:SubMenuPantallaMovCons.pantallaSubMenuMovconsultas(movimiento);
               break;
               case 0: JOptionPane.showMessageDialog(null,"ADIOS GRACIAS POR USAR NUESTROS SERVICIOS");
               return;
           }
            opcion = menuPantallaPrincipalUI.pantallaPrincipalOpciones();
        }
    }

}
