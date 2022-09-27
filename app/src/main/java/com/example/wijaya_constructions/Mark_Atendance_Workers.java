package com.example.wijaya_constructions;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class Mark_Atendance_Workers extends AppCompatActivity {


    int year,month,day;

    private TextView ATfirstnameTV;
    private TextView presenTV;
    private TextView absentTV;

    private final DHandler dHandler=new DHandler(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_atendance_workers);
        dHandler.openDB();
        ATfirstnameTV=findViewById(R.id.ATfirstnameTV);
        presenTV=findViewById(R.id.presenTV);
        absentTV=findViewById(R.id.absentTV);



    }

    public void PresentDate(View view){



            final Calendar c=Calendar.getInstance();
            year=c.get(Calendar.YEAR);
            month=c.get(Calendar.MONTH);
            day=c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    presenTV.setText(dayOfMonth+"-"+(month+1)+"-"+year);
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
                absentTV.setText(dayOfMonth+"-"+(month+1)+"-"+year);
            }
        },year,month,day);
        datePickerDialog.show();

    }

    public void Save(View view){
        String Workername=ATfirstnameTV.getText().toString();
        String Date1=presenTV.getText().toString();
        String Date2= absentTV.getText().toString();

        Attendance attendance=new Attendance(Workername,Date1,Date2);
        dHandler.MarkAttendance(attendance);


    }

}
