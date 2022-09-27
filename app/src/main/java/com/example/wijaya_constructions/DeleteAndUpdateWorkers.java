package com.example.wijaya_constructions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DeleteAndUpdateWorkers extends AppCompatActivity {

    private TextView WDfirstnameTV;
    private TextView WDlastnameTV;
    private TextView WDphoneTV;
    private TextView WDidTV;
    private TextView WDsiteTV;
    private TextView WDusernameTV;

    private final DHandler dHandler=new DHandler(this);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_and_update_workers);

        dHandler.openDB();


        WDfirstnameTV=findViewById(R.id.WDfirstnameTV);
        WDlastnameTV=findViewById(R.id.WDlastnameTV);
        WDphoneTV=findViewById(R.id.WDphoneTV);
        WDidTV=findViewById(R.id.WDidTV);
        WDsiteTV=findViewById(R.id.WDsiteTV);
        WDusernameTV=findViewById(R.id.WDusernameTV);

    }

    public void ONClickDelete(View view){

        String firstname = WDfirstnameTV.getText().toString();
        String lastname = WDlastnameTV.getText().toString();
        String phone = WDphoneTV.getText().toString();
        String id = WDidTV.getText().toString();
        String site =WDsiteTV.getText().toString();
        String username = WDusernameTV.getText().toString();



            Integer deleteRows = dHandler.DeleteWorkerData(WDfirstnameTV.getText().toString());
            if (deleteRows > 0)
                Toast.makeText(getApplicationContext(), "DELETED", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getApplicationContext(), "NOT DELETED", Toast.LENGTH_SHORT).show();

        }

    public void OnUpdateClick(View view){

        String firstname = WDfirstnameTV.getText().toString();
        String lastname = WDlastnameTV.getText().toString();
        String phone = WDphoneTV.getText().toString();
        String site = WDsiteTV.getText().toString();
        String id =WDidTV.getText().toString();
        String username = WDusernameTV.getText().toString();

        Worker worker=new Worker(firstname,lastname,phone,id,site,username);

        dHandler.UpdateWorker(worker);

        Toast.makeText(getApplicationContext(),"UPDATED",Toast.LENGTH_SHORT).show();

    }

}


