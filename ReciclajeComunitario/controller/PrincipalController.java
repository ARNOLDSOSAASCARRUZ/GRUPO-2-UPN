package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrincipalController {

    @FXML
    private void abrirRegistro() {
        cargarVista("registro.fxml");
    }

    @FXML
    private void abrirMateriales() {
        cargarVista("materiales.fxml");
    }

    @FXML
    private void abrirEstadisticas() {
        cargarVista("estadisticas.fxml");
    }

    @FXML
    private void abrirReporte() {
        cargarVista("reporte.fxml");
    }
    @FXML
    private void abrirUsuarios() {
    cargarVista("usuarios.fxml");
  }

    private void cargarVista(String fxml) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/" + fxml));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Vista: " + fxml.replace(".fxml", ""));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}