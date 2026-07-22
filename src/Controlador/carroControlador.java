package Controlador;

import Modelo.carroModelo;

public class carroControlador {
    private carroModelo ultimoCarroRegistrado;

    public String datos_registrar_carro(String placa, String color, String marca, String modelo) {
        carroModelo objCarro = new carroModelo(placa, color, marca, modelo);

        String errorPlaca = objCarro.validarPlaca(placa);
        String errorColor = objCarro.validarColor(color);
        String errorMarca = objCarro.validarMarca(marca);
        String errorModelo = objCarro.validarModelo(modelo);

        if (errorPlaca != null || errorColor != null || errorMarca != null || errorModelo != null) {
            StringBuilder mensaje = new StringBuilder("No se pudo registrar el carro:\n");
            if (errorPlaca != null) {
                mensaje.append("- ").append(errorPlaca).append("\n");
            }
            if (errorColor != null) {
                mensaje.append("- ").append(errorColor).append("\n");
            }
            if (errorMarca != null) {
                mensaje.append("- ").append(errorMarca).append("\n");
            }
            if (errorModelo != null) {
                mensaje.append("- ").append(errorModelo).append("\n");
            }
            return mensaje.toString();
        }

        this.ultimoCarroRegistrado = objCarro;

        return "Carro registrado correctamente\n"
                + "Placa: " + objCarro.getPlacaCarro() + "\n"
                + "Color: " + objCarro.getColorCarro() + "\n"
                + "Marca: " + objCarro.getMarcaCarro() + "\n"
                + "Modelo: " + objCarro.getModeloCarro();
    }

    public carroModelo getUltimoCarroRegistrado() {
        return ultimoCarroRegistrado;
    }
}
