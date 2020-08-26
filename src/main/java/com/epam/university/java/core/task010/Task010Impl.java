package com.epam.university.java.core.task010;

import com.epam.university.java.core.task009.Task009Impl;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Task010Impl implements Task010 {

    Task009Impl helper = new Task009Impl();

    @Override
    public Map<String, Integer> countWordNumbers(File source) {

        Collection<String> uniqString = helper.countWords(source);

        Map<String, Integer> amountOfWordsRepetitions = new HashMap<>();

        for (String s : uniqString) {
            amountOfWordsRepetitions
                    .put(s, Collections.frequency(getWords(source), s));
        }
        return amountOfWordsRepetitions;
    }

    private List<String> getWords(File source) {
        Objects.requireNonNull(source.getName(), "Не указано имя файла");
        URI resourceURI = source.toURI();
        String text = null;
        try {
            text = new String(Files.readAllBytes(Paths.get(resourceURI)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(Arrays.asList(
                text.toLowerCase().split("\\W+"))
        );
    }
}
