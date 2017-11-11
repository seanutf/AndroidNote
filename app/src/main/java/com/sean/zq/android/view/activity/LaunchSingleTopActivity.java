package com.sean.zq.android.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.sean.note.android.R;

/**
 * Created by zhangyi on 2017/11/11.
 */

public class LaunchSingleTopActivity extends LaunchModeBaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViewById(R.id.btn_launch_mode_0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LaunchSingleTopActivity.this, LaunchStandardActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_launch_mode_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LaunchSingleTopActivity.this, LaunchSingleTopActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_launch_mode_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LaunchSingleTopActivity.this, LaunchSingleTaskActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_launch_mode_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LaunchSingleTopActivity.this, LaunchSingleInstanceActivity.class);
                startActivity(intent);
            }
        });
//        findViewById(R.id.btn_launch_mode_4).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(LaunchStandardActivity.this, LaunchStandardActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}
