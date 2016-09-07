package com.sean.zq.android.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by sks on 2016/9/7.
 */
public class QAListDataAdapter extends BaseAdapter{

    List<String> list;
    Context context;
    public QAListDataAdapter(Context context, List<String> list) {
        this.list = list;
        this.context = context;
    }

    public void setList(List<String> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if(list != null && list.size() > 0){
            return list.size();
        }
        return 0;
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

        return null;
    }
}
