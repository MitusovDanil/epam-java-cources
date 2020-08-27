package com.epam.university.java.core.task005;

public class Task005Impl implements Task005 {


    @Override
    public PiHolder findPi(int digits) {

        if (digits <= 0 || digits > 10) {
            throw new IllegalArgumentException();
        }
        int beginning = (int) Math.pow(10, digits - 1);
        int ending = (int) Math.pow(10, digits) - 1;
        int firstDigit = 0;
        int secondDigit = 0;
        double minClosestValue = 1;

        for (int i = (int) (beginning * Math.PI); i <= ending; i++) {
            for (int j = i / 4; j <= i / 3; j++) {
                double temp = Math.abs(((double) i / (double) j) - Math.PI);
                if (temp < minClosestValue) {
                    minClosestValue = temp;
                    firstDigit = i;
                    secondDigit = j;
                }
            }
        }
        return new PiHolderImpl(firstDigit, secondDigit);
    }
}
