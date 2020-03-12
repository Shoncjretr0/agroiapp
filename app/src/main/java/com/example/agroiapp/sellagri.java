package com.example.agroiapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.Objects;

public class sellagri extends AppCompatActivity {
    EditText sellphoneno;
    EditText sellnameusr;
    EditText selladdressusr;
    EditText sellpincdusr;
    TextView selllocation;
    EditText sellcommname;
    ImageView sellgmapsy;
    ImageView picselect;
    Button sellpost;
    Button upload;
    Spinner sellspin;
    DatabaseReference databasesell;
    String latmap;
    String longmap;
    String[] rrw;
    ArrayList<Uri> ImageList = new ArrayList<Uri>();
    int uploads = 0;
    static final int PICK_IMG = 1;
    int CurrentImageSelect = 0;
    int i=1;
    String a,b,c,d;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellagri);
        databasesell = FirebaseDatabase.getInstance().getReference("sellagriref");

        sellphoneno = findViewById(R.id.sellphno);
        sellnameusr = findViewById(R.id.sellname);
        selladdressusr = findViewById(R.id.sellpostal);
        sellpincdusr = findViewById(R.id.sellpincd);
        selllocation = findViewById(R.id.selllocagri);
        sellcommname = findViewById(R.id.commonamesell);
        sellpost = findViewById(R.id.sellbtnagriseg);
        sellspin = findViewById(R.id.sellspinner);
        sellgmapsy = findViewById(R.id.imageViewsell);
        picselect=findViewById(R.id.imageViewsellphoto);
        upload=findViewById(R.id.sellupload);


        sellpost.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                positiong();
               String txtlocg = String.format("%s, %s", latmap, longmap);
                selllocation.setText(txtlocg);
                addpostsell();
                startActivity(new Intent(sellagri.this, agrihome.class));

            }
        });
        sellgmapsy.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(sellagri.this, sellgmap.class));



            }
        });
        picselect.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                choose();



            }
        });
        upload.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                upload();



            }
        });


    }
    public void choose() {
        //we will pick images
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        startActivityForResult(intent, PICK_IMG);

    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMG) {
            if (resultCode == RESULT_OK) {
                if (data.getClipData() != null) {
                    int count = data.getClipData().getItemCount();



                    while (CurrentImageSelect < count) {
                        Uri imageuri = data.getClipData().getItemAt(CurrentImageSelect).getUri();
                        ImageList.add(imageuri);
                        CurrentImageSelect = CurrentImageSelect + 1;
                    }

                }

            }

        }

    }
    @SuppressLint("SetTextI18n")
    public void upload() {

        final StorageReference ImageFolder =  FirebaseStorage.getInstance().getReference().child("commodity_picture");
        for (uploads=0; uploads < ImageList.size(); uploads++) {
            Uri Image  = ImageList.get(uploads);
            final StorageReference imagename = ImageFolder.child("image/"+Image.getLastPathSegment());

            imagename.putFile(ImageList.get(uploads)).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    imagename.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {

                            String url = String.valueOf(uri);
                            SendLink(url);
                        }
                    });

                }
            });


        }

    }
    public void SendLink(String urll){

            if(i==1){
                this.a=urll;
                i=i+1;
                Toast.makeText(this, "A", Toast.LENGTH_LONG).show();

            }
            else if(i==2){
                 this.b=urll;
                i=i+1;
                Toast.makeText(this, "b", Toast.LENGTH_LONG).show();

            }
            else if(i==3){

                 this.c=urll;
                i=i+1;
                Toast.makeText(this, "c", Toast.LENGTH_LONG).show();

            }
            else{
                this.d=urll;
                i=i+1;
                Toast.makeText(this, "d", Toast.LENGTH_LONG).show();

            }






    }



    public void addpostsell() {
        String sname = sellnameusr.getText().toString().trim();
        String sphno = sellphoneno.getText().toString().trim();
        String saddr = selladdressusr.getText().toString().trim();
        String spincd = sellpincdusr.getText().toString().trim();
        String sloc = selllocation.getText().toString().trim();
        String scomname = sellcommname.getText().toString().trim();
        String sspin = sellspin.getSelectedItem().toString();
        String slat=latmap;
        String slong=longmap;
        String aa=a;
        String bb=b;
        String cc=c;
        String dd=d;



        if (!TextUtils.isEmpty(sname)) {

            String idsell = databasesell.push().getKey();

            sellagriref sellagrii = new sellagriref(idsell, sphno, sname, saddr, spincd, sloc, scomname, sspin, slat, slong,aa,bb,cc,dd);
            assert idsell != null;
            databasesell.child(idsell).setValue(sellagrii);
            Toast.makeText(this, "post sucessfull", Toast.LENGTH_LONG).show();


        } else {
            Toast.makeText(this, "you should enter the details", Toast.LENGTH_LONG).show();
        }

    }

    public void positiong() {
        latmap = String.valueOf(Objects.requireNonNull(getIntent().getExtras()).getDouble("value100"));
        longmap = String.valueOf(getIntent().getExtras().getDouble("value101"));
        if (latmap == null ) {
            latmap = "location";
            longmap = "not found";
        } else {

            latmap = String.valueOf(getIntent().getExtras().getDouble("value100"));
            longmap = String.valueOf(getIntent().getExtras().getDouble("value101"));
        }
    }
}

