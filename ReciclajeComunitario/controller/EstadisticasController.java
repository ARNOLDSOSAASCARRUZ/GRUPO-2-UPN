package controller;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Material;
import model.Usuario;
import utils.CalculadoraPuntos;
import utils.RepositorioDatos;

import java.util.*;

public class EstadisticasController {

    @FXML private TableView<UsuarioEstadistica> tablaEstadisticas;
    @FXML private TableColumn<UsuarioEstadistica, String> colUsuario;
    @FXML private TableColumn<UsuarioEstadistica, Integer> colPuntos;
    @FXML private BarChart<String, Number> graficoMateriales;

    @FXML
    public void initialize() {
        mostrarEstadisticas();
        mostrarGrafico();
    }

    private void mostrarEstadisticas() {
        Map<Usuario, Integer> puntosPorUsuario = new HashMap<>();
        CalculadoraPuntos calculadora = new CalculadoraPuntos();

        for (Material m : RepositorioDatos.listaMateriales) {
            int puntos = calculadora.calcular(m);
            puntosPorUsuario.merge(m.getUsuario(), puntos, Integer::sum);
        }

        List<UsuarioEstadistica> datos = new ArrayList<>();
        for (Map.Entry<Usuario, Integer> entry : puntosPorUsuario.entrySet()) {
            datos.add(new UsuarioEstadistica(entry.getKey().getNombre(), entry.getValue()));
        }

        colUsuario.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPuntos.setCellValueFactory(new PropertyValueFactory<>("puntos"));
        tablaEstadisticas.getItems().setAll(datos);
    }

    private void mostrarGrafico() {
        Map<String, Double> acumuladoPorTipo = new HashMap<>();

        for (Material m : RepositorioDatos.listaMateriales) {
            acumuladoPorTipo.merge(m.getTipo(), m.getPeso(), Double::sum);
        }

        XYChart.Series<String, Number> serie = new XYChart.Series<>();
        serie.setName("Kg reciclados por tipo");

        for (Map.Entry<String, Double> entry : acumuladoPorTipo.entrySet()) {
            serie.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue()));
        }

        graficoMateriales.getData().clear();
        graficoMateriales.getData().add(serie);
    }

    // Clase interna para mostrar en tabla
    public static class UsuarioEstadistica {
        private String nombre;
        private int puntos;

        public UsuarioEstadistica(String nombre, int puntos) {
            this.nombre = nombre;
            this.puntos = puntos;
        }

        public String getNombre() { return nombre; }
        public int getPuntos() { return puntos; }
    }
}