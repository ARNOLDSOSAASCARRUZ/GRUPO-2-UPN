package model;

public class Usuario extends Persona {
    private int id;
    private int puntos;

    // Constructor vacío
    public Usuario() {
        super();
    }

    // Constructor completo
    public Usuario(int id, String nombre, String dni, String direccion, int puntos) {
        super(nombre, dni, direccion); // hereda atributos de Persona
        this.id = id;
        this.puntos = puntos;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    // ✅ Polimorfismo: sobrescribe mostrarDatos()
    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + " | ID: " + id + " | Puntos: " + puntos;
    }
}