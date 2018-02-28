package com.sean.zq.android.module.animations;

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
    }
}
