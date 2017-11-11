package com.sean.zq.android.view.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.sean.note.android.R;

/**
 * Created by sean on 2017/11/11.
 * 学习Activity的启动模式
 * 此父类用于打印服务
 * 摘录：彻底弄懂Activity四大启动模式
 * http://blog.csdn.net/mynameishuangshuai/article/details/51491074
 */

public class LaunchModeBaseActivity extends AppCompatActivity {

    private static final String TAG = LaunchModeBaseActivity.class.getName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_launch_mode);
        Log.i(TAG, "********onCreate()方法**********");
        Log.i(TAG, "onCreate：" + getClass().getSimpleName() + " TaskId: " + getTaskId() + " hasCode:" + this.hashCode());
        dumpTaskAffinity();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(TAG, "********onNewIntent()方法*********");
        Log.i(TAG, "onNewIntent：" + getClass().getSimpleName() + " TaskId: " + getTaskId() + " hasCode:" + this.hashCode());
        dumpTaskAffinity();
    }


    protected void dumpTaskAffinity(){
        try {
            ActivityInfo info = this.getPackageManager()
                    .getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.i(TAG, "taskAffinity:"+info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

}
