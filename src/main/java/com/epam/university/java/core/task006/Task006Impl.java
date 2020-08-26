package com.epam.university.java.core.task006;

import java.util.Collection;

public class Task006Impl implements Task006 {

    double product;
    double squareOfAmperage;
    double avgAmperage;
    double avgVoltage;

    @Override
    public double resistance(Collection<Measurement> measurements) {
        if (measurements == null) {
            throw new IllegalArgumentException();
        }
        avgAmperage = getAvgAmperage(measurements);
        avgVoltage = getAvgVoltage(measurements);

        product = getProductOfAmperageAndVoltage(measurements);
        squareOfAmperage = getSquareOfAmperage(measurements);

        return ((int) ((product / squareOfAmperage) * 1000)) / 1000.0;
    }

    private double getProductOfAmperageAndVoltage(Collection<Measurement> col) {
        double product = 0;

        for (Measurement m : col) {
            product += (m.getAmperage() - avgAmperage) * (m.getVoltage() - avgVoltage);
        }
        return product;
    }

    private double getSquareOfAmperage(Collection<Measurement> col) {
        double squareOfAmperage = 0;
        for (Measurement m : col) {
            squareOfAmperage += Math.pow((m.getAmperage() - avgAmperage), 2);
        }
        return squareOfAmperage;
    }

    private double getAvgAmperage(Collection<Measurement> col) {
        return col
                .stream()
                .mapToDouble(Measurement::getAmperage)
                .sum() / col.size();
    }

    private double getAvgVoltage(Collection<Measurement> col) {
        return col
                .stream()
                .mapToDouble(Measurement::getVoltage)
                .sum() / col.size();
    }
}
