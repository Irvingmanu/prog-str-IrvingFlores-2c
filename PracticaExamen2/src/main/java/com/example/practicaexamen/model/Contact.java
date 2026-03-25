package com.example.practicaexamen.model;

public class Contact {
    // Atributos de cada contacto
    private String nombre;
    private String telefono;
    private String parentesco;

    // Constructor: Se usa para crear un nuevo contacto con sus datos iniciales
    public Contact(String nombre, String telefono, String parentesco){
        this.nombre = nombre;
        this.telefono = telefono;
        this.parentesco = parentesco;
    }

    // Getters y Setters: Métodos para leer (get) y modificar (set) los datos
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getParentesco() { return parentesco; }
    public void setParentesco(String parentesco) { this.parentesco = parentesco; }
}