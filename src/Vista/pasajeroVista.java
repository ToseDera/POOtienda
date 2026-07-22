package Vista;

import Controlador.pasajeroControlador;
import Modelo.pasajeroModelo;
import java.util.Scanner;

public class pasajeroVista {

    public void vistaPasajero(Scanner sc) {
        pasajeroModelo objPasajero = new pasajeroModelo("", "", "");
        boolean exito;

        String nombre;
        do {
            System.out.print("Nombre del pasajero: ");
            nombre = sc.nextLine();
            exito = objPasajero.setNombrePasajero(nombre);
            if (!exito) {
                System.out.println("Error: " + objPasajero.getUltimoError());
            }
        } while (!exito);

        String apellido;
        do {
            System.out.print("Apellido del pasajero: ");
            apellido = sc.nextLine();
            exito = objPasajero.setApellidoPasajero(apellido);
            if (!exito) {
                System.out.println("Error: " + objPasajero.getUltimoError());
            }
        } while (!exito);

        String cedula;
        do {
            System.out.print("Cédula del pasajero: ");
            cedula = sc.nextLine();
            exito = objPasajero.setCedulaPasajero(cedula);
            if (!exito) {
                System.out.println("Error: " + objPasajero.getUltimoError());
            }
        } while (!exito);

        pasajeroControlador controlador = new pasajeroControlador();
        String resultado = controlador.datos_registrar_pasajero(
                objPasajero.getNombrePasajero(), objPasajero.getApellidoPasajero(), objPasajero.getCedulaPasajero());
        System.out.println(resultado);
    }
}
