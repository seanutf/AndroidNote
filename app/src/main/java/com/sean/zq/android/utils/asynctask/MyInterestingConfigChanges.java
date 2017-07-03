package com.sean.zq.android.utils.asynctask;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Log;

/**
 * Created by sks on 2017/7/3.
 */

public class MyInterestingConfigChanges {

    private static final String TAG = "MyInterest";

    final Configuration mLastConfiguration = new Configuration();
    int mLastDensity;
    boolean applyNewConfig(Resources res) {
        Log.i(TAG, "InterestingConfigChanges is have NewConfig");
        int configChanges = mLastConfiguration.updateFrom(res.getConfiguration());
        boolean densityChanged = mLastDensity != res.getDisplayMetrics().densityDpi;
        if (densityChanged || (configChanges&(ActivityInfo.CONFIG_LOCALE
                |ActivityInfo.CONFIG_UI_MODE|ActivityInfo.CONFIG_SCREEN_LAYOUT)) != 0) {
            Log.i(TAG, "InterestingConfigChanges apply NewConfig");
            mLastDensity = res.getDisplayMetrics().densityDpi;
            return true;
        }
        return false;
    }
}
