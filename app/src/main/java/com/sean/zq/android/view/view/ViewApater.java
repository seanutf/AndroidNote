package com.sean.zq.android.view.view;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sean.note.android.R;
import com.sean.zq.android.view.view.fragment.FragmentDemoActivity;

import java.util.List;

/**
 * Created by sean on 2016/10/15.
 */
public class ViewApater extends BaseAdapter{

    List<String> list;
    Context context;

    public ViewApater(Context context,List<String> list){
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
            convertView = View.inflate(context, R.layout.qa_list_item,null);
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
            intent = new Intent(context,FragmentDemoActivity.class);
            context.startActivity(intent);
        }
    }
}
