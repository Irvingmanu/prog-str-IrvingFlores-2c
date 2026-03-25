package com.example.objetosperdidos.services;

import com.example.objetosperdidos.model.ObjetoPerdido;

import java.util.ArrayList;
import java.util.List;

public class ObjetoService {
    private List<ObjetoPerdido> lista = new ArrayList<>();

    public List<String> loadForListView(){
        List<String> result = new ArrayList<>();
        for (ObjetoPerdido objetoPerdido : lista){
            // Une los datos con guiones: Ejemplo: "Irving-1234567890-Hermano"
            result.add(objetoPerdido.getNombre() + "-" + objetoPerdido.getLugar() + "-" + objetoPerdido.getEstado());
        }
        return result;
    }

    public void addObjet(String nombre, String lugar, String estado){
        validate(nombre, lugar, estado);

        for (ObjetoPerdido objetoPerdido: lista){
            if (objetoPerdido.getNombre().equalsIgnoreCase(nombre)){
                throw new IllegalArgumentException("el nombre esta repetido");
            }
        }

        lista.add(new ObjetoPerdido(nombre, lugar, estado));
    }
    public void updateObjet(String nombre, String lugar, String estado){
        validate(nombre, lugar, estado);

        ObjetoPerdido objetoExistente = search(nombre);

        if (objetoExistente != null){
            objetoExistente.setLugar(lugar);
            objetoExistente.setEstado(estado);
        } else {
            throw new IllegalArgumentException("El objeto no se encontro");
        }
    }

    public void deleteObjet(String nombre){
        ObjetoPerdido objetoExistente = search(nombre);

        if (objetoExistente != null){
            lista.remove(objetoExistente);
        } else {
            throw new IllegalArgumentException("No se encontro el objeto para eliminar");
        }
    }

    public ObjetoPerdido search(String nombre){
        for (ObjetoPerdido objetoPerdido : lista){
            if (objetoPerdido.getNombre().equalsIgnoreCase(nombre)){
                return objetoPerdido;
            }
        }
        return null;
    }

    public void validate(String nombre, String lugar, String estado){
        if (nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("Nombre vacio");
        }

        if (!nombre.matches("^[A-Za-z]+$")){
            throw new IllegalArgumentException("No contiene solo letras");
        }

        if (lugar == null || lugar.isBlank()){
            throw new IllegalArgumentException("Lugar vacio");
        }

        if (!lugar.matches("^[A-Za-z0-9]+$")){
            throw new IllegalArgumentException("No contiene solo letras");
        }

        if (estado == null || estado.isBlank()){
            throw new IllegalArgumentException("estado no seleccionado");
        }
    }
}
