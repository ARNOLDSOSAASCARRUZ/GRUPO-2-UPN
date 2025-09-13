package C3_CoArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaEstudiantes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> estudiantes = new ArrayList<>();

        // Solicitar al usuario ingresar al menos 5 nombres
        System.out.println("Ingrese nombres de 5 estudiantes:");
        for (int i = 1; i <= 5; i++) {
            System.out.print("Estudiante " + i + ": ");
            String nombre = scanner.nextLine();
            estudiantes.add(nombre);
        }

        // Mostrar la lista completa
        System.out.println("\nLista completa de estudiantes:");
        for (String nombre : estudiantes) {
            System.out.println("- " + nombre);
        }

        // Eliminar el tercer nombre (Ã­ndice 2)
        if (estudiantes.size() >= 3) {
            String eliminado = estudiantes.remove(2);
            System.out.println("\nSe eliminÃ³ el tercer estudiante: " + eliminado);
        }

        // Mostrar la lista actualizada
        System.out.println("\nLista actualizada de estudiantes:");
        for (String nombre : estudiantes) {
            System.out.println("- " + nombre);
        }

        scanner.close();
    }
}
