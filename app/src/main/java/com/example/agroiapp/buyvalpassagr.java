package com.example.agroiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class buyvalpassagr extends AppCompatActivity {

   public EditText pincdbuypass;
    public Button gobuy;
    public String gtavc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyvalpassagr);

        pincdbuypass = findViewById(R.id.pincdbuypass);
        gobuy = findViewById(R.id.buttongobuy);

        gobuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(buyvalpassagr.this, buyagri.class));
                rre();
            }
        });
    }
        public void rre() {
            gtavc=pincdbuypass.getText().toString();
            Intent i = new Intent(buyvalpassagr.this,buyagri.class);
            i.putExtra("value105",gtavc);
            startActivity(i);
            finish();
        }
}
