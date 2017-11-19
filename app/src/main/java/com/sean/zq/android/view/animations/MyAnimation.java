package com.sean.zq.android.view.animations;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by sean on 2017/11/19.
 * 自定义的补间动画
 */

public class MyAnimation extends Animation {

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
    }
}
