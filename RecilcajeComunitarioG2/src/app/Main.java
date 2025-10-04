package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // ✅ Carga del archivo FXML desde /fxml/
            URL fxmlUrl = getClass().getResource("/fxml/menu_principal.fxml");
            if (fxmlUrl == null) {
                throw new RuntimeException("No se encontró menu_principal.fxml en /fxml/");
            }

            Parent root = FXMLLoader.load(fxmlUrl);
            Scene scene = new Scene(root);

            // ✅ Carga del archivo CSS desde /styles/
            URL cssUrl = getClass().getResource("/styles/app.css");
            if (cssUrl != null) {
                scene.getStylesheets().add(cssUrl.toExternalForm());
            } else {
                System.out.println("⚠️ app.css no encontrado en /styles/. Se cargará sin estilos.");
            }

            // ✅ Configuración de la ventana principal
            primaryStage.setTitle("Sistema de Reciclaje Comunitario - G2");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();

        } catch (Exception e) {
            System.out.println("❌ Error al cargar la interfaz principal: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}