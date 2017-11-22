package com.sean.zq.android.view.animations;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.sean.note.android.R;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class PropertyAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_property_animation);
        ObjectAnimator objectAnimator = (ObjectAnimator) ObjectAnimator.ofFloat();
        //InetAddress.getLocalHost() ; //返回本地主机

        try {
            InetAddress inetAddress = InetAddress.getByName("Zhangyi") ; //在给定主机名(计算机的名字或者域名)的情况下确定主机的IP地址
        inetAddress.getHostAddress(); //返回IP地址的字符串
            inetAddress.getHostName(); //返回主机名
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
