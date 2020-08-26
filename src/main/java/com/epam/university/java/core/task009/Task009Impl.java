package com.epam.university.java.core.task009;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Task009Impl implements Task009 {

    @Override
    public Collection<String> countWords(File sourceFile) {
        try {
            String source = readFromFileToString(sourceFile);

            return Stream.of(source.split("[.,:?!;=+]?\\s+"))
                    .map(String::toLowerCase)
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toSet());

        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    private String readFromFileToString(File sourceFile) throws IOException {
        Objects.requireNonNull(sourceFile.getName(), "Не указано имя файла");
        URI resourceURI = sourceFile.toURI();
        return new String(Files.readAllBytes(Paths.get(resourceURI)));
    }
}
