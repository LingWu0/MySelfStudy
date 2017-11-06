package com.example.xxsj.myselfstudy.utils;

import java.security.MessageDigest;

/**
 * Created by xxsj on 2017/11/6.
 */

public class MD5Encoder {
    public static String encode(String string)throws Exception{
        byte[] hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        StringBuilder stringBuilder = new StringBuilder(hash.length*2);
        for (byte b:hash){
            if ((b & 0xFF) < 0x10) {
                stringBuilder.append("0");
            }
            stringBuilder.append(Integer.toHexString(b & 0xFF));
        }
        return stringBuilder.toString();
        }


}
