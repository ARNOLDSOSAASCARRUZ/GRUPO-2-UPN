package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import model.Material;
import utils.Exportar;
import utils.RepositorioDatos;

public class ReporteController {

    @FXML private TextArea areaVistaPrevia;
    @FXML private Label lblEstado;

    @FXML
    public void initialize() {
        mostrarVistaPrevia();
    }

    private void mostrarVistaPrevia() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario\tTipo\tPeso (kg)\tFecha\n");

        for (Material m : RepositorioDatos.listaMateriales) {
            sb.append(m.getUsuario().getNombre()).append("\t")
              .append(m.getTipo()).append("\t")
              .append(m.getPeso()).append("\t")
              .append(m.getFecha()).append("\n");
        }

        areaVistaPrevia.setText(sb.toString());
    }

    @FXML
    private void exportarReporte() {
        boolean exito = Exportar.exportar(RepositorioDatos.listaMateriales, "reporte_reciclaje.csv");

        if (exito) {
            lblEstado.setText("✅ Reporte exportado correctamente.");
        } else {
            lblEstado.setText("❌ Error al exportar el reporte.");
        }
    }
}