package com.sean.zq.android.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by sean on 2017/8/13.
 */

@SeanAnnotation(color = "red",value = "")
public class AnnotationTest {

    public void cheakAnn(){
        //判断AnnotationTest类存不存在SeanAnnotation这个Annotation
        if(AnnotationTest.class.isAnnotationPresent(SeanAnnotation.class)){
            //既然有，就先得到这个注解的实例对象，这个实例对象是在应用的时候产生的
            SeanAnnotation seanAnnotation = AnnotationTest.class.getAnnotation(SeanAnnotation.class);
            String color = seanAnnotation.color();
        }
    }
}
