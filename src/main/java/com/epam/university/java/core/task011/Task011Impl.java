package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


public class Task011Impl implements Task011 {

    @Override
    public String getLastName(String[] collection) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(collection));
        return getLastName(list);
    }

    @Override
    public String getLastName(ArrayList<String> collection) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException();
        }
        if (collection.size() == 1) {
            return collection.get(0);
        }
        int removingIndex = -1;
        while (collection.size() > 1) {
            removingIndex = (removingIndex + 1) % collection.size();
            collection.remove(removingIndex);
        }
        return collection.get(0);
    }

    @Override
    public String getLastName(LinkedList<String> collection) {
        ArrayList<String> list = new ArrayList<>(collection);
        return getLastName(list);
    }
}
