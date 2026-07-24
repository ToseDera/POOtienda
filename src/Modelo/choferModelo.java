package Modelo;

public class choferModelo {

    // Inicializar variables
    public String nombreChofer = "";
    String apellidoChofer = "";
    String cedulaChofer = "";
    String licenciaChofer = "";
    String ultimoError = null;

    // Constructor
    public choferModelo(String datoNombre, String datoApellido, String datoCedula, String datoLicencia) {
        setNombreChofer(datoNombre);
        setApellidoChofer(datoApellido);
        setCedulaChofer(datoCedula);
        setLicenciaChofer(datoLicencia);
    }

    // Getters
    public String getNombreChofer() {
        return nombreChofer;
    }

    public String getApellidoChofer() {
        return apellidoChofer;
    }

    public String getCedulaChofer() {
        return cedulaChofer;
    }

    public String getLicenciaChofer() {
        return licenciaChofer;
    }

    public String getUltimoError() {
        return ultimoError;
    }

    // Setters
    public boolean setNombreChofer(String nombreChofer) {
        String error = validarNombre(nombreChofer);
        if (error != null) {
            this.ultimoError = error;
            return false;
        }
        this.nombreChofer = nombreChofer;
        this.ultimoError = null;
        return true;
    }

    public boolean setApellidoChofer(String apellidoChofer) {
        String error = validarNombre(apellidoChofer);
        if (error != null) {
            this.ultimoError = error;
            return false;
        }
        this.apellidoChofer = apellidoChofer;
        this.ultimoError = null;
        return true;
    }

    public boolean setCedulaChofer(String cedulaChofer) {
        String error = validarCedula(cedulaChofer);
        if (error != null) {
            this.ultimoError = error;
            return false;
        }
        this.cedulaChofer = cedulaChofer;
        this.ultimoError = null;
        return true;
    }

    public boolean setLicenciaChofer(String licenciaChofer) {
        String error = validarLicencia(licenciaChofer);
        if (error != null) {
            this.ultimoError = error;
            return false;
        }
        this.licenciaChofer = licenciaChofer;
        this.ultimoError = null;
        return true;
    }

    // Validaciones
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

    public String validarLicencia(String licencia) {
        if (licencia == null || licencia.trim().isEmpty()) {
            return "La licencia no puede estar vacía";
        }
        if (!licencia.trim().matches("[A-Za-z0-9-]{5,15}")) {
            return "La licencia debe tener entre 5 y 15 caracteres alfanuméricos";
        }
        return null;
    }

    // Valida datos del chofer
    public boolean esValido() {
        return validarNombre(nombreChofer) == null
                && validarNombre(apellidoChofer) == null
                && validarCedula(cedulaChofer) == null
                && validarLicencia(licenciaChofer) == null;
    }
}
