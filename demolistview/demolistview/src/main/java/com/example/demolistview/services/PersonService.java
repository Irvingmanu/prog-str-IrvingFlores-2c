package com.example.demolistview.services;

import com.example.demolistview.repositories.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    private PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadDataforList() throws IOException {
        List<String> lines = repo.readAllLines(); //Recupera las líneas del archivo
        List<String> result = new ArrayList<>(); //el listado de resultado con el formato deseado

        for (String line : lines) {
            if (line == null || line.isBlank()) continue; //Ignora las líneas nulas

            String[] parts = line.split(",", -1);
            String name = parts[0].trim(); //Obtiene el nombre del arreglo
            String correo = parts[1].trim(); //Obtiene el correo del arreglo

            result.add(name + "-" + correo); //Se agrega a la lista de resultados con el formato deseado
        }

        return result;
    }

    public void addPerson(String name, String email) throws IOException {
        validatePerson(name, email);
        String nameNoComa= name.replace(",","");
        String emailNoComa= email.replace(",","");
        repo.appendNewLine(nameNoComa+","+emailNoComa);
    }

    private void validatePerson(String name, String email){

        if(name==null || name.isBlank() || name.length()<3){
            throw new IllegalArgumentException("El nombre no cumple con los standares");
        }
        String em= (email==null) ? "" : email.trim();
        if(em.isBlank()|| !em.contains("@") || ! em.contains(".")){
            throw new IllegalArgumentException("El correo es incorrecto");
        }

    }
}