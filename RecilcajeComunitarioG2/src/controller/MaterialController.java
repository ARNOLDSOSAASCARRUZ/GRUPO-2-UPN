package controller;

import model.DBConnection;
import model.Material;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MaterialController {

    // Verifica si el DNI existe en la tabla usuarios
    public boolean dniExiste(String dni) {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE dni = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dni);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (Exception e) {
            System.out.println("❌ Error al verificar DNI: " + e.getMessage());
        }

        return false;
    }

    // Registra el material reciclado
    public boolean registrarMaterial(Material material) {
        String sql = "INSERT INTO materiales (tipo_material, peso_kg, fecha_ingreso, dni_usuario) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, material.getTipoMaterial());
            stmt.setDouble(2, material.getPesoKg());
            stmt.setDate(3, java.sql.Date.valueOf(material.getFechaIngreso()));
            stmt.setString(4, material.getDniUsuario());

            int filas = stmt.executeUpdate();

            if (filas > 0) {
                actualizarPuntos(material.getDniUsuario(), material.getPesoKg());
                return true;
            }

        } catch (Exception e) {
            System.out.println("❌ Error al registrar material: " + e.getMessage());
        }

        return false;
    }

    // Actualiza los puntos del usuario según el peso reciclado
    private void actualizarPuntos(String dni, double pesoKg) {
        int puntosGanados = (int) pesoKg; // 1 punto por kg reciclado

        String sql = "UPDATE usuarios SET puntos = puntos + ? WHERE dni = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, puntosGanados);
            stmt.setString(2, dni);
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("❌ Error al actualizar puntos: " + e.getMessage());
        }
    }
}