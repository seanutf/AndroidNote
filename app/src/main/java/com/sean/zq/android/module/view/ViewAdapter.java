package com.sean.zq.android.module.view;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sean.note.android.R;
import com.sean.zq.android.module.view.activity.LaunchStandardActivity;
import com.sean.zq.android.module.view.fragment.FragmentDemoActivity;
import com.sean.zq.android.module.view.view.clickEvent.ViewClickEventActivity;
import com.sean.zq.android.module.view.view.custom.CustomViewActivity;

import java.util.List;

/**
 * Created by sean on 2016/10/15.
 */
public class ViewAdapter extends BaseAdapter{

    List<String> list;
    Context context;

    public ViewAdapter(Context context, List<String> list){
        this.list = list;
        this.context = context;
    }
    @Override
    public int getCount() {
        return list.size();
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
        ViewMetaViewHolder holder = null;
        if(convertView == null){
            holder = new ViewMetaViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.qa_list_item, parent,false);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            convertView.setTag(holder);
        } else {
            holder = (ViewMetaViewHolder)convertView.getTag();
        }
        if(list != null && list.size() > 0) {
            final String meta = list.get(position);
            if (!TextUtils.isEmpty(meta)) {
                holder.title.setText(meta);
                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickEvent(meta);
                    }
                });
            }
        }
        return convertView;
    }

    private void onClickEvent(String meta) {
        Intent intent = null;
        if(meta.equals(context.getString(R.string.text_view_fragment))){
            intent = new Intent(context, FragmentDemoActivity.class);
            context.startActivity(intent);
        }else if(meta.equals(context.getString(R.string.text_view_activity))){
            intent = new Intent(context, LaunchStandardActivity.class);
            context.startActivity(intent);
        }else if(meta.equals(context.getString(R.string.text_view_event))){
            intent = new Intent(context, ViewClickEventActivity.class);
            context.startActivity(intent);
        }else if(meta.equals(context.getString(R.string.text_view_custom))){
            intent = new Intent(context, CustomViewActivity.class);
            context.startActivity(intent);
        }
    }
}
