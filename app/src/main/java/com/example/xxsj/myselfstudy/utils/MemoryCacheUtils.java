package com.example.xxsj.myselfstudy.utils;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by xxsj on 2017/11/6.
 */

public class MemoryCacheUtils {
   //内存缓存：图片缓存技术的核心类，用于缓存所有下载好的图片，在程序内存达到设定值时会将最近使用的图片移除掉
    private static long maxMemory = Runtime.getRuntime().maxMemory();
    private static LruCache<String,Bitmap> memoryCache = new LruCache<String, Bitmap>((int) maxMemory){
        @Override
        protected int sizeOf(String key, Bitmap value) {
            int byteCount = value.getByteCount();//获取图片占用内存大小
            return byteCount;
        }
    };
//向内存中存入
    public static void setBitmapToMemory(String str,Bitmap bitmap){
        memoryCache.put(str,bitmap);
    }
//从内存中读出
    public static Bitmap getBitmapFromMemory(String str){
            return memoryCache.get(str);
    }

}
