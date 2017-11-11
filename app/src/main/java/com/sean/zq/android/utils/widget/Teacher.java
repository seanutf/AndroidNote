package com.sean.zq.android.utils.widget;

/**
 * Created by zhangyi on 2017/11/7.
 */

public class Teacher {

    private static Teacher teacher = null;
    private Teacher(){
        Runtime.getRuntime();
    }
    public static synchronized Teacher getTeacher(){
        if(teacher == null)
            teacher = new Teacher();
        return teacher;
    }

}
