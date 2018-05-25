package com.example.a16_0128.resourcehub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class UserAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
