package Modelo;

public class pasajeroModelo {

    // Inicializar variables
    public String nombrePasajero = "";
    String apellidoPasajero = "";
    String cedulaPasajero = "";

    // Constructor
    public pasajeroModelo(String datoNombre, String datoApellido, String datoCedula) {
        this.nombrePasajero = datoNombre;
        this.apellidoPasajero = datoApellido;
        this.cedulaPasajero = datoCedula;
    }

    // Getters
    public String getNombrePasajero() {
        return nombrePasajero;
    }

    public String getApellidoPasajero() {
        return apellidoPasajero;
    }

    public String getCedulaPasajero() {
        return cedulaPasajero;
    }

    // Setters
    public void setNombrePasajero(String nombrePasajero) {
        this.nombrePasajero = nombrePasajero;
    }

    public void setApellidoPasajero(String apellidoPasajero) {
        this.apellidoPasajero = apellidoPasajero;
    }

    public void setCedulaPasajero(String cedulaPasajero) {
        this.cedulaPasajero = cedulaPasajero;
    }
}
