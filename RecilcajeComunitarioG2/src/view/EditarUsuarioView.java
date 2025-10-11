package view;

import controller.UsuarioController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Usuario;

public class EditarUsuarioView {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtDni;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtPuntos;

    @FXML
    private Label lblEstado;

    private UsuarioController controller = new UsuarioController();
    private Usuario usuarioActual;

    public void cargarUsuario(Usuario usuario) {
        this.usuarioActual = usuario;
        txtNombre.setText(usuario.getNombre());
        txtDni.setText(usuario.getDni());
        txtDireccion.setText(usuario.getDireccion());
        txtPuntos.setText(String.valueOf(usuario.getPuntos()));
    }

    @FXML
    private void guardarCambios() {
        if (usuarioActual == null) {
            lblEstado.setText("⚠️ No se ha cargado ningún usuario.");
            return;
        }

        String nombre = txtNombre.getText().trim();
        String dni = txtDni.getText().trim();
        String direccion = txtDireccion.getText().trim();
        String puntosStr = txtPuntos.getText().trim();

        if (nombre.isEmpty() || dni.isEmpty() || direccion.isEmpty() || puntosStr.isEmpty()) {
            lblEstado.setText("⚠️ Todos los campos son obligatorios.");
            return;
        }

        try {
            int puntos = Integer.parseInt(puntosStr);
            usuarioActual.setNombre(nombre);
            usuarioActual.setDni(dni);
            usuarioActual.setDireccion(direccion);
            usuarioActual.setPuntos(puntos);

            controller.actualizarUsuario(usuarioActual);
            lblEstado.setText("✅ Cambios guardados correctamente.");
        } catch (NumberFormatException e) {
            lblEstado.setText("⚠️ Los puntos deben ser un número entero.");
        }
    }

    @FXML
    private void cerrarVentana() {
        Stage stage = (Stage) txtNombre.getScene().getWindow();
        stage.close();
    }
}