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
    double [] testData = {12, 3, 53.2 ,7, 65, 55, 43, 21};
    ArrayList<Double> values = new ArrayList<>();
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputText = findViewById(R.id.outText);
        inputText = findViewById(R.id.inputText);
        result = findViewById(R.id.result);

        //VI fyller vår arraylist med värdena från testData
        for (double value : testData){
            values.add(value);
        }


        outputText.setText("Min app fungerar");
//Hej

    }
    public void buttonHandler(View view){
        outputText.setText(inputText.getText().toString());
    }
    @SuppressLint("DefaultLocale")
    public void calculator(View view){
        result.setText(String.format("Medelvärde: %.2f\nMedian: %.2f\nStandardavvikelse: %.2f",
                calcMean(values),
                Statistics.calcMedian(values),
                Statistics.calcStdev(values)
        ));
    }

}