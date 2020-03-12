package com.example.agroiapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class fertagribuy extends AppCompatActivity {

    EditText fertagribuyname;
    EditText fertagribuyaddress;
    EditText fertagribuypincd;
    EditText fertagribuyphoneno;
    Button fertbuy;
    String fertid;
    String useridfert;
    DatabaseReference fertlistbuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fertagribuy);
        fertlistbuy = FirebaseDatabase.getInstance().getReference("fertilizerbuylist");


        fertid = Objects.requireNonNull(getIntent().getExtras()).getString("value95");
        fertagribuyname = findViewById(R.id.fertbuyagri);
        fertagribuyaddress = findViewById(R.id.fertbuyaddress);
        fertagribuypincd = findViewById(R.id.pincodebuyagfert);
        fertagribuyphoneno = findViewById(R.id.fertbuyphno);
        fertbuy = findViewById(R.id.fertbuybutn);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            for(UserInfo profile: user.getProviderData()){
                useridfert=profile.getEmail();
            }

        }else{
            useridfert="null";
        }



        fertbuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addfertbuylist();
                startActivity(new Intent(fertagribuy.this, agrihome.class));

            }
        });
    }
    private void addfertbuylist() {
        String fertname = fertagribuyname.getText().toString().trim();
        String fertphno = fertagribuyphoneno.getText().toString().trim();
        String fertaddr = fertagribuyaddress.getText().toString().trim();
        String fertpincd = fertagribuypincd.getText().toString().trim();
        String fertisid = fertid.trim();
        String useridbuyfert = useridfert.trim();


        if (!TextUtils.isEmpty(fertname)) {

            String idf = fertlistbuy.push().getKey();

            fertagrireffer fertagr = new fertagrireffer(idf, useridbuyfert, fertname, fertaddr, fertpincd, fertphno, fertisid);
            fertlistbuy.child(Objects.requireNonNull(idf)).setValue(fertagr);
            Toast.makeText(this, "product purchase confirmed", Toast.LENGTH_LONG).show();


        } else {
            Toast.makeText(this, "you should enter the details", Toast.LENGTH_LONG).show();
        }


    }
}

