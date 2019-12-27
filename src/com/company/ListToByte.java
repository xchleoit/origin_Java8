package com.company;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * @Author xulei
 * @Description
 * @Date 2019/12/26
 **/
public class ListToByte {
    public static void main(String[] args) throws Exception{
        List<String> list = Arrays.asList("1","test","测试");
        List<List<Byte>> bytes = new ArrayList<>();
        for (int i =0;i<list.size();i++){
           List<Byte> b= arraytoList(list.get(i).getBytes());
           bytes.add(b);
        }
        bytes.forEach(e-> System.out.print(e+"\n"));



        OutputStream out = new FileOutputStream("D://1.txt");
        Byte[] aaa = (Byte[]) list.toArray();
        byte[] b = new byte[aaa.length];
        for (int i =0;i<aaa.length;i++){
            b[i] = aaa[i];
        }

        InputStream is = new ByteArrayInputStream(b);
        byte[] buff = new byte[1024];
        int len = 0;
        while((len=is.read(buff))!=-1){
            out.write(buff, 0, len);
        }
        is.close();
        out.close();

    }
    public static List<Byte> arraytoList(byte[] bytes){
        List<Byte> list = new ArrayList<>();
        for (Byte h:bytes){
            list.add(h);
        }
        return list;
    }


}
