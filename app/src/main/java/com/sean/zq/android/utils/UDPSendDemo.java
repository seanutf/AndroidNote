package com.sean.zq.android.utils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by sean on 2017/12/2.
 *
 * UDP 协议发送数据
 */

public class UDPSendDemo {

    public static void main(String[] args){
        try{
            //1.使用DatagramSocket创建发送端Socket服务对象
            DatagramSocket datagramSocket = new DatagramSocket();

            //2.使用DatagramPacket创建数据，并把数据打包
            //2.1 将需要传递的数据变成字节数组，并获取长度
            String str = "Hello, this message send by udp. You can call me Sean";
            byte[] bys = str.getBytes();
            int length = bys.length;
            //2.2 获取到接收端的IP地址
            InetAddress address = InetAddress.getByName("192.168.1.1");
            //2.3获取到接收端的端口号
            int port = 10010;
            //2.4构造DatagramPacket，组成数据包
            DatagramPacket packet = new DatagramPacket(bys, length, address, port);

            //3.发送数据包
            datagramSocket.send(packet);

            //4.释放资源
            datagramSocket.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
