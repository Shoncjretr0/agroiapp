package com.example.agroiapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class buyagri extends AppCompatActivity {

    ListView listviewbuys;
    DatabaseReference databasesell;
    List<sellagriref> listbuyy;
    String pincdbuy;
    String latmap,lonmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyagri);

        databasesell = FirebaseDatabase.getInstance().getReference("sellagriref");

        listviewbuys = findViewById(R.id.listviewbuy);

        listbuyy = new ArrayList<>();

        pincdbuy = Objects.requireNonNull(getIntent().getExtras()).getString("value105");

        Query query = FirebaseDatabase.getInstance().getReference("sellagriref")
                .orderByChild("ssellpincdusr")
                .equalTo(pincdbuy);
        query.addListenerForSingleValueEvent(valueEventListener);

    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            listbuyy.clear();
            for (DataSnapshot databasellsn : dataSnapshot.getChildren()) {
                sellagriref sellagria = databasellsn.getValue(sellagriref.class);

                listbuyy.add(sellagria);
            }
            buylistadapter adapter = new buylistadapter(buyagri.this, listbuyy);
            listviewbuys.setAdapter(adapter);

            listviewbuys.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i,long l) {



                    sellagriref listbuy=listbuyy.get(i);

                   latmap= listbuy.getSslat();
                    lonmap=listbuy.getSslong();
                    String uri=String.format(Locale.ENGLISH,"geo:%s,%s?q=%s,%s",latmap,lonmap,latmap,lonmap);
                    Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                    startActivity(intent);
                    return false;
                }
            });

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {


        }

    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.back_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                startActivity(new Intent(buyagri.this, agrihome.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }


    }





}

