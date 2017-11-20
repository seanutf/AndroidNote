package com.sean.zq.android.view.animations;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.sean.note.android.R;

public class PropertyAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_property_animation);
        ObjectAnimator objectAnimator = (ObjectAnimator) ObjectAnimator.ofFloat();
    }
}
