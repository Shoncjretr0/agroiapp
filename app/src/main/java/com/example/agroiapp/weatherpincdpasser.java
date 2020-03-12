package com.example.agroiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class weatherpincdpasser extends AppCompatActivity {

    public Button go;
    public EditText fr;
    public String gta;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weatherpincdpasser);
        go = findViewById(R.id.buttongo);
        fr = findViewById(R.id.weatherpincdpass);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(weatherpincdpasser.this, weatherapi.class));
                rr();
            }
        });
    }
    public void rr(){
        gta=fr.getText().toString();
        Intent i = new Intent(weatherpincdpasser.this,weatherapi.class);
        i.putExtra("value10",gta);
        startActivity(i);
        finish();
    }
}
