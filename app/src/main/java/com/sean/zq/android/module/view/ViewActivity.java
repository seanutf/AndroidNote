package com.sean.zq.android.module.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.sean.note.android.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sean on 2016/10/15.
 */
public class ViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_layout);
        ListView listView = (ListView) findViewById(R.id.list_activity_view);
        ViewAdapter adapter = new ViewAdapter(this, getViewData());
        listView.setAdapter(adapter);
    }

    private List<String> getViewData(){
        List<String> list = new ArrayList<String>();
        list.add(getString(R.string.text_view_fragment));
        list.add(getString(R.string.text_view_activity));
        list.add(getString(R.string.text_view_event));
        list.add(getString(R.string.text_view_custom));
        return list;
    }
}
