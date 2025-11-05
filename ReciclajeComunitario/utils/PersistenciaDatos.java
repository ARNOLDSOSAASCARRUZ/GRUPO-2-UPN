package utils;

import model.Material;
import model.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaDatos {

    public static void guardarMateriales(List<Material> lista, String archivo) {
        try (FileWriter writer = new FileWriter(archivo)) {
            for (Material m : lista) {
                String nombreUsuario = (m.getUsuario() != null) ? m.getUsuario().getNombre() : "Desconocido";
                writer.write(nombreUsuario + ";" +
                             m.getTipo() + ";" +
                             m.getPeso() + ";" +
                             m.getFecha() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error al guardar materiales: " + e.getMessage());
        }
    }

    public static List<Material> cargarMateriales(String archivo) {
        List<Material> lista = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 4) {
                    Usuario u = new Usuario(partes[0], "DNI", "Dirección"); // puedes mejorar esto
                    Material m = new Material(partes[1], Double.parseDouble(partes[2]), partes[3], u);
                    lista.add(m);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar materiales: " + e.getMessage());
        }
        return lista;
    }
}