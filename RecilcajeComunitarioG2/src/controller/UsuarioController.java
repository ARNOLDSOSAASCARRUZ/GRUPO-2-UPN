package controller;

import model.DBConnection;
import model.Usuario;
import util.DNIValidator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioController {

    // Registra un nuevo usuario si el DNI es válido y no está duplicado
    public boolean registrarUsuario(Usuario usuario) {
        if (!DNIValidator.esValido(usuario.getDni())) {
            System.out.println("❌ DNI inválido: debe tener 8 dígitos numéricos.");
            return false;
        }

        if (dniDuplicado(usuario.getDni())) {
            System.out.println("❌ DNI ya registrado.");
            return false;
        }

        String sql = "INSERT INTO usuarios (nombre, dni, direccion) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getDni());
            stmt.setString(3, usuario.getDireccion());

            int filas = stmt.executeUpdate();
            return filas > 0;

        } catch (Exception e) {
            System.out.println("❌ Error al registrar usuario: " + e.getMessage());
        }

        return false;
    }

    // Verifica si el DNI ya existe en la base de datos
    private boolean dniDuplicado(String dni) {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE dni = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dni);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (Exception e) {
            System.out.println("❌ Error al verificar duplicado de DNI: " + e.getMessage());
        }

        return false;
    }

    // Obtiene todos los usuarios registrados
    public List<Usuario> obtenerUsuarios() {
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

        } catch (Exception e) {
            System.out.println("❌ Error al obtener usuarios: " + e.getMessage());
        }

        return lista;
    }
}