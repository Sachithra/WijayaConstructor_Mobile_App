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

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


private  DHandler dHandler=new DHandler(this);


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home_Fragment()).commit();
                break;

           case R.id.admin:
               // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home_Fragment()).commit();
             Intent intent = new Intent(this,Registe_Admin.class);
                startActivity(intent);

               break;


           case R.id.supervisoradd:


               Intent intent1 = new Intent(this,Registerr_Supervisor.class);
               startActivity(intent1);
               break;

            case R.id.workeradd:
                Intent intent2 = new Intent(this, Register_Workers.class);
                startActivity(intent2);
                break;

            case R.id.siteadd:
                Intent intent3 = new Intent(this,AddConstructionSites.class);
                startActivity(intent3);
                break;


            case R.id.sremove:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Delete_Fragment_()).commit();
                Intent intent4 = new Intent(this,DeleteAndUpdateSupervisor.class);
                startActivity(intent4);
                break;

            case R.id.wremove:
                Intent intent5 = new Intent(this,DeleteAndUpdateWorkers.class);
                startActivity(intent5);
                break;

            case R.id.view:
                Intent intent6 = new Intent(this,View_Supervisor_And_Workers.class);
                startActivity(intent6);
                break;


            case R.id.logout:
                Intent intent7 = new Intent(this,Log_Out.class);
                startActivity(intent7);
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



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


