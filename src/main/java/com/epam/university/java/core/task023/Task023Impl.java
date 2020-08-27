package com.epam.university.java.core.task023;

import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.stream.Collectors;


public class Task023Impl implements Task023 {
    @Override
    public String extract(String phoneString) {
        String onlyNumbers = new Scanner(phoneString)
                .findAll("\\d")
                .map(MatchResult::group)
                .collect(Collectors.joining());
        if (onlyNumbers.length() < 11) {
            throw new IllegalArgumentException();
        }
        return onlyNumbers.substring(1, 4);
    }
}
