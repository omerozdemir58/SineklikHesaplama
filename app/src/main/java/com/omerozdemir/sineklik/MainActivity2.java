package com.omerozdemir.sineklik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
TextView textView;
SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = findViewById(R.id.textView3);
        sharedPreferences= this.getSharedPreferences("com.omerozdemir.sineklik", Context.MODE_PRIVATE);

        Intent intent = getIntent();
        String result =  sharedPreferences.getString("result2","");
        textView.setText("Ölçü: " +result);



    }
    public void changeActivity(View view){
        Intent intent = new Intent(MainActivity2.this,MainActivity.class);
        startActivity(intent);
    }
}