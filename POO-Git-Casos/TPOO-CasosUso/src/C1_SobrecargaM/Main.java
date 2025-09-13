
import java.util.Scanner;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        Calculadora calc = new Calculadora();

        // Solicitar dos enteros
        System.out.println("Ingrese el primer nÃºmero entero:");
        int entero1 = scanner.nextInt();
        System.out.println("Ingrese el segundo nÃºmero entero:");
        int entero2 = scanner.nextInt();
        int resultado1 = calc.sumar(entero1, entero2);
        System.out.println("Resultado de sumar dos enteros: " + resultado1);

        // Solicitar tres enteros
        System.out.println("\nIngrese tres nÃºmeros enteros:");
        int e1 = scanner.nextInt();
        int e2 = scanner.nextInt();
        int e3 = scanner.nextInt();
        int resultado2 = calc.sumar(e1, e2, e3);
        System.out.println("Resultado de sumar tres enteros: " + resultado2);

        // Solicitar dos decimales
        System.out.println("\nIngrese el primer nÃºmero decimal(x.xx):");
        double decimal1 = scanner.nextDouble();
        System.out.println("Ingrese el segundo nÃºmero decimal(x.xx):");
        double decimal2 = scanner.nextDouble();
        double resultado3 = calc.sumar(decimal1, decimal2);
        System.out.println("Resultado de sumar dos decimales: " + resultado3);

        scanner.close();
    }
    
}
