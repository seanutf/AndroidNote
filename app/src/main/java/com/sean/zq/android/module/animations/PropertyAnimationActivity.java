package com.sean.zq.android.module.animations;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sean.note.android.R;

public class PropertyAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_property_animation);
        ObjectAnimator objectAnimator = (ObjectAnimator) ObjectAnimator.ofFloat();
        //InetAddress.getLocalHost() ; //返回本地主机
    }
}
