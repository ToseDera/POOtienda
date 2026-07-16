package Modelo;

public class apiModelo {

    // Inicializar variables
    public String name = "";
    public String url = "";
    public String password = "";
    public int usuariosConectados;
    public int minUsuariosActivos;

    // Constructor
    public apiModelo(String datoName, String datoUrl, String datoPassword) {
        this.name = datoName;
        this.url = datoUrl;
        this.password = datoPassword;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMinUsuariosActivos(int minUsuariosActivos) {
        this.minUsuariosActivos = minUsuariosActivos;
    }

    // Metodos
    public Boolean validarConexion() {
        Boolean respuesta = true;

        if (this.name == "" || this.url == "" || this.password == "") {
            respuesta = false;
        }

        return respuesta;
    }

    // Valida usuarios conectados
    public Boolean validarDesconexion() {
        return this.usuariosConectados < this.minUsuariosActivos;
    }

    // Desconexion si aplica
    public void desconexion() {
        if (validarDesconexion()) {
            this.usuariosConectados = 0;
        }
    }
}
