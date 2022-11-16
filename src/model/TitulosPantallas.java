package model;

public enum TitulosPantallas {
    TITULOLOGIN("LOGIN"),
    TITULOLOGNUEVACUENTA("LOGIN-NUEVA CUENTA"),
    TITULOCAJERO("CAJERO AUTOMATICO CDT"),
    TITULOMOVIMIENTOCONSULTAS("CONSULTAS/MOVIMIENTOS"),
    TITULOPRESTAMOS("PRESTAMOS"),
    TITULOPAGOSRECARGAS("PAGOS/RECARGAS"),
    TITULOPAGOS("PAGOS"),
    TITULORECARGA("RECARGAS"),
    TITULODEPTRANS("DEPOSITOS/TRANSFERENCIAS"),
    TITULOERROR("ERROR");

    public final String descripcion;

    private TitulosPantallas(String descripcion) {
        this.descripcion = descripcion;
    }

}
