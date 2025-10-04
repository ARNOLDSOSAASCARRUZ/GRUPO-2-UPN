package view;

import controller.UsuarioController;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Usuario;

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

    private UsuarioController controller = new UsuarioController();

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
        tablaUsuarios.setItems(javafx.collections.FXCollections.observableArrayList(controller.obtenerUsuarios()));
    }
}