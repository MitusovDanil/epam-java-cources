package com.epam.university.java.core.task001;

public class Task001Impl implements Task001 {

    @Override
    public double addition(String firstNumber, String secondNumber) {
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException();
        }
        if (firstNumber.isEmpty() || secondNumber.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return Double.parseDouble(firstNumber)
                + Double.parseDouble(secondNumber);
    }

    @Override
    public double subtraction(String firstNumber, String secondNumber) {
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException();
        }
        if (firstNumber.isEmpty() || secondNumber.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return Double.parseDouble(firstNumber)
                - Double.parseDouble(secondNumber);
    }

    @Override
    public double multiplication(String firstNumber, String secondNumber) {
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException();
        }
        if (firstNumber.isEmpty() || secondNumber.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return Double.parseDouble(firstNumber)
                * Double.parseDouble(secondNumber);
    }

    @Override
    public double division(String firstNumber, String secondNumber) {
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException();
        }
        if (firstNumber.isEmpty() || secondNumber.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return (Double.parseDouble(firstNumber) + 0.0)
                / Double.parseDouble(secondNumber);
    }
}
