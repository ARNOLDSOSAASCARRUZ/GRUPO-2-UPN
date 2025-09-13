package C4_IntegracionConceptos;

import java.util.Scanner;

// Clase principal que permite al usuario ingresar productos al inventario
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();

        System.out.println("Ingreso de productos al inventario");
        System.out.print("¿Cuántos productos desea registrar? ");
        int cantidad = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= cantidad; i++) {
            System.out.println("\n Producto " + i);
            System.out.println("Seleccione el tipo de ingreso:");
            System.out.println("1. Solo nombre");
            System.out.println("2. Nombre y precio");
            System.out.println("3. Nombre, precio y cantidad");
            System.out.print("OpciÃ³n: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            System.out.print("Nombre del producto: ");
            String nombre = scanner.nextLine();

            switch (opcion) {
                case 1:
                    inventario.agregarProducto(nombre);
                    break;
                case 2:
                    System.out.print("Precio: ");
                    double precio2 = Double.parseDouble(scanner.nextLine());
                    inventario.agregarProducto(nombre, precio2);
                    break;
                case 3:
                    System.out.print("Precio: ");
                    double precio3 = Double.parseDouble(scanner.nextLine());
                    System.out.print("Cantidad: ");
                    int cantidad3 = Integer.parseInt(scanner.nextLine());
                    inventario.agregarProducto(nombre, precio3, cantidad3);
                    break;
                default:
                    System.out.println(" Opción inválida. Producto no registrado.");
            }
        }

        // Mostrar el inventario final
        inventario.mostrarInventario();
        scanner.close();
    }
}
