package com.example.wijaya_constructions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Registerr_Supervisor extends AppCompatActivity {
    private TextView SfirstnameTV;
    private TextView SlastnameTV;
    private TextView SemailTV;
    private TextView SpasswordTV;
    private TextView SsiteTV;
    private TextView SunameTV;

    private final DHandler dHandler = new DHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_supervisor);

        dHandler.openDB();

        SfirstnameTV = findViewById(R.id.SfirstnameTV);
        SlastnameTV = findViewById(R.id.SlastnameTV);
        SemailTV = findViewById(R.id.SemailTV);
        SpasswordTV = findViewById(R.id.SpasswordTV);
        SsiteTV = findViewById(R.id.SsiteTV);
        SunameTV = findViewById(R.id.SunameTV);
    }

    public void OnclickAddSupervisor(View View) {
        String firstname = SfirstnameTV.getText().toString();
        String lastname = SlastnameTV.getText().toString();
        String email = SemailTV.getText().toString();
        String password = SpasswordTV.getText().toString();
        String site = SsiteTV.getText().toString();
        String username = SunameTV.getText().toString();

       if (firstname.trim().isEmpty()) {
           Toast.makeText(this, "FIRSTNAME CANNOT BE EMPTY", Toast.LENGTH_SHORT).show();
       } else if (lastname.trim().isEmpty()) {
           Toast.makeText(this, "LASTNAME CANNOT BE EMPTY", Toast.LENGTH_SHORT).show();
       } else if (email.trim().isEmpty()) {
           Toast.makeText(this, "EMAIL  CANNOT BE EMPTY", Toast.LENGTH_SHORT).show();
       } else if (password.trim().isEmpty()) {
           Toast.makeText(this, "PLEASE ENTER PHONE NUMBER", Toast.LENGTH_SHORT).show();
      } else if (site.trim().isEmpty()) {
          Toast.makeText(this, "PLEASE ENTER SITE NAME", Toast.LENGTH_SHORT).show();
      } else if (username.trim().isEmpty()) {
          Toast.makeText(this, "PLEASE USERNAME", Toast.LENGTH_SHORT).show();
        } else {
            Supervisor supervisor = new Supervisor(firstname, lastname, email, password, site, username);
             dHandler.RegisterS(supervisor);
                Toast.makeText(this, "REGISTER SUCCESSFULLY", Toast.LENGTH_SHORT).show();
            }

        }

    }

