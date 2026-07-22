package Modelo;

public class pasajeroModelo {

    // Inicializar variables
    public String nombrePasajero = "";
    String apellidoPasajero = "";
    String cedulaPasajero = "";
    String ultimoError = null;

    // Constructor
    public pasajeroModelo(String datoNombre, String datoApellido, String datoCedula) {
        setNombrePasajero(datoNombre);
        setApellidoPasajero(datoApellido);
        setCedulaPasajero(datoCedula);
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

    // Devuelve el mensaje del último error de validación, o null si el último set fue exitoso
    public String getUltimoError() {
        return ultimoError;
    }

    // Setters (solo aplican el dato si pasa la validación)
    public boolean setNombrePasajero(String nombrePasajero) {
        String error = validarNombre(nombrePasajero);
        if (error != null) {
            this.ultimoError = error;
            return false;
        }
        this.nombrePasajero = nombrePasajero;
        this.ultimoError = null;
        return true;
    }

    public boolean setApellidoPasajero(String apellidoPasajero) {
        String error = validarNombre(apellidoPasajero);
        if (error != null) {
            this.ultimoError = error;
            return false;
        }
        this.apellidoPasajero = apellidoPasajero;
        this.ultimoError = null;
        return true;
    }

    public boolean setCedulaPasajero(String cedulaPasajero) {
        String error = validarCedula(cedulaPasajero);
        if (error != null) {
            this.ultimoError = error;
            return false;
        }
        this.cedulaPasajero = cedulaPasajero;
        this.ultimoError = null;
        return true;
    }

    // Validaciones: devuelven el mensaje de error, o null si el dato es válido
    public String validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return "El nombre no puede estar vacío";
        }
        if (!nombre.trim().matches("[A-Za-zÁÉÍÓÚáéíóúÑñ ]{2,50}")) {
            return "El nombre solo puede contener letras y espacios, entre 2 y 50 caracteres";
        }
        return null;
    }

    public String validarCedula(String cedula) {
        if (cedula == null || cedula.trim().isEmpty()) {
            return "La cédula no puede estar vacía";
        }
        if (!cedula.matches("[0-9]{6,10}")) {
            return "La cédula debe contener solo números, entre 6 y 10 dígitos";
        }
        return null;
    }

    // Valida que el pasajero tenga todos sus datos correctos
    public boolean esValido() {
        return validarNombre(nombrePasajero) == null
                && validarNombre(apellidoPasajero) == null
                && validarCedula(cedulaPasajero) == null;
    }
}
