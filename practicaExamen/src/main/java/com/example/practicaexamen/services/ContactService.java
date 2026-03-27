package com.example.practicaexamen.services;

import com.example.practicaexamen.model.Contacto;

import java.util.ArrayList;
import java.util.List;

public class ContactService {

    private List<Contacto> lista = new ArrayList<>();

    public List<String> loadForListView(){
        List<String> result = new ArrayList<>();
        for (Contacto contacto : lista){
            result.add(contacto.getNombre() + "-" + contacto.getTelefono() + "-" + contacto.getParentesco());
        }
        return result;
    }

    public void agregarContacto(String nombre, String telefono, String parentesco){
        validar(nombre, telefono, parentesco);

        for (Contacto contacto : lista){
            if (contacto.getNombre().equalsIgnoreCase(nombre)){
                throw new IllegalArgumentException("El nombre esta repetido");
            }
        }
        lista.add(new Contacto(nombre, telefono, parentesco));
    }

    public void actualizarContacto(String nombre, String telefono, String parentesco){
        validar(nombre, telefono, parentesco);

        Contacto contactoAActualizar = buscarContacto(nombre);

        if (contactoAActualizar != null){
            contactoAActualizar.setTelefono(telefono);
            contactoAActualizar.setParentesco(parentesco);
        } else {
            throw new IllegalArgumentException("Contacto no encontrado para actualizar");
        }
    }

    public void eliminarContacto(String nombreBuscado){

        Contacto contactoAEliminar = buscarContacto(nombreBuscado);

        if (contactoAEliminar != null){
            lista.remove(contactoAEliminar);
        } else {
            throw new IllegalArgumentException("Contacto no encontrado para eliminar");
        }
    }

    public Contacto buscarContacto(String contactoBuscado){
        for (Contacto contactoActual : lista){
            if (contactoBuscado.equals(contactoActual.getNombre())){
                return contactoActual;
            }
        }
        return null;
    }

    private void validar(String nombre, String telefono, String parentesco){
        if (nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("El nombre esta vacío");
        }

        if (!nombre.matches("^[A-Za-z]+$")){
            throw new IllegalArgumentException("Solo se permiten letras en el nombre");
        }

        if (telefono == null || !telefono.matches("^[0-9]{10}$")){
            throw new IllegalArgumentException("El telefono solo debe contener numeros y debe tener 10");
        }

        if (parentesco == null || parentesco.isBlank()){
            throw new IllegalArgumentException("El parentesco se ha seleccionado");
        }
    }
}
