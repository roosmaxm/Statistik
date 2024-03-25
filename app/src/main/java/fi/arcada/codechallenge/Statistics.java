package fi.arcada.codechallenge;

public class Statistics {
    public static double calcMean(double[] array){
        double sum = 0;
        for (double value : array) {
            sum += value;
        }
        return sum / array.length;
    }
}
