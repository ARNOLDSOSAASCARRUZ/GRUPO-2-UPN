package model;

public class ResumenMaterial {
    private String tipo;
    private double kilos;

    public ResumenMaterial(String tipo, double kilos) {
        this.tipo = tipo;
        this.kilos = kilos;
    }

    public String getTipo() {
        return tipo;
    }

    public double getKilos() {
        return kilos;
    }
}