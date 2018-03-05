package com.sean.zq.android.module.view.widget.constraint.meta;

import java.io.Serializable;

/**
 * Created by Sean on 2018/3/4.
 */

public class UserDemo implements Serializable {

    String name;
    String avatar;
    String desc;

    public UserDemo(String name, String desc){
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
