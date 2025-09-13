package C4_IntegracionConceptos;

// Clase que gestiona el inventario de productos

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> productos = new ArrayList<>();

    // Agregar solo nombre
    public void agregarProducto(String nombre) {
        productos.add(new Producto(nombre));
    }

    // Agregar nombre y precio
    public void agregarProducto(String nombre, double precio) {
        if (precio < 0) {
            System.out.println("Error: el precio no puede ser negativo.");
            return;
        }
        productos.add(new Producto(nombre, precio));
    }

    // Agregar nombre, precio y cantidad
    public void agregarProducto(String nombre, double precio, int cantidad) {
        if (precio < 0 || cantidad < 0) {
            System.out.println(" Error: ni el precio ni la cantidad pueden ser negativos.");
            return;
        }
        productos.add(new Producto(nombre, precio, cantidad));
    }

    // Mostrar todos los productos
    public void mostrarInventario() {
        System.out.println("\n Inventario actual:");
        for (Producto p : productos) {
            System.out.println(p);
        }
    }
}
