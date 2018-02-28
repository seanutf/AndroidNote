package com.sean.zq.android.module.classLoader;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by sean on 2017/11/30.
 *
 * 自定义的类加载器demo
 */

public class MyClassLoader {

    public static void main(String[] args){
        String srcPath  = args[0];
        String destPath = args[1];
        try{
            FileInputStream fileInputStream = new FileInputStream(srcPath);
            FileOutputStream fileOutputStream = new FileOutputStream(destPath);
            cypher(fileInputStream, fileOutputStream);
            fileInputStream.close();
            fileOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private static void cypher(InputStream inputStream, OutputStream outputStream){
        int b = -1;
        try{
            while ((b = inputStream.read()) != -1){
                outputStream.write(b ^ 0xff);
            }
        }catch (Exception e){
         e.printStackTrace();
        }

    }
}
