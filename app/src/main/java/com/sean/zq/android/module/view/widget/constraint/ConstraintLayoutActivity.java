package com.sean.zq.android.module.view.widget.constraint;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sean.note.android.R;
import com.sean.zq.android.module.view.widget.constraint.meta.UserDemo;

import java.util.ArrayList;
import java.util.List;

public class ConstraintLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);
        RecyclerView rvUser = findViewById(R.id.rv_user);
        rvUser.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        DividerItemDecoration divider = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this,R.drawable.cconstraint_demo_divider));
        rvUser.addItemDecoration(divider);
        ConstraintAdapter adapter = new ConstraintAdapter();
        adapter.setList(perparUserList());
        rvUser.setAdapter(adapter);
    }

    private List<UserDemo> perparUserList() {
        List<UserDemo> list = new ArrayList<>();
        list.add(new UserDemo("王五","潮汕人"));
        list.add(new UserDemo("张三","山东人"));
        list.add(new UserDemo("李四","西北人"));
        list.add(new UserDemo("李斯","华东人"));
        list.add(new UserDemo("隋唐","华北人"));
        list.add(new UserDemo("寒潮","东北人就是牛逼阿，瞅你咋的不服啊不服干一仗阿你等着啊我去叫人到时候别跑啊小子"));
        list.add(new UserDemo("动向","西夏人"));
        list.add(new UserDemo("武当","云南人"));
        list.add(new UserDemo("昆仑","缅甸人"));
        list.add(new UserDemo("梦想","美国人"));
        return list;
    }
}
