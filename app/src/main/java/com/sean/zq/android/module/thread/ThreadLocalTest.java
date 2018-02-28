package com.sean.zq.android.module.thread;

/**
 * Created by Sean on 2018/1/23.
 */

public class ThreadLocalTest {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public void setThread(){
        threadLocal.set(5);
    }
}
