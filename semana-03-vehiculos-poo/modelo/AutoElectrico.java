package modelo;

public class AutoElectrico extends Auto implements Electrico 
{

    private int nivelBateria;

    public AutoElectrico(String marca, String modelo, int anio, int puertas, int nivelBateria) {
        super(marca, modelo, anio, puertas);
        this.nivelBateria = nivelBateria;
    }

    @Override
    public void acelerar() {
        System.out.println("Auto electrico acelera. Bateria: " + nivelBateria + "%");
    }

    @Override
    public void cargarBateria() {
        nivelBateria = 100;
    }

    @Override
    public int getNivelBateria() {
        return nivelBateria;
    }

    @Override
    public boolean necesitaCarga() {
        return nivelBateria < 20;
    }

    @Override
    public String toString() {
        return "Auto Electrico: " + marca + " " + modelo + " - Bateria " + nivelBateria + "%";
    }
}