package com.sean.zq.android.utils.customView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by sean on 2016/9/29.
 * 仿ios的弹性ListView
 * 效果：界面滚动到底端或者顶端后会随手势继续往上或往下滑动一段距离，手一离开屏幕，界面恢复原位。
 * 这种方法修改后的效果感人，弹入弹出动画比较生硬，
 * 且这种该法似乎无法加入动画以控制弹入弹出过程，所以不建议使用此方法
 * 取自《Android群英传》徐宜生著2015年9月第1版P75.
 */
public class StretchListView extends ListView{

    public StretchListView(Context context) {
        super(context);
    }

    public StretchListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StretchListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, 50, isTouchEvent);
    }
}
