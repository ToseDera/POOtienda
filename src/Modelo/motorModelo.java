package Modelo;

public class motorModelo {
    // Inicializar variables
    public String tipoMotor = "";
    String caballosFuerza = "";

    // Constructor
    public motorModelo(String datoTipoMotor, String datoCaballosFuerza) {
        this.tipoMotor = datoTipoMotor;
        this.caballosFuerza = datoCaballosFuerza;
    }

    // Getters
    public String getTipoMotor() {
        return tipoMotor;
    }

    public String getCaballosFuerza() {
        return caballosFuerza;
    }

    // Setters
    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public void setCaballosFuerza(String caballosFuerza) {
        this.caballosFuerza = caballosFuerza;
    }
}
