package com.sean.zq.android.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by sean on 2017/1/4.
 */

public class MBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "MBroadcastReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("msg");
        Log.i(TAG, msg);
    }
}
