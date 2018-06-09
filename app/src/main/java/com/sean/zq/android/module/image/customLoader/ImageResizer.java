package com.sean.zq.android.module.image.customLoader;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.sean.partner.BuildConfig;
import com.sean.partner.utils.LogUtil;

import java.io.FileDescriptor;
import java.io.InputStream;

/**
 * Created by Sean on 2018/6/9.
 */
public class ImageResizer {

    final static String TAG = ImageResizer.class.getSimpleName();


    public interface ScalingBitmapCallback{
        void getHeightAndWidth(BitmapFactory.Options options);
    }

    public static Bitmap createFramedPhoto(int width, int height, Bitmap image, float outerRadiusRat) {
        //根据源文件新建一个darwable对象
        Drawable imageDrawable = new BitmapDrawable(image);
        // 新建一个新的输出图片
        Bitmap output = createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        // 新建一个矩形
        RectF outerRect = new RectF(0, 0, width, height);
        // 产生一个红色的圆角矩形
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        canvas.drawRoundRect(outerRect, outerRadiusRat, outerRadiusRat, paint);
        // 将源图片绘制到这个圆角矩形上
        //详解见http://lipeng88213.iteye.com/blog/1189452
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        imageDrawable.setBounds(0, 0, width, height);
        canvas.saveLayer(outerRect, paint, Canvas.ALL_SAVE_FLAG);
        imageDrawable.draw(canvas);
        canvas.restore();
        return output;
    }

    public static Bitmap getCroppedBitmap(Bitmap bitmap) {
        try {
            Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(),
                    Bitmap.Config.ARGB_8888);
            //设置一个图片大小的矩形
            final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            //bm是一个刚好canvas大小的空Bitmap ，画完后应该会自动保存到bm
            Canvas canvas = new Canvas(output);

            final Paint paint = new Paint();
            paint.setAntiAlias(true);

            int halfWidth = bitmap.getWidth() / 2;
            int halfHeight = bitmap.getHeight() / 2;
            //画圆
            canvas.drawCircle(halfWidth, halfHeight, Math.min(halfWidth, halfHeight), paint);
            //设置为取两层图像交集部门,只显示上层图像
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            //画图像
            canvas.drawBitmap(bitmap, rect, rect, paint);

            return output;
        }catch (Exception e) {
            return null;
        }
    }

    public static Bitmap getCroppedBitmapForRoundRect(Bitmap bitmap, float radius) {
        try {
            Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(),
                    Bitmap.Config.ARGB_8888);
            //设置一个图片大小的矩形
            final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            //bm是一个刚好canvas大小的空Bitmap ，画完后应该会自动保存到bm
            Canvas canvas = new Canvas(output);

            final Paint paint = new Paint();
            paint.setAntiAlias(true);

            int halfWidth = bitmap.getWidth() / 2;
            int halfHeight = bitmap.getHeight() / 2;

            //画圆角矩形
            final RectF rectF = new RectF(0, 0, bitmap.getWidth(), bitmap.getHeight());
            float[] radii={radius, radius, radius, radius,0f,0f,0f,0f};
            Path path = new Path();
            path.addRoundRect(rectF, radii, Path.Direction.CW);
            canvas.drawPath(path, paint);

            //设置为取两层图像交集部门,只显示上层图像
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            //画图像
            canvas.drawBitmap(bitmap, rect, rect, paint);

            return output;
        }catch (Exception e) {
            return null;
        }
    }

//    public static Bitmap decodeSampledBitmapFromByteArray(byte[] bytes, int reqWidth, int reqHeight) {
//        // First decode with inJustDecodeBounds=true to check dimensions
//        final BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;
//        BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);
//
//        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
//        options.inJustDecodeBounds = false;
//        options.inPurgeable = true;
//        setPreferredConfig(options);
//        return decodeByteArray(bytes, 0, bytes.length, options);
//    }

//    public static Bitmap decodeByteArray(byte[] data, int offset, int length, BitmapFactory.Options options) {
//        if (BuildConfig.DEBUG) {
//            return BitmapFactory.decodeByteArray(data, offset, length, options);
//        }
//        try {
//            return BitmapFactory.decodeByteArray(data, offset, length, options);
//        } catch (OutOfMemoryError e) {
//        }
//        return null;
//    }

