package model;

public class Punto {
    private Usuario usuario;
    private int cantidad;

    public Punto(Usuario usuario, int cantidad) {
        this.usuario = usuario;
        this.cantidad = cantidad;
    }

    // Getters y setters
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    // Método auxiliar para sumar puntos
    public void agregarPuntos(int puntos) {
        this.cantidad += puntos;
    }
}