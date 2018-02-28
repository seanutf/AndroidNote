package com.sean.zq.android.module.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.sean.note.android.R;
/**
 * Activity 的生命周期
 * */

public class LifecycleActivity extends AppCompatActivity {

    private static String TAG = "@@@LifecycleActivity@@@";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_lifecycle);
        Log.e(TAG,"call onCreate()");
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LifecycleActivity.this, Lifecycle2Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG,"call onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"call onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG,"call onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG,"call onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"call onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG,"call onRestart()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG,"call onSaveInstanceState()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(TAG,"call onRestoreInstanceState()");
    }
}