//    public static Bitmap decodeSampledBitmapFromStream(InputStream is, int reqWidth, int reqHeight) {
//        // First decode with inJustDecodeBounds=true to check dimensions
//        final BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;
//        Bitmap bitmap = BitmapFactory.decodeStream(is, null, options);
//        // Calculate inSampleSize
//        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
//
//        options.inJustDecodeBounds = false;
//        options.inPurgeable = true;
//        setPreferredConfig(options);
//        return decodeStream(is, null, options);
//    }

    public static Bitmap decodeStream(InputStream is, Rect outPadding, BitmapFactory.Options options) {
        if (BuildConfig.DEBUG) {
            return BitmapFactory.decodeStream(is, outPadding, options);
        }
        try {
            return BitmapFactory.decodeStream(is, outPadding, options);
        } catch (OutOfMemoryError e) {
        }
        return null;
    }

    public static Bitmap decodeStream(InputStream is) {
        if (BuildConfig.DEBUG) {
            return BitmapFactory.decodeStream(is);
        }
        try {
            return BitmapFactory.decodeStream(is);
        } catch (OutOfMemoryError e) {
        }
        return null;
    }

    public static Bitmap decodeSampledBitmapFromDescriptor(FileDescriptor fileDescriptor, int reqWidth, int reqHeight) {

        long time = System.currentTimeMillis();
        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        setPreferredConfig(options);
        //if (BuildConfig.DEBUG) {
        if (false) {
            final Bitmap bitmap1 = decodeFileDescriptor(fileDescriptor, null, options);
            LogUtil.d(TAG, "ImageResizer.decodeSampledBitmapFromDescriptor cost " + (System.currentTimeMillis() - time));
            return bitmap1;
        }
        try {
            final Bitmap bitmap1 = decodeFileDescriptor(fileDescriptor, null, options);
            LogUtil.d(TAG, "ImageResizer.decodeSampledBitmapFromDescriptor cost " + (System.currentTimeMillis() - time));
            return bitmap1;
        } catch (OutOfMemoryError e) {
            return  null;
        }catch (Exception e){
            return null;
        }
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fd, Rect outPadding, BitmapFactory.Options options) {
        if (BuildConfig.DEBUG) {
            return BitmapFactory.decodeFileDescriptor(fd, outPadding, options);
        }
        try {
            return BitmapFactory.decodeFileDescriptor(fd, outPadding, options);
        } catch (OutOfMemoryError e) {
        }
        return null;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {
        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        setPreferredConfig(options);
        return decodeResource(res, resId, options);
    }

    public static Bitmap decodeResource(Resources res, int resId, BitmapFactory.Options options) {
        if (BuildConfig.DEBUG) {
            return BitmapFactory.decodeResource(res, resId, options);
        }
        try {
            return BitmapFactory.decodeResource(res, resId, options);
        } catch (OutOfMemoryError e) {
        }
        return null;
    }

    public static Bitmap decodeBitmapFromFileToPortrait(String filename, int reqWidth, int reqHeight, float rotate) {
        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filename, options);

        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        setPreferredConfig(options);
        Bitmap bitmap = decodeFile(filename, options);

        if (rotate != 0) {
            rotateBitmap(bitmap, rotate);
        }

        return bitmap;
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, float rotate) {
        if (rotate == 0) return bitmap;

        Matrix matrix = new Matrix();
        matrix.setRotate(rotate);
        return createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap scaleBitmap(Bitmap source, float xScale, float yScale) {
        Matrix matrix = new Matrix();
        boolean b = matrix.postScale(xScale, yScale);
        return createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
    }

    public static Bitmap scaleBitmap(Bitmap source, int needWidth, int needHeight) {
        float xScale = needWidth / source.getWidth();
        float yScale = needHeight / source.getHeight();
        Matrix matrix = new Matrix();
        boolean b = matrix.postScale(xScale, yScale);
        return createBitmap(source, 0, 0, needWidth, needHeight, matrix, true);
    }

    public static Bitmap createBitmap(int width, int height, android.graphics.Bitmap.Config config) {
        if (BuildConfig.DEBUG) {
            return Bitmap.createBitmap(width, height, config);
        }

        try {
            return Bitmap.createBitmap(width, height, config);
        }
        catch (Throwable e) {
        }
        return null;
    }

    public static Bitmap createBitmap(Bitmap source, int x, int y, int width, int height,
                                      Matrix m, boolean filter) {
        if (BuildConfig.DEBUG) {
            return Bitmap.createBitmap(source, x, y, width, height, m, filter);
        }
        try {
            return Bitmap.createBitmap(source, x, y, width, height, m, filter);
        } catch (Throwable e) {
        }
        return null;
    }

    public Bitmap decodeSampledBitmapFromFileDescriptor(FileDescriptor fileDescriptor, int reqWidth, int reqHeight){
        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);

        //Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
    }

    public static Bitmap decodeSampledBitmapFromFile(String filename, int reqWidth, int reqHeight,ScalingBitmapCallback callback) {
        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filename, options);

        if(callback != null) callback.getHeightAndWidth(options);
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        setPreferredConfig(options);
        return decodeFile(filename, options);
    }

    public static Bitmap decodeSampledBitmapFromFile(String filename, int reqWidth, int reqHeight) {
        return  decodeSampledBitmapFromFile(filename,reqWidth,reqHeight,null);
    }

    public static BitmapFactory.Options decodeBitmapSizeFromFile(String filename) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filename, options);
        return options;
    }

    public static Bitmap decodeFile(String filename, BitmapFactory.Options options) {
        if (BuildConfig.DEBUG) {
            return BitmapFactory.decodeFile(filename, options);
        }
        try {
            return BitmapFactory.decodeFile(filename, options);
        } catch (OutOfMemoryError e) {
        }
        return null;
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        if (reqWidth == 0 && reqHeight == 0) {
            return 1;
        }
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;

        if (reqHeight == 0) reqHeight = height;
        if (reqWidth == 0) reqWidth = width;

        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            if (height <= reqHeight) { //高度满足就看宽度
                inSampleSize = Math.round((float) width / (float) reqWidth);
            }else if (width <= reqWidth) { //宽度满足就看高度
                inSampleSize = Math.round((float) height / (float) reqHeight);
            }else if (width > height) { //宽照片按高度算，避免过度截取
                inSampleSize = Math.round((float) height / (float) reqHeight);
            } else { //高照片按宽度算，避免过度截取
                inSampleSize = Math.round((float) width / (float) reqWidth);
            }

            // This offers some additional logic in case the image has a strange
            // aspect ratio. For example, a panorama may have a much larger
            // width than height. In these cases the total pixels might still
            // end up being too large to fit comfortably in memory, so we should
            // be more aggressive with sample down the image (=larger
            // inSampleSize).

            final float totalPixels = width * height;

            // Anything more than 2x the requested pixels we'll sample down
            // further.
            final float totalReqPixelsCap = reqWidth * reqHeight * 2;

            while (totalPixels / (inSampleSize * inSampleSize) > totalReqPixelsCap) {
                inSampleSize++;
            }
        }
        return inSampleSize;
    }

    static void setPreferredConfig(BitmapFactory.Options options) {
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
    }
}
