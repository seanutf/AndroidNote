package com.sean.zq.android.module.kotlin

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sean.note.android.R
import com.sean.zq.android.meta.AddrData
import kotlinx.android.synthetic.main.item_kotlin_demo_list.view.*

/**
 * Created by Administrator on 2018/2/23.
 */
class KotlinMainListAdapter(val demoList: List<String>, val context: Context) : RecyclerView.Adapter<KotlinMainListAdapter.DemoViewHolder>() {

    override fun onBindViewHolder(holder: DemoViewHolder?, position: Int) {
        holder?.bindItems(holder, demoList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DemoViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.item_kotlin_demo_list,
                parent, false)
        return DemoViewHolder(v)
    }

    override fun getItemCount(): Int {
        return demoList.size
    }

    class DemoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(holder: DemoViewHolder?, itemTitle: String) {
            itemView.title_demo_item.text = itemTitle
            itemView.root_view_demo_item.setOnClickListener({

                when(holder?.layoutPosition){
                    0 ->{
                        val intent = Intent(itemView.context, KotlinTestBroadcastActivity::class.java)
                        startActivity(itemView.context, intent, null)
                    }
                    1 ->{
                        val intent = Intent(itemView.context, KotlinIntentServiceActivity::class.java)
                        startActivity(itemView.context, intent, null)
                    }
                    2 ->{
                        val intent = Intent(itemView.context, KotlinTestBroadcastActivity::class.java)
                        startActivity(itemView.context, intent, null)
                    }
                    3 ->{
                        val intent = Intent(itemView.context, KotlinTestBroadcastActivity::class.java)
                        startActivity(itemView.context, intent, null)
                    }
                    4 ->{
                        val intent = Intent(itemView.context, KotlinTestBroadcastActivity::class.java)
                        startActivity(itemView.context, intent, null)
                    }
                    5 ->{
                        val intent = Intent(itemView.context, KotlinTestBroadcastActivity::class.java)
                        startActivity(itemView.context, intent, null)
                    }
                    else ->{

                    }
                }
            })
        }
    }
}