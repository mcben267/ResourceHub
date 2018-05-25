package com.example.a16_0128.resourcehub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class OverviewActivity extends AppCompatActivity {

    String url="https://mcben267.000webhostapp.com/mcbenapp/acs216viewcontent.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ListView lv= (ListView) findViewById(R.id.lv);
        final Downloader d=new Downloader(this,url,lv);
        Button refresh=(Button) findViewById(R.id.fab);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //EXECUTE DOWNLOAD
                d.execute();
            }
        });

    }
}
