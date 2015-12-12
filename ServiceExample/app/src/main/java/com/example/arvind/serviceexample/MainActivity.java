package com.example.arvind.serviceexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_CATEGORY = "MyServiceActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean startServiceClick(View button) {
        Intent intent = new Intent(this, MyService.class);
        Log.d(LOG_CATEGORY, "before starting service");
        this.startService(intent);
        Log.d(LOG_CATEGORY, "after starting service");
        return true;
    }
}
