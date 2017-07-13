package com.sean.zq.android.view.serialize;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sean.note.android.R;
import com.sean.zq.android.meta.SerializeData;

public class Serialize1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_serialize1);
        SerializeData.Builder builder = new SerializeData.Builder();
        final SerializeData data = builder.setChina(false).setHeight(2.3f).setId(6575985L).setName("ffr").build();
        findViewById(R.id.btn_jump_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Serialize1Activity.this, Serialize2Activity.class);
                intent.putExtra("ff",data);
                startActivity(intent);
            }
        });
    }
}
