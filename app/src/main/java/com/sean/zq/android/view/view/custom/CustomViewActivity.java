package com.sean.zq.android.view.view.custom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.sean.note.android.R;

import java.util.HashMap;

public class CustomViewActivity extends AppCompatActivity {
    LinearLayout rootView;
    private static final String TAG = "CustomViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_custom_view);
        initView();
    }

    private void initView() {
        CustomRedView customRedView = new CustomRedView(this);
        rootView = (LinearLayout) findViewById(R.id.root_view_custom_view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(300,300);
        //customRedView.setLayoutParams(layoutParams);
        rootView.addView(customRedView);
    }
}
