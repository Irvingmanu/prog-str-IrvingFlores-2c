package com.example.demo.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class FormController {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtEdad;

    @FXML
    private Label lblResultado;

    public void onValidate(ActionEvent event){
        String nombre = txtNombre.getText() == null ? "" : txtNombre.getText();
        String email = txtEmail.getText() == null ? "" : txtEmail.getText();
        String edad = txtEdad.getText() == null ? "" : txtEdad.getText();

        List<String> errores = new ArrayList<>();

        //Validacion de campo nombre
        if (nombre.isBlank() || nombre.length()<3){
            errores.add("El nombre ingresado es invalido");
        }
        //Validacion de email
        if (email.isBlank() || !email.contains("@") || !email.contains(".")){
            errores.add("El email es invalido");
        }

        int edadValida = 0;
        edadValida = Integer.parseInt(edad);
        try{
            if (edadValida < 0 || edadValida > 120){
                errores.add("Esta fuera de rango");
            }
        } catch (Exception e) {
            errores.add("Dato no numerico");
        }

        if (errores.isEmpty()){
            lblResultado.setText("El formulario es correcto");
            lblResultado.setStyle("-fx-txt-fill: green");
        } else {
            lblResultado.setText("Error de: "+String.join(",",errores));
            lblResultado.setStyle("-fx-txt-fill: red");
        }

    }
}
