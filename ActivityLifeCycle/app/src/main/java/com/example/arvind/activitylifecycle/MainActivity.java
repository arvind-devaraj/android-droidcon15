package com.example.arvind.activitylifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity {



    private static final String MY_TAG = "MY_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(MY_TAG, "onCreate");
        showToast("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(MY_TAG, "onStart");
        showToast("onStart");

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(MY_TAG, "onRestoreInstanceState");
        showToast("onRestoreInstanceState");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(MY_TAG, "onResume");
        showToast("onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(MY_TAG, "onPause");
        showToast("onPause");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(MY_TAG, "onSaveInstanceState");
        showToast("onSaveInstanceState");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(MY_TAG, "onStop");
        showToast("onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(MY_TAG, "onDestroy");
        showToast("onDestroy");

    }

    private void showToast(String string)
    {
        Toast.makeText( getApplicationContext(),string, Toast.LENGTH_LONG).show();
    }
}
