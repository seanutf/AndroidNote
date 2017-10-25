package com.sean.zq.android.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by zhangyi on 2017/8/13.
 */

@Retention(RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface SeanAnnotation {
    String color() default "blue";
    String value();
}
