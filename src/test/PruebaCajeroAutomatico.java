package test;
import components.Validaciones;

import model.CtaBancaria;
import model.Domicilio;
import model.Movimiento;
import model.Persona;
import ui.*;
import ui.prestamos.DestinoPrestamoSubPantalla;
import ui.transferencia.SubPantallaTransferencias;
import ui.prestamos.PantallaCuota;
import ui.prestamos.SubPantallaPrestamos;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PruebaCajeroAutomatico {

    //Creacion de objetos con sus atributos para realizar pruebas
    public static MenuPantallaPrincipalUI menuPantallaPrincipalUI = new MenuPantallaPrincipalUI();
    private static Domicilio domicilio = new Domicilio("Barrio Guiraldes manzana1","Chaco","Resistencia");
    private static Persona persona = new Persona("Espinola","Renzo",domicilio,"33074277");
    private static CtaBancaria ctaBancaria = new CtaBancaria(persona,333225,5000,"Caja de Ahorro");
    private static Movimiento movimiento = new Movimiento("TRANSFERENCIA",new Date(),-2500.50);
    private static Movimiento movimiento2 = new Movimiento("DEPOSITO",new Date(),3500.50);

    public static void main(String[] args) {
        ctaBancaria.setMovimiento(movimiento);
        ctaBancaria.setMovimiento(movimiento2);
        Integer response= menuPantallaPrincipalUI.pantallaPrincipalOpciones();
        opcionSeleccion(response!=null?response:0);
    }
    public static void opcionSeleccion(int opcion) {
        Validaciones validaciones = new Validaciones();
        SubMenuPantallaPR subMenuPantallaPR = new SubMenuPantallaPR();
        SubMenuPantallaMovCons pantallaMovCons = new SubMenuPantallaMovCons();
        DepositoExtracciones depositoExtracciones = new DepositoExtracciones();

           switch(opcion) {
               case 1: 
                   break;
               case 2:depositoExtracciones.menuDepoExtrac(ctaBancaria);
                   break;
               case 3:PantallaSubMenuPrestamos.generarPantallaPrestamos(ctaBancaria);
                   break;
               case 4:subMenuPantallaPR.pantallaSubMenuPagosRecargas(ctaBancaria);
                   break;
               case 5:pantallaMovCons.pantallaSubMenuMovconsultas(ctaBancaria);
               break;
               case 0: JOptionPane.showMessageDialog(null,"ADIOS GRACIAS POR USAR NUESTROS SERVICIOS");
               return;
               default:
                   JOptionPane.showMessageDialog(null,"Ingreso Erroneo");
                   opcion=menuPantallaPrincipalUI.pantallaPrincipalOpciones();
                   opcionSeleccion(opcion);
               break;
           }
           opcion = menuPantallaPrincipalUI.pantallaPrincipalOpciones();
           opcionSeleccion(opcion);
        }
    }
