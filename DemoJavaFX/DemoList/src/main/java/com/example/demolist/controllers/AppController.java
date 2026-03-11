package com.example.demolist.controllers;

import com.example.demolist.services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.util.List;

public class AppController {
    @FXML
    private Label lblMsg;
    @FXML
    private ListView<String> listView;

    private ObservableList<String> data = FXCollections.observableArrayList();
    PersonService service = new PersonService();

    @FXML
    public void initialize(){
        listView.setItems(data);
        loadFromFile();
    }


    private void loadFromFile(){
        try {
            List<String> items = service.loadForlistView();
            data.setAll(items);
            lblMsg.setText("Datos cargados correctamente");
            lblMsg.setStyle("-fx-text-fill: green");
        } catch (IOException e) {
            lblMsg.setText("Error: "+e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }


}
