package util;

import javafx.scene.chart.PieChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

import java.util.Map;

public class ChartGenerator {

    // Genera gráfico de pastel con los kilos reciclados por tipo
    public static PieChart generarGraficoPastel(Map<String, Double> datos) {
        PieChart chart = new PieChart();
        chart.setTitle("Kilos reciclados por tipo");

        for (Map.Entry<String, Double> entry : datos.entrySet()) {
            PieChart.Data slice = new PieChart.Data(entry.getKey(), entry.getValue());
            chart.getData().add(slice);
        }

        return chart;
    }

    // Genera gráfico de barras con los kilos reciclados por tipo
    public static BarChart<String, Number> generarGraficoBarras(Map<String, Double> datos, BarChart<String, Number> chart) {
        chart.setTitle("Kilos reciclados por tipo");

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Materiales");

        for (Map.Entry<String, Double> entry : datos.entrySet()) {
            series.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue()));
        }

        chart.getData().clear();
        chart.getData().add(series);

        return chart;
    }
}