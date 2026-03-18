package com.example.demolistviewfile.controllers;

import com.example.demolistviewfile.services.PersonService;
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
    private Label lblMsg;
    @FXML
    private ListView<String> listView;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEdad;

    private ObservableList<String> data = FXCollections.observableArrayList();
    PersonService service= new PersonService();

    @FXML
    public void initialize(){
        listView.setItems(data);
        listView.getSelectionModel().selectedItemProperty().addListener(
                (obs,oldValue,newValue) ->{
                    if (newValue!=null){
                    String[] parts = newValue.split("-"); //para separar las lineas del csv y editar los campos por separado
                    txtName.setText(parts[0]);
                    txtEmail.setText(parts[1]);
                    txtEdad.setText(parts[2]);
                    }
                }
        );
        loadFromFile();
    }

    @FXML
    public void onAddPerson(){
       try {

           String name = txtName.getText();
           String email = txtEmail.getText();
           String edad = txtEdad.getText();
           service.addPerson(name,email,edad);
           lblMsg.setText("Usuario creado correctamente!");
           lblMsg.setStyle("-fx-text-fill: green");
           txtName.clear();
           txtEmail.clear();
           txtEdad.clear();
           loadFromFile();

       }catch(IOException e){
           lblMsg.setText("Es error de archivo"+ e.getMessage());
           lblMsg.setStyle("-fx-text-fill: red");

       }catch (IllegalArgumentException e){
           lblMsg.setText("Es error de datos"+ e.getMessage());
           lblMsg.setStyle("-fx-text-fill: red");

       }

    }

    @FXML

    public void onUpdate(){
        try{
            int index = listView.getSelectionModel().getSelectedIndex();
            String nombre = txtName.getText();
            String email = txtEmail.getText();
            String edad = txtEdad.getText();
            service.updatePerson(index, nombre, email, edad);
            loadFromFile();
            txtName.clear();
            txtEmail.clear();
            txtEdad.clear();
            lblMsg.setText("Se acutalizo el registro correctamente");
        } catch (IOException e) {
            lblMsg.setText("Hubo un error con el archivo");
        }catch (IllegalArgumentException e ){
            lblMsg.setText("Hubo un error con los datos"+e.getMessage());
        }
    }

    public void onDelete() throws IOException {
        int index = listView.getSelectionModel().getSelectedIndex();
        String nombre = txtName.getText();
        String email = txtEmail.getText();
        String edad = txtEdad.getText();
        service.deletePerson(index, nombre,email, edad);
        loadFromFile();
    }

    @FXML
    public void onReload(){
        loadFromFile();
    }

    private void loadFromFile(){
        try{
            List<String> items = service.loadForListView();
            data.setAll(items);
            lblMsg.setText("Datos cargados correctamente");
            lblMsg.setStyle("-fx-text-fill: green");
        } catch (IOException e) {
            lblMsg.setText("Error: "+e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }
}
