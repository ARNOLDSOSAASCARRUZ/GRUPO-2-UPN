package controller;

import model.DBConnection;
import model.ReporteItem;
import model.Usuario;
import util.CSVExporter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReporteController {

    // ✅ Obtiene todos los usuarios registrados con sus datos
    public List<Usuario> obtenerUsuariosRegistrados() {
        List<Usuario> lista = new ArrayList<>();

        String sql = "SELECT nombre, dni, direccion, puntos FROM usuarios";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setNombre(rs.getString("nombre"));
                u.setDni(rs.getString("dni"));
                u.setDireccion(rs.getString("direccion"));
                u.setPuntos(rs.getInt("puntos"));
                lista.add(u);
            }

            // ✅ Mostrar datos polimórficos en consola
            System.out.println("📋 Usuarios registrados:");
            for (Usuario u : lista) {
                System.out.println(u.mostrarDatos()); // usa el método sobrescrito
            }

        } catch (Exception e) {
            System.out.println("❌ Error al obtener usuarios registrados: " + e.getMessage());
        }

        return lista;
    }

    // ✅ Exporta los usuarios a un archivo CSV
    public boolean exportarUsuariosCSV(String rutaArchivo) {
        List<Usuario> usuarios = obtenerUsuariosRegistrados();
        return CSVExporter.exportarUsuarios(usuarios, rutaArchivo);
    }

    // ✅ Obtiene los datos para llenar la tabla de reporte
    public ObservableList<ReporteItem> obtenerDatosReporte() {
        ObservableList<ReporteItem> lista = FXCollections.observableArrayList();

        String sql = "SELECT u.nombre AS usuario, u.dni, m.tipo_material, m.peso_kg, m.fecha_ingreso " +
                     "FROM usuarios u JOIN materiales m ON u.dni = m.dni_usuario " +
                     "ORDER BY m.fecha_ingreso DESC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String usuario = rs.getString("usuario");
                String dni = rs.getString("dni");
                String material = rs.getString("tipo_material");
                double peso = rs.getDouble("peso_kg");
                String fecha = rs.getString("fecha_ingreso");

                lista.add(new ReporteItem(usuario, dni, material, peso, fecha));
            }

            System.out.println("📄 Registros cargados para reporte: " + lista.size());

        } catch (Exception e) {
            System.out.println("❌ Error al obtener datos del reporte: " + e.getMessage());
        }

        return lista;
    }
}