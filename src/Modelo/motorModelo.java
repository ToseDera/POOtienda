package Modelo;

public class motorModelo {
    // Inicializar variables
    public String tipoMotor = "";
    String numeroSerie = "";
    String caballosFuerza = "";
    String ultimoError = null;

    // Tipos de motor permitidos
    private static final String[] TIPOS_VALIDOS = { "Gasolina", "Diesel", "Electrico", "Hibrido", "Gas" };

    // Constructor
    public motorModelo(String datoTipoMotor, String datoNumeroSerie, String datoCaballosFuerza) {
        setTipoMotor(datoTipoMotor);
        setNumeroSerie(datoNumeroSerie);
        setCaballosFuerza(datoCaballosFuerza);
    }

    // Getters
    public String getTipoMotor() {
        return tipoMotor;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public String getCaballosFuerza() {
        return caballosFuerza;
    }

    // Devuelve el mensaje del último error de validación, o null si el último set fue exitoso
    public String getUltimoError() {
        return ultimoError;
    }

    // Setters (solo aplican el dato si pasa la validación)
    public boolean setTipoMotor(String tipoMotor) {
        String error = validarTipoMotor(tipoMotor);
        if (error != null) {
            this.ultimoError = error;
            return false;
        }
        this.tipoMotor = tipoMotor;
        this.ultimoError = null;
        return true;
    }

    public boolean setNumeroSerie(String numeroSerie) {
        String error = validarNumeroSerie(numeroSerie);
        if (error != null) {
            this.ultimoError = error;
            return false;
        }
        this.numeroSerie = numeroSerie;
        this.ultimoError = null;
        return true;
    }

    public boolean setCaballosFuerza(String caballosFuerza) {
        String error = validarCaballosFuerza(caballosFuerza);
        if (error != null) {
            this.ultimoError = error;
            return false;
        }
        this.caballosFuerza = caballosFuerza;
        this.ultimoError = null;
        return true;
    }

    // Validaciones: devuelven el mensaje de error, o null si el dato es válido
    public String validarTipoMotor(String tipoMotor) {
        if (tipoMotor == null || tipoMotor.trim().isEmpty()) {
            return "El tipo de motor no puede estar vacío";
        }
        for (String tipo : TIPOS_VALIDOS) {
            if (tipo.equalsIgnoreCase(tipoMotor.trim())) {
                return null;
            }
        }
        return "El tipo de motor debe ser uno de: Gasolina, Diesel, Electrico, Hibrido, Gas";
    }

    public String validarNumeroSerie(String numeroSerie) {
        if (numeroSerie == null || numeroSerie.trim().isEmpty()) {
            return "El número de serie no puede estar vacío";
        }
        if (!numeroSerie.trim().matches("[A-Za-z0-9-]{5,20}")) {
            return "El número de serie debe tener entre 5 y 20 caracteres alfanuméricos";
        }
        return null;
    }

    public String validarCaballosFuerza(String caballosFuerza) {
        if (caballosFuerza == null || caballosFuerza.trim().isEmpty()) {
            return "Los caballos de fuerza no pueden estar vacíos";
        }
        if (!caballosFuerza.trim().matches("[0-9]{1,4}")) {
            return "Los caballos de fuerza deben ser un número entero";
        }
        int valor = Integer.parseInt(caballosFuerza.trim());
        if (valor < 1 || valor > 2000) {
            return "Los caballos de fuerza deben estar entre 1 y 2000";
        }
        return null;
    }

    // Valida que el motor tenga todos sus datos correctos
    public boolean esValido() {
        return validarTipoMotor(tipoMotor) == null
                && validarNumeroSerie(numeroSerie) == null
                && validarCaballosFuerza(caballosFuerza) == null;
    }
}
