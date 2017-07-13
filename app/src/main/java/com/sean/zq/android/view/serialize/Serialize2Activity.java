package com.sean.zq.android.view.serialize;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sean.note.android.R;
import com.sean.zq.android.meta.SerializeData;

public class Serialize2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_serialize2);
        if(getIntent() != null){
            SerializeData data = getIntent().getParcelableExtra("ff");
        }
    }
}
