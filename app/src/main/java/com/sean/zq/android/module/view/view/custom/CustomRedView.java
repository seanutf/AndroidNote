package com.sean.zq.android.module.view.view.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by sean on 2017/12/19.
 *
 * 自定义View
 */

public class CustomRedView extends View {

    public CustomRedView(Context context) {
        super(context);
    }

    public CustomRedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomRedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Paint paint = new Paint();
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG); //创建笔刷时默认开启抗锯齿模式

        //自定义View时如果需要自定义显示风格
        //就需要设置paint参数
        //paint.setColor(Color.RED); //设置笔刷的颜色
        paint.setStyle(Paint.Style.STROKE); //设置绘画风格为画笔模式，FILL 是填充模式，STROKE 是画线模式（即勾边模式），FILL_AND_STROKE 是两种模式一并使用：既画线又填充。它的默认值是 FILL
        paint.setStrokeWidth(2); // 设置笔刷笔锋的宽度
        //paint.setStrokeCap(Paint.Cap.BUTT);//设置笔刷线条端点形状，可以用来设置点的形状,ROUND 画出来是圆形的点，SQUARE 或 BUTT 画出来是方形的点。
        //paint.setAntiAlias(true);  //是否开启抗锯齿

        //画圆
        //canvas.drawCircle(300, 300, 200, paint);

        //颜色填充,
        // 一般用于在绘制之前设置底色，或者在绘制之后为界面设置半透明蒙版
        //canvas.drawColor(Color.parseColor("#88880000"));
        //canvas.drawColor(Color.BLACK);
        //canvas.drawRGB(100, 200, 100);
        //canvas.drawARGB(100, 100, 200, 100);

        //画矩形,
        // left, top, right, bottom 是矩形四条边的坐标
        //canvas.drawRect(100, 100, 500, 500, paint);

        //画点
        //画点需要设置paint的setStrokeWidth和setStrokeCap方法
        //canvas.drawPoint(50, 50, paint);

        //画多个点
        //float[] points = {30, 20, 50, 50, 50, 100, 100, 50, 100, 100, 150, 50, 150, 100};//点的xy坐标集合
        // 绘制四个点：(50, 50) (50, 100) (100, 50) (100, 100)
        //canvas.drawPoints(points, 2 /* 跳过数组前几个元素不画 */, 8 /* 集合中想要画的点个数*2（xy坐标）*/, paint);

        //画椭圆，
        // 只能绘制横着的或者竖着的椭圆，不能绘制斜的（斜的倒是也可以，但不是直接使用 drawOval()，而是配合几何变换）
        //left, top, right, bottom 是这个椭圆的左、上、右、下四个边界点的坐标，也可以用来画圆。
        //canvas.drawOval(new RectF(50, 50, 350, 200), paint);
        //最小版本5.0以上版本
        //canvas.drawOval(50, 50, 350, 200, paint);

        //画线
        //startX, startY, stopX, stopY 分别是线的起点和终点坐标。
        //canvas.drawLine(200, 200, 800, 500, paint);

        //画一组线
        //float[] points = {20, 20, 120, 20, 70, 20, 70, 120, 20, 120, 120, 120, 150, 20,
        // 250, 20, 150, 20, 150, 120, 250, 20, 250, 120, 150, 120, 250, 120};
        //canvas.drawLines(points, paint);

        //画圆角矩形
        //left, top, right, bottom 是四条边的坐标，rx 和 ry 是圆角的横向半径和纵向半径
        //canvas.drawRoundRect(new RectF(50, 50, 350, 200), 50, 50, paint);
        //最小版本5.0以上版本
        //canvas.drawRoundRect(100, 100, 500, 300, 50, 50, paint);

        //画弧形或扇形
        //left, top, right, bottom 描述的是这个弧形所在的椭圆；
        // startAngle 是弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针为负角度），
        // sweepAngle 是弧形划过的角度；useCenter 表示是否连接到圆心，如果不连接到圆心，就是弧形，如果连接到圆心，就是扇形。
        //canvas.drawArc(new RectF(200, 100, 800, 500), -110, 100, true, paint);
        //canvas.drawArc(new RectF(200, 100, 800, 500), 20, 140, true, paint);
        //canvas.drawArc(new RectF(200, 100, 800, 500), 180, 60, false, paint);
        //最小版本5.0以上版本
        //canvas.drawArc(200, 100, 800, 500, -110, 100, true, paint); // 绘制扇形
        //canvas.drawArc(200, 100, 800, 500, 20, 140, false, paint); // 绘制弧形
        //canvas.drawArc(200, 100, 800, 500, 180, 60, false, paint); // 绘制不封口的弧形

        //画自定义图形
        //drawPath(Path path, Paint paint)
        // addXxx() ——添加子图形
        Path path = new Path(); // 初始化 Path 对象
        //path.addCircle(300, 300, 200, Path.Direction.CCW);
        //canvas.drawPath(path, paint);

        /*
        * addOval(float left, float top, float right, float bottom, Direction dir) / addOval(RectF oval, Direction dir) 添加椭圆
          addRect(float left, float top, float right, float bottom, Direction dir) / addRect(RectF rect, Direction dir) 添加矩形
          addRoundRect(RectF rect, float rx, float ry, Direction dir) /
          addRoundRect(float left, float top, float right, float bottom, float rx, float ry, Direction dir) /
          addRoundRect(RectF rect, float[] radii, Direction dir) /
          addRoundRect(float left, float top, float right, float bottom, float[] radii, Direction dir) 添加圆角矩形
          addPath(Path path) 添加另一个 Path
        * */

        //xxxTo() ——画线（直线或曲线）

        //画直线
        //lineTo(float x, float y) / rLineTo(float x, float y)
        //从当前位置向目标位置画一条直线， x 和 y 是目标位置的坐标。这两个方法的区别是，lineTo(x, y) 的参数是绝对坐标，而 rLineTo(x, y) 的参数是相对当前位置的相对坐标 （前缀 r 指的就是  relatively 「相对地」)
        //path.lineTo(100, 100); // 由当前位置 (0, 0) 向 (100, 100) 画一条直线
        //path.rLineTo(100, 0); // 由当前位置 (100, 100) 向正右方 100 像素的位置画一条直线
        //canvas.drawPath(path, paint);

        //画贝塞尔曲线
        //画二次贝塞尔曲线
        //这条二次贝塞尔曲线的起点就是当前位置，而参数中的 x1, y1 和 x2, y2 则分别是控制点和终点的坐标。和 rLineTo(x, y) 同理，rQuadTo(dx1, dy1, dx2, dy2) 的参数也是相对坐标
        //quadTo(float x1, float y1, float x2, float y2) / rQuadTo(float dx1, float dy1, float dx2, float dy2)
        //画三次贝塞尔曲线
        //和上面这个 quadTo() rQuadTo() 的二次贝塞尔曲线同理，cubicTo() 和 rCubicTo() 是三次贝塞尔曲线，不再解释
        //cubicTo(float x1, float y1, float x2, float y2, float x3, float y3) / rCubicTo(float x1, float y1, float x2, float y2, float x3, float y3)
        //path.quadTo(100, 100, 200, 300);
        //path.rQuadTo(300, 200, 100, 250);
        //canvas.drawPath(path, paint);

        //移动到目标位置
        //moveTo(float x, float y) / rMoveTo(float x, float y)
        //不论是直线还是贝塞尔曲线，都是以当前位置作为起点，而不能指定起点。但你可以通过 moveTo(x, y) 或 rMoveTo() 来改变当前位置，从而间接地设置这些方法的起点。
        //注意要先移动起点，再画线
        path.moveTo(200, 100); // 我移~~
        path.lineTo(300, 200); // 画线

        //path.lineTo(200, 0); // 画竖线
        canvas.drawPath(path, paint);

        //画弧线
        //arcTo(RectF oval, float startAngle, float sweepAngle, boolean forceMoveTo) /
        // arcTo(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean forceMoveTo) /
        // arcTo(RectF oval, float startAngle, float sweepAngle)
        //这个方法和 Canvas.drawArc() 比起来，少了一个参数 useCenter，而多了一个参数 forceMoveTo 。
        //少了 useCenter ，是因为 arcTo() 只用来画弧形而不画扇形，所以不再需要 useCenter 参数；而多出来的这个 forceMoveTo 参数的意思是，绘制是要「抬一下笔移动过去」，还是「直接拖着笔过去」，区别在于是否留下移动的痕迹。
        //path.lineTo(100, 100);
        // 强制移动到弧形起点（无痕迹）
        //path.arcTo(new RectF(100, 100, 300, 300), -90, 90, true);
        //path.arcTo(new RectF(100, 100, 300, 300), -90, 90, false);
        //最小版本5.0以上版本
        //path.arcTo(100, 100, 300, 300, -90, 90, true);

        //addArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle) /
        // addArc(RectF oval, float startAngle, float sweepAngle)
        //addArc() 只是一个直接使用了 forceMoveTo = true 的简化版 arcTo()
        //path.addArc(new RectF(100, 100, 300, 300), -90, 90);
        //最小版本5.0以上版本
        //path.addArc(100, 100, 300, 300, -90, 90);
        //canvas.drawPath(path, paint);

        //封闭当前图形
        //close()
        //path.moveTo(100, 100);
        //path.lineTo(200, 100);
        //path.lineTo(150, 150);
        //path.close(); // 使用 close() 封闭子图形。等价于 path.lineTo(100, 100)
        //canvas.drawPath(path, paint);

        //填充颜色
        //fillType 的取值有四个：EVEN_ODD、WINDING （默认值）、INVERSE_EVEN_ODD、INVERSE_WINDING
        //path.setFillType(Path.FillType.EVEN_ODD); //WINDING 是「看线条绘制方向选择全填充还是交叉填充」，而 EVEN_ODD 是「交叉填充」

        //画图片
        //canvas.drawBitmap(bitmap, 200, 100, paint);

        //画文字
        //String text = "Hi,Sean!";
        //paint.setTextSize(48);
        //canvas.drawText(text, 200, 100, paint);
    }
}
