package com.sean.zq.android.module.thread;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.sean.note.android.R;
import com.sean.zq.android.module.thread.async.AsyncTaskLoaderActivity;
import com.sean.zq.android.module.thread.async.MyAsyncTaskLoaderActivity;

/**
 * Created by sks on 2017/6/29.
 */

public class ThreadActivity extends AppCompatActivity {

    Button btnJumpThread, btnJumpAsync, btnJumpMyAsync;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_thread);
        btnJumpThread = (Button) findViewById(R.id.btn_jump_thread);
        btnJumpAsync = (Button) findViewById(R.id.btn_jump_async);
        btnJumpMyAsync = (Button) findViewById(R.id.btn_jump_my_async);
        btnJumpThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThreadActivity.this, ThreadExecutorActivity.class));
            }
        });
        btnJumpAsync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThreadActivity.this, AsyncTaskLoaderActivity.class));
            }
        });
        btnJumpMyAsync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThreadActivity.this, MyAsyncTaskLoaderActivity.class));
            }
        });
    }
}
