package com.epam.university.java.core.task008;

import java.util.ArrayDeque;
import java.util.Deque;

public class Task008Impl implements Task008 {

    @Override
    public boolean isValid(String sourceString) {
        if (sourceString.isEmpty()) {
            return true;
        }
        Deque<Character> characters = new ArrayDeque<>();
        char[] chars = sourceString.toCharArray();
        int count = 0;
        for (char aChar : chars) {
            if (aChar == '[' || aChar == '{' || aChar == '(') {
                characters.addFirst(aChar);
                count++;
            } else if (aChar == '}' && getFirstIsNotEmpty(characters) == '{') {
                characters.poll();
            } else if (aChar == ']' && getFirstIsNotEmpty(characters) == '[') {
                characters.poll();
            } else if (aChar == ')' && getFirstIsNotEmpty(characters) == '(') {
                characters.poll();
            }
        }
        return characters.isEmpty() && count > 0;
    }

    private Character getFirstIsNotEmpty(Deque<Character> ch) {
        Character c = '!';
        if (!ch.isEmpty()) {
            c = ch.getFirst();
        }
        return c;
    }
}
