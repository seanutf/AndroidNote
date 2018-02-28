package com.sean.zq.android.module.view.view.clickEvent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.sean.note.android.R;

/**
 * Created by sean on 2017/11/14.
 * View和ViewGroup的触摸事件的学习
 */

public class ViewClickEventActivity extends AppCompatActivity {

    private static final String TAG  = "ViewClickEventActivity";

    ImageView iv;
    Button btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_view_click_enent);
        iv = (ImageView)findViewById(R.id.iv);
        btn = (Button) findViewById(R.id.btn);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onTouch return false will print twice");
            }
        });
        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                /**
                 * ACTION_DOWN 0
                 * ACTION_UP   1
                 * ACTION_MOVE 2
                 *
                 * */
                /**
                 * false  打印1次 0  ACTION_DOWN
                 *        dispatchTouchEvent返回true,响应所有触摸事件
                 *        先响应触摸事件，后响应点击事件
                 * true   打印3次 012 ACTION_DOWN ACTION_UP ACTION_MOVE
                 *        仅仅响应触摸事件，不响应点击事件
                 *
                 * */
                Log.i(TAG, "ImageView onTouch event = " + event.getAction());
                return false;
            }
        });
        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                /**
                 * ACTION_DOWN 0
                 * ACTION_UP   1
                 * ACTION_MOVE 2
                 *
                 * */
                /**
                 * false  打印3次 012 ACTION_DOWN ACTION_UP ACTION_MOVE
                 * true   打印3次 012 ACTION_DOWN ACTION_UP ACTION_MOVE
                 *
                 * */
                Log.i(TAG, "Button onTouch event = " + event.getAction());
                return true;
            }
        });

    }
}
