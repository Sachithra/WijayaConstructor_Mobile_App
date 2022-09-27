package com.example.wijaya_constructions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Register_Workers extends AppCompatActivity {

    private TextView WfirstnameTV;
    private TextView WlastnameTV;
    private TextView WphoneTV;
    private TextView WsiteTV;
    private TextView WidTV;
    private TextView WusernameTV;

    private final DHandler dHandler=new DHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workers);

        dHandler.openDB();

        WfirstnameTV=findViewById(R.id.Wfirstname);
        WlastnameTV=findViewById(R.id.WlastnameTV);
        WphoneTV=findViewById(R.id.WphoneTV);
        WsiteTV=findViewById(R.id.WsiteTV);
        WidTV=findViewById(R.id.WsiteTV);
        WusernameTV=findViewById(R.id.WusernameTV);

    }
    public void OnclickAddWorker(View view){

        String firstname=WfirstnameTV.getText().toString();
        String lastname=WlastnameTV.getText().toString();
        String email=WphoneTV.getText().toString();
        String phone=WsiteTV.getText().toString();
        String site=WidTV.getText().toString();
        String username=WusernameTV.getText().toString();



        if(firstname.trim().isEmpty()){
            Toast.makeText(this, "FIRSTNAME CANNOT BE EMPTY", Toast.LENGTH_SHORT).show();
        }else if (lastname.trim().isEmpty()){
            Toast.makeText(this, "LASTNAME CANNOT BE EMPTY", Toast.LENGTH_SHORT).show();
        }else if (email.trim().isEmpty()){
            Toast.makeText(this, "EMAIL  CANNOT BE EMPTY", Toast.LENGTH_SHORT).show();
        }else if (phone.trim().isEmpty()){
            Toast.makeText(this, "PLEASE ENTER PHONE NUMBER", Toast.LENGTH_SHORT).show();
        }else if (site.trim().isEmpty()){
            Toast.makeText(this, "PLEASE ENTER SITE NAME", Toast.LENGTH_SHORT).show();
        }else if (username.trim().isEmpty()){
            Toast.makeText(this, "PLEASE USERNAME", Toast.LENGTH_SHORT).show();
        }else{
            Worker worker=new Worker(firstname,lastname,email,phone,site,username);

                dHandler.RegisterW(worker);

            Toast.makeText(this, "REGISTER SUCCESSFULLY", Toast.LENGTH_SHORT).show();
            }

        }

    }


