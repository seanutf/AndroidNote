package com.sean.zq.android.view.qa;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sean.note.android.R;

import java.util.List;

/**
 * Created by sean on 2016/9/7.
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
        QAMetaViewHolder holder = null;
        if(convertView == null){
            holder = new QAMetaViewHolder();
            convertView = View.inflate(context, R.layout.qa_list_item,null);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            convertView.setTag(holder);
        } else {
            holder = (QAMetaViewHolder)convertView.getTag();
        }
        if(list != null && list.size() > 0) {
            final String meta = list.get(position);
            if (!TextUtils.isEmpty(meta)) {
                holder.title.setText(meta);
            }
        }
        return convertView;
    }
}
