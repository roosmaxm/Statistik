package fi.arcada.codechallenge;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    double[] temps = {4.7, -4.8, -1.8, 0.7, 0.1, -6, -7.8, -7, -3.8, -10.6, -10.3, -0.3, 4.8, 2.6, 0.1, 1.2, -1.5, -2.7, 1.8, 0.2, -2, -5.5, -1.3, 2.1, -0.6, -0.9, 1, -0.5, -1.4, -1.6, -5.3, -7.7, -8.2, -9.5, -3.9, -0.4, 1, 0.8, -0.4, 0.6, 1, -1.5, -0.5, 1.4, 1.5, 1.8, 2, 1.1, -0.1, 0.1, -0.7, -0.4, -3, -6.8, 2, 1.5, -1.3, -0.2, 1.6, 1.9, 1.3, 0.6, -2, -2.4, 0.8, -0.3, -2.5, -2.6, -0.7, 1.8, 1.3, 0.9, 3, 0.7, 0.8, 1.6, 2.5, 2, 6.2};
    LineChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chart = findViewById(R.id.chart);

        displayDataWithMovingAverage(temps, "Temperature", 3);

        System.out.println(Arrays.toString(Statistics.movingAvg(temps, 3)));
    }

    public void displayDataWithMovingAverage(double[] values, String label, int windowSize) {
        List<Entry> entries = new ArrayList<>();
        double[] movingAvg = Statistics.movingAvg(values, windowSize);

        for (int i = 0; i < values.length; i++) {
            entries.add(new Entry(i, (float) values[i]));
        }

        LineDataSet dataSet = new LineDataSet(entries, label);
        dataSet.setColor(Color.RED);
        dataSet.setDrawValues(false);
        dataSet.setDrawCircles(false);

        LineDataSet avgDataSet = new LineDataSet(getMovingAverageEntries(movingAvg), "Moving Average");
        avgDataSet.setColor(Color.BLUE);
        avgDataSet.setDrawValues(false);
        avgDataSet.setDrawCircles(false);

        LineData lineData = new LineData(dataSet, avgDataSet);

        chart.setData(lineData);
        chart.invalidate();
    }

    private List<Entry> getMovingAverageEntries(double[] movingAvg) {
        List<Entry> avgEntries = new ArrayList<>();
        for (int i = 0; i < movingAvg.length; i++) {
            avgEntries.add(new Entry(i, (float) movingAvg[i]));
        }
        return avgEntries;
    }
}
