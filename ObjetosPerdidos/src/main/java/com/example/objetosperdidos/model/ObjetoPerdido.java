package com.example.objetosperdidos.model;

public class ObjetoPerdido {
    private String nombre;
    private String lugar;
    private String estado;

    public ObjetoPerdido(String nombre, String lugar, String estado){
        this.nombre = nombre;
        this.lugar = lugar;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
