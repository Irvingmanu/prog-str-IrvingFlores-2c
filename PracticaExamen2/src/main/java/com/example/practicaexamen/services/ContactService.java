package com.example.practicaexamen.services;

import com.example.practicaexamen.model.Contact;
import java.util.ArrayList;
import java.util.List;

public class ContactService {

    // REGLA 2 y 6: Aquí se guardan los contactos.
    // Al ser un ArrayList, solo vive en la memoria mientras el programa está abierto.
    private List<Contact> lista = new ArrayList<>();

    // Este método transforma nuestra lista de objetos 'Contact' en una lista de Textos (Strings)
    // para que el ListView de la pantalla los pueda mostrar fácilmente.
    public List<String> loadForListView(){
        List<String> result = new ArrayList<>();
        for (Contact contact : lista){
            // Une los datos con guiones: Ejemplo: "Irving-1234567890-Hermano"
            result.add(contact.getNombre() + "-" + contact.getTelefono() + "-" + contact.getParentesco());
        }
        return result;
    }

    // OPERACIÓN: AGREGAR
    public void addContact(String nombre, String telefono, String parentesco){
        // 1. Valida que los datos sean correctos (que no estén vacíos, etc.)
        validate(nombre, telefono, parentesco);

        // 2. Verifica que no exista un contacto con el mismo nombre (Regla de validación 5)
        for (Contact contacto : lista){
            if (contacto.getNombre().equalsIgnoreCase(nombre)){
                throw new IllegalArgumentException("Nombre repetido"); // Detiene el proceso y lanza error
            }
        }
        // 3. Si todo está bien, crea el objeto y lo añade a la memoria
        lista.add(new Contact(nombre, telefono, parentesco));
    }

    // OPERACIÓN: ACTUALIZAR POR NOMBRE
    public void updateContact(String nombre, String telefono, String parentesco) {
        // 1. Validamos que los datos que intentan guardar sean correctos
        validate(nombre, telefono, parentesco);

        // 2. Buscamos el contacto usando el método que ya tienes creado
        Contact contactoExistente = search(nombre);

        // 3. Si lo encuentra, actualiza sus datos
        if (contactoExistente != null) {
            // El nombre no lo cambiamos porque es el que usamos para buscarlo
            contactoExistente.setTelefono(telefono);
            contactoExistente.setParentesco(parentesco);
        } else {
            // Si no lo encuentra, lanzamos un error para que la pantalla lo muestre
            throw new IllegalArgumentException("Contacto no encontrado para actualizar");
        }
    }

    // OPERACIÓN: ELIMINAR POR NOMBRE
    public void deleteContact(String nombre) {
        // 1. Buscamos el contacto por su nombre
        Contact contactoExistente = search(nombre);

        // 2. Si lo encuentra, lo borramos de la lista
        if (contactoExistente != null) {
            lista.remove(contactoExistente);
        } else {
            throw new IllegalArgumentException("Contacto no encontrado para eliminar");
        }
    }

    // OPERACIÓN: BUSCAR
    public Contact search(String nombre) {
        // Recorre todos los contactos guardados
        for (Contact contacto : lista) {
            // Si el nombre coincide (ignorando mayúsculas/minúsculas), lo devuelve
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                return contacto;
            }
        }
        return null; // Si termina de buscar y no hay nada, regresa nulo
    }

    // VALIDACIONES
    public void validate(String nombre, String telefono, String parentesco){
        // Valida que el nombre no esté vacío
        if (nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("Nombre vacío");
        }
        // Valida que el nombre solo tenga letras
        if (!nombre.matches("^[A-Za-z]+$")){
            throw new IllegalArgumentException("No contiene solo letras");
        }
        // Valida que el teléfono tenga exactamente 10 dígitos (Regla de validación 3)
        if (telefono == null || !telefono.matches("^[0-9]{10}$")){
            throw new IllegalArgumentException("Teléfono incorrecto");
        }
        // Valida que se haya seleccionado un parentesco (Regla de validación 4)
        if (parentesco == null || parentesco.isBlank()){
            throw new IllegalArgumentException("Parentesco no seleccionado");
        }
    }
}