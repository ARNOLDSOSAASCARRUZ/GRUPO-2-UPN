package C5_MultiplesExcep;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Ingrese un nÃºmero entero: ");
            String entrada = sc.nextLine();  // leer como texto

            int numero = Integer.parseInt(entrada);  // puede lanzar NumberFormatException

            if (numero < 0) {
                throw new NumNegativoExcep("Error: No se permiten nÃºmeros negativos.");
            }

            System.out.println("NÃºmero ingresado correctamente: " + numero);

        } catch (NumberFormatException e) {
            System.out.println("Error: El valor ingresado no es un nÃºmero entero vÃ¡lido.");
        } catch (NumNegativoExcep e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
            System.out.println("Programa finalizado.");
        }
    }
}
