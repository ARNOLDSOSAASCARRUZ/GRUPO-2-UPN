package view;

import controller.UsuarioController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import model.Usuario;

import java.io.IOException;

public class RegistroUsuarioView {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtDni;

    @FXML
    private TextField txtDireccion;

    @FXML
    private Label lblMensaje;

    private UsuarioController controller = new UsuarioController();

    @FXML
    private void registrarUsuario() {
        String nombre = txtNombre.getText().trim();
        String dni = txtDni.getText().trim();
        String direccion = txtDireccion.getText().trim();

        if (nombre.isEmpty() || dni.isEmpty() || direccion.isEmpty()) {
            lblMensaje.setText("⚠️ Todos los campos son obligatorios.");
            return;
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setDni(dni);
        usuario.setDireccion(direccion);

        boolean exito = controller.registrarUsuario(usuario);

        if (exito) {
            lblMensaje.setText("✅ Usuario registrado correctamente.");
            txtNombre.clear();
            txtDni.clear();
            txtDireccion.clear();
        } else {
            lblMensaje.setText("❌ No se pudo registrar el usuario.");
        }
    }

    @FXML
    private void volverAlMenu(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/menu_principal.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Menú Principal");
            stage.show();
        } catch (IOException e) {
            System.out.println("❌ Error al volver al menú principal");
            e.printStackTrace();
        }
    }
}