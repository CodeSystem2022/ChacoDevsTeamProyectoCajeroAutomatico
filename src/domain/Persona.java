package domain;
/*
 *Clase Persona: esta clase representara los datos necesarios de una persona
 */
public class Persona {
    private String nombre;
    private String apellido;
    private Domicilio domicilio;
    private Long dni;

    public Persona(String nombre, String apellido, Domicilio domicilio, Long dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.dni = dni;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder()
                .append("                   DATOS PERSONALES                      \n")
                .append("NOMBRE: " + this.getNombre() + "-APELLIDO: " + this.getApellido() + "\n")
                .append("DNI: " + this.getDni() + "               \n")
                .append("DOMICILIO: " +this.getDomicilio().getDireccion() + "\n")
                .append("LOCALIDAD: " + this.getDomicilio().getLocalidad() + "\n")
                .append("PROVINCIA: " + this.getDomicilio().getProvincia() + "\n");
        return sb.toString();
    }
}
