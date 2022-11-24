package model;

import java.util.ArrayList;
import java.util.List;
/*
 * Clase CtaBancaria
 * esta clase contendra los atributos de Persona
 * numCta: es el numero de cuenta
 * saldo: el saldo que posee la cuenta
 * tipoCuentaBancaria: es el tipo de cuenta bancaria caja de ahorro-cuenta corriente
 * movimientos: es una coleccion de movimientos que se registraran por cada accion que se realize que modifique el saldo
 * CBU: es el cbu de la cuenta bancaria
 * user: es el usuario para el logeo
 */
public class CtaBancaria {
    //determino un numero aleatorio para la cuenta bancaria que se asemeje a la realidad en el siguiente rango
    private static final int NRO_CTA_BANCARIA=(int) (Math.random() * (999999 - 100000)) + 100000 ;
    private Persona persona;
    private int numCta;
    private double saldo;
    private String tipoCuentaBancaria;
    private List<Movimiento> movimientos;
    private String CBU;
    private User user;

    public CtaBancaria() {
        armarCBU();
    }

    public CtaBancaria(Persona persona, int numCta, double saldo, String tipoCuentaBancaria) {
        this.persona = persona;
        this.numCta = NRO_CTA_BANCARIA;
        this.saldo = saldo;
        this.tipoCuentaBancaria = tipoCuentaBancaria;
        armarCBU();
        crearUsuarioAdmin();
    }

    public CtaBancaria(double saldo, String tipoCuentaBancaria) {
        this.numCta = NRO_CTA_BANCARIA;
        this.saldo = saldo;
        this.tipoCuentaBancaria = tipoCuentaBancaria;
        armarCBU();
        crearUsuarioAdmin();
    }

    public CtaBancaria(Persona persona, int numCta, double saldo, String tipoCuentaBancaria, List<Movimiento> movimientos) {
        this.persona = persona;
        this.numCta = NRO_CTA_BANCARIA;
        this.saldo = saldo;
        this.tipoCuentaBancaria = tipoCuentaBancaria;
        this.movimientos = movimientos;
        armarCBU();
        crearUsuarioAdmin();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User usario) {
        this.user = usario;
    }

    public String getCBU() {
        return CBU;
    }

    public void setCBU(String CBU) {
        this.CBU = CBU;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }
    //Se crea el metodo guardarValidarMovimiento, donde este recibe un objeto Movimiento y lo adhiere a la lista de
    //de movimientos tambien se valida el monto de la operacion con respecto a su saldo
    public boolean guardarValidarMovimiento(Movimiento movimiento){
        if(movimiento!=null){
            List<Movimiento> movimientoList = new ArrayList<>();
            if (this.validarSaldo(movimiento.getMontoOperacion())) {
                movimientoList.add(movimiento);
                if (this.getMovimientos() != null)
                    this.getMovimientos().add(movimiento);
                else
                    this.setMovimientos(movimientoList);
                this.actualizaSaldoCta(movimiento);
                return true;
            } else return false;
        }else return false;
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
    //Armo el cbu con la numeracion correspondiente para el bco provincial de chaco
    //con su prefijo de 311 y el numero de cuenta
    private void armarCBU(){
        String CBU="311000000000"+this.getNumCta();
        this.setCBU(CBU);
    }

    public void sumaSaldo(double montoOperacion){
        this.setSaldo(this.getSaldo()+montoOperacion);
    }
    // valido que el monto de la operacion (el cual es negativo) sumado el saldo que posee
    // sea superior a 0
    public boolean validarSaldo(double montoOperacion){
        return this.getSaldo() + montoOperacion > 0;
    }
    //En caso de que el metodo validarSaldo retorne true
    // permitiria setear el nuevo saldo (saldo de la cuenta +(-monto de la operacion))
    public void restaSaldo( double montoOperacion){
        if (validarSaldo(montoOperacion))
            this.setSaldo(this.getSaldo()+montoOperacion);
    }
    //Recibe como un objeto movimiento determino que el monto sea negativo para resta o en caso contrario
    //sumaria al saldo
    public void actualizaSaldoCta(Movimiento movimiento){
        if (movimiento.getMontoOperacion()<0){
            restaSaldo(movimiento.getMontoOperacion());
        }else
            sumaSaldo(movimiento.getMontoOperacion());
    }
    //Creo un  usuario ADMINISTRADOR para el loggin
    public void crearUsuarioAdmin(){
        this.setUser(new User("ADMIN","1234"));
    }
}
