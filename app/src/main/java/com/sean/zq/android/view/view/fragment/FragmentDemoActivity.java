package com.sean.zq.android.view.view.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

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
        FragmentDataApater apater = new FragmentDataApater(this,getFragmentData());
        listView.setAdapter(apater);
    }

    private List<String> getFragmentData() {
        List<String> list = new ArrayList<String>();
        list.add(getString(R.string.text_fragment_demo_from_api_demo));
        list.add(getString(R.string.text_fragment_demo_from_api_demo_back_stack));
        return list;
    }
}
