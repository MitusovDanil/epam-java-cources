package com.epam.university.java.core.task022;

import com.epam.university.java.core.task022.Task022;

import java.util.Collection;
import java.util.Comparator;

public class Task022Impl implements Task022 {
    @Override
    public int maxSum(Collection<Integer> numbers) {
        int sum = numbers
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
        int min = numbers
                .stream()
                .min(Comparator.naturalOrder())
                .get();
        return sum - min;
    }

    @Override
    public int minSum(Collection<Integer> numbers) {
        int sum = numbers
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
        int max = numbers
                .stream()
                .max(Comparator.naturalOrder())
                .get();
        return sum - max;
    }
}
