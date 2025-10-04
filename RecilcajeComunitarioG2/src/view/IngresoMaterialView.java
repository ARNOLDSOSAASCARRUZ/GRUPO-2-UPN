package view;

import controller.MaterialController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Material;

import java.time.LocalDate;

public class IngresoMaterialView {

    @FXML
    private ComboBox<String> comboTipoMaterial;

    @FXML
    private TextField txtPesoKg;

    @FXML
    private TextField txtDni;

    @FXML
    private Label lblMensaje;

    private MaterialController controller = new MaterialController();

    @FXML
    public void initialize() {
        comboTipoMaterial.getItems().addAll("Plástico", "Papel", "Vidrio", "Metal", "Orgánico");
        comboTipoMaterial.getSelectionModel().selectFirst();
    }

    @FXML
    private void registrarMaterial() {
        String tipo = comboTipoMaterial.getValue();
        String dni = txtDni.getText().trim();
        String pesoStr = txtPesoKg.getText().trim();

        if (dni.isEmpty() || pesoStr.isEmpty()) {
            lblMensaje.setText("⚠️ DNI y peso son obligatorios.");
            return;
        }

        double peso;
        try {
            peso = Double.parseDouble(pesoStr);
            if (peso <= 0) {
                lblMensaje.setText("⚠️ El peso debe ser mayor a cero.");
                return;
            }
        } catch (NumberFormatException e) {
            lblMensaje.setText("⚠️ Peso inválido. Usa números.");
            return;
        }

        if (!controller.dniExiste(dni)) {
            lblMensaje.setText("❌ DNI no registrado.");
            return;
        }

        Material material = new Material();
        material.setTipoMaterial(tipo);
        material.setPesoKg(peso);
        material.setFechaIngreso(LocalDate.now());
        material.setDniUsuario(dni);

        boolean exito = controller.registrarMaterial(material);

        if (exito) {
            lblMensaje.setText("✅ Material registrado correctamente.");
            txtPesoKg.clear();
        } else {
            lblMensaje.setText("❌ Error al registrar material.");
        }
    }
}