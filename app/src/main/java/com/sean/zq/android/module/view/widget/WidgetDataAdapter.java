package com.sean.zq.android.module.view.widget;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sean.note.android.R;
import com.sean.zq.android.module.view.widget.constraint.ConstraintLayoutActivity;
import com.sean.zq.android.module.view.widget.meta.WidgetMeta;
import com.sean.zq.android.module.view.widget.surfaceview.SurfaceViewActivity;
import com.sean.zq.android.module.view.widget.textview.TextViewActivity;
import com.sean.zq.android.module.view.widget.toolbar.ToolBarActivity;

import java.util.List;

/**
 * Created by sean on 2016/10/12.
 */
public class WidgetDataAdapter extends BaseAdapter{
    Context context;
    List<WidgetMeta> list;
    public WidgetDataAdapter(Context context,List<WidgetMeta> list){
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
        WidgetMetaViewHolder holder = null;
        if(convertView == null){
            holder = new WidgetMetaViewHolder();
            convertView = View.inflate(context, R.layout.qa_list_item,null);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            convertView.setTag(holder);
        } else {
            holder = (WidgetMetaViewHolder)convertView.getTag();
        }
        if(list != null && list.size() > 0) {
            final WidgetMeta meta = list.get(position);
            if(meta != null){
                if (!TextUtils.isEmpty(meta.getText())) {
                    holder.title.setText(meta.getText());
                }

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

    private void onClickEvent(WidgetMeta.WidgetMetaType type) {
        Intent intent = null;
        switch (type){
            case tv:
                intent = new Intent(context,TextViewActivity.class);
                context.startActivity(intent);
                break;
            case sv:
                intent = new Intent(context,SurfaceViewActivity.class);
                context.startActivity(intent);
                break;
            case tb:
                intent = new Intent(context,ToolBarActivity.class);
                context.startActivity(intent);
                break;
            case ctl:
                intent = new Intent(context,ConstraintLayoutActivity.class);
                context.startActivity(intent);
                break;
            default:
                break;
        }
    }
}
