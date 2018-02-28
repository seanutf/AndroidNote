package com.sean.zq.android.module.animations;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.sean.note.android.R;

import static android.view.animation.Animation.RESTART;

public class TweenActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_tweens);
        imageView = (ImageView)findViewById(R.id.imageView2);
        final ConstraintLayout constraintLayout = (ConstraintLayout)findViewById(R.id.cl_root);


        //平移动画 使用TranslateAnimation
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                TranslateAnimation translateAnimation = new TranslateAnimation(0,200,0,200);
                //动画播放的时间间隔
                translateAnimation.setDuration(3000);
                //动画播放的重复次数
                translateAnimation.setRepeatCount(2);
                translateAnimation.setRepeatMode(RESTART);
                imageView.startAnimation(translateAnimation);
            }
        });

        //缩放动画 使用ScaleAnimation
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //.ScaleAnimation scaleAnimation = new ScaleAnimation(0, 2.0f,0,2.0f);
                //ScaleAnimation scaleAnimation = new ScaleAnimation(0, 2.0f,0,2.0f,ScaleAnimation.RELATIVE_TO_SELF,0.5f,ScaleAnimation.RELATIVE_TO_SELF,0.5f );
                ScaleAnimation scaleAnimation = new ScaleAnimation(0, 2.0f,0,2.0f,ScaleAnimation.RELATIVE_TO_PARENT,0.5f,ScaleAnimation.RELATIVE_TO_PARENT,0.5f );
                //动画播放的时间间隔
                scaleAnimation.setDuration(3000);
                //动画播放的重复次数
                scaleAnimation.setRepeatCount(2);
                scaleAnimation.setRepeatMode(RESTART);
                imageView.startAnimation(scaleAnimation);
            }
        });

        //Glide.with(this)
                //.load(url)
                //.into(imageView);

        //旋转动画 使用RotateAnimation
        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //RotateAnimation rotateAnimation = new RotateAnimation(0, 360, 0.5f, 0.5f);
                RotateAnimation rotateAnimation = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                //动画播放的时间间隔
                rotateAnimation.setDuration(3000);
                //动画播放的重复次数
                rotateAnimation.setRepeatCount(2);
                rotateAnimation.setRepeatMode(RESTART);
                imageView.startAnimation(rotateAnimation);
            }
        });

        //镜面动画 使用
        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        //倒影动画 使用
        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TranslateAnimation translateAnimation = new TranslateAnimation();
            }
        });

        //透明度动画 使用AlphaAnimation
        findViewById(R.id.button8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1.0f);
                //动画播放的时间间隔
                alphaAnimation.setDuration(3000);
                //动画结束后保留结束状态
                alphaAnimation.setFillAfter(true);
                imageView.startAnimation(alphaAnimation);
            }
        });

        //组合使用动画 组合使用TranslateAnimation,ScaleAnimation,RotateAnimation,AlphaAnimation
        findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //shareInterpolator 动画插桶 为true表示按照动画的顺序一个个的播放动画
                //AnimationSet animationSet = new AnimationSet(false);
                AnimationSet animationSet = new AnimationSet(true);

                //平移
                TranslateAnimation translateAnimation = new TranslateAnimation(0,200,0,200);
                translateAnimation.setDuration(3000);
                translateAnimation.setRepeatCount(2);
                translateAnimation.setRepeatMode(RESTART);
                //Interpolator

                //缩放
                ScaleAnimation scaleAnimation = new ScaleAnimation(0, 2.0f,0,2.0f,ScaleAnimation.RELATIVE_TO_PARENT,0.5f,ScaleAnimation.RELATIVE_TO_PARENT,0.5f );
                scaleAnimation.setDuration(3000);
                scaleAnimation.setRepeatCount(2);
                scaleAnimation.setRepeatMode(RESTART);

                //旋转
                RotateAnimation rotateAnimation = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                rotateAnimation.setDuration(3000);
                rotateAnimation.setRepeatCount(2);
                rotateAnimation.setRepeatMode(RESTART);

                //透明度
                AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
                alphaAnimation.setDuration(3000);
                alphaAnimation.setRepeatCount (2);
                alphaAnimation.setRepeatMode(RESTART);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        //在动画开始时执行处理
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        //在动画结束时执行处理
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        //在动画重复时执行处理
                    }
                });

                animationSet.addAnimation(translateAnimation);
                animationSet.addAnimation(scaleAnimation);
                animationSet.addAnimation(rotateAnimation);
                animationSet.addAnimation(alphaAnimation);

                imageView.startAnimation(animationSet);
            }
        });
    }
}
