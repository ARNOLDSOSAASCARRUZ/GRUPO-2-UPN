import java.util.Scanner;

public class Estudiante {
    // Atributos privados
    private String nombre;
    private int edad;
    private String dni;

    // Constructor
    public Estudiante(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    // Métodos get
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDni() {
        return dni;
    }

    // Métodos set
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    // Método main para crear y mostrar un estudiante
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar datos al usuario
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la edad del estudiante: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        System.out.print("Ingrese el DNI del estudiante: ");
        String dni = scanner.nextLine();

        // Crear objeto Estudiante
        Estudiante estudiante = new Estudiante(nombre, edad, dni);

                // Mostrar datos usando getters
                System.out.println("Nombre: " + estudiante.getNombre());
                System.out.println("Edad: " + estudiante.getEdad());
                System.out.println("DNI: " + estudiante.getDni());
            }
        }