package model;

import java.util.Date;

public class Movimientos{
    private CtaBancaria ctaBancaria;
    private String tipoOperacion;
    private double montoOperacion;
    private Date fecha;

    public Movimientos(CtaBancaria ctaBancaria,String tipoOperacion, Date fecha,Double montoOperacion) {
        this.ctaBancaria=ctaBancaria;
        this.tipoOperacion = tipoOperacion;
        this.fecha = fecha;
        this.montoOperacion=montoOperacion;
    }

    public CtaBancaria getCtaBancaria() {
        return ctaBancaria;
    }

    public void setCtaBancaria(CtaBancaria ctaBancaria) {
        this.ctaBancaria = ctaBancaria;
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
