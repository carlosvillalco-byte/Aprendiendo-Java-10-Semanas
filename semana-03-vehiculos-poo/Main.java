import java.util.ArrayList;
import modelo.*;
import servicio.GestorVehiculos;

public class Main
 {

    public static void main(String[] args) {

        // =====================================
        // DEMOSTRACION DE POLIMORFISMO
        // =====================================
        System.out.println("== DEMOSTRACION DE POLIMORFISMO ==");

        ArrayList<Vehiculo> flota = new ArrayList<>();

        flota.add(new Auto("Toyota", "Corolla", 2024, 4));
        flota.add(new Moto("Honda", "CB500", 2023, false));
        flota.add(new Camion("Volvo", "FH16", 2022, 24.0));
        flota.add(new AutoElectrico("Tesla", "Model 3", 2024, 4, 80));
        flota.add(new MotoElectrica("NIU", "NQi", 2023, 60));

        // Un solo recorrido: polimorfismo
        for (Vehiculo v : flota) {
            v.acelerar();
        }

        // =====================================
        // GESTION DE VEHICULOS (MENU)
        // =====================================
        GestorVehiculos gestor = new GestorVehiculos();
        gestor.menu();
    }
}