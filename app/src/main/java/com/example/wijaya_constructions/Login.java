package com.example.wijaya_constructions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private TextView LusernameTV;
    private TextView LpasswordTV;
    private final DHandler dHandler=new DHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LusernameTV = (TextView)findViewById(R.id.LusernameTV);
        LpasswordTV = (TextView)findViewById(R.id.LpasswordTV);
        dHandler.openDB();

    }

    public void OnLoginClick(View view)  {

        String username=LusernameTV.getText().toString();
        String password=LpasswordTV.getText().toString();


        Boolean CheckSupervisorLogin=dHandler.CheckSupervisorLogin(username,password);
        if (CheckSupervisorLogin==true){
            Toast.makeText(getApplicationContext(), "LOGIN GRANTED", Toast.LENGTH_SHORT).show();
            Intent  intent =new Intent(this,MainActivity_Supervisor.class);
            startActivity(intent);

        }else {
            Toast.makeText(getApplicationContext(), "LOGIN FAIL", Toast.LENGTH_SHORT).show();

            Boolean CheckAdminLogin=dHandler.CheckAdminLogin(username,password);
                if(CheckAdminLogin==true){
                    Toast.makeText(getApplicationContext(), "LOGIN GRANTED", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(this,MainActivity.class);
                    startActivity(intent);

            } else {
                    Toast.makeText(getApplicationContext(), "LOGIN FAILED", Toast.LENGTH_SHORT).show();
                }
        }
    }
}