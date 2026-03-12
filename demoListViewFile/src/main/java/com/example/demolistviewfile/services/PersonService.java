package com.example.demolistviewfile.services;

import com.example.demolistviewfile.repositories.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadForListView() throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> result= new ArrayList<>();
        for(String line : lines){
          if(line==null || line.isBlank()) continue;

          String[] parts= line.split(",");
          String name=parts[0];
          String email=parts[1];
          String edad=parts[2];
          result.add(name+"-"+email+"-"+edad);
        }
        return result;
    }

    public void addPerson(String name, String email, String edad) throws IOException {
        validate(name, email, edad);
        repo.addNewLine(name+","+email);
    }
    private void validate(String name, String email, String edad){
        if (name==null || name.isBlank() || name.length()<3){
            throw new IllegalArgumentException("El nombre es incorrecto");
        }
        String em = (email==null) ? " " : email.trim();
        if (em.isBlank() || !em.contains("@") || !em.contains(".")){
            throw new IllegalArgumentException("El email es invalido");
        }

        try{
            int edadValida = Integer.parseInt(edad);
            if (edadValida < 0){
                throw new IllegalArgumentException("La edad no puede ser negativa");
            } else if (edadValida <18){
                throw new IllegalArgumentException("La edad debe ser mayor a 18");
            }
        } catch (Exception e) {
            if (e instanceof NumberFormatException){
                throw new IllegalArgumentException("La edad no es numerica");
            }
            throw e;
        }
    }
}
