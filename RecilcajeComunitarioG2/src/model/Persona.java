package model;

public class Persona {
    private String nombre;
    private String dni;
    private String direccion;

    public Persona() {}

    public Persona(String nombre, String dni, String direccion) {
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
    }

    // Getters y Setters
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

    // ✅ Método base para polimorfismo
    public String mostrarDatos() {
        return "Nombre: " + nombre + " | DNI: " + dni + " | Dirección: " + direccion;
    }
}