package com.sean.zq.android.utils;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

import com.sean.zq.android.view.DecelerateAccelerateInterpolator;

/**
 * Created by sean on 2016/10/11.
 */
public class AnimationHelper {

    /**
     * 创建平移动画
     */
    public static Animation createTranslateAnim(Context context, int fromX, int toX) {
        TranslateAnimation tlAnim = new TranslateAnimation(fromX, toX, 0, 0);
        //自动计算时间
        long duration = (long) (Math.abs(toX - fromX) * 1.0f / ScreenUtils.getScreenW(context) * 4000);
        tlAnim.setDuration(duration);
        tlAnim.setInterpolator(new DecelerateAccelerateInterpolator());
        tlAnim.setFillAfter(true);

        return tlAnim;
    }
}
