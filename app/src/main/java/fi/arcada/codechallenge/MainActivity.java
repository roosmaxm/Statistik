package fi.arcada.codechallenge;

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

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView outputText;
    EditText inputText;
    double [] values = {12, 3, 53.2 ,7, 65, 55, 43, 21};
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputText = findViewById(R.id.outText);
        inputText = findViewById(R.id.inputText);
        result = findViewById(R.id.result);


        outputText.setText("Min app fungerar");


    }
    public void buttonHandler(View view){
        outputText.setText(inputText.getText().toString());
    }
    public void calculator(View view){
        double average = calculate();
        result.setText(String.format("%.2f", average));
    }
    public double calculate() {
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.length;
    }
}