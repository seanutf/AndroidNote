package com.sean.zq.android.view.widget.textview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sean.note.android.R;
import com.sean.zq.android.utils.ScreenUtils;

/**
 * Created by sean on 2016/10/12.
 */
public class TextViewDetailActivity extends AppCompatActivity{

    LinearLayout rootLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view_detail);
        rootLayout = (LinearLayout)findViewById(R.id.activity_text_view_detail_root_layout);
        int type = getIntent().getIntExtra(TextViewActivity.REQUEST_TEXTVIEW_DETAIL_ACTIVITY_TYPE_ONE,-1);
        switch(type){
            case 0:
                //getTextSize()和setTextSize()内容探究
                initGetSetTextViewSizeView();
                break;
            case 1:
                //跑马灯问题的确定
                initMarqueeView();
                break;
            default:
                break;
        }
    }

    private void initMarqueeView() {
        View view = getLayoutInflater().inflate(R.layout.activity_content_textview_marquee,null);
        TextView tvContent = (TextView)view.findViewById(R.id.content);
        TextView tvWidthMatchParent = (TextView)view.findViewById(R.id.tv_width_match_parent);
        TextView tvWidthWrapContent = (TextView)view.findViewById(R.id.tv_width_wrap_content);
        TextView tvWidth180 = (TextView)view.findViewById(R.id.tv_width_180);
        tvContent.setText(getString(R.string.text_view_detail_content_1));
        tvWidthMatchParent.setText(getString(R.string.text_view_detail_content_marquee_long));
        tvWidthMatchParent.setSelected(true);
        tvWidthWrapContent.setText(getString(R.string.text_view_detail_content_marquee_long));
        tvWidthWrapContent.setSelected(true);
        tvWidth180.setText(getString(R.string.text_view_detail_content_marquee_long));
        tvWidth180.setSelected(true);
        rootLayout.addView(view);
    }

    private void initGetSetTextViewSizeView() {
        View view = getLayoutInflater().inflate(R.layout.activity_content_textview_textsize,null);
        TextView tv1Sp = (TextView)view.findViewById(R.id.tv_1_only_sp);
        TextView tv2Px = (TextView)view.findViewById(R.id.tv_2_density_px);
        TextView tv3DimensSp = (TextView)view.findViewById(R.id.tv_3_dimens_sp);
        TextView tv4DimensDp = (TextView)view.findViewById(R.id.tv_4_dimens_dp);
        TextView tv5DimensPx = (TextView)view.findViewById(R.id.tv_5_dimens_px);


        //对textView1设置字体大小，setTextSize传入参数类型默认是sp
        //实际上也是调用setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        tv1Sp.setTextSize(17);
        int tv1SpSize = (int)tv1Sp.getTextSize();
        //对textView2设置字体大小，通过density参数算出17sp对应的像素大小，传入字体类型进行设置
        tv2Px.setTextSize(TypedValue.COMPLEX_UNIT_PX, ScreenUtils.dp2px(this, 17));
        int tv2PxSize = (int)tv2Px.getTextSize();
        //tv3DimensSp.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.font_size_sp));
        //tv3DimensSp.setTextSize(TypedValue.COMPLEX_UNIT_SP, getResources().getDimension(R.dimen.font_size_sp));
        tv3DimensSp.setTextSize(TypedValue.COMPLEX_UNIT_DIP, getResources().getDimension(R.dimen.font_size_sp));
        int tv3DimensSpSize = (int)tv3DimensSp.getTextSize();
        //tv4DimensDp.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.font_size_dp));
        //tv4DimensDp.setTextSize(TypedValue.COMPLEX_UNIT_SP, getResources().getDimension(R.dimen.font_size_dp));
        tv4DimensDp.setTextSize(TypedValue.COMPLEX_UNIT_DIP, getResources().getDimension(R.dimen.font_size_dp));
        int tv4DimensDpSize = (int)tv4DimensDp.getTextSize();
        //tv5DimensPx.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.font_size_px));
        //tv5DimensPx.setTextSize(TypedValue.COMPLEX_UNIT_SP, getResources().getDimension(R.dimen.font_size_px));
        tv5DimensPx.setTextSize(TypedValue.COMPLEX_UNIT_DIP, getResources().getDimension(R.dimen.font_size_px));
        int tv5DimensPxSize = (int)tv5DimensPx.getTextSize();
        int i = (int)getResources().getDimension(R.dimen.font_size_sp);
        int x = (int)getResources().getDimension(R.dimen.font_size_dp);
        int y = (int)getResources().getDimension(R.dimen.font_size_px);


        rootLayout.addView(view);
    }
}
