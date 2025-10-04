package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPrincipalView {

    @FXML
    private void abrirRegistroUsuario() {
        abrirVentana("/fxml/registro_usuario.fxml", "Registro de Usuario");
    }

    @FXML
    private void abrirIngresoMaterial() {
        abrirVentana("/fxml/ingreso_material.fxml", "Ingreso de Materiales");
    }

    @FXML
    private void abrirEstadisticas() {
        abrirVentana("/fxml/estadisticas.fxml", "Estadísticas");
    }

    @FXML
    private void abrirReporte() {
        abrirVentana("/fxml/reporte.fxml", "Reporte General");
    }

    @FXML
    private void abrirVerUsuarios() {
        abrirVentana("/fxml/ver_usuarios.fxml", "Usuarios Registrados");
    }

    // ✅ Método reutilizable para abrir ventanas sin cerrar el menú principal
    private void abrirVentana(String rutaFXML, String tituloVentana) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent root = loader.load();
            Stage nuevaVentana = new Stage();
            nuevaVentana.setScene(new Scene(root));
            nuevaVentana.setTitle(tituloVentana);
            nuevaVentana.setResizable(false);
            nuevaVentana.show();
        } catch (IOException e) {
            System.out.println("❌ Error al abrir ventana: " + rutaFXML);
            e.printStackTrace();
        }
    }
}