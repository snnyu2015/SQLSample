package com.example.mahipal.sqlsample;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//serves as SQLLiteExample.java in this case!!!

public class MainActivity extends ActionBarActivity {

    Button btnUpdateSQL, btnViewDB;
EditText ETname, ETcolor, ETvitamins, ETlocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqliteexample);

        btnUpdateSQL = (Button) findViewById(R.id.btnUpdateSQL);
        btnViewDB = (Button) findViewById(R.id.btnViewDB);

        ETname = (EditText) findViewById(R.id.ETname);
        ETcolor = (EditText) findViewById(R.id.ETcolor);
        ETvitamins = (EditText) findViewById(R.id.ETvitamins);
        ETlocation = (EditText) findViewById(R.id.ETlocation);


        //Buttons go here
//------------------------------------------------------------------------
        btnUpdateSQL.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String name= ETname.getText().toString();
                String color= ETcolor.getText().toString();
                String vitamins= ETvitamins.getText().toString();
                String location= ETlocation.getText().toString();

                Fruits entry = new Fruits(MainActivity.this);
                entry.open();
                entry.createEntry(name, color, vitamins, location);
                entry.close();

            }

        });

//------------------------------------------------------------------------
        btnViewDB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
Intent i = new Intent("com.example.mahipal.SQLView");
                startActivity(i);

            }

        });
//------------------------------------------------------------------------

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
