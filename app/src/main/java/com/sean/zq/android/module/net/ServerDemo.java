package com.sean.zq.android.module.net;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by sean on 2017/12/3.
 *
 * TCP协议
 */

public class ServerDemo {

    public static void main(String[] args) throws Exception{
        //1.创建服务器端Socket对象
        ServerSocket serverSocket = new ServerSocket(10010);
        //2.监听对应客户端的连接
        Socket socket = serverSocket.accept();
        //3.获取输入流，读取数据
        InputStream inputStream = socket.getInputStream();
        byte[] bys = new byte[1024];
        int len = inputStream.read(bys);
        String client  = new String(bys, 0, len);
        //4.释放资源
        socket.close();

    }
}
