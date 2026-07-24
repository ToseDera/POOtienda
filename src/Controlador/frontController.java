package Controlador;

import Modelo.apiModelo;
import Modelo.carroModelo;
import Modelo.choferModelo;
import Modelo.motorModelo;
import Modelo.pasajeroModelo;

public class frontController {

    private final apiModelo repositorio = new apiModelo();

    private carroModelo ultimoCarroRegistrado;
    private choferModelo ultimoChoferRegistrado;
    private motorModelo ultimoMotorRegistrado;
    private pasajeroModelo ultimoPasajeroRegistrado;

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
        repositorio.guardarCarro(objCarro);

        return "Carro registrado correctamente\n"
                + "Placa: " + objCarro.getPlacaCarro() + "\n"
                + "Color: " + objCarro.getColorCarro() + "\n"
                + "Marca: " + objCarro.getMarcaCarro() + "\n"
                + "Modelo: " + objCarro.getModeloCarro();
    }

    public String datos_registrar_chofer(String nombre, String apellido, String cedula, String licencia) {
        choferModelo objChofer = new choferModelo(nombre, apellido, cedula, licencia);

        String errorNombre = objChofer.validarNombre(nombre);
        String errorApellido = objChofer.validarNombre(apellido);
        String errorCedula = objChofer.validarCedula(cedula);
        String errorLicencia = objChofer.validarLicencia(licencia);

        if (errorNombre != null || errorApellido != null || errorCedula != null || errorLicencia != null) {
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
            if (errorLicencia != null) {
                mensaje.append("- ").append(errorLicencia).append("\n");
            }
            return mensaje.toString();
        }

        this.ultimoChoferRegistrado = objChofer;
        repositorio.guardarChofer(objChofer);

        return "Chofer registrado correctamente\n"
                + "Nombre: " + objChofer.getNombreChofer() + "\n" + "Apellido: " + objChofer.getApellidoChofer() + "\n"
                + "Cédula: " + objChofer.getCedulaChofer() + "\n"
                + "Licencia: " + objChofer.getLicenciaChofer();
    }

    public String datos_registrar_motor(String tipoMotor, String numeroSerie, String caballosFuerza) {
        motorModelo objMotor = new motorModelo(tipoMotor, numeroSerie, caballosFuerza);

        String errorTipo = objMotor.validarTipoMotor(tipoMotor);
        String errorNumeroSerie = objMotor.validarNumeroSerie(numeroSerie);
        String errorCaballosFuerza = objMotor.validarCaballosFuerza(caballosFuerza);

        if (errorTipo != null || errorNumeroSerie != null || errorCaballosFuerza != null) {
            StringBuilder mensaje = new StringBuilder("No se pudo registrar el motor:\n");
            if (errorTipo != null) {
                mensaje.append("- ").append(errorTipo).append("\n");
            }
            if (errorNumeroSerie != null) {
                mensaje.append("- ").append(errorNumeroSerie).append("\n");
            }
            if (errorCaballosFuerza != null) {
                mensaje.append("- ").append(errorCaballosFuerza).append("\n");
            }
            return mensaje.toString();
        }

        this.ultimoMotorRegistrado = objMotor;
        repositorio.guardarMotor(objMotor);

        return "Motor registrado correctamente\n"
                + "Tipo: " + objMotor.getTipoMotor() + "\n"
                + "Número de serie: " + objMotor.getNumeroSerie() + "\n"
                + "Caballos de fuerza: " + objMotor.getCaballosFuerza();
    }

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
        repositorio.guardarPasajero(objPasajero);

        return "Pasajero registrado correctamente\n"
                + "Nombre: " + objPasajero.getNombrePasajero() + "\n"
                + "Apellido: " + objPasajero.getApellidoPasajero() + "\n"
                + "Cédula: " + objPasajero.getCedulaPasajero();
    }

    public carroModelo getUltimoCarroRegistrado() {
        return ultimoCarroRegistrado;
    }

    public choferModelo getUltimoChoferRegistrado() {
        return ultimoChoferRegistrado;
    }

    public motorModelo getUltimoMotorRegistrado() {
        return ultimoMotorRegistrado;
    }

    public pasajeroModelo getUltimoPasajeroRegistrado() {
        return ultimoPasajeroRegistrado;
    }
}
