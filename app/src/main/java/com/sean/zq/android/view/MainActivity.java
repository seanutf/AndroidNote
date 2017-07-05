package com.sean.zq.android.view;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sean.note.android.R;
import com.sean.zq.android.meta.MainData;
import com.sean.zq.android.utils.widget.StretchListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) ==  PackageManager.PERMISSION_GRANTED){
            ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE);
        }else{

        }

        StretchListView listView = (StretchListView)findViewById(R.id.main_list);
        final MainListDataAdapter adapter = new MainListDataAdapter(this,getMainDataList());
        if(listView !=null)
            listView.setAdapter(adapter);
    }

    private List<MainData> getMainDataList() {
        List<MainData> list = new ArrayList<MainData>();
        //创建对象
        MainData mainDataQA = new MainData(getString(R.string.text_qa_text_main), MainData.MainDataType.qa, getString(R.string.text_qa_summary_main));
        MainData mainDataView = new MainData(getString(R.string.text_view_text_main), MainData.MainDataType.view, getString(R.string.text_view_summary_main));
        MainData mainDataLayout = new MainData(getString(R.string.text_widget_text_main), MainData.MainDataType.layout, getString(R.string.text_widget_summary_main));
        MainData mainDataLaunch = new MainData(getString(R.string.text_launch_text_main), MainData.MainDataType.launch, getString(R.string.text_launch_summary_main));
        MainData mainDataThread = new MainData(getString(R.string.text_thread_text_main), MainData.MainDataType.thread, getString(R.string.text_thread_summary_main));
        MainData mainDataAnimation = new MainData(getString(R.string.text_animation_text_main), MainData.MainDataType.animation, getString(R.string.text_animation_summary_main));
        MainData mainDataShare = new MainData(getString(R.string.text_share_text_main), MainData.MainDataType.share, getString(R.string.text_share_summary_main));

        //添加对象到列表
        list.add(mainDataQA);
        list.add(mainDataView);
        list.add(mainDataLayout);
        list.add(mainDataLaunch);
        list.add(mainDataThread);
        list.add(mainDataAnimation);
        list.add(mainDataShare);

        return list;
    }
}
