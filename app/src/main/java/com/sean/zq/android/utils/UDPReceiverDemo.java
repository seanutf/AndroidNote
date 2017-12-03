package com.sean.zq.android.utils;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by sean on 2017/12/2.
 *
 * UDP 协议接收数据
 */

public class UDPReceiverDemo {

    public static void main(String[] args){
        try{
            //1.使用DatagramSocket创建接收端Socket服务对象，并指定端口
            DatagramSocket datagramSocket = new DatagramSocket(10010);

            //2.使用DatagramPacket创建数据包,用于接收
            byte[] bys = new byte[1024];
            int length = bys.length;
            //2.1构造DatagramPacket，组成数据包
            DatagramPacket packet = new DatagramPacket(bys, length);

            //3.接收数据包
            datagramSocket.receive(packet);

            //4.解析数据包
            InetAddress address = packet.getAddress();
            String ip = address.getHostAddress();
            byte[] bytes = packet.getData();
            int l = bytes.length;
            String s = new String(bytes, 0, l);
            System.out.println(ip + "********" + s);

            //5.释放资源
            datagramSocket.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
