package view;

import controller.UsuarioController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Usuario;

import java.util.List;

public class VerUsuariosView {

    @FXML
    private TableView<Usuario> tablaUsuarios;

    @FXML
    private TableColumn<Usuario, String> colNombre;

    @FXML
    private TableColumn<Usuario, String> colDni;

    @FXML
    private TableColumn<Usuario, String> colDireccion;

    @FXML
    private TableColumn<Usuario, Integer> colPuntos;

    @FXML
    private Button btnEliminarUsuario;

    @FXML
    private Button btnEditarUsuario;

    @FXML
    private Button btnRefrescar;

    private final UsuarioController controller = new UsuarioController();

    @FXML
    public void initialize() {
        configurarTabla();
        cargarUsuarios();
    }

    private void configurarTabla() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colPuntos.setCellValueFactory(new PropertyValueFactory<>("puntos"));
    }

    private void cargarUsuarios() {
        List<Usuario> usuarios = controller.obtenerUsuarios();
        tablaUsuarios.setItems(FXCollections.observableArrayList(usuarios));
        usuarios.forEach(u -> System.out.println(u.mostrarDatos())); // polimorfismo aplicado
    }

    @FXML
    private void eliminarUsuario() {
        Usuario seleccionado = tablaUsuarios.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("⚠️ Selección requerida", "Debes seleccionar un usuario para eliminar.");
            return;
        }

        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmar eliminación");
        confirmacion.setHeaderText("¿Deseas eliminar al usuario con DNI " + seleccionado.getDni() + "?");
        confirmacion.setContentText("Se eliminarán también sus materiales registrados.");

        confirmacion.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                controller.eliminarMaterialesPorUsuario(seleccionado.getDni().trim()); // ✅ primero elimina materiales
                boolean eliminado = controller.eliminarUsuarioPorDni(seleccionado.getDni().trim());
                if (eliminado) {
                    cargarUsuarios();
                    System.out.println("🗑️ Usuario y materiales eliminados: " + seleccionado.getDni());
                } else {
                    mostrarAlerta("❌ Error", "No se pudo eliminar el usuario. Verifica el DNI.");
                }
            }
        });
    }

    @FXML
    private void editarUsuario() {
        Usuario seleccionado = tablaUsuarios.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("⚠️ Selección requerida", "Debes seleccionar un usuario para editar.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/editar_usuario.fxml"));
            Parent root = loader.load();

            EditarUsuarioView editarController = loader.getController();
            editarController.cargarUsuario(seleccionado);

            Stage stage = new Stage();
            stage.setTitle("Editar Usuario");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("❌ Error", "No se pudo abrir la ventana de edición.");
        }
    }

    @FXML
    private void refrescarTabla() {
        cargarUsuarios();
        System.out.println("🔄 Tabla de usuarios actualizada.");
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}