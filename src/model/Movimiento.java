package model;

import java.util.Date;

public class Movimiento {
    private String tipoOperacion;
    private double montoOperacion;
    private Date fecha;

    public Movimiento(String tipoOperacion, Date fecha, Double montoOperacion) {
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
