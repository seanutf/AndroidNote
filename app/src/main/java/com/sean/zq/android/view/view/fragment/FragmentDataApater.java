package com.sean.zq.android.view.view.fragment;

import android.app.Activity;
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
 * Created by sean on 2016/10/16.
 */
public class FragmentDataApater extends BaseAdapter{

    Context context;
    List<String> list;

    public FragmentDataApater(Context context, List<String> list){
        this.context = context;
        this.list = list;
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
        if(convertView == null)
            convertView = ((Activity)context).getLayoutInflater().inflate(R.layout.qa_list_item,null);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        if(list != null && list.size() > 0 && list.get(position) != null){
            final String meta = list.get(position);
            if(!TextUtils.isEmpty(meta)){
                title.setText(meta);

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
        if(meta.equals(context.getString(R.string.text_fragment_demo_from_api_demo))){
            intent = new Intent(context,FragmentLayout.class);
            context.startActivity(intent);
        } else if (meta.equals(context.getString(R.string.text_fragment_demo_from_api_demo_back_stack))){
            intent = new Intent(context,FragmentStack.class);
            context.startActivity(intent);
        }
    }
}
