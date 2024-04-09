package fi.arcada.codechallenge;

import static fi.arcada.codechallenge.Statistics.calcMean;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView outputText;
    EditText inputText;
    RecyclerView recyclerView;
    SharedPreferences prefs;
    SharedPreferences.Editor prefsEditor;
    TextView greetingText;

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
        recyclerView = findViewById(R.id.recyclerView);
        result = findViewById(R.id.result);
        greetingText = findViewById(R.id.greetingText);


        // SharedPreference
        prefs = PreferenceManager.getDefaultSharedPreferences(this);


        // Öppna editorn
        prefsEditor = prefs.edit();

        // Läs värde från SharedPreferences
        int appStartCount = prefs.getInt("counter", 0);

        // Lägg till värde till SharedPreferences och öka med 1
        prefsEditor.putInt("counter", appStartCount + 1);

        // Spara ändringen
        prefsEditor.apply();

        // Visa värdet
        outputText.setText("Times you have opened app: " + appStartCount);


        //Vi fyller vår arraylist med värdena från testData
        for (int i = 0; i < testData.length; i++){
            dataItems.add(new DataItem(names[i], testData[i]));
        }


        DataItemViewAdapter adapter = new DataItemViewAdapter(this, dataItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    public void onResume() {
        super.onResume();
        String greeting = prefs.getString("greeting", "Hello");
        greetingText = findViewById(R.id.greetingText);
        greetingText.setText(greeting);
    }

    public void openSettings(View view){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void buttonHandler(View view){
        String text = inputText.getText().toString();
        outputText.setText(text);

        // Lägg till värde till SharedPreferences
        SharedPreferences.Editor prefsEditor;
        prefsEditor = prefs.edit();
        prefsEditor.putString("lastText", text);
        prefsEditor.apply();
    }
    @SuppressLint("DefaultLocale")
    public void calculator(View view){
        ArrayList<Double> values = new ArrayList<>();
        for (DataItem item: dataItems){
            values.add(item.getValue());
        }
        result.setText(String.format("Medelvärde: %.2f\nMedian: %.2f\nStandardavvikelse: %.2f\nLQ: %.2f\nUQ: %.2f\nIQR: %.2f",
                calcMean(values),
                Statistics.calcMedian(values),
                Statistics.calcStdev(values),
                Statistics.calcLQ(values),
                Statistics.calcUQ(values),
                Statistics.calcIQR(values)



        ));
    }

}