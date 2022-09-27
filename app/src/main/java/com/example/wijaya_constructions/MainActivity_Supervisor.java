package com.example.wijaya_constructions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;



public class MainActivity_Supervisor extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private  DHandler dHandler=new DHandler(this);

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home_Fragment()).commit();
                break;

            case R.id.workeradd:

                Intent intent = new Intent(this, Register_Workers.class);
                startActivity(intent);

                break;

            case R.id.wremove:

                Intent intent2 = new Intent(this, DeleteAndUpdateWorkers.class);
                startActivity(intent2);

                break;

            case R.id.atendance:

                Intent intent3 = new Intent(this, Mark_Atendance_Workers.class);
                startActivity(intent3);

                break;


            case R.id.cal:

                Intent intent4 = new Intent(this, Salary_Cal.class);
                startActivity(intent4);

                break;



            case R.id.logout:

                Intent intent5 = new Intent(this, Log_Out.class);
                startActivity(intent5);

                break;


        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

        }

    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_supervisor);



        dHandler.openDB();

        drawerLayout=findViewById(R.id.nav_view);

        NavigationView navigationView=findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        Toolbar toolbar=findViewById(R.id.toolbar);
        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(this,
                drawerLayout,toolbar,R.string.open_nav,R.string.close_nav);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Home_Fragment()).commit();




    }


}