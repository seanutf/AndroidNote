package com.sean.zq.android.meta;

import java.io.Serializable;

/**
 * Created by sks on 2017/7/13.
 */

public class OtherUserData implements Serializable{

    String name;
    String addr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
