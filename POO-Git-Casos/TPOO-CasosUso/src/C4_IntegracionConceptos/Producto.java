package C4_IntegracionConceptos;

// Clase que representa un producto con nombre, precio y cantidad
public class Producto {
    String nombre;
    double precio;
    int cantidad;

    // Constructor completo
    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Constructor con nombre y precio
    public Producto(String nombre, double precio) {
        this(nombre, precio, 1); // Cantidad por defecto
    }

    // Constructor con solo nombre
    public Producto(String nombre) {
        this(nombre, 0.0, 1); // Precio y cantidad por defecto
    }

    @Override
    public String toString() {
        return " Producto: " + nombre + " | Precio: S/" + precio + " | Cantidad: " + cantidad;
    }
}
