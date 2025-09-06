import java.util.Scanner;

public class RegistroUsuario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        System.out.print("Confirme su contraseña: ");
        String confirmarContrasena = scanner.nextLine();

        if (!contrasena.equals(confirmarContrasena)) {
            System.out.println("Error: Las contraseñas no coinciden.");
            return;
        }

        System.out.print("Ingrese su correo electrónico: ");
        String correoElectronico = scanner.nextLine();

        if (!correoElectronico.contains("@")) {
            System.out.println("Error: El correo electrónico debe contener '@'.");
            return;
        }

        System.out.println("Registro exitoso buena. Bienvenido, " + nombreUsuario + "!");
    }
}