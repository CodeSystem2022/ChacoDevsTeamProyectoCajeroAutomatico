package ui.editardatos;

import domain.CtaBancaria;
import domain.Domicilio;
import domain.Persona;
import domain.TitulosPantallas;

import javax.swing.*;
import java.awt.*;


public class PantallaSubMenuEdDatPersonal {
    public void editarDatos(CtaBancaria ctaBancaria) {
        JFrame frame;
        JPanel pane;
        JTextField nombreField;
        JTextField apellidoField;
        JTextField dniField;
        JTextField localidadField;
        JTextField provinciaField;
        JTextField direccionField;
        frame = new JFrame("                  EDITAR DATOS PERSONALES                  \n " +
                "\n");

        long dni = 0;
        pane = new JPanel();
        pane.setLayout(new GridLayout(0, 2, 2, 2));

        nombreField = new JTextField(5);
        apellidoField = new JTextField(5);
        dniField = new JTextField(5);
        localidadField = new JTextField(5);
        provinciaField = new JTextField(5);
        direccionField = new JTextField(5);

        pane.add(new JLabel("Nombre: "));
        pane.add(nombreField);
        pane.add(new JLabel("Apellido: "));
        pane.add(apellidoField);
        pane.add(new JLabel("DNI: "));
        pane.add(dniField);
        pane.add(new JLabel("Localidad: "));
        pane.add(localidadField);
        pane.add(new JLabel("Provincia: "));
        pane.add(provinciaField);
        pane.add(new JLabel("Direccion: "));
        pane.add(direccionField);

        int option = JOptionPane.showConfirmDialog(frame, pane, "EDITAR DATOS PERSONALES", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.YES_OPTION) {

            String nombreInput = nombreField.getText();
            String apellidoInput = apellidoField.getText();
            String dniInput = dniField.getText();
            String localidadInput = localidadField.getText();
            String provinciaInput = provinciaField.getText();
            String direccionInput = direccionField.getText();

            try {
                dni = Long.parseLong(dniInput);
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
            try {
                Persona persona = new Persona();
                persona.setApellido(apellidoInput);
                persona.setNombre(nombreInput);
                persona.setDni(dni);
                Domicilio domicilio = new Domicilio();
                domicilio.setDireccion(direccionInput);
                domicilio.setLocalidad(localidadInput);
                domicilio.setProvincia(provinciaInput);
                persona.setDomicilio(domicilio);
                ctaBancaria.setPersona(persona);
                JOptionPane.showMessageDialog(null, "SE REALIZO LA ACTUALIZACION DE LOS DATOS EXITOSAMENTE", TitulosPantallas.TITULODATOSPERSONALES.descripcion, JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "ERROR,OCURRIO UN ERROR AL REGISTRAR LOS DATOS", TitulosPantallas.TITULODATOSPERSONALES.descripcion, JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void verDatos(CtaBancaria ctaBancaria) {
        if(ctaBancaria.getPersona()!=null) {
            JOptionPane.showMessageDialog(null,ctaBancaria.getPersona().toString(), TitulosPantallas.TITULODATOSPERSONALES.descripcion, JOptionPane.INFORMATION_MESSAGE);
        }else
            JOptionPane.showMessageDialog(null, "ERROR, DEBE CARGAR LOS DATOS PERSONALES", TitulosPantallas.TITULODATOSPERSONALES.descripcion, JOptionPane.ERROR_MESSAGE);
    }
}
