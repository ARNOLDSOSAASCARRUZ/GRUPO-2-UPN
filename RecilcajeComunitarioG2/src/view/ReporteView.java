package view;

import controller.ReporteController;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import model.ReporteItem;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReporteView {

    @FXML
    private Label lblMensaje;

    @FXML
    private TableView<ReporteItem> tablaReporte;

    @FXML
    private TableColumn<ReporteItem, String> colUsuario;

    @FXML
    private TableColumn<ReporteItem, String> colDni;

    @FXML
    private TableColumn<ReporteItem, String> colMaterial;

    @FXML
    private TableColumn<ReporteItem, Double> colPeso;

    @FXML
    private TableColumn<ReporteItem, String> colFecha;

    private ReporteController controller = new ReporteController();

    @FXML
    public void initialize() {
        configurarTabla();
        cargarDatos();
    }

    private void configurarTabla() {
        colUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        colDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        colMaterial.setCellValueFactory(new PropertyValueFactory<>("material"));
        colPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
    }

    private void cargarDatos() {
        ObservableList<ReporteItem> lista = controller.obtenerDatosReporte();
        tablaReporte.setItems(lista);

        if (lista == null || lista.isEmpty()) {
            lblMensaje.setText("⚠️ No hay datos para mostrar.");
            System.out.println("📄 Tabla de reporte vacía.");
        } else {
            lblMensaje.setText("✅ Datos cargados: " + lista.size());
            System.out.println("📄 Registros en tabla: " + lista.size());
        }
    }

    @FXML
    private void generarReporte(ActionEvent event) {
        try {
            // 📂 Carpeta fija
            String rutaCarpeta = "D:/ReportesReciclajeComunitario";
            File carpeta = new File(rutaCarpeta);
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }

            // 📄 Nombre dinámico con fecha y hora
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String rutaArchivo = rutaCarpeta + "/reporte_" + timestamp + ".csv";

            boolean exito = controller.exportarUsuariosCSV(rutaArchivo);

            if (exito) {
                lblMensaje.setText("✅ Reporte exportado en: " + rutaArchivo);
                System.out.println("✅ Reporte generado en: " + rutaArchivo);
            } else {
                lblMensaje.setText("❌ Error al exportar el reporte.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            lblMensaje.setText("❌ Excepción al generar reporte: " + e.getMessage());
        }
    }
}
