package com.example.a16_0128.resourcehub;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class DashBoardActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView coursecontent,courseOverview,assignment,events,pastpapers,forum;
    private DrawerLayout nDrawer;
    private ActionBarDrawerToggle nTogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        //
       // NavigationView navigationView = (NavigationView) findViewById(R.id.navi);

        //defining Card view Buttons
        coursecontent =(CardView) findViewById(R.id.btncoursecontent);
        courseOverview =(CardView) findViewById(R.id.btnoverview);
        assignment =(CardView) findViewById(R.id.btnassignment);
        events =(CardView) findViewById(R.id.btnEvents);
        pastpapers =(CardView) findViewById(R.id.btnpastpapers);
        forum =(CardView) findViewById(R.id.btnForum);
        //end

        //onclick listener
        coursecontent.setOnClickListener(this);
        courseOverview.setOnClickListener(this);
        assignment.setOnClickListener(this);
        pastpapers.setOnClickListener(this);
        events.setOnClickListener(this);
        forum.setOnClickListener(this);

        //menu drawer
        nDrawer = findViewById(R.id.drawerId);
        nTogle = new ActionBarDrawerToggle(this, nDrawer, R.string.open, R.string.close);
        nDrawer.addDrawerListener(nTogle);
        nTogle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //end of drawer
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (nTogle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Card view logic
    @Override
    public void onClick(View view) {
        Intent i;

        switch(view.getId()){
            case R.id.btncoursecontent:
                //i= new Intent(this,course_content.class);
                Toast.makeText(DashBoardActivity.this,"Clicked Course Content",Toast.LENGTH_SHORT).show();
                //startActivity(i);
                break;
            case R.id.btnoverview:
                //i= new Intent(this,course_content.class);
                Toast.makeText(DashBoardActivity.this,"Clicked Overview",Toast.LENGTH_SHORT).show();
                //startActivity(i);
                break;
            case R.id.btnpastpapers:
                //i= new Intent(this,course_content.class);
                Toast.makeText(DashBoardActivity.this,"Clicked Pastpapers",Toast.LENGTH_SHORT).show();
                //startActivity(i);
                break;
            case R.id.btnassignment:
                i= new Intent(this,AssignmentActivity.class);
                Toast.makeText(DashBoardActivity.this,"Clicked Assignment",Toast.LENGTH_SHORT).show();
                startActivity(i);
                break;
            case R.id.btnForum:
                i= new Intent(this,ForumActivity.class);
                Toast.makeText(DashBoardActivity.this,"Clicked Forum",Toast.LENGTH_SHORT).show();
                startActivity(i);
                break;
            case R.id.btnEvents:
                i= new Intent(this,CalendarActivity.class);
                Toast.makeText(DashBoardActivity.this,"Clicked Events",Toast.LENGTH_SHORT).show();
                startActivity(i);break;
            case  R.id.btnmyaccount:
                //i= new Intent(this,CalendarActivity.class);
                Toast.makeText(DashBoardActivity.this,"Clicked Account",Toast.LENGTH_SHORT).show();
              //    startActivity(i);break;

            default:break;
        }

    }


}
