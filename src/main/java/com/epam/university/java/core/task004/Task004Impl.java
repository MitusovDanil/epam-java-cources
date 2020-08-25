package com.epam.university.java.core.task004;

import java.util.*;

public class Task004Impl implements Task004 {
    @Override
    public String[] intersection(String[] first, String[] second) {
        if (isNullable(first, second)) {
            throw new IllegalArgumentException();
        }

        Set<String> firstSet =
                new LinkedHashSet<>(Arrays.asList(first));
        Set<String> secondSet =
                new LinkedHashSet<>(Arrays.asList(second));

        firstSet.addAll(secondSet);

        secondSet.retainAll(Arrays.asList(first));

        return secondSet.toArray(new String[]{});
    }

    @Override
    public String[] union(String[] first, String[] second) {
        if (isNullable(first, second)) {
            throw new IllegalArgumentException();
        }

        Set<String> firstSet =
                new LinkedHashSet<>(Arrays.asList(first));
        Set<String> secondSet =
                new LinkedHashSet<>(Arrays.asList(second));

        firstSet.addAll(secondSet);

        return firstSet.toArray(new String[]{});
    }

    private static <T> boolean isNullable(T first, T second) {
        return (first == null) || (second == null);
    }
}
