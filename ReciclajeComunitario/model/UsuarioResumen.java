package model;

public class UsuarioResumen {
    private String nombre;
    private String dni;
    private String direccion;
    private int puntos;

    public UsuarioResumen(String nombre, String dni, String direccion, int puntos) {
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.puntos = puntos;
    }

    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
    public String getDireccion() { return direccion; }
    public int getPuntos() { return puntos; }
}