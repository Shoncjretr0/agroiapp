package com.example.agroiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class pestisideagri extends AppCompatActivity {

    public ImageView pest1;
    public ImageView pest2;
    public ImageView pest3;
    public ImageView pest4;
    public ImageView pest5;
    public String pestid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pestisideagri);

        pest1=findViewById(R.id.pestpro0);
        pest2=findViewById(R.id.pestpro1);
        pest3=findViewById(R.id.pestpro2);
        pest4=findViewById(R.id.pestpro3);
        pest5=findViewById(R.id.pestpro4);

        pest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(pestisideagri.this, pestagriregbuy.class));
                pestid="pestid01:Agro_plusAm003set(2)";
                pestidpass();

            }
        });
        pest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(pestisideagri.this, pestagriregbuy.class));
                pestid="pestid02:TrustBasket_75ml";
                pestidpass();

            }
        });
        pest3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(pestisideagri.this, pestagriregbuy.class));
                pestid="pestid03:Agro_plusAM003_set1";
                pestidpass();


            }
        });
        pest4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(pestisideagri.this, pestagriregbuy.class));
                pestid="pestid04:SURYA_Organic_neem_oil_emulsifier_1L";
                pestidpass();


            }
        });
        pest5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(pestisideagri.this, pestagriregbuy.class));
                pestid="pestid05:Agro_plusAM001";
                pestidpass();


            }
        });


    }

    public void pestidpass(){

        Intent i = new Intent(pestisideagri.this,pestagriregbuy.class);
        i.putExtra("value91",pestid);
        startActivity(i);
        finish();

    }
}
