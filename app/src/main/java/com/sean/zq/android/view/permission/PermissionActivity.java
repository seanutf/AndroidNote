package com.sean.zq.android.view.permission;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.sean.note.android.R;

/**
 * Created by sean on 2017/7/5.
 * 该页面展示运行时权限的最佳实践
 */

public class PermissionActivity extends AppCompatActivity {

    Button btnOpenCamera, btnGetLocation, btnGetContacts;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_permission);
        btnOpenCamera = (Button) findViewById(R.id.btn_to_open_camera);
        btnGetLocation = (Button) findViewById(R.id.btn_to_get_location);
        btnGetContacts = (Button) findViewById(R.id.btn_to_get_contacts);

        btnOpenCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT  >= Build.VERSION_CODES.M){
                    //checkSelfPermission();
                }
            }
        });
    }
}
