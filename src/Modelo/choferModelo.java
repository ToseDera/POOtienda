package Modelo;

public class choferModelo {

    // Inicializar variables
    public String nombreChofer = "";
    String apellidoChofer = "";
    String cedulaChofer = "";

    // Constructor
    public choferModelo(String datoNombre, String datoApellido, String datoCedula) {
        this.nombreChofer = datoNombre;
        this.apellidoChofer = datoApellido;
        this.cedulaChofer = datoCedula;
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

    // Setters
    public void setNombreChofer(String nombreChofer) {
        this.nombreChofer = nombreChofer;
    }

    public void setApellidoChofer(String apellidoChofer) {
        this.apellidoChofer = apellidoChofer;
    }

    public void setCedulaChofer(String cedulaChofer) {
        this.cedulaChofer = cedulaChofer;
    }
}
