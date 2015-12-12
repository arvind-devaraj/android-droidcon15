package com.example.arvind.servicemusic;

import android.support.v7.app.AppCompatActivity;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onClick(View view) {
        Intent intent = new Intent(this, MultimediaService.class);
        intent.putExtra("action", "start");
        startService(intent);
        return true;
    }

    public boolean onStopClicked(View view) {
        Intent intent = new Intent(this, MultimediaService.class);
        intent.putExtra("action", "stop");
        startService(intent);
        return true;
    }
}
