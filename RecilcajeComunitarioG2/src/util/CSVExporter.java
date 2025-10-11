package util;

import model.Usuario;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVExporter {

    public static boolean exportarUsuarios(List<Usuario> usuarios, String rutaArchivo) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {

            // Encabezado
            writer.append("Nombre,DNI,Dirección,Puntos\n");

            // Datos
            for (Usuario u : usuarios) {
                writer.append(u.getNombre()).append(",")
                      .append(u.getDni()).append(",")
                      .append(u.getDireccion()).append(",")
                      .append(String.valueOf(u.getPuntos())).append("\n");
            }

            writer.flush();
            return true;

        } catch (IOException e) {
            System.out.println("❌ Error al exportar CSV: " + e.getMessage());
            return false;
        }
    }
}