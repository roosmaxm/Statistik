package fi.arcada.codechallenge;

import java.util.ArrayList;
import java.util.Collections;

public class Statistics {


    public static double calcStdev(ArrayList<Double> values){
        double mean = Statistics.calcMean(values);
        double sum = 0;
        double varians = 0;
        double dev = 0;

        for(int i = 0; i < values.size(); i++){
            sum += Math.pow((values.get(i) - mean), 2);
        }
        varians = sum / values.size();
        dev = Math.sqrt(varians);
        return dev;
    }
    public static double calcMedian(ArrayList<Double> values){
        ArrayList<Double> sorted = new ArrayList<>(values);
        Collections.sort(sorted);
        int midIndex = sorted.size()/2;
        return sorted.get(midIndex);
    }

    public static double calcMean(ArrayList<Double> values){
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.size();
    }

    public static  double calcLQ(ArrayList<Double> array) {
        ArrayList<Double> sortedArray = new ArrayList<>(array);
        Collections.sort(sortedArray);

        int n = sortedArray.size();
        double lqIndex = 0.25 * (n + 1); // Index of the lower quartile

        if (n % 4 == 0) {
            // If the number of elements is divisible by 4
            return sortedArray.get((int) lqIndex - 1); // Exact value
        } else {
            // If the number of elements is not divisible by 4
            int k = (int) lqIndex;
            double fraction = lqIndex - k;
            double lowerValue = sortedArray.get(k - 1);
            double upperValue = sortedArray.get(k);
            return lowerValue + (upperValue - lowerValue) * fraction; // Interpolate
        }
    }

    public static  double calcUQ(ArrayList<Double> array) {
        ArrayList<Double> sortedArray = new ArrayList<>(array);
        Collections.sort(sortedArray);

        int n = sortedArray.size();
        double uqIndex = 0.75 * (n + 1); // Index of the upper quartile

        if (n % 4 == 0) {
            // If the number of elements is divisible by 4
            return sortedArray.get((int) uqIndex - 1); // Exact value
        } else {
            // If the number of elements is not divisible by 4
            int k = (int) uqIndex;
            double fraction = uqIndex - k;
            double lowerValue = sortedArray.get(k - 1);
            double upperValue = sortedArray.get(k);
            return lowerValue + (upperValue - lowerValue) * fraction; // Interpolate
        }
    }

    public static  double calcIQR(ArrayList<Double> array) {
        double lq = calcLQ(array);
        double uq = calcUQ(array);
        return uq - lq;
    }


}


