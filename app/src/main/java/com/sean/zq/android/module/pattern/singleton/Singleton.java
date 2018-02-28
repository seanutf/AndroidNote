package com.sean.zq.android.module.pattern.singleton;

/**
 * Created by zhangyi on 2017/11/7.
 */

public class Singleton {
    private Singleton(){}
    public static Singleton getInstance(){
        return SingletonHolder.sInstance;
    }

    private static class SingletonHolder{
        private  static final Singleton sInstance = new Singleton();
    }
}
