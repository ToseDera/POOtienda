package Main;

import Modelo.*;

public class tiendaParking {
    public static void main(String[] args) {

        // clase choferModelo
        choferModelo chofer = new choferModelo("Jose", "Garcia", " 1122334455");
        chofer.setNombreChofer("Jose");

        String dato_nombre = chofer.getNombreChofer();
        System.out.println("Nombre chofer: " + dato_nombre);

        // clase carroModelo
        carroModelo carro = new carroModelo("cda-4321", "Rojo", "Chevrolet", "2020");
        carro.setPlacaCarro("cda-4321");
        carro.setColorCarro("Rojo");
        carro.setMarcaCarro("Chevrolet");
        carro.setModeloCarro("2020");

        String dato_placa = carro.getPlacaCarro();
        System.out.println("Placa carro: " + dato_placa);

        // clase motorModelo
        motorModelo motor = new motorModelo("Diesel", "250");
        motor.setTipoMotor("Diesel");
        motor.setCaballosFuerza("250");

        // clase pasajeroModelo
        pasajeroModelo pasajero = new pasajeroModelo("Juan", "Perez", "1198765432");
        pasajero.setNombrePasajero("Juan");
        pasajero.setApellidoPasajero("Perez");
        pasajero.setCedulaPasajero("1198765432");

        String dato_tipo_motor = motor.getTipoMotor();
        System.out.println("Tipo de motor: " + dato_tipo_motor);

        String dato_caballos_fuerza = motor.getCaballosFuerza();
        System.out.println("Caballos de fuerza: " + dato_caballos_fuerza);

    }
}
