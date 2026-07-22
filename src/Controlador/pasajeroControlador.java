package Controlador;

import Modelo.pasajeroModelo;

public class pasajeroControlador {
    private pasajeroModelo ultimoPasajeroRegistrado;

    public String datos_registrar_pasajero(String nombre, String apellido, String cedula) {
        pasajeroModelo objPasajero = new pasajeroModelo(nombre, apellido, cedula);

        String errorNombre = objPasajero.validarNombre(nombre);
        String errorApellido = objPasajero.validarNombre(apellido);
        String errorCedula = objPasajero.validarCedula(cedula);

        if (errorNombre != null || errorApellido != null || errorCedula != null) {
            StringBuilder mensaje = new StringBuilder("No se pudo registrar el pasajero:\n");
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

        this.ultimoPasajeroRegistrado = objPasajero;

        return "Pasajero registrado correctamente\n"
                + "Nombre: " + objPasajero.getNombrePasajero() + "\n"
                + "Apellido: " + objPasajero.getApellidoPasajero() + "\n"
                + "Cedula: " + objPasajero.getCedulaPasajero();
    }

    public pasajeroModelo getUltimoPasajeroRegistrado() {
        return ultimoPasajeroRegistrado;
    }
}
