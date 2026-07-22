package Controlador;

import Modelo.choferModelo;

public class choferControlador {
    private choferModelo ultimoChoferRegistrado;

    public String datos_registrar_chofer(String nombre, String apellido, String cedula) {
        choferModelo objChofer = new choferModelo(nombre, apellido, cedula);

        String errorNombre = objChofer.validarNombre(nombre);
        String errorApellido = objChofer.validarNombre(apellido);
        String errorCedula = objChofer.validarCedula(cedula);

        if (errorNombre != null || errorApellido != null || errorCedula != null) {
            StringBuilder mensaje = new StringBuilder("No se pudo registrar el chofer:\n");
            if (errorNombre != null) {
                mensaje.append("- ").append(errorNombre).append("\n");
            }
            if (errorApellido != null) {
                mensaje.append("- ").append(errorApellido).append("\n");
            }
            if (errorCedula != null) {
                mensaje.append("- ").append(errorCedula).append("\n");
            }
            return mensaje.toString();
        }

        this.ultimoChoferRegistrado = objChofer;

        return "Chofer registrado correctamente\n"
                + "Nombre: " + objChofer.getNombreChofer() + "\n" + "Apellido: " + objChofer.getApellidoChofer() + "\n"
                + "Cédula: " + objChofer.getCedulaChofer();
    }

    public choferModelo getUltimoChoferRegistrado() {
        return ultimoChoferRegistrado;
    }
}
