package com.example.wijaya_constructions;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class AddConstructionSites extends AppCompatActivity {
    int year,month,day;
    private TextView sitenameTV;
    private TextView siteidTV;
    private TextView handoverTV;
    private TextView handOutTV;
    private TextView costTV;
    private final DHandler dHandler=new DHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_construction_sites);

        dHandler.openDB();

        sitenameTV=findViewById(R.id.sitenameTV);
        siteidTV=findViewById(R.id.siteidTV);
        handoverTV=findViewById(R.id.handoverTV);
        handOutTV=findViewById(R.id.handOutTV);
        costTV=findViewById(R.id.costTV);

    }
    public void OnSetDate(View view){

        final Calendar c=Calendar.getInstance();
        year=c.get(Calendar.YEAR);
        month=c.get(Calendar.MONTH);
        day=c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                handoverTV.setText(dayOfMonth+"-"+(month+1)+"-"+year);
            }
        },year,month,day);
        datePickerDialog.show();

    }


    public void OnSetDate2(View view){

        final Calendar c=Calendar.getInstance();
        year=c.get(Calendar.YEAR);
        month=c.get(Calendar.MONTH);
        day=c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                handOutTV.setText(dayOfMonth+"-"+(month+1)+"-"+year);
            }
        },year,month,day);
        datePickerDialog.show();

    }


    public void OnAddSite(View view){

        String Sitename=sitenameTV.getText().toString();
        String SitId=siteidTV.getText().toString();
        String Handover= handoverTV.getText().toString();
        String HandOut=handOutTV.getText().toString();
        String Cost=costTV.getText().toString();

        if(Sitename.trim().isEmpty()){
            Toast.makeText(this, "SITE NAME CANNOT BE EMPTY", Toast.LENGTH_SHORT).show();
        }else if (SitId.trim().isEmpty()){
            Toast.makeText(this, "SITE ID CANNOT BE EMPTY", Toast.LENGTH_SHORT).show();
        }else if (Handover.trim().isEmpty()){
            Toast.makeText(this, "HANDOVER DATE CANNOT BE EMPTY", Toast.LENGTH_SHORT).show();
        }else if ( HandOut.trim().isEmpty()){
            Toast.makeText(this, "HANDOUT DATE CANNOT BE EMPTY", Toast.LENGTH_SHORT).show();
        }else if (Cost.trim().isEmpty()){
            Toast.makeText(this, "COST CANNOT BE EMPTY", Toast.LENGTH_SHORT).show();

        }else{

            Site site=new Site(Sitename,SitId,Handover,HandOut,Cost);
            dHandler.AddSite(site);

        }

    }

}