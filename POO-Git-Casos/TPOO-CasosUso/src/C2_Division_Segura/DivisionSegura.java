package C2_Division_Segura;

import java.util.Scanner;

public class DivisionSegura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Para leer entrada del usuario

        try {
            // Solicitar el primer nÃºmero (dividendo)
            System.out.print("Ingrese el primer número (dividendo): ");
            int dividendo = scanner.nextInt();

            // Solicitar el segundo nÃºmero (divisor)
            System.out.print("Ingrese el segundo número (divisor): ");
            int divisor = scanner.nextInt();

            // Realizar la divisiÃ³n
            int resultado = dividendo / divisor;

            // Mostrar el resultado
            System.out.println("Resultado de la división: " + resultado);

        } catch (ArithmeticException e) {
            // Captura el error si el divisor es cero
            System.out.println(" Error: división entre cero no permitida.");
        } catch (Exception e) {
            // Captura cualquier otro error (por ejemplo, entrada no numÃ©rica)
            System.out.println(" Error: entrada inválida. Ingrese solo números enteros.");
        } finally {
            scanner.close(); // Cierra el recurso Scanner
        }
    }
}
