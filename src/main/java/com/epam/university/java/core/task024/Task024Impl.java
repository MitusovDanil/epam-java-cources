package com.epam.university.java.core.task024;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class Task024Impl implements Task024 {

    @Override
    public Collection<String> getWordsCount(String source) {
        if (source.isEmpty()) {
            return Collections.emptyList();
        }
        if (source.equals(source.toLowerCase())) {
            return Collections.singleton(source);
        }
        return Arrays.stream(source.split(
                "(?<=\\p{Ll})(?=\\p{Lu})|(?<=\\p{L})(?=\\p{Lu}\\p{Ll})"))
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }
}
