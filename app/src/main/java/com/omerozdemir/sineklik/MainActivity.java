package com.omerozdemir.sineklik;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    RadioButton sabitText;
    RadioButton solText;
    RadioButton sagText;

    double result2 = 0;
    String ozellik;
    SharedPreferences sharedPreferences;
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
        sabitText = findViewById(R.id.sabitText);
        solText = findViewById(R.id.solText);
        sagText = findViewById(R.id.sagText);

        sharedPreferences = this.getSharedPreferences("com.omerozdemir.sineklik", Context.MODE_PRIVATE);
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

            if (beyazText.isChecked() && pencereText.isChecked() && sabitText.isChecked()) {
            result2 = (number1 + number2) * 2 * 15.42 + ((number2 + 0.05) * 8.8) + 9;
            resultText.setText("Beyaz Pencere Sonuç:" + result2);
            ozellik = "Beyaz Pencere Sabit";

        } else if (beyazText.isChecked() && kapiText.isChecked()) {
            result2 = (number1 + number2) * 2 * 15.42 + ((number2 + 0.05) * 8.8) + (number1 * 15.42)+ 11;
            resultText.setText("beyaz kapi Sonuç:" + result2);
                ozellik = "Beyaz Kapı";
        } else if (kahveText.isChecked() && pencereText.isChecked()) {
            result2 = (number1 + number2) * 2 * 17.65 + ((number2 + 0.05) * 8.8) + 9;
            resultText.setText("kahve pencere Sonuç:" + result2);
                ozellik = "Kahverengi Pencere";
        } else if (kahveText.isChecked() && kapiText.isChecked()) {
            result2 =  (number1 + number2) * 2 * 17.65 + ((number2 + 0.05) * 8.8) + (number1 * 15.85)+ 11;
            resultText.setText("kahve kapi Sonuç:" + result2);
                ozellik = "Kahverengi Kapı";

            }
            number1*=100;
            number2*=100;
            int number3=0, number4=0;
            number3 = (int)number1;
            number4 = (int)number2;
            yaz = String.format("%s x %s %s",number3,number4,ozellik);
        }
    }
    public void changeScreen(View view){
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

    public void save(View view){
        try {
            Intent intent = new Intent(this,MainActivity2.class);
            String res = String.valueOf(yaz);
            sharedPreferences.edit().putString("result2",yaz).apply();

            startActivity(intent);
        }
        catch (Exception e){
            System.out.println();
        }

    }
}

