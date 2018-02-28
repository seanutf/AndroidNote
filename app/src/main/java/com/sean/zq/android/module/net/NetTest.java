package com.sean.zq.android.module.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by sean on 2018/2/28.
 */

public class NetTest {
    public void getNet(){
        try {
            InetAddress inetAddress = InetAddress.getByName("Zhangyi") ; //在给定主机名(计算机的名字或者域名)的情况下确定主机的IP地址
            inetAddress.getHostAddress(); //返回IP地址的字符串
            inetAddress.getHostName(); //返回主机名
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
