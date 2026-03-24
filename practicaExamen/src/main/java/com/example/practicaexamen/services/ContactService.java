package com.example.practicaexamen.services;

import com.example.practicaexamen.model.Contacto;

import java.util.ArrayList;
import java.util.List;

public class ContactService {

    List<Contacto> listaContactos = new ArrayList<>();

    public void agregarContacto(Contacto nuevoContacto){
        validate(nuevoContacto.getNombre(), nuevoContacto.getTelefono(), nuevoContacto.getParentesco());
        Contacto contactoExistente = buscarContacto(nuevoContacto.getNombre());

        if (contactoExistente != null){
            throw new IllegalArgumentException("El contacto ya existe");
        }

        listaContactos.add(nuevoContacto);
    }

    public Contacto buscarContacto(String contactoBuscado){
        for (Contacto contactoActual : listaContactos){
            if (contactoBuscado.equals(contactoActual.getNombre())){
                return contactoActual;
            }
        }
        return null;
    }

    public void eliminarContacto(String nombreBuscado){
        Contacto contactoAEliminar = buscarContacto(nombreBuscado);
        if (contactoAEliminar != null){
            listaContactos.remove(contactoAEliminar);
        }
    }

    public void actualizarContacto(String nombre, Contacto nuevoContacto){
        String nombreLimpio = (nuevoContacto.getNombre() == null) ? "" : nuevoContacto.getNombre().trim();
        nuevoContacto.setNombre(nombreLimpio);
        String telefonoLimpio = (nuevoContacto.getTelefono() == null) ? "" : nuevoContacto.getTelefono().trim();
        nuevoContacto.setTelefono(telefonoLimpio);
        String parentescoLimpio = (nuevoContacto.getParentesco() == null) ? "" : nuevoContacto.getParentesco().trim();
        nuevoContacto.setParentesco(parentescoLimpio);

        validate(nuevoContacto.getNombre(), nuevoContacto.getTelefono(), nuevoContacto.getParentesco());
        Contacto contactoAActualizar = buscarContacto(nombre);

        if (contactoAActualizar != null){
            int posicion = listaContactos.indexOf(contactoAActualizar);
            listaContactos.set(posicion, nuevoContacto);
        }
    }

    public final String[] PARENTESCOS = {"Padre", "Madre", "Hermano", "Hermana", "Abuelo", "Abuela", "Tío", "Tía"};


    private void validate(String nombre, String telefono, String parentesco){
        nombre = (nombre == null) ? "" : nombre.trim();
        telefono = (telefono == null) ? "" : telefono.trim();
        parentesco = (parentesco == null) ? "" : parentesco.trim();

        if(nombre.isBlank() || !nombre.matches("^[A-Za-z]+$") || nombre.length()<3){
            throw new IllegalArgumentException("El nombre es incorrecto");
        }

        if (telefono.isBlank() || !telefono.matches("^[0-9]+$") || telefono.length()!=10 ){
            throw new IllegalArgumentException("El telefono es incorrecto");
        }
        boolean encontrado = false;

        for (String p : PARENTESCOS) {
            if (p.equals(parentesco)) {
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            throw new IllegalArgumentException("El parentesco no es válido");
        }
    }

    public List<String> loadForListView() {
        List<String> listaFormateada = new ArrayList<>();
        for (Contacto c : listaContactos) {
            listaFormateada.add(c.getNombre() + " - " + c.getTelefono() + " (" + c.getParentesco() + ")");
        }
        return listaFormateada;
    }

    public List<Contacto> getListaContactos() {
        return listaContactos;
    }
}
