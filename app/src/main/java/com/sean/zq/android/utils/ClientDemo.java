package com.sean.zq.android.utils;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by sean on 2017/12/3.
 *
 * TCP协议
 */

public class ClientDemo {

    public  static void main(String[] args) throws Exception{
        //1. 创建Socket对象（创建对象的同时已经建立好了连接）
        Socket socket = new Socket("192.168.1.1", 10010);
        //2.获取输出流，写数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("this message si write by tcp.".getBytes());
        //3.释放资源
        socket.close();
    }
}
