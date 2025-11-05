package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.UsuarioResumen;
import model.Usuario;
import model.Material;
import utils.RepositorioDatos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UsuariosController {

    @FXML private TableView<UsuarioResumen> tablaUsuarios;
    @FXML private TableColumn<UsuarioResumen, String> colNombre;
    @FXML private TableColumn<UsuarioResumen, String> colDni;
    @FXML private TableColumn<UsuarioResumen, String> colDireccion;
    @FXML private TableColumn<UsuarioResumen, Integer> colPuntos;

    @FXML
    public void initialize() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colPuntos.setCellValueFactory(new PropertyValueFactory<>("puntos"));

        ObservableList<UsuarioResumen> resumenes = FXCollections.observableArrayList();

        for (Usuario u : RepositorioDatos.listaUsuarios) {
            int puntos = 0;
            for (Material m : RepositorioDatos.listaMateriales) {
                if (m.getUsuario().getDni().equals(u.getDni())) {
                    puntos += (int) (m.getPeso() * 10); // regla de puntos: 1kg = 10 puntos
                }
            }
            resumenes.add(new UsuarioResumen(u.getNombre(), u.getDni(), u.getDireccion(), puntos));
        }

        tablaUsuarios.setItems(resumenes);
        tablaUsuarios.refresh();
    }
}