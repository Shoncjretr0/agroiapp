package com.example.agroiapp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;


public class navvalpass extends AppCompatActivity {

    public Context context;
    public ImageView img;

    public FirebaseDatabase database ;
    public DatabaseReference mReference ;
    public DatabaseReference childReference ;
    String profusr ="gandhi@gmail.com";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_header);


        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(navvalpass.this,"profile pic", Toast.LENGTH_SHORT).show();

            }
        });

       // profusr= Objects.requireNonNull(getIntent().getExtras()).getString("value1093");
        profusr="gandhi@gmail.com";

        context = this;
        img = findViewById(R.id.nav_headerproimg);

        // place here
        database = FirebaseDatabase.getInstance();
        mReference = (DatabaseReference) database.getReference("usrprofref")
                .orderByChild("usrproemail")
                .equalTo(profusr);

    }

    @Override
    public void onStart() {
        super.onStart();
        childReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String message = dataSnapshot.child("usrpicurl").getValue(String.class);
                Picasso.get()
                        .load(message)
                        .into(img);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



}











