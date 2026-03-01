package modelo;

public class MotoElectrica extends Moto implements Electrico 
{

    private int nivelBateria;

    public MotoElectrica(String marca, String modelo, int anio, int nivelBateria) {
        super(marca, modelo, anio, false);
        this.nivelBateria = nivelBateria;
    }

    @Override
    public void acelerar() {
        System.out.println("Moto electrica acelera. Bateria: " + nivelBateria + "%");
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
        return "Moto Electrica: " + marca + " " + modelo + " - Bateria " + nivelBateria + "%";
    }
}