package com.sean.zq.android.module.view.fragment;

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
public class FragmentDemoActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);

        ListView listView = (ListView) findViewById(R.id.list_activity_fragment);
        FragmentDataAdapter adapter = new FragmentDataAdapter(this,getFragmentData());
        listView.setAdapter(adapter);
    }

    private List<String> getFragmentData() {
        List<String> list = new ArrayList<String>();
        list.add(getString(R.string.text_fragment_demo_from_api_demo));
        list.add(getString(R.string.text_fragment_demo_from_api_demo_back_stack));
        return list;
    }
}
