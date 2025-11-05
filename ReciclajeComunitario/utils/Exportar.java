package utils;

import model.Material;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Exportar {

    public static boolean exportar(List<Material> lista, String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write("Usuario,Tipo,Peso (kg),Fecha\n");

            for (Material m : lista) {
                writer.write(m.getUsuario().getNombre() + "," +
                             m.getTipo() + "," +
                             m.getPeso() + "," +
                             m.getFecha() + "\n");
            }

            return true;
        } catch (IOException e) {
            System.err.println("Error al exportar: " + e.getMessage());
            return false;
        }
    }
}