package com.example.a16_0128.resourcehub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ForumActivity extends AppCompatActivity {

    //private RecyclerView mMessageRecycler;
   // private MessageListAdapter mMessageAdapter;
    List messageList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


       // mMessageRecycler = (RecyclerView) findViewById(R.id.reyclerview_message_list);
       // mMessageAdapter = new MessageListAdapter(this, messageList);
      //  mMessageRecycler.setLayoutManager(new LinearLayoutManager(this));
      //  mMessageRecycler.setAdapter(mMessageAdapter);
    }
}
