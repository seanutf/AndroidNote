package com.sean.zq.android.module.view.view.custom;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;

import java.util.Arrays;

/**
 * Created by sean on 2017/12/21.
 *
 * 钢琴键盘的自定义View.
 */

public class PianoKeyboardView extends View {

    private static final String TAG = "PianoKeyboardView";
    private static final int MAX_FINGERS = 5;
    private static final int WHITE_KEYS_COUNT = 7;
    private static final int BLACK_KEYS_COUNT = 5;
    private static final float BLACK_TO_WHITE_WIDTH_RATIO = 0.625f;
    private static final float BLACK_TO_WHITE_HEIGHT_RATIO = 0.54f;

    private Paint mWhiteKeyPaint, mBlackKeyPaint, mBlackKeyHitPanint, mWhiteKeyHitPaint;

    //最多支持5个手指
    private Point[] mFingerPoints = new Point[MAX_FINGERS];
    private int[] mFingerTones = new int[MAX_FINGERS];
    private SoundPool mSounPool;
    private SparseIntArray mToneToIndexMap = new SparseIntArray();
    private Paint mCKeyPaint, mCSharpKeyPaint, mDkeyPaint, mDSharpKeyPaint, mEkeyPaint, mESharpKeyPaint,
            mFKeyPaint, mFSharpKeyPaint, mGKeyPaint, mGSharpKeyPaint, mAKeyPaint, mASharpKeyPaint,
            mBKeyPaint, mBSharpKeyPaint;
    private Rect mCKey = new Rect(), mCSharpKey = new Rect(), mDKey = new Rect(), mDSharpKey = new Rect(),
            mEKey = new Rect(), mESharpKey = new Rect(), mFKey = new Rect(), mFSharpKey = new Rect(),
            mGKey = new Rect(), mGSharpKey = new Rect(), mAKey = new Rect(), mASharpKey = new Rect(),
            mBKey = new Rect(), mBSharpKey = new Rect();
    private MotionEvent.PointerCoords mPointerCoords;

    public PianoKeyboardView(Context context) {
        super(context);
    }

    public PianoKeyboardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PianoKeyboardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        mPointerCoords = new MotionEvent.PointerCoords();
        Arrays.fill(mFingerPoints, null);
        Arrays.fill(mFingerTones, -1);
        loadKeySamples(getContext());
        setupPaints();
    }

    private void setupPaints() {
        //……简单起见，省略部分代码
    }

    private void loadKeySamples(Context context) {
        mSounPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        //mToneToIndexMap.put(R.raw.c, mSounPool.load(context, R.raw.c, 1));
        //……简单起见，省略部分代码
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        releaseKeySamples();
    }

    private void releaseKeySamples() {
        mToneToIndexMap.clear();
        mSounPool.release();
    }
}
