package model;

import java.util.Date;

public class Movimientos extends CtaBancaria {
    private String tipoOperacion;
    private double montoOperacion;
    private Date fecha;

    public Movimientos(String tipoOperacion, Date fecha,Double montoOperacion) {
        this.tipoOperacion = tipoOperacion;
        this.fecha = fecha;
        this.montoOperacion=montoOperacion;
    }

    public Movimientos(Persona persona, int numCta, double saldo, String tipoCuentaBancaria,
                       String tipoOperacion, Date fecha,double montoOperacion) {
        super(persona, numCta, saldo, tipoCuentaBancaria);
        this.tipoOperacion = tipoOperacion;
        this.fecha = fecha;
        this.montoOperacion=montoOperacion;
    }

    public double getMontoOperacion() {
        return montoOperacion;
    }

    public void setMontoOperacion(double montoOperacion) {
        this.montoOperacion = montoOperacion;
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
