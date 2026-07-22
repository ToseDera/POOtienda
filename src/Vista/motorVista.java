package Vista;

import Controlador.motorControlador;
import Modelo.motorModelo;
import java.util.Scanner;

public class motorVista {

    public void vistaMotor(Scanner sc) {
        motorModelo objMotor = new motorModelo("", "");
        boolean exito;

        String tipoMotor;
        do {
            System.out.print("Tipo de motor (Gasolina, Diesel, Electrico, Hibrido, Gas): ");
            tipoMotor = sc.nextLine();
            exito = objMotor.setTipoMotor(tipoMotor);
            if (!exito) {
                System.out.println("Error: " + objMotor.getUltimoError());
            }
        } while (!exito);

        String caballosFuerza;
        do {
            System.out.print("Caballos de fuerza: ");
            caballosFuerza = sc.nextLine();
            exito = objMotor.setCaballosFuerza(caballosFuerza);
            if (!exito) {
                System.out.println("Error: " + objMotor.getUltimoError());
            }
        } while (!exito);

        motorControlador controlador = new motorControlador();
        String resultado = controlador.datos_registrar_motor(objMotor.getTipoMotor(), objMotor.getCaballosFuerza());
        System.out.println(resultado);
    }
}
