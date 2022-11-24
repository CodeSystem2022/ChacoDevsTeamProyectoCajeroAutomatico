package model;
/*
 * Clase User: esta clase es utiliza para crear los datos que se guardaran para el loggin y esta relacionada
 * con la cuenta bancaria
 */
public class User {
    private String usuario;
    private String contraseña;

    public User(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public User() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
