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

}
