package com.example.practicaexamen.controllers;

import com.example.practicaexamen.model.Contacto;
import com.example.practicaexamen.services.ContactService;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AppController {

    @FXML
    public void initialize() {
        cmbParentesco.getItems().setAll(service.PARENTESCOS);
    }

    ContactService service = new ContactService();

    @FXML
    public Label lblMsg;
    @FXML
    private ListView<String> lvContactos;
    @FXML
    private ComboBox<String> cmbParentesco;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtTelefono;

    @FXML
    public void onAgregar() {
        try {
            String nombre = txtNombre.getText();
            String telefono = txtTelefono.getText();
            String parentesco = cmbParentesco.getValue();

            Contacto nuevoContacto = new Contacto(nombre, telefono, parentesco);
            service.agregarContacto(nuevoContacto);

            lblMsg.setText("Contacto agregado correctamente");
            lblMsg.setStyle("-fx-text-fill: green");

            limpiarCampos();
            reload();

        } catch (IllegalArgumentException e) {
            lblMsg.setText("Error de datos:" + e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }
    @FXML
    public void onActualizar() {
        try {
            String nombre = txtNombre.getText();
            String telefono = txtTelefono.getText();
            String parentesco = cmbParentesco.getValue();

            Contacto nuevoContacto = new Contacto(nombre, telefono, parentesco);
            service.actualizarContacto(nombre, nuevoContacto);

            lblMsg.setText("contacto actualizado correctamente");
            lblMsg.setStyle("-fx-text-fill: green");

            limpiarCampos();
            reload();
        } catch (IllegalArgumentException e) {
            lblMsg.setText("Error de datos: " + e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }

    }
    @FXML
    public void onBuscar() {
        String nombreBuscado = txtNombre.getText();
        Contacto contactoEncontrado = service.buscarContacto(nombreBuscado);

        if (contactoEncontrado != null) {
            txtTelefono.setText(contactoEncontrado.getTelefono());
            cmbParentesco.setValue(contactoEncontrado.getParentesco());
            lblMsg.setText("contacto encontrado");
            lblMsg.setStyle("-fx-text-fill: green");
        } else {
            lblMsg.setText("El contacto no existe");
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }
    @FXML
    public void onEliminar() {
        try {
            String nombreBuscado = txtNombre.getText();
            service.eliminarContacto(nombreBuscado);
            lblMsg.setText("contacto eliminado correctamente ");
            lblMsg.setStyle("-fx-text-fill: green");

            limpiarCampos();
            reload();

        } catch (IllegalArgumentException e) {
            lblMsg.setText("Error: " + e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");

        }
    }

    @FXML
    private void limpiarCampos() {
        txtNombre.clear();
        txtTelefono.clear();
        cmbParentesco.setValue(null);
    }

    public void reload() {
        lvContactos.getItems().setAll(service.loadForListView());
    }
}