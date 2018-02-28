package com.sean.zq.android.module.view.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.sean.note.android.R;
import com.sean.zq.android.meta.WidgetMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sean on 2016/10/12.
 */
public class WidgetActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_layout);

        TextView viewTab = (TextView) findViewById(R.id.tab_view);
        TextView viewGroupTab = (TextView) findViewById(R.id.tab_view_group);
        ListView viewListView = (ListView) findViewById(R.id.list_activity_widget);
        ListView viewGroupListView = (ListView) findViewById(R.id.list_activity_view_group);

        List<WidgetMeta> viewList = getWidgetData();
        List<WidgetMeta> viewGroupList =  getViewGroupData();

        if(viewList != null && viewList.size() > 0){
            viewTab.setVisibility(View.VISIBLE);
            WidgetDataAdapter adapter = new WidgetDataAdapter(this,viewList);
            viewListView.setAdapter(adapter);
        } else {
            viewTab.setVisibility(View.GONE);
        }

        if(viewGroupList != null && viewGroupList.size() > 0){
            viewGroupTab.setVisibility(View.VISIBLE);
            WidgetDataAdapter adapter = new WidgetDataAdapter(this,viewGroupList);
            viewGroupListView.setAdapter(adapter);
        } else {
            viewGroupTab.setVisibility(View.GONE);
        }
    }

    private List<WidgetMeta> getWidgetData(){
        List<WidgetMeta> list = new ArrayList<WidgetMeta>();
        WidgetMeta tvMeta = new WidgetMeta(getString(R.string.text_widget_textview), WidgetMeta.WidgetMetaType.tv);
        WidgetMeta svMeta = new WidgetMeta(getString(R.string.text_widget_surfaceview), WidgetMeta.WidgetMetaType.sv);

        list.add(tvMeta);
        list.add(svMeta);
        return list;
    }

    private List<WidgetMeta> getViewGroupData(){
        List<WidgetMeta> list = new ArrayList<WidgetMeta>();
        WidgetMeta tbMeta = new WidgetMeta(getString(R.string.text_widget_toolbar), WidgetMeta.WidgetMetaType.tb);

        list.add(tbMeta);
        return list;
    }
}
