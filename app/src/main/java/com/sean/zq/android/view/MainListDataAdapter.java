package com.sean.zq.android.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sean.note.android.R;
import com.sean.zq.android.meta.MainData;

import java.util.List;

/**
 * Created by sean on 2016/9/6.
 */
public class MainListDataAdapter extends BaseAdapter{
    List<MainData> list;
    Context context;
    public MainListDataAdapter(Context context, List<MainData> list) {
        this.list = list;
        this.context = context;
    }

    public void setList(List<MainData> list){
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
        MainDataViewHolder holder = null;
        if(convertView == null){
            holder = new MainDataViewHolder();
            convertView = View.inflate(context, R.layout.main_list_item,null);
            holder.title = (TextView)convertView.findViewById(R.id.title);
            holder.summary = (TextView)convertView.findViewById(R.id.summary);
            convertView.setTag(holder);
        } else {
            holder = (MainDataViewHolder) convertView.getTag();
        }
        if(list != null && list.size() > 0){
            final MainData meta = list.get(position);
            if(meta != null){
                holder.title.setText(meta.getText());
                holder.summary.setText(meta.getSummary());
                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickEvent(meta.getType());
                    }
                });
            }
        }
        return convertView;
    }

    private void onClickEvent(MainData.MainDataType type) {
        switch (type){
            case view:
                break;
            case launch:
                break;
            case layout:
                break;
            case animation:
                break;
            case thread:
                break;
            default:
                break;
        }
    }
}
