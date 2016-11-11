package com.sean.zq.android.view.widget.textview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
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

    final static int COLOR_ACCENT = Color.parseColor("#FF4081");
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
            case 2:
                //给TextView添加阴影
                initShadowView();
                break;
            case 3:
                //给TextView添加html超链接
                initHtmlLinkView();
                break;
            default:
                break;
        }
    }

    private void initHtmlLinkView() {
        View view = getLayoutInflater().inflate(R.layout.activity_content_textview_html,null);
        ;
        TextView tv = ((TextView)view.findViewById(R.id.tv_html));
       /* StringBuffer sb = new StringBuffer();
        sb.append("<h1><font color='#ff0000'>Html标签方式:</font></h1>");
        sb.append("<h6><b><i><font color='#00ff00'><a href='https://github.com/seanutf/AndroidNote'>");
        sb.append(getString(R.string.text_view_detail_content_html));
        sb.append("</a></font></i></b></h6>");
        tv.setText(Html.fromHtml(sb.toString()));*/
        /* 上述方法是从网上摘抄，并且很有意思，想要达到的效果其实就是向一段文本中添加html超链接
        但是它还设置了字体，字号，字色，使整个示例看起来很乱，我不懂得html语言，不太清楚这些标签是否是必须的，所以我想简化它，
        而它做的就是向StringBuffer添加了一段html代码，然后把StringBuffer赋给TextView
        <h1><font color='#ff0000'>Html标签方式:</font></h1>
        <h6>
            <b>
                <i>
                    <font color='#00ff00'>
                        <a href='https://github.com/seanutf/AndroidNote'>
                            getString(R.string.text_view_detail_content_html)
                        </a>
                    </font>
                </i>
            </b>
        </h6>
        实际上，如果我们的项目是一个可以通过网络与服务器交互的项目，这段html代码完全可以由后台传入，我们不需StringBuffer，
        直接设置tv.setText(Html.fromHtml(text.toString()))即可；但如果我们的项目是一个本地项目，想要嵌入网络连接，还真需要这样做
        * */
        StringBuffer sb = new StringBuffer();
        sb.append("<h6><i><font><a href='https://github.com/seanutf/AndroidNote'>");
        sb.append(getString(R.string.text_view_detail_content_html));
        sb.append("</a></font></i></h6>");
        tv.setText(Html.fromHtml(sb.toString()));
        tv.setMovementMethod(LinkMovementMethod.getInstance());// 这句很重要,使超链接<a href>起作用
        tv.setAutoLinkMask(Linkify.WEB_URLS);// 当文本内容中包含超链接格式的文本时,自动转换成超链接样式,点击会自动跳转到指定的网页
        tv.setAutoLinkMask(Linkify.PHONE_NUMBERS);//自动转手机号码点击它可进入系统拨号界面
        tv.setAutoLinkMask(Linkify.EMAIL_ADDRESSES);//自动转邮件地址点击它可发送邮件(要提前设置好自己的电子邮件)
        tv.setAutoLinkMask(Linkify.MAP_ADDRESSES);//自动转街道地址点击它可查看位置(前提已安装了google地图)
        tv.setAutoLinkMask(Linkify.ALL);//包括上面4种情况
        rootLayout.addView(view);
    }

    private void initShadowView() {
        View view = getLayoutInflater().inflate(R.layout.activity_content_textview_shadow,null);
        ((TextView)view.findViewById(R.id.tv_shadow)).setShadowLayer(40.5f, 15, -10, 0xff00ff00);
        rootLayout.addView(view);
    }

    private void initMarqueeView() {
        View view = getLayoutInflater().inflate(R.layout.activity_content_textview_marquee,null);
        TextView tvContent = (TextView)view.findViewById(R.id.content);
        //tvContent.setCompoundDrawablesWithIntrinsicBounds();
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
