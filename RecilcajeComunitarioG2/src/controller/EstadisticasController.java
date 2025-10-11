package controller;

import model.DBConnection;
import model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class EstadisticasController {

    // ✅ Lista de usuarios con puntos acumulados (> 0)
    public ObservableList<Usuario> obtenerUsuariosConPuntos() {
        ObservableList<Usuario> lista = FXCollections.observableArrayList();

        String sql = "SELECT nombre, dni, direccion, puntos FROM usuarios WHERE puntos > 0 ORDER BY puntos DESC";

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

            System.out.println("📊 Usuarios con puntos cargados: " + lista.size());

            // ✅ Mostrar datos polimórficos en consola
            for (Usuario u : lista) {
                System.out.println(u.mostrarDatos()); // usa el método sobrescrito
            }

        } catch (Exception e) {
            System.out.println("❌ Error al obtener usuarios con puntos: " + e.getMessage());
        }

        return lista;
    }

    // ✅ Mapa de tipo_material → total kilos reciclados
    public Map<String, Double> obtenerKilosPorTipo() {
        Map<String, Double> mapa = new HashMap<>();

        String sql = "SELECT tipo_material, SUM(peso_kg) AS total_kg FROM materiales GROUP BY tipo_material";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String tipo = rs.getString("tipo_material");
                double kilos = rs.getDouble("total_kg");
                mapa.put(tipo, kilos);
            }

            System.out.println("📉 Tipos de materiales cargados: " + mapa.size());

        } catch (Exception e) {
            System.out.println("❌ Error al obtener kilos por tipo: " + e.getMessage());
        }

        return mapa;
    }
}