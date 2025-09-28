package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Usuario;
import utils.RepositorioDatos;

public class RegistroController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtDni;
    @FXML private TextField txtDireccion;
    @FXML private Label lblMensaje;

    @FXML
    private void registrarUsuario() {
        String nombre = txtNombre.getText().trim();
        String dni = txtDni.getText().trim();
        String direccion = txtDireccion.getText().trim();

        if (nombre.isEmpty() || dni.isEmpty() || direccion.isEmpty()) {
            lblMensaje.setText("⚠️ Todos los campos son obligatorios.");
            return;
        }

        if (!dni.matches("\\d{8}")) {
            lblMensaje.setText("⚠️ El DNI debe tener 8 dígitos.");
            return;
        }

        Usuario nuevo = new Usuario(nombre, dni, direccion);
        RepositorioDatos.listaUsuarios.add(nuevo); // ✅ Guardar en memoria compartida

        System.out.println("Registrado: " + nuevo.getNombre());
        System.out.println("Total usuarios: " + RepositorioDatos.listaUsuarios.size());

        lblMensaje.setText("✅ Usuario registrado correctamente.");
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtDni.clear();
        txtDireccion.clear();
    }
}