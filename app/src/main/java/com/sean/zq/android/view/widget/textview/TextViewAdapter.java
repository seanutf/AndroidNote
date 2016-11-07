package com.sean.zq.android.view.widget.textview;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sean.note.android.R;

import java.util.List;

/**
 * Created by sean on 2016/10/12.
 */
public class TextViewAdapter extends BaseAdapter{

    Context context;
    List<String> list;
    public TextViewAdapter(Context context, List<String> list){
        this.list = list;
        this.context = context;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        TextViewMetaViewHolder holder = null;
        if(convertView == null){
            holder = new TextViewMetaViewHolder();
            convertView = View.inflate(context, R.layout.qa_list_item,null);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            convertView.setTag(holder);
        } else {
            holder = (TextViewMetaViewHolder)convertView.getTag();
        }
        if(list != null && list.size() > 0) {
            final String meta = list.get(position);
            if (!TextUtils.isEmpty(meta)) {
                holder.title.setText(meta);
                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickEvent(position);
                    }
                });
            }
        }
        return convertView;
    }

    private void onClickEvent(int position) {
        Intent intent = null;
        switch (position){
            case 0:
                intent = new Intent(context,TextViewDetailActivity.class);
                intent.putExtra(TextViewActivity.REQUEST_TEXTVIEW_DETAIL_ACTIVITY_TYPE_ONE,0);
                context.startActivity(intent);
                break;
            case 1:
                intent = new Intent(context,BarrageActivity.class);
                context.startActivity(intent);
                break;
            case 2:
                intent = new Intent(context,TextViewDetailActivity.class);
                intent.putExtra(TextViewActivity.REQUEST_TEXTVIEW_DETAIL_ACTIVITY_TYPE_ONE,1);
                context.startActivity(intent);
                break;
            default:
                break;
        }
    }
}
