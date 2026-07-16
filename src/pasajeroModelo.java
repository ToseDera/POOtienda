public class pasajeroModelo {
    //Inicializar variables
    public String nombre_pasajero = "";
    public String apellido_pasajero = "";
    public String cedula_pasajero = "";

    //Constructor
    public pasajeroModelo(String dato_nombre, String dato_apellido, String dato_cedula){
        this.nombre_pasajero = dato_nombre;
        this.apellido_pasajero = dato_apellido;
        this.cedula_pasajero = dato_cedula;
    }

    //Getters
    public String getNombre_pasajero() { return nombre_pasajero; }
    public String getApellido_pasajero() { return apellido_pasajero; }
    public String getCedula_pasajero() { return cedula_pasajero; }

    //Setters
    public void setNombre_pasajero(String nombre_pasajero) { this.nombre_pasajero = nombre_pasajero; }
    public void setApellido_pasajero(String apellido_pasajero) { this.apellido_pasajero = apellido_pasajero; }
    public void setCedula_pasajero(String cedula_pasajero) { this.cedula_pasajero = cedula_pasajero; }
}
