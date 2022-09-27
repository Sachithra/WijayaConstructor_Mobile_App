package com.example.wijaya_constructions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DeleteAndUpdateSupervisor extends AppCompatActivity {

private TextView DfirstnameTV;
private TextView DlastnameTV;
private TextView DpasswordTV;
private TextView DemailTV;
private TextView DsiteTV;
private TextView DusernameTV;

    private final DHandler dHandler=new DHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_and_update_supervisor);

        dHandler.openDB();

        DfirstnameTV=findViewById(R.id.DfirstnameTV);
        DlastnameTV=findViewById(R.id.DlastnameTV);
        DpasswordTV=findViewById(R.id.DpasswordTV);
        DemailTV=findViewById(R.id.DemailTV);
        DsiteTV=findViewById(R.id.DsiteTV);
        DusernameTV=findViewById(R.id.DusernameTV);


    }
    public void OnDeleteClick(View view) {

        String firstname = DfirstnameTV.getText().toString();
        String lastname = DlastnameTV.getText().toString();
        String password = DsiteTV.getText().toString();
        String email =DpasswordTV.getText().toString();
        String site = DsiteTV.getText().toString();
        String username = DusernameTV.getText().toString();




        Integer deleteRows= dHandler.DeleteData(DfirstnameTV.getText().toString());
        if (deleteRows >0)
            Toast.makeText(getApplicationContext(),"DELETED",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(),"NOT DELETED",Toast.LENGTH_SHORT).show();



    }
    public void UpdateOnClick(View view){
        String firstname = DfirstnameTV.getText().toString();
        String lastname = DlastnameTV.getText().toString();
        String password = DpasswordTV.getText().toString();;
        String site =DsiteTV.getText().toString();
        String email = DemailTV.getText().toString();
        String username = DusernameTV.getText().toString();

        Supervisor supervisor=new Supervisor(firstname,lastname,password,email,site,username);

        dHandler.UpdateSupervisor(supervisor);

       Toast.makeText(getApplicationContext(),"UPDATED",Toast.LENGTH_SHORT).show();

    }

}