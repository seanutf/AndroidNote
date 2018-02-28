package com.sean.zq.android.module.data.serialize;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sean.note.android.R;
import com.sean.zq.android.meta.AddrData;
import com.sean.zq.android.meta.OtherUserData;
import com.sean.zq.android.meta.SerializeData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Serialize1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_serialize1);
        SerializeData.Builder builder = new SerializeData.Builder();
        OtherUserData otherUserData = new OtherUserData();
        otherUserData.setName("兰若");
        otherUserData.setAddr("朝阳区望京街道");
        List<String> addrList = new ArrayList<String>();
        AddrData addrData1 = new AddrData();
        addrData1.setArea("西三旗望京街道1");
        addrData1.setCity("北京");
        addrData1.setStreet("大望路1");
        AddrData addrData2 = new AddrData();
        addrData2.setArea("西三旗望京街道2");
        addrData2.setCity("纽约");
        addrData2.setStreet("大望路2");
        AddrData addrData3 = new AddrData();
        addrData3.setArea("西三旗望京街道3");
        addrData3.setCity("伦敦");
        addrData3.setStreet("大望路3");
        AddrData addrData4 = new AddrData();
        addrData4.setArea("西三旗望京街道4");
        addrData4.setCity("悉尼");
        addrData4.setStreet("大望路4");
        List<AddrData> addrDataList = new ArrayList<AddrData>();
        addrDataList.add(addrData1);
        addrDataList.add(addrData2);
        addrDataList.add(addrData3);
        addrDataList.add(addrData4);
        addrList.add("钢琴");
        addrList.add("编程");
        addrList.add("网球");
        Map<Integer, String> scoreList = new HashMap<>();
        scoreList.put(1,"54");
        scoreList.put(2,"60");
        scoreList.put(3,"70");
        scoreList.put(4,"90");
        scoreList.put(5,"79");
        final SerializeData data = builder.setScore(scoreList)
                .setPostion(353)
                .setFirst(addrData2)
                .setFirst(true)
                .setmDataPattern(SerializeData.DataPattern.File)
                .setHobby(addrList)
                .setAddrDataList(addrDataList)
                .setOtherUserData(otherUserData)
                .setChina(false).setHeight(2.3f)
                .setId(6575985L)
                .setName("ffr")
                .build();
        findViewById(R.id.btn_jump_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Serialize1Activity.this, Serialize2Activity.class);
                intent.putExtra("ff",data);
                startActivity(intent);
            }
        });
    }
}
