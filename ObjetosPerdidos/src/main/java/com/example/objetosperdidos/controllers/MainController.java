package com.example.objetosperdidos.controllers;

import com.example.objetosperdidos.model.ObjetoPerdido;
import com.example.objetosperdidos.services.ObjetoService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.List;

public class MainController {

    @FXML
    private TextField txtNombre;
    @FXML
    public TextField txtLugar;
    @FXML
    private ComboBox<String> cmbEstado;
    @FXML
    private ListView<String> listView;
    @FXML
    private Label lblMsg;

    private final ObservableList<String> data = FXCollections.observableArrayList();

    ObjetoService service = new ObjetoService();

    String[] estado = {"Sin reclamar", "Entregado"};

    @FXML
    public void initialize() {
        listView.setItems(data);

        cmbEstado.getItems().addAll(estado);

        reload();

        listView.getSelectionModel().selectedItemProperty().addListener((obs, o, n) -> {
            if (n != null){
                String[] p = n.split("-");

                txtNombre.setText(p[0]);
                txtLugar.setText(p[1]);
                cmbEstado.setValue(p[2]);

            }
        });
    }

    @FXML
    public void onAdd(){
        try {
            service.addObjet(txtNombre.getText(), txtLugar.getText(), cmbEstado.getValue());
            reload();
            clear();
        } catch (Exception e) {
            lblMsg.setText(e.getMessage());
        }
    }

    @FXML
    public void onUpdate() {
        try {
            String nombre = txtNombre.getText();
            String lugar = txtLugar.getText();
            String estado = cmbEstado.getValue();

            service.updateObjet(nombre, lugar, estado);

            reload();
            clear();
            lblMsg.setText("Objeto actualizado con éxito");

        } catch (Exception e) {
            lblMsg.setText(e.getMessage());
        }
    }

    @FXML
    public void onDelete() {
        try {
            String nombre = txtNombre.getText();

            // Verificamos rápido que no hayan presionado el botón con la caja vacía
            if (nombre.isBlank()) {
                lblMsg.setText("Escribe el nombre del objeto a eliminar");
                return; // Detenemos la ejecución aquí
            }

            // Mandamos el nombre al servicio para que lo borre
            service.deleteObjet(nombre);

            // Refrescamos y limpiamos
            reload();
            clear();
            lblMsg.setText("Objeto eliminado con éxito");

        } catch (Exception e) {
            lblMsg.setText(e.getMessage());
        }
    }

    @FXML
    public void onSearch() {
        String nombre = txtNombre.getText();

        var c = service.search(nombre);

        if (c != null) {
            txtLugar.setText(c.getLugar());
            cmbEstado.setValue(c.getEstado());
            lblMsg.setText("Objeto encontrado");
        } else {
            lblMsg.setText("No encontrado");
        }
    }

    @FXML
    public void onClear() {
        clear();
    }


    private void reload(){
        List<String> items = service.loadForListView();
        data.setAll(items);
    }

    private void clear() {
        txtNombre.clear();
        txtLugar.clear();
        cmbEstado.setValue(null);
        lblMsg.setText("");
    }

}