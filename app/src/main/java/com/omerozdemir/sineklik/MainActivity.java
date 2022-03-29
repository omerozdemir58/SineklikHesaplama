package com.omerozdemir.sineklik;

import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText genislik;
    EditText yukseklik;
    TextView resultText;
    RadioButton beyazText;
    RadioButton kahveText;
    RadioButton kapiText;
    RadioButton pencereText;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        genislik = findViewById(R.id.genislik);
        yukseklik = findViewById(R.id.yukseklik);
        resultText = findViewById(R.id.resultText);
        beyazText = findViewById(R.id.beyazText);
        kahveText = findViewById(R.id.kahveText);
        kapiText = findViewById(R.id.kapiText);
        pencereText = findViewById(R.id.pencereText);
    }
    public void result(View view) {

        if(genislik.getText().toString().matches("")||yukseklik.getText().toString().matches("")){
            resultText.setText("Değer Girin");
        }
        else{
            double number2 = Double.parseDouble(yukseklik.getText().toString());//Double türüne çeviriyoruz.
            double number1 = Double.parseDouble(genislik.getText().toString());
            if (beyazText.isChecked() && pencereText.isChecked()) {
            double result = (number1 + number2) * 2 / 100 * 15.9 + 5 + (number2 / 100 * 8.64);
            resultText.setText("beyaz pencere  Sonuç:" + result);//Bunu stringe çevirmemiz gerekiyor ancak bu şeklide yazınca kendisi
        } else if (beyazText.isChecked() && kapiText.isChecked()) {
            double result = (number1 + number2) * 2 / 100 * 15.9 + 5 + (number2 / 100 * 8.64 + 5);
            resultText.setText("beyaz kapi Sonuç:" + result);
        } else if (kahveText.isChecked() && pencereText.isChecked()) {
            double result = (number1 + number2) * 2 / 100 * 16.9 + 5 + (number2 / 100 * 8.64);
            resultText.setText("kahve pencere Sonuç:" + result);
            } else if (kahveText.isChecked() && kapiText.isChecked()) {
            double result = (number1 + number2) * 2 / 100 * 16.9 + 5 + (number2 / 100 * 8.64 + 5);
            resultText.setText("kahve kapi Sonuç:" + result);
            }
        }
    }
}

