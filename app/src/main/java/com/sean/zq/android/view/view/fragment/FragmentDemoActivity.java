package com.sean.zq.android.view.view.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.sean.note.android.R;

/**
 * Created by sean on 2016/10/15.
 */
public class FragmentDemoActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);
        Fragment f = new Fragment();
                TextView btnApiDemo = (TextView) findViewById(R.id.btn_api_demo);
        btnApiDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentDemoActivity.this,FragmentLayout.class);
                startActivity(intent);
            }
        });
    }
}
