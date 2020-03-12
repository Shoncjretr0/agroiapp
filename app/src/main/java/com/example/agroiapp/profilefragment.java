package com.example.agroiapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class profilefragment extends AppCompatActivity {

    String d;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MainActivity m = new MainActivity();
         d = m.rrmain();


    }
}
