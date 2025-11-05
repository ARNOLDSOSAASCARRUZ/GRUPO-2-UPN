package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Material;
import model.Usuario;
import utils.RepositorioDatos;

import java.time.LocalDate;

public class MaterialesController {

    @FXML private ComboBox<String> cmbTipoMaterial;
    @FXML private TextField txtPeso;
    @FXML private DatePicker dpFecha;
    @FXML private TextField txtDniUsuario;
    @FXML private Label lblMensaje;

    @FXML
    public void initialize() {
        cmbTipoMaterial.getItems().addAll("Plástico", "Papel", "Vidrio", "Metal", "Orgánico");
    }

    @FXML
    private void registrarMaterial() {
        String tipo = cmbTipoMaterial.getValue();
        String pesoTexto = txtPeso.getText().trim();
        LocalDate fecha = dpFecha.getValue();
        String dni = txtDniUsuario.getText().trim();

        if (tipo == null || tipo.trim().isEmpty() || pesoTexto.isEmpty() || fecha == null || dni.isEmpty()) {
            lblMensaje.setText("⚠️ Todos los campos son obligatorios.");
            return;
        }

        double peso;
        try {
            peso = Double.parseDouble(pesoTexto);
        } catch (NumberFormatException e) {
            lblMensaje.setText("⚠️ El peso debe ser un número válido.");
            return;
        }

        // Validar que el DNI exista en la lista de usuarios registrados
        Usuario usuarioReal = RepositorioDatos.listaUsuarios.stream()
            .filter(u -> u.getDni().equals(dni))
            .findFirst()
            .orElse(null);

        if (usuarioReal == null) {
            lblMensaje.setText("❌ El DNI ingresado no corresponde a ningún usuario registrado.");
            return;
        }

        Material nuevo = new Material(tipo, peso, fecha, usuarioReal);
        RepositorioDatos.listaMateriales.add(nuevo);

        System.out.println("📦 Material registrado: " + nuevo.resumen());
        System.out.println("🔗 Vinculado a usuario: " + usuarioReal.resumen());
        System.out.println("📘 Bitácora: Material de tipo '" + tipo + "' con " + peso + "kg registrado por " + usuarioReal.getNombre() + " el " + fecha);

        lblMensaje.setText("✅ Material registrado correctamente. Puntos asignados: " + (int)(peso * 10));
        limpiarCampos();
    }

    private void limpiarCampos() {
        cmbTipoMaterial.getSelectionModel().clearSelection();
        txtPeso.clear();
        dpFecha.setValue(null);
        txtDniUsuario.clear();
    }
}