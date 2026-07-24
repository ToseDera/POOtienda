package Vista;

import Controlador.frontController;
import Modelo.choferModelo;
import java.util.Scanner;

public class choferVista {

    public void vistaChofer(Scanner sc) {
        choferModelo objChofer = new choferModelo("", "", "");
        boolean exito;

        String nombre;
        do {
            System.out.print("Nombre del chofer: ");
            nombre = sc.nextLine();
            exito = objChofer.setNombreChofer(nombre);
            if (!exito) {
                System.out.println("Error: " + objChofer.getUltimoError());
            }
        } while (!exito);

        String apellido;
        do {
            System.out.print("Apellido del chofer: ");
            apellido = sc.nextLine();
            exito = objChofer.setApellidoChofer(apellido);
            if (!exito) {
                System.out.println("Error: " + objChofer.getUltimoError());
            }
        } while (!exito);

        String cedula;
        do {
            System.out.print("Cédula del chofer: ");
            cedula = sc.nextLine();
            exito = objChofer.setCedulaChofer(cedula);
            if (!exito) {
                System.out.println("Error: " + objChofer.getUltimoError());
            }
        } while (!exito);

        frontController controlador = new frontController();
        String resultado = controlador.datos_registrar_chofer(
                objChofer.getNombreChofer(), objChofer.getApellidoChofer(), objChofer.getCedulaChofer());
        System.out.println(resultado);
    }
}
