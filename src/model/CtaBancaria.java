package model;

import java.util.List;

public class CtaBancaria {
    private Persona persona;
    private int numCta;
    private double saldo;
    private String tipoCuentaBancaria;
    private List<Movimientos> movimientos;

    public CtaBancaria() {
    }

    public CtaBancaria(Persona persona, int numCta, double saldo, String tipoCuentaBancaria) {
        this.persona = persona;
        this.numCta = numCta;
        this.saldo = saldo;
        this.tipoCuentaBancaria = tipoCuentaBancaria;
    }

    public CtaBancaria(Persona persona, int numCta, double saldo, String tipoCuentaBancaria, List<Movimientos> movimientos) {
        this.persona = persona;
        this.numCta = numCta;
        this.saldo = saldo;
        this.tipoCuentaBancaria = tipoCuentaBancaria;
        this.movimientos = movimientos;
    }

    public List<Movimientos> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimientos> movimientos) {
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
    public double sumaSaldo(double saldo){
        return this.saldo = this.getSaldo()+saldo;
    }
    public boolean validarSaldo(double saldo){
        return this.saldo - saldo > 0;
    }
    public double  restaSaldo( double saldo){
        if (validarSaldo(saldo))
            return this.saldo-saldo;
        else
            return 0;

    }
}
