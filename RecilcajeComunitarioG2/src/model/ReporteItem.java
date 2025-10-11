package model;

public class ReporteItem {

    private String usuario;
    private String dni;
    private String material;
    private double peso;
    private String fecha;

    public ReporteItem(String usuario, String dni, String material, double peso, String fecha) {
        this.usuario = usuario;
        this.dni = dni;
        this.material = material;
        this.peso = peso;
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getDni() {
        return dni;
    }

    public String getMaterial() {
        return material;
    }

    public double getPeso() {
        return peso;
    }

    public String getFecha() {
        return fecha;
    }
}