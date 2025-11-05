package utils;

import model.Material;
import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDatos {

    public static List<Usuario> listaUsuarios = new ArrayList<>();
    public static List<Material> listaMateriales = new ArrayList<>();

    // Método auxiliar para depuración
    public static void imprimirUsuariosRegistrados() {
        System.out.println("🧾 Usuarios registrados:");
        for (Usuario u : listaUsuarios) {
            System.out.println("- " + u.getNombre() + " | DNI: " + u.getDni() + " | Dirección: " + u.getDireccion());
        }
    }

    public static void imprimirMaterialesRegistrados() {
        System.out.println("♻️ Materiales registrados:");
        for (Material m : listaMateriales) {
            System.out.println("- " + m.getTipo() + " | " + m.getPeso() + "kg | " + m.getFecha() + " | Usuario: " + m.getUsuario().getNombre());
        }
    }
}