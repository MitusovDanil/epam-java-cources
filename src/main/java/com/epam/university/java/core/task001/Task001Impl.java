package com.epam.university.java.core.task001;

public class Task001Impl implements Task001 {

    @Override
    public double addition(String firstNumber, String secondNumber) {
        ifNullThrowException(firstNumber, secondNumber);
        ifEmptyThrowException(firstNumber, secondNumber);

        return Double.parseDouble(firstNumber)
                + Double.parseDouble(secondNumber);
    }

    @Override
    public double subtraction(String firstNumber, String secondNumber) {
        ifNullThrowException(firstNumber, secondNumber);
        ifEmptyThrowException(firstNumber, secondNumber);

        return Double.parseDouble(firstNumber)
                - Double.parseDouble(secondNumber);
    }

    @Override
    public double multiplication(String firstNumber, String secondNumber) {
        ifNullThrowException(firstNumber, secondNumber);
        ifEmptyThrowException(firstNumber, secondNumber);

        return Double.parseDouble(firstNumber)
                * Double.parseDouble(secondNumber);
    }

    @Override
    public double division(String firstNumber, String secondNumber) {
        ifNullThrowException(firstNumber, secondNumber);
        ifNullThrowException(firstNumber, secondNumber);

        return (Double.parseDouble(firstNumber) + 0.0)
                / Double.parseDouble(secondNumber);
    }

    private static <T> void ifNullThrowException(T first, T second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
    }

    private static void ifEmptyThrowException(String first, String second) {
        if (first.isEmpty() || second.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
