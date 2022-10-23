package model;

import java.util.Date;

public class Moviemientos extends CtaBancaria {
    private String tipoOperacion;
    private Date fecha;

    public Moviemientos(String tipoOperacion, Date fecha) {
        this.tipoOperacion = tipoOperacion;
        this.fecha = fecha;
    }

    public Moviemientos(Persona persona, int numCta, double saldo, String tipoCuentaBancaria, String tipoOperacion, Date fecha) {
        super(persona, numCta, saldo, tipoCuentaBancaria);
        this.tipoOperacion = tipoOperacion;
        this.fecha = fecha;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
