package com.sean.zq.android.module.view.widget.surfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by sean on 2016/11/2.
 */
public class BarrageSurfaceView extends SurfaceView implements SurfaceHolder.Callback,Runnable{

    //SurfaceHolder
    private SurfaceHolder mHolder;
    //用于绘图的Canvas
    private Canvas mCanvas;
    //子线程标志位
    private boolean mIsDrawing;

    public BarrageSurfaceView(Context context) {
        super(context);
        init();
    }

    public BarrageSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BarrageSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mHolder = getHolder();
        mHolder.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);
        mHolder.setFormat(PixelFormat.OPAQUE);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mIsDrawing = true;
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mIsDrawing = false;
    }

    @Override
    public void run() {
        while(mIsDrawing){
            draw();
        }
    }

    private void draw(){
        try {
            mCanvas = mHolder.lockCanvas();
            //draw something
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(mCanvas != null){
                mHolder.unlockCanvasAndPost(mCanvas);
            }
        }
    }
}
