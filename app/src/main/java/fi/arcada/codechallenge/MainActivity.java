package fi.arcada.codechallenge;

import static fi.arcada.codechallenge.Statistics.calcMean;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView outputText;
    EditText inputText;
    String[] names = {"Max", "Oliver", "Ben", "Alva", "Netta", "Olivia", "Morris", "Benjamin"};
    double [] testData = {12, 3, 53.2 ,7, 65, 55, 43, 21};
    ArrayList<DataItem> dataItems = new ArrayList<>();
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputText = findViewById(R.id.outText);
        inputText = findViewById(R.id.inputText);
        result = findViewById(R.id.result);

        //Vi fyller vår arraylist med värdena från testData
        for (int i = 0; i < testData.length; i++){
            dataItems.add(new DataItem(names[i], testData[i]));
        }


        outputText.setText("Min app fungerar");
//Hej

    }
    public void buttonHandler(View view){
        outputText.setText(inputText.getText().toString());
    }
    @SuppressLint("DefaultLocale")
    public void calculator(View view){
        ArrayList<Double> values = new ArrayList<>();
        for (DataItem item: dataItems){
            values.add(item.getValue());
        }
        result.setText(String.format("Medelvärde: %.2f\nMedian: %.2f\nStandardavvikelse: %.2f",
                calcMean(values),
                Statistics.calcMedian(values),
                Statistics.calcStdev(values)
        ));
    }

}