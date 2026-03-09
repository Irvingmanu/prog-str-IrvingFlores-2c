package com.example.demolist.repositories;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PersonFileRepository {

    private final Path pathFile = Paths.get("data" , "persons.csv");

    private void ensureFile() throws IOException {

        if (Files.notExists(pathFile)){
            Files.createFile(pathFile);
        }
    }

    public List<String> readAllLines() throws IOException {
        return Files.readAllLines(pathFile, StandardCharsets.UTF_8);
    }
}