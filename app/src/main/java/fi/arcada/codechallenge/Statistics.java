package fi.arcada.codechallenge;

import java.util.ArrayList;
import java.util.Collections;

public class Statistics {

    public static double[] movingAvg(double[] values, int windowSize) {
        double[] sma = new double[values.length];

        for (int i = 0; i < values.length; i++) {
            if (i >= windowSize - 1) {
                double sum = 0;
                for (int j = i - windowSize + 1; j <= i; j++) {
                    sum += values[j];
                }
                double avg = sum / windowSize;

                sma[i] = avg;
            } else {
                double sum = 0;
                for (int j = 0; j <= i; j++) {
                    sum += values[j];
                }
                double avg = sum / (i + 1);
                sma[i] = avg;
            }
        }
        return sma;
    }
}
