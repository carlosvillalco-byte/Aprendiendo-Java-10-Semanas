package modelo;

public class Moto extends Vehiculo
 {

    private boolean tieneSidecar;

    public Moto(String marca, String modelo, int anio, boolean tieneSidecar) {
        super(marca, modelo, anio);
        this.tieneSidecar = tieneSidecar;
    }

    @Override
    public void acelerar() {
        System.out.println("Moto acelera");
    }

    @Override
    public String toString() {
        return "Moto: " + super.toString();
    }
}