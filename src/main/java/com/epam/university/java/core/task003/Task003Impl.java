package com.epam.university.java.core.task003;

import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Task003Impl implements Task003 {
    @Override
    public String[] invert(String[] source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        Collections.reverse(Arrays.asList(source));
        return source;
    }

    @Override
    public String[] join(String[] first, String[] second) {
        ifNullThrowException(first, second);
        String[] merged = Arrays
                .copyOf(first, first.length + second.length);
        System
                .arraycopy(second, 0, merged, first.length, second.length);

        return merged;
    }

    @Override
    public int findMax(int[] source) {
        if (source == null || source.length == 0) {
            throw new IllegalArgumentException();
        }
        return Arrays.stream(source)
                .max()
                .getAsInt();
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        ifNullThrowException(source, condition);
        return Arrays.stream(source)
                .filter(s -> s.length() > 3)
                .toArray(String[]::new);
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemote) {
        ifNullThrowException(source, toRemote);
        List<String> sourceList = Arrays
                .stream(source)
                .distinct()
                .collect(Collectors.toList());

        sourceList.removeAll(Arrays.asList(toRemote));

        return sourceList.toArray(new String[]{});
    }

    @Override
    public String[] map(String[] source, MappingOperation operation) {
        ifNullThrowException(source, operation);
        return Arrays.stream(source)
                .map(StringBuilder::new)
                .map(StringBuilder::reverse)
                .map(Object::toString)
                .toArray(String[]::new);
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        ifNullThrowException(source, operation);
        return new Scanner(Arrays.toString(source))
                .findAll(Pattern.compile("\\d+"))
                .map(MatchResult::group)
                .map(Integer::parseInt)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .map(Object::toString)
                .toArray(String[]::new);
    }

    private static <T> void ifNullThrowException(T first, T second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
    }
}
