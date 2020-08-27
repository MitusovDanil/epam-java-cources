package com.epam.university.java.core.task002;

import java.util.Arrays;


public class Task002Impl implements Task002 {
    @Override
    public boolean isEquals(String firstString, String secondString) {
        ifNullThrowException(firstString, secondString);

        return firstString.equals(secondString);
    }

    @Override
    public String left(String sourceString, int number) {
        if (sourceString == null || number < 0) {
            throw new IllegalArgumentException();
        }
        if (number > sourceString.length()) {
            return sourceString;
        }
        return sourceString.substring(0, number);
    }

    @Override
    public String left(String sourceString, String separator) {
        ifNullThrowException(sourceString, separator);

        return sourceString.split(separator)[0];
    }

    @Override
    public String right(String sourceString, int number) {
        if (sourceString == null || number < 0) {
            throw new IllegalArgumentException();
        }
        if (number > sourceString.length()) {
            return sourceString;
        }
        String spacesFreeString = sourceString
                .replaceFirst("[^A-Za-z]+", "");

        return spacesFreeString
                .substring(number);
    }

    @Override
    public String right(String sourceString, String separator) {
        ifNullThrowException(sourceString, separator);

        String spacesFreeSource = sourceString
                .replaceAll(" ", "");
        String spacesFreeSeparator = separator
                .replaceAll(" ", "");

        if (isSeparatorValid(spacesFreeSource,
                spacesFreeSeparator)) {
            return sourceString;
        }

        return spacesFreeSource
                .split(spacesFreeSeparator)[1];
    }

    @Override
    public String[] split(String sourceString, String split) {
        ifNullThrowException(sourceString, split);
        return sourceString.split(split);
    }

    @Override
    public String join(String[] sourceCollection, String glue) {
        ifNullThrowException(sourceCollection, glue);

        if (sourceCollection.length == 0) {
            throw new IllegalArgumentException();
        }
        if (Arrays.toString(sourceCollection).contains("null")) {
            throw new IllegalArgumentException();
        }
        return String.join(glue, sourceCollection);
    }

    private static <T> void ifNullThrowException(T first, T second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isSeparatorValid(String sourceString, String separator) {
        return !Arrays.asList(sourceString.split(""))
                .contains(separator);
    }
}
