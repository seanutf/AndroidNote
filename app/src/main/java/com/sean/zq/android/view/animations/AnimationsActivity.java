package com.sean.zq.android.view.animations;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sean.note.android.R;

public class AnimationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animations);
        findViewById(R.id.btn_jump_tween).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AnimationsActivity.this,TweenActivity.class));
            }
        });
        findViewById(R.id.btn_jump_property).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AnimationsActivity.this,PropertyAnimationActivity.class));
            }
        });
    }
}
