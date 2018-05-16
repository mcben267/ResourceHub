package com.example.a16_0128.resourcehub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.Calendar;

public class CalendarActivity extends AppCompatActivity implements View.OnClickListener{

    Button sycnCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        sycnCalendar = findViewById(R.id.btnSync);
        sycnCalendar.setOnClickListener(CalendarActivity.this);

        MaterialCalendarView materialCalendarView =(MaterialCalendarView) findViewById(R.id.calendarView);

        materialCalendarView.state().edit()
                .setFirstDayOfWeek(Calendar.MONDAY)
                .setMinimumDate(CalendarDay.from(1990, 1, 1))
                .setMaximumDate(CalendarDay.from(2100, 12, 31))
                .setCalendarDisplayMode(CalendarMode.WEEKS)
                .commit();
    }


    @Override
    public void onClick(View view) {
        showToast();
    }
    void  showToast(){
        Toast.makeText(CalendarActivity.this,"synchronizing",Toast.LENGTH_SHORT).show();


    }
}
