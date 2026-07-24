package Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class apiModelo {

    // Inicializar variables
    // Campos de conexión a la base de datos: no son necesarios por el momento, se dejan comentados para retomarlos más adelante
    // public String name = "";
    // public String url = "";
    // public String password = "";
    private int usuariosConectados = 0;
    private int minUsuariosActivos = 0;
    String ultimoError = null;

    // Estructuras temporales: guardan los registros validados antes de enviarlos a la base de datos
    private final List<carroModelo> carrosGuardados = new ArrayList<>();
    private final List<choferModelo> choferesGuardados = new ArrayList<>();
    private final List<motorModelo> motoresGuardados = new ArrayList<>();
    private final List<pasajeroModelo> pasajerosGuardados = new ArrayList<>();

    // Constructor
    public apiModelo() {
    }

    // Guardado temporal: el Encargado de BD valida que el registro esté completo antes de confirmarlo
    public boolean guardarCarro(carroModelo carro) {
        if (carro == null || !carro.esValido()) {
            return false;
        }
        return carrosGuardados.add(carro);
    }

    public boolean guardarChofer(choferModelo chofer) {
        if (chofer == null || !chofer.esValido()) {
            return false;
        }
        return choferesGuardados.add(chofer);
    }

    public boolean guardarMotor(motorModelo motor) {
        if (motor == null || !motor.esValido()) {
            return false;
        }
        return motoresGuardados.add(motor);
    }

    public boolean guardarPasajero(pasajeroModelo pasajero) {
        if (pasajero == null || !pasajero.esValido()) {
            return false;
        }
        return pasajerosGuardados.add(pasajero);
    }

    public List<carroModelo> getCarrosGuardados() {
        return Collections.unmodifiableList(carrosGuardados);
    }

    public List<choferModelo> getChoferesGuardados() {
        return Collections.unmodifiableList(choferesGuardados);
    }

    public List<motorModelo> getMotoresGuardados() {
        return Collections.unmodifiableList(motoresGuardados);
    }

    public List<pasajeroModelo> getPasajerosGuardados() {
        return Collections.unmodifiableList(pasajerosGuardados);
    }

    // public apiModelo(String datoName, String datoUrl, String datoPassword) {
    //     setName(datoName);
    //     setUrl(datoUrl);
    //     setPassword(datoPassword);
    // }

    // Getters
    // public String getName() {
    //     return name;
    // }

    // public String getUrl() {
    //     return url;
    // }

    // public String getPassword() {
    //     return password;
    // }

    public String getUltimoError() {
        return ultimoError;
    }

    public int getUsuariosConectados() {
        return usuariosConectados;
    }

    public int getMinUsuariosActivos() {
        return minUsuariosActivos;
    }

    // Setters
    // public boolean setName(String name) {
    //     String error = validarName(name);
    //     if (error != null) {
    //         this.ultimoError = error;
    //         return false;
    //     }
    //     this.name = name;
    //     this.ultimoError = null;
    //     return true;
    // }

    // public boolean setUrl(String url) {
    //     String error = validarUrl(url);
    //     if (error != null) {
    //         this.ultimoError = error;
    //         return false;
    //     }
    //     this.url = url;
    //     this.ultimoError = null;
    //     return true;
    // }

    // public boolean setPassword(String password) {
    //     String error = validarPassword(password);
    //     if (error != null) {
    //         this.ultimoError = error;
    //         return false;
    //     }
    //     this.password = password;
    //     this.ultimoError = null;
    //     return true;
    // }

    public boolean setMinUsuariosActivos(int minUsuariosActivos) {
        String error = validarMinUsuariosActivos(minUsuariosActivos);
        if (error != null) {
            this.ultimoError = error;
            return false;
        }
        this.minUsuariosActivos = minUsuariosActivos;
        this.ultimoError = null;
        return true;
    }

    // Validaciones: devuelven el mensaje de error, o null si el dato es válido
    // public String validarName(String name) {
    //     if (name == null || name.trim().isEmpty()) {
    //         return "El nombre de la API no puede estar vacío";
    //     }
    //     return null;
    // }

    // public String validarUrl(String url) {
    //     if (url == null || url.trim().isEmpty()) {
    //         return "La URL no puede estar vacía";
    //     }
    //     if (!url.trim().matches("^https?://[\\w.-]+(:\\d+)?(/.*)?$")) {
    //         return "La URL debe tener un formato válido (http:// o https://)";
    //     }
    //     return null;
    // }

    // public String validarPassword(String password) {
    //     if (password == null || password.isEmpty()) {
    //         return "La contraseña no puede estar vacía";
    //     }
    //     if (password.length() < 6) {
    //         return "La contraseña debe tener al menos 6 caracteres";
    //     }
    //     return null;
    // }

    public String validarMinUsuariosActivos(int minUsuariosActivos) {
        if (minUsuariosActivos < 0) {
            return "El mínimo de usuarios activos no puede ser negativo";
        }
        return null;
    }

    // Valida que la api tenga todos sus datos correctos
    // public boolean esValido() {
    //     return validarName(name) == null
    //             && validarUrl(url) == null
    //             && validarPassword(password) == null
    //             && validarMinUsuariosActivos(minUsuariosActivos) == null;
    // }

    // Métodos
    // public Boolean validarConexion() {
    //     return esValido();
    // }

    // Valida usuarios conectados
    public Boolean validarDesconexion() {
        return this.usuariosConectados < this.minUsuariosActivos;
    }

    // Desconexión si aplica
    public void desconexion() {
        if (validarDesconexion()) {
            this.usuariosConectados = 0;
        }
    }

    // Registra la conexión de un usuario
    public void conectarUsuario() {
        this.usuariosConectados++;
    }

    // Registra la desconexión de un usuario puntual (no confundir con desconexion() masiva)
    public boolean desconectarUsuario() {
        if (this.usuariosConectados <= 0) {
            this.ultimoError = "No hay usuarios conectados para desconectar";
            return false;
        }
        this.usuariosConectados--;
        desconexion();
        return true;
    }
}
