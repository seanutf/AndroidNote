package com.sean.zq.android.module.view.widget.constraint;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sean.note.android.R;
import com.sean.zq.android.module.view.widget.constraint.meta.UserDemo;

import java.util.List;

/**
 * Created by Sean on 2018/3/4.
 */

public class ConstraintAdapter extends RecyclerView.Adapter {

    List<UserDemo> list;

    public void setList(List<UserDemo> list){
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_constraint_demo, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder != null && list.get(position) != null){
            ((ViewHolder)holder).ivAvatar.setImageResource(R.mipmap.ic_launcher);
            ((ViewHolder)holder).tvName.setText(list.get(position).getName());
            ((ViewHolder)holder).tvDesc.setText(list.get(position).getDesc());
        }
    }

    @Override
    public int getItemCount() {
        if(list != null && list.size() > 0){
            return list.size();
        }
        return 0;
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivAvatar;
        TextView tvName;
        TextView tvDesc;
        public ViewHolder(View itemView) {
            super(itemView);
            ivAvatar = (ImageView)itemView.findViewById(R.id.iv_avatar);
            tvName = (TextView)itemView.findViewById(R.id.tv_name);
            tvDesc = (TextView)itemView.findViewById(R.id.tv_desc);
        }
    }
}
