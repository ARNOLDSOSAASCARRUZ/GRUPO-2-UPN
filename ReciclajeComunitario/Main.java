import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import model.Material;
import utils.PersistenciaDatos;
import utils.RepositorioDatos;

import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Cargar materiales desde archivo al iniciar
            List<Material> materialesCargados = PersistenciaDatos.cargarMateriales("materiales.csv");
            RepositorioDatos.listaMateriales.addAll(materialesCargados);

            Parent root = FXMLLoader.load(getClass().getResource("view/principal.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("🌱 Sistema de Reciclaje Comunitario - G2");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            System.err.println("Error al cargar la interfaz principal: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}