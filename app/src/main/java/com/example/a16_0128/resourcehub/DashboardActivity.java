package com.example.a16_0128.resourcehub;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView coursecontent,courseOverview,assignment,events,pastpapers,forum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //toolbar

        //defining Card view Buttons
        coursecontent =(CardView) findViewById(R.id.btncoursecontent);
        courseOverview =(CardView) findViewById(R.id.btnoverview);
        assignment =(CardView) findViewById(R.id.btnassignment);
        events =(CardView) findViewById(R.id.btnEvents);
        pastpapers =(CardView) findViewById(R.id.btnpastpapers);
        forum =(CardView) findViewById(R.id.btnForum);
        //end

        //onclick listener
        coursecontent.setOnClickListener( this);
        courseOverview.setOnClickListener( this);
        assignment.setOnClickListener( this);
        pastpapers.setOnClickListener( this);
        events.setOnClickListener( this);
        forum.setOnClickListener( this);

        //spinner
        final String[] Units = {"Select Unit", "ACS 216","ACS 311", "ACS 312", "ACS 314", "AC 302", "ACS 303"};
        final String[] Major = {"Select Major","ACS","COM","ACC","ENV"};
        Spinner Unitspinner = (Spinner) findViewById(R.id.spinList_Units);
        Spinner Majorspinner = (Spinner) findViewById(R.id.spinList_Major);

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
    }

    //Card view logic
    public void onClick(View view) {
        Intent i;

        switch(view.getId()){
            case R.id.btncoursecontent:
                //i= new Intent(this,course_content.class);
                Toast.makeText(DashboardActivity.this,"Clicked Course Content",Toast.LENGTH_SHORT).show();
                //startActivity(i);
                break;
            case R.id.btnoverview:
                //i= new Intent(this,course_content.class);
                Toast.makeText(DashboardActivity.this,"Clicked Overview",Toast.LENGTH_SHORT).show();
                //startActivity(i);
                break;
            case R.id.btnpastpapers:
                i= new Intent(this,PastpapersActivity.class);
                Toast.makeText(DashboardActivity.this,"Clicked Pastpapers",Toast.LENGTH_SHORT).show();
                startActivity(i);
                break;
            case R.id.btnassignment:
                i= new Intent(this,AssignmentActivity.class);
                Toast.makeText(DashboardActivity.this,"Clicked Assignment",Toast.LENGTH_SHORT).show();
                startActivity(i);
                break;
            case R.id.btnForum:
                i= new Intent(this,ForumActivity.class);
                Toast.makeText(DashboardActivity.this,"Clicked Forum",Toast.LENGTH_SHORT).show();
                startActivity(i);
                break;
            case R.id.btnEvents:
                i= new Intent(this,CalendarActivity.class);
                Toast.makeText(DashboardActivity.this,"Clicked Events",Toast.LENGTH_SHORT).show();
                startActivity(i);break;

            default:break;
        }

    }

}
