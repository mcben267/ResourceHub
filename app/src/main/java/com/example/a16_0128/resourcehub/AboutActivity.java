package com.example.a16_0128.resourcehub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class AboutActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AboutPage aboutPage = new AboutPage(this);
        aboutPage.isRTL(false);
        aboutPage.setDescription("Prototype version 0.1");
        aboutPage.addItem(new Element().setTitle("Version 1.0"));
        aboutPage.addGroup("connect with us");
        aboutPage.addEmail("marcus@gmail.com");
        aboutPage.addWebsite("www.mcben267@wordpress.com");
        aboutPage.addFacebook("Resource hub kenya");
        aboutPage.addGitHub("mcben267");
        View aboutpage = aboutPage.create();
        setContentView(aboutpage);

    }
}
