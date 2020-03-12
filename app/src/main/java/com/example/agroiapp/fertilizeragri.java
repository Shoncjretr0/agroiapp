package com.example.agroiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class fertilizeragri extends AppCompatActivity {


    public ImageView fert1;
    public ImageView fert2;
    public ImageView fert3;
    public ImageView fert4;
    public ImageView fert5;
    public ImageView fert6;
    public String ferttid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fertilizeragri);
        fert1=findViewById(R.id.fert0);
        fert2=findViewById(R.id.fert1);
        fert3=findViewById(R.id.fert2);
        fert4=findViewById(R.id.fert3);
        fert5=findViewById(R.id.fert4);
        fert6=findViewById(R.id.fert5);

        fert1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(fertilizeragri.this,fertagribuy.class));
                ferttid="M_plantfood_9.4kg";
                fertidpass();

            }
        });
        fert2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(fertilizeragri.this, fertagribuy.class));
                ferttid="BLOOMBUDDY_ORGANIC_GROTH";
                fertidpass();

            }
        });
        fert3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(fertilizeragri.this, fertagribuy.class));
                ferttid="Ugaoo_vermicompost";
                fertidpass();


            }
        });
        fert4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(fertilizeragri.this, fertagribuy.class));
                ferttid="homemade_organic_fertilizer_1kg";
                fertidpass();


            }
        });
        fert5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(fertilizeragri.this, fertagribuy.class));
                ferttid="trusrbasket bio organic manure";
                fertidpass();


            }
        });
        fert6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(fertilizeragri.this, fertagribuy.class));
                ferttid="microbal organic fertilizer sunnoku";
                fertidpass();


            }
        });


    }

    public void fertidpass(){

        Intent i = new Intent(fertilizeragri.this,fertagribuy.class);
        i.putExtra("value95",ferttid);
        startActivity(i);
        finish();

    }
    }

