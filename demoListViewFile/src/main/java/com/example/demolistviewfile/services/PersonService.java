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

    public void updatePerson(int index, String nombre, String email, String edad) throws IOException {

        validate(nombre, email, edad);
        List<String> listaOriginal=repo.readAllLines();
        List<String> cleanLines = new ArrayList<>();
        for (String line : listaOriginal){
            if (line!=null && !line.isEmpty()){
                cleanLines.add(line); //esta linea esta buena, ya que no es null y tampoco esta en blanco
            }
        }
        cleanLines.set(index, nombre+","+email+","+edad);
        repo.saveFile(cleanLines); //SUSTITUIR LA INFO EN EL ARCHIVO, DEJANDOLO ACTUALIZADO
    }

    public void deletePerson(int index, String nombre, String email, String edad) throws IOException {
        validate(nombre, email, edad);
        List<String> listaOriginal=repo.readAllLines();
        List<String> cleanLines = new ArrayList<>();
        for (String line : listaOriginal){
            if (line!=null && !line.isEmpty()){
                cleanLines.add(line); //esta linea esta buena, ya que no es null y tampoco esta en blanco
            }
        }
        cleanLines.remove(index);
        repo.saveFile(cleanLines); //SUSTITUIR LA INFO EN EL ARCHIVO, DEJANDOLO ACTUALIZADO
    }

    public void addPerson(String name, String email, String edad) throws IOException {
        validate(name, email, edad);
        repo.addNewLine(name+","+email+","+edad);
    }

    private void validate(String name, String email, String edad){
        if(name==null || name.isBlank() || name.length()<3){
            throw new IllegalArgumentException("El nombre es incorrecto");
        }
        String em = (email==null) ? "" : email.trim();
        if (em.isBlank() || !em.contains("@") || !em.contains(".")){
            throw new IllegalArgumentException("El email es invalido");
        }

        try {
            String ed = (edad==null) ? "" : edad.trim();
            int edadValida = Integer.parseInt(ed);
            if (edadValida < 0) throw new IllegalArgumentException("Edad menor a 0");
            if (edadValida < 18) throw new IllegalArgumentException("Menor de 18");
        } catch (Exception e) {
            if (e instanceof NumberFormatException) {
                throw new IllegalArgumentException("Edad no numérica");
            }
            throw e;
        }
    }
}
