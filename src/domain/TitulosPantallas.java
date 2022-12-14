package domain;
//Se creo una Clase Enum donde contenga los diversos titulos de pantallas a utilizarse en el proyecto
public enum TitulosPantallas {
    TITULOLOGIN("LOGIN"),
    TITULOLOGNUEVACUENTA("LOGIN-NUEVA CUENTA"),
    TITULOCAJERO("CAJERO AUTOMATICO CDT"),
    TITULOMOVIMIENTOCONSULTAS("CONSULTAS/MOVIMIENTOS"),
    TITULOPRESTAMOS("PRESTAMOS"),
    TITULOPAGOSRECARGAS("PAGOS/RECARGAS"),
    TITULOPAGOS("PAGOS"),
    TITULORECARGA("RECARGAS"),
    TITULODEPTRANS("TRANSFERENCIAS"),
    TITULODATOSPERSONALES("DATOS PERSONALES"),
    TITULOERROR("ERROR"),
    TITULOEDITARDATOS("DATOS PERSONALES");

    public final String descripcion;

    TitulosPantallas(String descripcion) {
        this.descripcion = descripcion;
    }

}
