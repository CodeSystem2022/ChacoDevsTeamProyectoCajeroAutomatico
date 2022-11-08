package model;

import java.util.List;

import ui.prestamos.PantallaCuota;

public class CtaBancaria {
    private Persona persona;
    private int numCta;
    private double saldo;
    private String tipoCuentaBancaria;
    private List<Movimiento> movimientos;

    public CtaBancaria() {
    }

    public CtaBancaria(Persona persona, int numCta, double saldo, String tipoCuentaBancaria) {
        this.persona = persona;
        this.numCta = numCta;
        this.saldo = saldo;
        this.tipoCuentaBancaria = tipoCuentaBancaria;
    }

    public CtaBancaria(Persona persona, int numCta, double saldo, String tipoCuentaBancaria, List<Movimiento> movimientos) {
        this.persona = persona;
        this.numCta = numCta;
        this.saldo = saldo;
        this.tipoCuentaBancaria = tipoCuentaBancaria;
        this.movimientos = movimientos;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getNumCta() {
        return numCta;
    }

    public void setNumCta(int numCta) {
        this.numCta = numCta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipoCuentaBancaria() {
        return tipoCuentaBancaria;
    }

    public void setTipoCuentaBancaria(String tipoCuentaBancaria) {
        this.tipoCuentaBancaria = tipoCuentaBancaria;
    }

    public void sumaSaldo(double montoOperacion){
        this.saldo = this.saldo+montoOperacion;
    }

    public boolean validarSaldo(double montoOperacion){
        return this.saldo - montoOperacion > 0;
    }

    public void restaSaldo( double montoOperacion){
        if (validarSaldo(montoOperacion))
            this.saldo=this.saldo+montoOperacion;
    }

    public void actualizaSaldoCta(Movimiento movimiento){
        if (movimiento.getMontoOperacion()<0){
            restaSaldo(movimiento.getMontoOperacion());
        }else
            sumaSaldo(movimiento.getMontoOperacion());
    }
}
