package com.epam.university.java.core.task020;

import java.util.*;
import java.util.stream.Collectors;

public class Task020Impl implements Task020 {
    @Override
    public int calculate(Collection<String> stones) {
        Set<String> allLetters = retrieveLettersFromStrings(stones);
        for (int i = 0; i < stones.size(); i++) {
            allLetters.retainAll(
                    toListOfStringSets(stones).get(i)
            );
        }
        return allLetters.size();
    }

    private Set<String> retrieveLettersFromStrings(Collection<String> stones) {
        return stones
                .stream()
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toSet());
    }

    private List<Set<String>> toListOfStringSets(Collection<String> stones) {
        List<Set<String>> sets = new ArrayList<>();
        for (String s : stones) {
            Set<String> strings = new HashSet<>(
                    Arrays.asList(s.split(""))
            );
            sets.add(strings);
        }
        return sets;
    }
}
