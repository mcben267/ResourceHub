package com.example.a16_0128.resourcehub;

import android.app.Activity;
import android.content.Context;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by geek267 on 2018/05/03.
 */


class CustomAdapter extends ArrayAdapter<String> {

    public CustomAdapter(@NonNull Context context, String[] Notes) {
        super (context,R.layout.customrow ,Notes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater notesInflater=LayoutInflater.from(getContext());
        View customView = notesInflater.inflate(R.layout.customrow,parent,false);

        String fileNameItem = getItem(position);
        TextView filename = (TextView) customView.findViewById(R.id.filename);
        ImageView imageIcon = (ImageView) customView.findViewById(R.id.imageIcon);

        filename.setText(fileNameItem);
        imageIcon.setImageResource(R.drawable.pdficon);


        return customView;
    }
}
