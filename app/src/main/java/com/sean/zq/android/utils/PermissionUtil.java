package com.sean.zq.android.utils;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.sean.zq.android.view.permission.PermissionActivity;

/**
 * Created by sks on 2017/7/6.
 */

public class PermissionUtil {

    private final static String TAG  = "PermissionUtil";

    private final static int PERMISSIONS_TAG_REQUEST_READ_CONTACTS = 0;
    private final static int PERMISSIONS_TAG_REQUEST_CAMERA = 1;
    private static final String SCHEME = "package";
    static boolean isFirst = true;
    public static void getPermission(final Context context){
        if (ContextCompat.checkSelfPermission(context.getApplicationContext(), Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale((Activity) context,
                    Manifest.permission.CAMERA)){
                new AlertDialog.Builder(context)
                        .setMessage("请授予我们照相机权限，以便应用功能的正常使用")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions((Activity) context,
                                        new String[]{Manifest.permission.CAMERA},
                                        PERMISSIONS_TAG_REQUEST_CAMERA);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create()
                        .show();
            }else{
                if(isFirst){
                    ActivityCompat.requestPermissions((Activity) context,
                            new String[]{Manifest.permission.CAMERA},
                            PERMISSIONS_TAG_REQUEST_CAMERA);
                    isFirst = false;
                }else {
                    new AlertDialog.Builder((Activity) context)
                            .setMessage("必须授予应用照相机权限，才能此功能！点击确定跳转到应用信息页面，请打开相关权限")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent();
                                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                    Uri uri = Uri.fromParts(SCHEME, context.getPackageName(), null);
                                    intent.setData(uri);
                                    context.startActivity(intent);
                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .create()
                            .show();
                }
            }
        }
    }
}
