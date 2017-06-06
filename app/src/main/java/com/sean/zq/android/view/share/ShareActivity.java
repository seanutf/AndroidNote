package com.sean.zq.android.view.share;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.sean.note.android.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by sks on 2017/4/17.
 */

public class ShareActivity extends AppCompatActivity {

    ImageView imageView;
    Button btnShareText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_system);
        UUID.randomUUID().toString();
        initView();
    }

    private void initView() {
        imageView = (ImageView) findViewById(R.id.share_image);
        btnShareText = (Button) findViewById(R.id.share_text);
        btnShareText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareText();
            }
        });
        if(getIntent() != null)handleSendImage(getIntent());
    }

    public void shareText() {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, "This is my Share text.");
        shareIntent.setType("text/plain");
        //设置分享列表的标题，并且每次都显示分享列表
        startActivity(Intent.createChooser(shareIntent, "分享到"));
    }

    //分享单张图片
    public void shareSingleImage(View view) {
        String imagePath = Environment.getExternalStorageDirectory() + File.separator + "test.jpg";
        //由文件得到uri
        Uri imageUri = Uri.fromFile(new File(imagePath));
        Log.d("share", "uri:" + imageUri);  //输出：file:///storage/emulated/0/test.jpg

        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
        shareIntent.setType("image/*");
        startActivity(Intent.createChooser(shareIntent, "分享到"));
    }

    //分享多张图片
    public void shareMultipleImage(View view) {
        ArrayList<Uri> uriList = new ArrayList<>();

        String path = Environment.getExternalStorageDirectory() + File.separator;
        uriList.add(Uri.fromFile(new File(path+"australia_1.jpg")));
        uriList.add(Uri.fromFile(new File(path+"australia_2.jpg")));
        uriList.add(Uri.fromFile(new File(path+"australia_3.jpg")));

        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
        shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uriList);
        shareIntent.setType("image/*");
        startActivity(Intent.createChooser(shareIntent, "分享到"));
    }

    /**
     * 用ImageView显示单张图片
     * @param intent
     */
    private void handleSendImage(Intent intent) {
        Uri imageUri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);
        if (imageUri != null) {
            //自动裁剪出制定大小的图片显示在imageview上
            ContentResolver contentProvider = getContentResolver();
            Bitmap mBitmap = null;
            try {
                Bitmap bmp = BitmapFactory.decodeStream(contentProvider.openInputStream(imageUri));
                mBitmap = Bitmap.createScaledBitmap(bmp, 100, 100, true);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            imageView.setImageBitmap(mBitmap);
        }
    }


    /**
     * 用GridView显示多张图片
     * @param intent
     */
    private void handleSendMultipleImages(Intent intent) {
        final ArrayList<Uri> imageUris = intent.getParcelableArrayListExtra(Intent.EXTRA_STREAM);
        if (imageUris != null) {
            GridView gridView = new GridView(this);
            //设置item的宽度
            gridView.setColumnWidth(130);
            //设置列为自动适应
            gridView.setNumColumns(GridView.AUTO_FIT);
            gridView.setAdapter(new GridAdapter(this, imageUris));
            setContentView(gridView);

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        final int position, long id) {

                    //点击GridView的item 可以分享图片给其他应用
                    //这里可以参考http://blog.csdn.net/xiaanming/article/details/9395991
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_STREAM, imageUris.get(position));
                    intent.setType("image/*");
                    startActivity(Intent.createChooser(intent, "共享图片"));
                }
            });

        }
    }

    /**
     * 重写BaseAdapter
     * @author xiaanming
     *
     */
    public class GridAdapter extends BaseAdapter {
        private Context mContext;
        private ArrayList<Uri> list;

        public GridAdapter(Context mContext, ArrayList<Uri> list) {
            this.list = list;
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(mContext);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageURI(list.get(position));
            return imageView;
        }
    }

}
