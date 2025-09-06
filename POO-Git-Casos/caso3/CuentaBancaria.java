import java.util.Scanner;

public class CuentaBancaria {
    // Atributos privados
    private String titular;
    private double saldo;

    // Constructor
    public CuentaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // Método para depositar
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("✅ Depósito exitoso. Nuevo saldo: S/ " + saldo);
        } else {
            System.out.println("⚠️ El monto debe ser mayor que cero.");
        }
    }

    // Método para retirar con validación
    public void retirar(double monto) {
        if (monto > saldo) {
            System.out.println("❌ Fondos insuficientes. Saldo disponible: S/ " + saldo);
        } else if (monto <= 0) {
            System.out.println("⚠️ El monto debe ser mayor que cero.");
        } else {
            saldo -= monto;
            System.out.println("✅ Retiro exitoso. Nuevo saldo: S/ " + saldo);
        }
    }

    // Método para mostrar datos
    public void mostrarDatos() {
        System.out.println("\n📋 Titular: " + titular);
        System.out.println("💰 Saldo actual: S/ " + saldo);
    }

    // Método main para interacción con Scanner
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ingreso de datos
        System.out.print("Ingrese el nombre del titular: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        CuentaBancaria cuenta = new CuentaBancaria(nombre, saldoInicial);
        cuenta.mostrarDatos();

        // Operaciones
        System.out.print("\nIngrese monto a depositar: ");
        double deposito = scanner.nextDouble();
        cuenta.depositar(deposito);

        System.out.print("\nIngrese monto a retirar: ");
        double retiro = scanner.nextDouble();
        cuenta.retirar(retiro);

        cuenta.mostrarDatos();
        scanner.close();
    }
}