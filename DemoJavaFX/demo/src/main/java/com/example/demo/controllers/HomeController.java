package com.example.demo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeController {

    public void onGoToForm(ActionEvent event){

        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/form-view.fxml"));
            Scene fromScene = new Scene(loader.load(), 520, 350);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(fromScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
