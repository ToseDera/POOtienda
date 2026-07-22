package Vista;

import Controlador.carroControlador;
import Modelo.carroModelo;
import java.util.Scanner;

public class carroVista {

    public void vistaCarro(Scanner sc) {
        carroModelo objCarro = new carroModelo("", "", "", "");
        boolean exito;

        String placa;
        do {
            System.out.print("Placa del carro (AAA-1234): ");
            placa = sc.nextLine();
            exito = objCarro.setPlacaCarro(placa);
            if (!exito) {
                System.out.println("Error: " + objCarro.getUltimoError());
            }
        } while (!exito);

        String color;
        do {
            System.out.print("Color del carro: ");
            color = sc.nextLine();
            exito = objCarro.setColorCarro(color);
            if (!exito) {
                System.out.println("Error: " + objCarro.getUltimoError());
            }
        } while (!exito);

        String marca;
        do {
            System.out.print("Marca del carro: ");
            marca = sc.nextLine();
            exito = objCarro.setMarcaCarro(marca);
            if (!exito) {
                System.out.println("Error: " + objCarro.getUltimoError());
            }
        } while (!exito);

        String modelo;
        do {
            System.out.print("Modelo (anio) del carro: ");
            modelo = sc.nextLine();
            exito = objCarro.setModeloCarro(modelo);
            if (!exito) {
                System.out.println("Error: " + objCarro.getUltimoError());
            }
        } while (!exito);

        carroControlador controlador = new carroControlador();
        String resultado = controlador.datos_registrar_carro(
                objCarro.getPlacaCarro(), objCarro.getColorCarro(), objCarro.getMarcaCarro(), objCarro.getModeloCarro());
        System.out.println(resultado);
    }
}
