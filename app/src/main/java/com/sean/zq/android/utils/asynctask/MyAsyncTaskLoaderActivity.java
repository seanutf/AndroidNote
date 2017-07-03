package com.sean.zq.android.utils.asynctask;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by sks on 2017/7/3.
 */

public class MyAsyncTaskLoaderActivity extends AppCompatActivity {

    private static final String TAG = "MyAsyncTaskActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "AsyncTaskLoaderActivity is onCreate");
        FragmentManager fm = getFragmentManager();
        // Create the list fragment and add it as our sole content.
        if (fm.findFragmentById(android.R.id.content) == null) {
            MyAsyncTaskLoaderFragment list = new MyAsyncTaskLoaderFragment();
            Log.i(TAG, "AppListFragment is init");
            fm.beginTransaction().add(android.R.id.content, list).commit();
            Log.i(TAG, "FragmentManager is commit AppListFragment");
        }
    }
}
