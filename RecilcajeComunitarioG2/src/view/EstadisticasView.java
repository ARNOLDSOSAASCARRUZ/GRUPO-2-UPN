package view;

import controller.EstadisticasController;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Usuario;
import util.ChartGenerator;

import java.util.Map;

public class EstadisticasView {

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
    private PieChart graficoKilos;

    @FXML
    private Label lblEstadoTabla;

    private EstadisticasController controller = new EstadisticasController();

    @FXML
    public void initialize() {
        configurarTabla();
        cargarDatosTabla();
        cargarGrafico();
    }

    private void configurarTabla() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colPuntos.setCellValueFactory(new PropertyValueFactory<>("puntos"));
    }

    private void cargarDatosTabla() {
        ObservableList<Usuario> usuarios = controller.obtenerUsuariosConPuntos();
        tablaUsuarios.setItems(usuarios);

        if (usuarios == null || usuarios.isEmpty()) {
            lblEstadoTabla.setText("⚠️ No hay usuarios registrados con puntos.");
            System.out.println("📊 Tabla vacía: no se encontraron usuarios con puntos.");
        } else {
            lblEstadoTabla.setText("✅ Usuarios cargados: " + usuarios.size());
            System.out.println("📊 Usuarios cargados en tabla: " + usuarios.size());
        }
    }

    private void cargarGrafico() {
        Map<String, Double> datos = controller.obtenerKilosPorTipo();

        if (datos == null || datos.isEmpty()) {
            graficoKilos.setTitle("⚠️ Sin datos de materiales");
            graficoKilos.setData(null);
            System.out.println("📉 Gráfico vacío: no se encontraron kilos por tipo.");
        } else {
            PieChart chart = ChartGenerator.generarGraficoPastel(datos);
            graficoKilos.setData(chart.getData());
            graficoKilos.setTitle(chart.getTitle());
            System.out.println("📉 Gráfico generado con " + datos.size() + " tipos de materiales.");
        }
    }
}