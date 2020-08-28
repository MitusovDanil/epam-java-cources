package com.epam.university.java.core.task007;

import java.util.ArrayList;
import java.util.Collection;


public class Task007Impl implements Task007 {
    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first, Collection<Integer> second) {
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Integer> first1 = new ArrayList<>(first);
        ArrayList<Integer> second2 = new ArrayList<>(second);
        int sum = first.size() + second.size();
        for (int i = 0; i < sum; i++) {
            array.add(i, 0);
        }

        for (int i = 0; i < first.size(); i++) {

            for (int j = 0; j < second.size(); j++) {

                array.set(i + j, (first1.get(i) * second2.get(j)) + array.get(i + j));
            }
        }
        array.remove(array.size() - 1);
        return array;
    }
}
