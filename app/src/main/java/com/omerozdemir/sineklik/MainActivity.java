package com.omerozdemir.sineklik;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
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
    double result2 = 0;
    String yaz;
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
            float number2 = Float.parseFloat(yukseklik.getText().toString());//Double türüne çeviriyoruz.
            float number1 = Float.parseFloat(genislik.getText().toString());
            number2 = number2 / 100;
            number1 = number1 / 100;
            if (beyazText.isChecked() && pencereText.isChecked()) {
            result2 = (number1 + number2) * 2 * 16.65 + ((number2 + 0.05) * 8.8) + 9;
            resultText.setText("beyaz pencere  Sonuç:" + result2);
        } else if (beyazText.isChecked() && kapiText.isChecked()) {
            result2 = (number1 + number2) * 2 * 16.65 + ((number2 + 0.05) * 8.8) + (number1 * 16.65)+ 11;
            resultText.setText("beyaz kapi Sonuç:" + result2);
        } else if (kahveText.isChecked() && pencereText.isChecked()) {
            result2 = (number1 + number2) * 2 * 17.65 + ((number2 + 0.05) * 8.8) + 9;
            resultText.setText("kahve pencere Sonuç:" + result2);
        } else if (kahveText.isChecked() && kapiText.isChecked()) {
            result2 =  (number1 + number2) * 2 * 17.65 + ((number2 + 0.05) * 8.8) + (number1 * 15.85)+ 11;
            resultText.setText("kahve kapi Sonuç:" + result2);

            }
            yaz = String.format("%f x %f",number1,number2*100);
        }
    }
    public void changeScreen(View view){
        String res = String.valueOf(yaz);
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra(Intent.EXTRA_TEXT,res);
       startActivity(intent);
    }
}

