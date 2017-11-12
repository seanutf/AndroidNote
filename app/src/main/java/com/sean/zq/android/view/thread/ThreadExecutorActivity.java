package com.sean.zq.android.view.thread;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.sean.note.android.R;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by sean on 2017/11/12.
 * java基础：线程和线程池的学习
 */

public class ThreadExecutorActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_thread_executor);
        ExecutorService service = Executors.newFixedThreadPool(3);
        for(int x = 0;x<10;x++){
            final int taskID = x;
            service.execute(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0;i < 10;i++){
                        System.out.println(Thread.currentThread().getName() + ";loop of " + i  + "; task is " +taskID);
                    }
                }
            });
        }
        service.shutdown();
        System.out.println(System.currentTimeMillis() + "@");
        Executors.newScheduledThreadPool(3).schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(System.currentTimeMillis() + "#");
                System.out.println("bombing!!");
                //Integer.valueOf()
                System.out.println(System.currentTimeMillis() + "%");
            }
        }, 10, TimeUnit.SECONDS);
        System.out.println(System.currentTimeMillis() + "&");
    }
}
