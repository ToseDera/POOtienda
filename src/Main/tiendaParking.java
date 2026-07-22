package Main;

import Vista.carroVista;
import Vista.choferVista;
import Vista.motorVista;
import Vista.pasajeroVista;
import java.util.Scanner;

public class tiendaParking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n--- Menú Parking ---");
            System.out.println("1. Registrar chofer");
            System.out.println("2. Registrar carro");
            System.out.println("3. Registrar motor");
            System.out.println("4. Registrar pasajero");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            String entrada = sc.nextLine();
            try {
                opcion = Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida");
                continue;
            }

            switch (opcion) {
                case 1:
                    new choferVista().vistaChofer(sc);
                    break;
                case 2:
                    new carroVista().vistaCarro(sc);
                    break;
                case 3:
                    new motorVista().vistaMotor(sc);
                    break;
                case 4:
                    new pasajeroVista().vistaPasajero(sc);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

        sc.close();
    }
}
