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

public class pestagriregbuy extends AppCompatActivity {

    EditText pestagribuyname;
    EditText pestagribuyaddress;
    EditText pestagribuypincd;
    EditText pestagribuyphoneno;
    Button pestbuy;
    String pestid;
    String userid;
    DatabaseReference pestisidebuy;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pestagriregbuy);

        pestisidebuy = FirebaseDatabase.getInstance().getReference("pestizidebuylist");


        pestid = Objects.requireNonNull(getIntent().getExtras()).getString("value91");
        pestagribuyname = findViewById(R.id.fertbuyagri);
        pestagribuyaddress = findViewById(R.id.fertbuyaddress);
        pestagribuypincd = findViewById(R.id.pincodebuyagfert);
        pestagribuyphoneno = findViewById(R.id.fertbuyphno);
        pestbuy = findViewById(R.id.fertbuybutn);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            for(UserInfo profile: user.getProviderData()){
                userid=profile.getEmail();
            }

        }else{
            userid="null";
        }



        pestbuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addpestbuylist();
                startActivity(new Intent(pestagriregbuy.this, agrihome.class));

            }
        });


    }

    private void addpestbuylist() {
        String pestname = pestagribuyname.getText().toString().trim();
        String pestphno = pestagribuyphoneno.getText().toString().trim();
        String pestaddr = pestagribuyaddress.getText().toString().trim();
        String pestpincd = pestagribuypincd.getText().toString().trim();
        String pestisid = pestid.trim();
        String useridbuy = userid.trim();


        if (!TextUtils.isEmpty(pestname)) {

            String idpestbuy = pestisidebuy.push().getKey();

            pestagriref pestagr = new pestagriref(idpestbuy, useridbuy, pestname, pestaddr, pestpincd, pestphno, pestisid);
            pestisidebuy.child(idpestbuy).setValue(pestagr);
            Toast.makeText(this, "product purchase confirmed", Toast.LENGTH_LONG).show();


        } else {
            Toast.makeText(this, "you should enter the details", Toast.LENGTH_LONG).show();
        }


    }
}
