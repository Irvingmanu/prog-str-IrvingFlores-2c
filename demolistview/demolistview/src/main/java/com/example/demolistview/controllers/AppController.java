package com.example.demolistview.controllers;

import com.example.demolistview.services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class AppController {

    @FXML
    private ListView<String> listView;

    @FXML
    private Label lblMsg;

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtEmail;



    // Se mantiene como final para proteger la referencia de la lista observable
    private final ObservableList<String> data = FXCollections.observableArrayList();

    private PersonService service = new PersonService();

    /**
     * El método initialize se ejecuta automáticamente después de que el FXML
     * ha sido cargado y los elementos @FXML han sido inyectados.
     */
    @FXML
    public void initialize() {
        // Vincula la lista de datos con el componente visual ListView
        if (listView != null) {
            listView.setItems(data);
        }

        // Carga los datos iniciales al arrancar la aplicación
        loadFromFile();
    }
    @FXML
    public void onAddPerson() {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();

            service.addPerson(name, email);

            lblMsg.setText("Persona agregada con éxito");
            lblMsg.setStyle("-fx-text-fill: green");

            txtName.clear();
            txtEmail.clear();
            loadFromFile();
        } catch (IOException e) {
            lblMsg.setText("hubo un error con el archivo");
            lblMsg.setStyle("-fx-text-fill: red");
        } catch(IllegalArgumentException ex){
            lblMsg.setText("hubo un error con los datos");
            lblMsg.setStyle("-fx-text-fill: red");

        }


    }
    /**
     * Intenta cargar los datos desde el servicio y actualiza la interfaz.
     * Se marca como @FXML para que pueda ser llamado desde un botón en el FXML.
     */
    @FXML
    private void loadFromFile() {
        try {
            // Obtenemos la lista desde el servicio
            List<String> items = service.loadDataforList();

            // Actualizamos la lista observable (esto refresca el ListView automáticamente)
            if (items != null) {
                data.setAll(items);
            }

            // Feedback visual de éxito
            if (lblMsg != null) {
                lblMsg.setText("Datos cargados exitosamente");
                lblMsg.setStyle("-fx-text-fill: green;");
            }

        } catch (IOException e) {
            // Manejo de error si el archivo no existe o no se puede leer
            if (lblMsg != null) {
                lblMsg.setText("Error: " + e.getMessage());
                lblMsg.setStyle("-fx-text-fill: red;");
            }

            // Imprimir el error en consola para depuración
            e.printStackTrace();
        }
    }
}