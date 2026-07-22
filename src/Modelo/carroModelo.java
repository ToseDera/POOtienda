package Modelo;

public class carroModelo {
    // Inicializar variables
    public String placaCarro = "";
    String colorCarro = "";
    String marcaCarro = "";
    String modeloCarro = "";
    String ultimoError = null;

    // Constructor
    public carroModelo(String datoPlaca, String datoColor, String datoMarca, String datoModelo) {
        setPlacaCarro(datoPlaca);
        setColorCarro(datoColor);
        setMarcaCarro(datoMarca);
        setModeloCarro(datoModelo);
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

    // Devuelve el mensaje del ultimo error de validacion, o null si el ultimo set fue exitoso
    public String getUltimoError() {
        return ultimoError;
    }

    // Setters (solo aplican el dato si pasa la validacion)
    public boolean setPlacaCarro(String placaCarro) {
        String error = validarPlaca(placaCarro);
        if (error != null) {
            this.ultimoError = error;
            return false;
        }
        this.placaCarro = placaCarro;
        this.ultimoError = null;
        return true;
    }

    public boolean setColorCarro(String colorCarro) {
        String error = validarColor(colorCarro);
        if (error != null) {
            this.ultimoError = error;
            return false;
        }
        this.colorCarro = colorCarro;
        this.ultimoError = null;
        return true;
    }

    public boolean setMarcaCarro(String marcaCarro) {
        String error = validarMarca(marcaCarro);
        if (error != null) {
            this.ultimoError = error;
            return false;
        }
        this.marcaCarro = marcaCarro;
        this.ultimoError = null;
        return true;
    }

    public boolean setModeloCarro(String modeloCarro) {
        String error = validarModelo(modeloCarro);
        if (error != null) {
            this.ultimoError = error;
            return false;
        }
        this.modeloCarro = modeloCarro;
        this.ultimoError = null;
        return true;
    }

    // Validaciones: devuelven el mensaje de error, o null si el dato es valido
    public String validarPlaca(String placa) {
        if (placa == null || placa.trim().isEmpty()) {
            return "La placa no puede estar vacia";
        }
        if (!placa.trim().matches("[A-Za-z]{3}-?[0-9]{3,4}[A-Za-z]?")) {
            return "La placa debe tener el formato AAA-1234 (3 letras y 3 o 4 numeros, guion opcional)";
        }
        return null;
    }

    public String validarColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            return "El color no puede estar vacio";
        }
        if (!color.trim().matches("[A-Za-zÁÉÍÓÚáéíóúÑñ ]{3,20}")) {
            return "El color solo puede contener letras y espacios, entre 3 y 20 caracteres";
        }
        return null;
    }

    public String validarMarca(String marca) {
        if (marca == null || marca.trim().isEmpty()) {
            return "La marca no puede estar vacia";
        }
        if (!marca.trim().matches("[A-Za-z0-9ÁÉÍÓÚáéíóúÑñ ]{2,30}")) {
            return "La marca debe tener entre 2 y 30 caracteres";
        }
        return null;
    }

    public String validarModelo(String modelo) {
        if (modelo == null || modelo.trim().isEmpty()) {
            return "El modelo no puede estar vacio";
        }
        if (!modelo.trim().matches("(19|20)[0-9]{2}")) {
            return "El modelo debe ser un anio valido entre 1900 y 2099";
        }
        return null;
    }

    // Valida que el carro tenga todos sus datos correctos
    public boolean esValido() {
        return validarPlaca(placaCarro) == null
                && validarColor(colorCarro) == null
                && validarMarca(marcaCarro) == null
                && validarModelo(modeloCarro) == null;
    }

    // Buscar carro por placa
    public carroModelo buscarCarro(String placaCarro) {
        if (this.placaCarro != null && this.placaCarro.equalsIgnoreCase(placaCarro)) {
            return this;
        }
        return null;
    }
}
