package Modelo;

public class carroModelo {
    // Inicializar variables
    public String placaCarro = "";
    String colorCarro = "";
    String marcaCarro = "";
    String modeloCarro = "";

    // Constructor
    public carroModelo(String datoPlaca, String datoColor, String datoMarca, String datoModelo) {
        this.placaCarro = datoPlaca;
        this.colorCarro = datoColor;
        this.marcaCarro = datoMarca;
        this.modeloCarro = datoModelo;
    }

    // Getters
    public String getPlacaCarro() {
        return placaCarro;
    }

    public String getColorCarro() {
        return colorCarro;
    }

    public String getMarcaCarro() {
        return marcaCarro;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    // Setters
    public void setPlacaCarro(String placaCarro) {
        this.placaCarro = placaCarro;
    }

    public void setColorCarro(String colorCarro) {
        this.colorCarro = colorCarro;
    }

    public void setMarcaCarro(String marcaCarro) {
        this.marcaCarro = marcaCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    // Buscar carro
    public carroModelo buscarCarro(String placaCarro) {
        if (this.placaCarro == placaCarro) {
            return this;
        }
        return null;
    }
}
