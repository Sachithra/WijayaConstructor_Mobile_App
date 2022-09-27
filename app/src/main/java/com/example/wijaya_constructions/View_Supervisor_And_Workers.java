package com.example.wijaya_constructions;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class View_Supervisor_And_Workers extends AppCompatActivity {

    private final DHandler dHandler=new DHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dHandler.openDB();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_supervisor_and_workers);
    }

    public void ViewDetailSupervisorOnClick(View view){

      Cursor ve= dHandler.getAllSupervisorData();
        if(ve.getCount()==0){
            Toast.makeText(getApplicationContext(), "NO DATA TO SHOW", Toast.LENGTH_SHORT).show();
            return;

        }
        StringBuffer buffer=new StringBuffer();
        while (ve.moveToNext()){
            buffer.append("firstname:"+ve.getString(0)+"\n");
            buffer.append("lastname:"+ve.getString(1)+"\n");
            buffer.append("email:"+ve.getString(2)+"\n");
            buffer.append("password:"+ve.getString(3)+"\n");
            buffer.append("site:"+ve.getString(4)+"\n");
            buffer.append("username:"+ve.getString(5)+"\n\n");
        }
        SMessage("SUPERVISORS",buffer.toString());


    }
    public void SMessage(String title,String Message){


        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void ViewDetailWorkerOnClick(View view){

        Cursor ve= dHandler.getAllWorkersData();
        if(ve.getCount()==0){
            Toast.makeText(getApplicationContext(), "NO DATA TO SHOW", Toast.LENGTH_SHORT).show();
            return;

        }
        StringBuffer buffer=new StringBuffer();
        while (ve.moveToNext()){
            buffer.append("firstname:"+ve.getString(0)+"\n");
            buffer.append("lastname:"+ve.getString(1)+"\n");
            buffer.append("phone:"+ve.getString(2)+"\n");
            buffer.append("site:"+ve.getString(3)+"\n");
            buffer.append("id:"+ve.getString(4)+"\n");
            buffer.append("username:"+ve.getString(5)+"\n\n");
        }
        SWMessage("WORKERS",buffer.toString());


    }
    public void SWMessage(String title,String Message){


        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}