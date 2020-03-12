package com.example.agroiapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class agrihome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Button buyy, selll, fertulizer, pestizides, cropdet, market, weathers, logout, profile;
    private FirebaseAuth firebaseAuth;
    private DrawerLayout drawer;
    private DrawerLayout navheader;
    navvalpass ret=new navvalpass();





    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agrihome);
        firebaseAuth = FirebaseAuth.getInstance();
        buyy = findViewById(R.id.buyhome);
        selll = findViewById(R.id.sellhome);
        fertulizer = findViewById(R.id.fertilizerhome);
        pestizides = findViewById(R.id.pesthome);
        cropdet = findViewById(R.id.cropdetailhome);
        market = findViewById(R.id.marketpricehome);
        weathers = findViewById(R.id.weatherhome);
        profile = findViewById(R.id.hmprfl);






        weathers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(agrihome.this, weatherpincdpasser.class));


            }
        });
        market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(agrihome.this, marketpriceagri.class));


            }
        });

        buyy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(agrihome.this, buyvalpassagr.class));


            }
        });
        selll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(agrihome.this,sellagri.class));


            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(agrihome.this, sellagri.class));


            }
        });
        fertulizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(agrihome.this, fertilizeragri.class));


            }
        });
        cropdet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(agrihome.this,"useriddd", Toast.LENGTH_SHORT).show();



            }
        });
        pestizides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(agrihome.this, pestisideagri.class));


            }
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(agrihome.this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();






    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.nav_profile:

                break;
            case R.id.nav_headerproimg:
                startActivity(new Intent(agrihome.this, sellagri.class));

                break;
            case R.id.nav_share:
                Toast.makeText(agrihome.this,"share", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
               Intent myIntent=new Intent(Intent.ACTION_SEND);
               myIntent.setType("text/plain");
               String shareBody="https://shoncj.wordpress.com/85-2/?frame-nonce=9b244eb8d1 try his app";
               String shareSub="hope you download it";
               myIntent.putExtra(Intent.EXTRA_SUBJECT,shareSub);
               myIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
               startActivity(Intent.createChooser(myIntent,"Share Using"));
                return true;
            case R.id.item2:
                    startActivity(new Intent(agrihome.this, settingsagri.class));
                    return true;
            case R.id.item3:
                Logout();
                return true;
                default:
                    return super.onOptionsItemSelected(item);

        }
    }
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void Logout() {
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(agrihome.this, MainActivity.class));
    }




    }

