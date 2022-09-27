package com.example.wijaya_constructions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Registe_Admin extends AppCompatActivity {

    private TextView AfirstnameTV;
    private TextView AlastnameTV;
    private TextView AemailTV;
    private TextView AusernameTV;
    private TextView ApasswordTV;

    private final DHandler dHandler=new DHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registe_admin);

        dHandler.openDB();

        AfirstnameTV=findViewById(R.id.AfirstnameTV);
        AlastnameTV=findViewById(R.id.AlastnameTV);
        AemailTV=findViewById(R.id.AemailTV);
        AusernameTV=findViewById(R.id.AusernameTV);
        ApasswordTV=findViewById(R.id.ApasswordTV);

    }

    public void AddAdminOnClick(View view) {

        String firstname = AfirstnameTV.getText().toString();
        String lastname = AlastnameTV.getText().toString();
        String email = AemailTV.getText().toString();
        String username = AusernameTV.getText().toString();
        String password = ApasswordTV.getText().toString();

        if (firstname.trim().isEmpty()) {
            Toast.makeText(this, "FIRSTNAME CANNOT BE EMPTY ", Toast.LENGTH_SHORT).show();
        } else if (lastname.trim().isEmpty()) {
            Toast.makeText(this, "LASTNAME CANNOT BE EMPTY", Toast.LENGTH_SHORT).show();
        } else if (email.trim().isEmpty()) {
            Toast.makeText(this, "EMAIL CANNOT BE EMPTY", Toast.LENGTH_SHORT).show();
        } else if (username.trim().isEmpty()) {
            Toast.makeText(this, "USERNAME CANNOT BE EMPTY", Toast.LENGTH_SHORT).show();
        } else if (password.trim().isEmpty()) {
            Toast.makeText(this, "PASSWORD CANNOT BE EMPTY", Toast.LENGTH_SHORT).show();

        }else{

            Admin admin = new Admin(firstname, lastname, email, username, password);

            dHandler.RegisterAdmin(admin);

            Toast.makeText(this, "Register Successfully", Toast.LENGTH_SHORT).show();
            }

    }

}