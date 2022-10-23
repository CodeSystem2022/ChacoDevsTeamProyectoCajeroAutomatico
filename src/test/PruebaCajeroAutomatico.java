package test;
import model.CtaBancaria;
import model.Domicilio;
import model.Persona;
import ui.*;
public class PruebaCajeroAutomatico {
    public static void main(String[] args) {
        Domicilio domicilio = new Domicilio("Barrio Guiraldes manzana1","Chaco","Resistencia");
        Persona persona = new Persona("Espinola","Renzo",domicilio,"33074277");
        CtaBancaria ctaBancaria = new CtaBancaria(persona,333225,5000,"Caja de Ahorro");

        MenuPantallaPrincipalUI menuPantallaPrincipalUI = new MenuPantallaPrincipalUI();
        int response= menuPantallaPrincipalUI.pantallaPrincipalOpciones(ctaBancaria);

    }
    public void opcionesSelecionadas(int opcion){

    }
}
