package com.sean.zq.android.module.pattern.singleton;

import android.app.Fragment;

/**
 * Created by sean on 2017/11/7.
 */

public class Student {

    private static Student s = new Student();
    private Student(){
        Fragment fragment = new Fragment();
    }
    public static Student getStudent(){
        return s;
    }


}
