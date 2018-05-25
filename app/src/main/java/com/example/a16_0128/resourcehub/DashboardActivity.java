package com.example.a16_0128.resourcehub;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener,NavigationView.OnNavigationItemSelectedListener  {

    private CardView coursecontent,courseOverview,assignment,events,pastpapers,forum;
    TextView selected,useremail,usermajor;
    Spinner Unitspinner,Majorspinner;
    ActionBarDrawerToggle toggle;

    String user_name;
    String user_email;
    String user_major;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //toolbar

        //blackboard
        selected = (TextView)findViewById(R.id.selectedMajor);

        //defining Card view Buttons
        coursecontent =(CardView) findViewById(R.id.btncoursecontent);
        courseOverview =(CardView) findViewById(R.id.btnoverview);
        assignment =(CardView) findViewById(R.id.btnassignment);
        events =(CardView) findViewById(R.id.btnEvents);
        pastpapers =(CardView) findViewById(R.id.btnpastpapers);
        forum =(CardView) findViewById(R.id.btnForum);

        //header info

        //useremail = findViewById(R.id.txtEmail);
        //usermajor = findViewById(R.id.spinList_Major);
        //String name  = getIntent().getStringExtra("name");


        //Navigation Drawer
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        getSupportActionBar();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout2);
        NavigationView navigationView = drawer.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
      //  TextView username = findViewById(R.id.spinList_Major);
       // username.setText(name);
        toggle = new ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        //onclick listener
        coursecontent.setOnClickListener( this);
        courseOverview.setOnClickListener( this);
        assignment.setOnClickListener( this);
        pastpapers.setOnClickListener( this);
        events.setOnClickListener( this);
        forum.setOnClickListener( this);



        //spinner
        final String[] Units = {"None", "ACS 216","ACS 311", "ACS 312", "ACS 314", "AC 302", "ACS 303"};
        final String[] Major = {"Select Major","ACS","COM","ACC","ENV"};
        Unitspinner = (Spinner) findViewById(R.id.spinList_Units);
        Majorspinner = (Spinner) findViewById(R.id.spinList_Major);

        ArrayAdapter<String> majortadpter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Major);
        ArrayAdapter<String> unitadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Units);

        majortadpter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Unitspinner.setAdapter(unitadapter);


        Majorspinner.setAdapter(majortadpter);

        Majorspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
               // unitSelected.setText(Major [position]);
               // UnitSelected = unitSelected.getText().toString();
                //UnitSelected = unitSelected.getText().toString();
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Unitspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position >= 0) {
                    selected.setText(Units[position]);

                }
                }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selected.setText("");
            }
        });

    }

    //Card view logic
    public void onClick(View view) {
        Intent i;
        switch(view.getId()){
            case R.id.btncoursecontent:
                //i= new Intent(this,course_content.class);
                Toast.makeText(DashboardActivity.this,"Clicked Lesson",Toast.LENGTH_SHORT).show();
                //startActivity(i);
                break;
            case R.id.btnoverview:
                i= new Intent(this,OverviewActivity.class);
                startActivity(i);
                break;
            case R.id.btnpastpapers:
                i= new Intent(this,PastpapersActivity.class);
                startActivity(i);
                break;
            case R.id.btnassignment:
                i= new Intent(this,AssignmentActivity.class);
                startActivity(i);
                break;
            case R.id.btnForum:
                i= new Intent(this,ForumActivity.class);
                startActivity(i);
                break;
            case R.id.btnEvents:
                i= new Intent(this,CalendarActivity.class);
                startActivity(i);break;

            default:break;
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(toggle.onOptionsItemSelected(item)){ return  true;}

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

         if (id == R.id.nav_Myaccount) {
            Intent intent = new Intent(DashboardActivity.this,UserAccountActivity.class);
            startActivity(intent);
        }  else if (id == R.id.nav_viewAbout) {
            Intent intent = new Intent(DashboardActivity.this,AboutActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_btnlogout) {
            Intent intent = new Intent(DashboardActivity.this,LoginActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout2);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
