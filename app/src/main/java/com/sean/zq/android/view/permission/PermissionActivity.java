package com.sean.zq.android.view.permission;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sean.note.android.R;
import com.sean.zq.android.utils.PermissionUtil;

/**
 * Created by sean on 2017/7/5.
 * 该页面展示运行时权限的最佳实践
 */

public class PermissionActivity extends AppCompatActivity {

    Button btnOpenCamera, btnGetLocation, btnGetContacts, btnGettorage, btnGetAll;
    private final static int PERMISSIONS_TAG_REQUEST_CAMERA = 1;
    private static final String SCHEME = "package";
    boolean isFirst = true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_permission);
        btnOpenCamera = (Button) findViewById(R.id.btn_to_open_camera);
        btnGetLocation = (Button) findViewById(R.id.btn_to_get_location);
        btnGetContacts = (Button) findViewById(R.id.btn_to_get_contacts);
        btnGettorage = (Button) findViewById(R.id.btn_to_get_storage);
        btnGetAll = (Button) findViewById(R.id.btn_to_get_all);

        btnOpenCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PermissionUtil.getPermission(PermissionActivity.this);
            }
        });
    }
}
