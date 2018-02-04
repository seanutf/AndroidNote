package com.sean.zq.android.view.image;

import android.content.BroadcastReceiver;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.LruCache;
import android.view.View;
import android.widget.TextView;

import com.sean.note.android.R;
import com.sean.zq.android.utils.DiskLruCache;
import com.sean.zq.android.utils.ImageResourcesURL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Executors;

public class ImageListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_mage_list);
        String[] aa = ImageResourcesURL.getImgURLs();
        RecyclerView rvList = (RecyclerView)findViewById(R.id.rv_list);


    }
}
