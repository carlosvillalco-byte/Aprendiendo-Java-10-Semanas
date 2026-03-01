package modelo;

public class Camion extends Vehiculo 
{

    private double cargaToneladas;

    public Camion(String marca, String modelo, int anio, double cargaToneladas) {
        super(marca, modelo, anio);
        this.cargaToneladas = cargaToneladas;
    }

    @Override
    public void acelerar() {
        System.out.println("Camion acelera");
    }

    @Override
    public String toString() {
        return "Camion: " + super.toString() + " - " + cargaToneladas + " toneladas";
    }
}