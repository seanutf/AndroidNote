package com.sean.zq.android.view.widget.textview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.sean.note.android.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sean on 2016/10/12.
 */
public class TextViewActivity extends AppCompatActivity{

    public static final String REQUEST_TEXTVIEW_DETAIL_ACTIVITY_TYPE_ONE = "0";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);
        ListView listView = (ListView)findViewById(R.id.activity_text_view_list);
        TextViewAdapter adapter = new TextViewAdapter(this,getTextViewData());
        listView.setAdapter(adapter);
    }

    private List<String> getTextViewData(){
        List<String> list = new ArrayList<String>();
        list.add(getString(R.string.text_view_knowledge_item_0));
        list.add(getString(R.string.text_view_knowledge_item_1));
        list.add(getString(R.string.text_view_knowledge_item_2));
        return list;
    }
}
