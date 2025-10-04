package model;

public class Usuario {

    private int id;
    private String nombre;
    private String dni;
    private String direccion;
    private int puntos;

    // Constructor vacío
    public Usuario() {}

    // Constructor completo
    public Usuario(int id, String nombre, String dni, String direccion, int puntos) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.puntos = puntos;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}