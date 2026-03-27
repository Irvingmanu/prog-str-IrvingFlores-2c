package com.example.practicaexamen.controllers;

import com.example.practicaexamen.services.ContactService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.util.List;

public class AppController {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtTelefono;
    @FXML private
    ComboBox<String> cmbParentesco;
    @FXML
    private ListView<String> listView;
    @FXML
    private Label lblMsg;

    private final ObservableList<String> data = FXCollections.observableArrayList();

    ContactService service = new ContactService();

    String[] parentescos = {"Padre", "Madre", "Hermano", "Hermana", "Abuelo", "Abuela", "Tío", "Tía"};

    @FXML
    public void initialize() {
        listView.setItems(data);

        cmbParentesco.getItems().addAll(parentescos);

        reload();

        listView.getSelectionModel().selectedItemProperty().addListener((obs, o, n) -> {
            if (n != null) {
                String[] p = n.split("-");
                txtNombre.setText(p[0]);
                txtTelefono.setText(p[1]);
                cmbParentesco.setValue(p[2]);
            }
        });
    }

    @FXML
    public void onAgregar() {
        try {
            service.agregarContacto(txtNombre.getText(), txtTelefono.getText(), cmbParentesco.getValue());
            reload();
            clear();
            lblMsg.setText("Contacto aregado con éxito");

        } catch (Exception e) {
            lblMsg.setText(e.getMessage());
        }
    }

    @FXML
    public void onActualizar() {
        try {
            String nombre = txtNombre.getText();
            String telefono = txtTelefono.getText();
            String parentesco = cmbParentesco.getValue();

            service.actualizarContacto(nombre, telefono, parentesco);

            reload();
            clear();
            lblMsg.setText("Contacto actualizado con exito");

        } catch (Exception e) {
            lblMsg.setText(e.getMessage());
        }
    }

    @FXML
    public void onEliminar() {
        try {
            String nombre = txtNombre.getText();

            if (nombre.isBlank()) {
                lblMsg.setText("No se ha escrito ningun nombre");
                return;
            }

            service.eliminarContacto(nombre);

            reload();
            clear();
            lblMsg.setText("Contacto eliminado con éxito");

        } catch (Exception e) {
            lblMsg.setText(e.getMessage());
        }
    }
    @FXML
    public void onBuscar() {
        String nombre = txtNombre.getText();

        var contacto = service.buscarContacto(nombre);

        if (contacto != null) {
            txtTelefono.setText(contacto.getTelefono());
            cmbParentesco.setValue(contacto.getParentesco());
            lblMsg.setText("contacto encontrado");
        } else {
            lblMsg.setText("Contacto no encontrado");
        }
    }

    @FXML
    public void onLimpiar() {
        clear();
    }

    private void reload() {
        List<String> items = service.loadForListView();
        data.setAll(items);
    }

    private void clear() {
        txtNombre.clear();
        txtTelefono.clear();
        cmbParentesco.setValue(null);
        lblMsg.setText("");
    }
}