package com.example.agroiapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class buylistadapter extends ArrayAdapter<sellagriref> {

    private Activity context;
    private List<sellagriref> buylistadapters;

    public buylistadapter (Activity context,List<sellagriref>  buylistadapters){
        super(context,R.layout.buylist, buylistadapters);
        this.context=context;
        this.buylistadapters=buylistadapters;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =context.getLayoutInflater();
         View listViewItem = inflater.inflate(R.layout.buylist,null,true);

        TextView textviewbuyname= listViewItem.findViewById(R.id.buyname);
        TextView textviewbuyaddr= listViewItem.findViewById(R.id.buyaddrb);
        TextView textviewbuypincd= listViewItem.findViewById(R.id.buypincdb);
        TextView textviewbuycommname= listViewItem.findViewById(R.id.buycommnameb);
        TextView textviewbuyphno= listViewItem.findViewById(R.id.buyphnob);
        TextView textviewbuyloc= listViewItem.findViewById(R.id.buylocb);

        sellagriref sellG= buylistadapters.get(position);

        textviewbuyname.setText( "Name:   " + sellG.getSsellnameusr());
        textviewbuyaddr.setText( "Address:   "+ sellG.getSselladdressusr());
        textviewbuypincd.setText("Pincode:   " +sellG.getSsellpincdusr());
        textviewbuycommname.setText("Commodity Name:   " + sellG.getSsellcommname());
        textviewbuyphno.setText("Phone No:   " + sellG.getSsellphoneno());
        textviewbuyloc.setText("Location:   " + sellG.getSselllocation());



                return listViewItem;







            }
}
