package domain;
/*
 *Clase Domicilio
 * Esta clase cuenta con los sieguientes atributos:
 * direccion, provincia, localidad: son los datos de la persona vinculada a la cuenta bancaria
 */
public class Domicilio {
    private String direccion;
    private String provincia;
    private String localidad;

    public Domicilio() {
    }

    public Domicilio(String direccion, String provincia, String localidad) {
        this.direccion = direccion;
        this.provincia = provincia;
        this.localidad = localidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}
