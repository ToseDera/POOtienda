package Controlador;

import Modelo.motorModelo;

public class motorControlador {
    private motorModelo ultimoMotorRegistrado;

    public String datos_registrar_motor(String tipoMotor, String caballosFuerza) {
        motorModelo objMotor = new motorModelo(tipoMotor, caballosFuerza);

        String errorTipo = objMotor.validarTipoMotor(tipoMotor);
        String errorCaballos = objMotor.validarCaballosFuerza(caballosFuerza);

        if (errorTipo != null || errorCaballos != null) {
            StringBuilder mensaje = new StringBuilder("No se pudo registrar el motor:\n");
            if (errorTipo != null) {
                mensaje.append("- ").append(errorTipo).append("\n");
            }
            if (errorCaballos != null) {
                mensaje.append("- ").append(errorCaballos).append("\n");
            }
            return mensaje.toString();
        }

        this.ultimoMotorRegistrado = objMotor;

        return "Motor registrado correctamente\n"
                + "Tipo: " + objMotor.getTipoMotor() + "\n"
                + "Caballos de fuerza: " + objMotor.getCaballosFuerza();
    }

    public motorModelo getUltimoMotorRegistrado() {
        return ultimoMotorRegistrado;
    }
}
