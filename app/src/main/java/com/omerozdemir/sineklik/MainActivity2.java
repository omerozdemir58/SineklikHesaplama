package com.omerozdemir.sineklik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
TextView textView1;
    TextView textView2;
SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        sharedPreferences= this.getSharedPreferences("com.omerozdemir.sineklik", Context.MODE_PRIVATE);

        Intent intent = getIntent();
        String result =  sharedPreferences.getString("result2","");
        if (textView1.getText().toString().matches("")){
            Intent intent1 = getIntent();
            String result1 =  sharedPreferences.getString("result2","");
            textView1.setText("Ölçü: " + result);
        }else {
            Intent intent2 = getIntent();
            String result2 =  sharedPreferences.getString("result2","");
            textView2.setText("Ölçü: " + result);

        }



    }
    public void changeActivity(View view){
        Intent intent = new Intent(MainActivity2.this,MainActivity.class);
        startActivity(intent);
    }
}