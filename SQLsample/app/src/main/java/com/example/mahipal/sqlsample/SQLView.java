package com.example.mahipal.sqlsample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

//this will display fruits.db on sqlview.xml



public class SQLView extends ActionBarActivity {

    TextView TVgetInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlview);

        TextView TVgetInfo = (TextView)findViewById(R.id.TVgetInfo);
        Fruits info = new Fruits(this);
        info.open();
        String data = info.getData();
        info.close();
        TVgetInfo.setText(data);
    }




}
