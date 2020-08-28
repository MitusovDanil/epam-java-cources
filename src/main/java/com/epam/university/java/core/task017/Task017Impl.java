package com.epam.university.java.core.task017;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Task017Impl implements Task017 {
    @Override
    public String formatString(Object... args) {
        return String.format("You know %s, %s!", args[0], args[1]);
    }

    @Override
    public String formatNumbers(Object... args) {
        NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
        nf.setMinimumFractionDigits(2);
        double first = (double) args[0];
        double second = (double) args[0];
        return String.format("%s, %s, +%s, %s",
                first, nf.format(second), nf.format(second), Double.toHexString(first));
    }

    @Override
    public String formatDates(Object... args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.dd.MM");
        return dateFormat.format(args[0]);
    }
}
