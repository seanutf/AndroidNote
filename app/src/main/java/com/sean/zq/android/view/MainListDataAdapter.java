package com.sean.zq.android.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sean.note.android.R;
import com.sean.zq.android.meta.MainData;
import com.sean.zq.android.view.animations.AnimationsActivity;
import com.sean.zq.android.view.image.ImageListActivity;
import com.sean.zq.android.view.permission.PermissionActivity;
import com.sean.zq.android.view.qa.QAActivity;
import com.sean.zq.android.view.serialize.Serialize1Activity;
import com.sean.zq.android.view.share.ShareActivity;
import com.sean.zq.android.view.thread.ThreadActivity;
import com.sean.zq.android.view.view.ViewActivity;
import com.sean.zq.android.view.widget.WidgetActivity;

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
        Intent intent = null;
        switch (type){
            case qa:
                intent = new Intent(context,QAActivity.class);
                context.startActivity(intent);
                break;
            case view:
                intent = new Intent(context,ViewActivity.class);
                context.startActivity(intent);
                break;
            case launch:
                intent = new Intent(context,QAActivity.class);
                context.startActivity(intent);
                break;
            case layout:
                intent = new Intent(context,WidgetActivity.class);
                context.startActivity(intent);
                break;
            case animation:
                intent = new Intent(context,AnimationsActivity.class);
                context.startActivity(intent);
                break;
            case thread:
                intent = new Intent(context,ThreadActivity.class);
                context.startActivity(intent);
                break;
            case share:
                intent = new Intent(context,ShareActivity.class);
                context.startActivity(intent);
                break;
            case permission:
                intent = new Intent(context, PermissionActivity.class);
                context.startActivity(intent);
            case serialize:
                intent = new Intent(context, Serialize1Activity.class);
                context.startActivity(intent);
                break;
            case image:
                intent = new Intent(context, ImageListActivity.class);
                context.startActivity(intent);
                break;
            default:
                break;
        }
    }
}
