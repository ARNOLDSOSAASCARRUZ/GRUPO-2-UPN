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

        String sql = "INSERT INTO usuarios (nombre, dni, direccion, puntos) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getDni());
            stmt.setString(3, usuario.getDireccion());
            stmt.setInt(4, usuario.getPuntos());

            int filas = stmt.executeUpdate();
            System.out.println("✅ Usuario registrado. Filas insertadas: " + filas);
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

            stmt.setString(1, dni.trim());
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

    // Elimina todos los materiales asociados al usuario
    public void eliminarMaterialesPorUsuario(String dni) {
        String sql = "DELETE FROM materiales WHERE dni_usuario = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dni.trim());
            int filas = stmt.executeUpdate();
            System.out.println("🧹 Materiales eliminados: " + filas);

        } catch (Exception e) {
            System.out.println("❌ Error al eliminar materiales: " + e.getMessage());
        }
    }

    // Elimina un usuario por DNI (después de eliminar sus materiales)
    public boolean eliminarUsuarioPorDni(String dni) {
        eliminarMaterialesPorUsuario(dni); // ✅ primero elimina los materiales

        String sql = "DELETE FROM usuarios WHERE dni = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dni.trim());
            int filas = stmt.executeUpdate();
            System.out.println("🗑️ Usuario eliminado. Filas afectadas: " + filas);
            return filas > 0;

        } catch (Exception e) {
            System.out.println("❌ Error al eliminar usuario: " + e.getMessage());
        }

        return false;
    }

    // Actualiza los datos de un usuario
    public boolean actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, direccion = ?, puntos = ? WHERE dni = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getDireccion());
            stmt.setInt(3, usuario.getPuntos());
            stmt.setString(4, usuario.getDni());

            int filas = stmt.executeUpdate();
            System.out.println("✏️ Filas actualizadas: " + filas);
            return filas > 0;

        } catch (Exception e) {
            System.out.println("❌ Error al actualizar usuario: " + e.getMessage());
        }

        return false;
    }
}