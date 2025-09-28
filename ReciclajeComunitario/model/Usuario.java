package model;

import javafx.beans.property.SimpleStringProperty;

public class Usuario {
    private final SimpleStringProperty nombre;
    private final SimpleStringProperty dni;
    private final SimpleStringProperty direccion;

    public Usuario(String nombre, String dni, String direccion) {
        this.nombre = new SimpleStringProperty(nombre);
        this.dni = new SimpleStringProperty(dni);
        this.direccion = new SimpleStringProperty(direccion);
    }

    // Getters compatibles con JavaFX TableView
    public String getNombre() { return nombre.get(); }
    public String getDni() { return dni.get(); }
    public String getDireccion() { return direccion.get(); }

    // Setters si necesitas modificar los datos
    public void setNombre(String nombre) { this.nombre.set(nombre); }
    public void setDni(String dni) { this.dni.set(dni); }
    public void setDireccion(String direccion) { this.direccion.set(direccion); }

    // Método auxiliar para mostrar resumen
    public String resumen() {
        return getNombre() + " (DNI: " + getDni() + ")";
    }
}