package com.sean.zq.android.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.sean.note.android.R;
import com.sean.zq.android.meta.MainData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView)findViewById(R.id.main_list);
        MainListDataAdapter adapter = new MainListDataAdapter(this,getMainDataList());
        listView.setAdapter(adapter);

    }

    private List getMainDataList() {
        List<MainData> list = new ArrayList<MainData>();
        //创建对象
        MainData mainDataQA = new MainData("问题",MainData.MainDataType.qa,"开发此应用时遇到的问题");
        MainData mainDataView = new MainData("View",MainData.MainDataType.view,"包括View和ViewGroup的学习");
        MainData mainDataLayout = new MainData("Layout",MainData.MainDataType.layout,"Layout的学习");
        MainData mainDataLaunch = new MainData("应用启动",MainData.MainDataType.launch,"App启动相关的学习");
        MainData mainDataThread = new MainData("线程",MainData.MainDataType.thread,"Android中线程的学习");
        MainData mainDataAnimation = new MainData("动画",MainData.MainDataType.animation,"Android中动画的学习");

        //添加对象到列表
        list.add(mainDataQA);
        list.add(mainDataView);
        list.add(mainDataLayout);
        list.add(mainDataLaunch);
        list.add(mainDataThread);
        list.add(mainDataAnimation);

        return list;
    }
}
