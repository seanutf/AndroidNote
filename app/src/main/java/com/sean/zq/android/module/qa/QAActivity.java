package com.sean.zq.android.module.qa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.sean.note.android.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sean on 2016/9/7.
 */
public class QAActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qa);
        ListView listView = (ListView)findViewById(R.id.qa_list);
        QAListDataAdapter adapter = new QAListDataAdapter(getBaseContext(),getQAMetaList());
        listView.setAdapter(adapter);
    }

    private List getQAMetaList() {
        List<String> list = new ArrayList<String>();
        //创建对象
        String qaGetActivity = getString(R.string.text_no_get_activity_qa);

        //添加对象到列表
        list.add(qaGetActivity);
        for(int i = 0;i < 50;i++){
            list.add("item"+ i);
        }
        return list;
    }
}
