package com.example.wijaya_constructions;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Salary_Cal extends AppCompatActivity {

    private ArrayList<String>data= new ArrayList<String>();
    private ArrayList<String>data2= new ArrayList<String>();
    private ArrayList<String>data3= new ArrayList<String>();
    private ArrayList<String>data4= new ArrayList<String>();

    private TableLayout table;
    private TextView WnameTV;
    private TextView WPaymentTV;
    private TextView WdaysTV;
    private TextView WAmTV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary_cal);


        WnameTV=findViewById(R.id.WnameTV);
        WPaymentTV=findViewById(R.id.WPaymentTV);
        WdaysTV=findViewById(R.id.WdaysTV);
        WAmTV=findViewById(R.id.WAmTV);

    }
    public void PrintOnClick(View view){

        int tot;
        String wname=WnameTV.getText().toString();
        int payment=Integer.parseInt(WPaymentTV.getText().toString());
        int days=Integer.parseInt(WdaysTV.getText().toString());
        //int am=Integer.parseInt(WAmTV.getText().toString());
        tot=payment*days;

        if(wname.trim().isEmpty()){
            Toast.makeText(this, "WORKER NAME CANNOT BE EMPTY", Toast.LENGTH_SHORT).show();
        }else if (WPaymentTV.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "PAYMENT MUST BE 3000", Toast.LENGTH_SHORT).show();
        }else if (WdaysTV.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "DAYS CANNOT BE EMPTY", Toast.LENGTH_SHORT).show();
        }else {
            data.add(wname);
            data2.add(String.valueOf(payment));
            data3.add(String.valueOf(days));
            data4.add(String.valueOf(tot));


            TableLayout table = (TableLayout) findViewById(R.id.tb1);

            TableRow row = new TableRow(this);
            TextView t1 = new TextView(this);
            TextView t2 = new TextView(this);
            TextView t3 = new TextView(this);
            TextView t4 = new TextView(this);

            String total;

            int sum = 0;

            for (int i = 0; i < data.size(); i++) {
                String Wname = data.get(i);
                String Pay = data2.get(i);
                String Dy = data3.get(i);

                total = data4.get(i);

                t1.setText(Wname);
                t2.setText(Pay);
                t3.setText(Dy);
                t4.setText(total);

                sum = sum + Integer.parseInt(data4.get(i).toString());

            }
            row.addView(t1);
            row.addView(t2);
            row.addView(t3);
            row.addView(t4);

            table.addView(row);

            WAmTV.setText(String.valueOf(sum));
            WnameTV.setText("");
            WPaymentTV.setText("");
            WdaysTV.setText("");
            WnameTV.requestFocus();


        }
    }

}