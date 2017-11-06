package com.example.xxsj.myselfstudy.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by xxsj on 2017/11/6.
 */

public class LocalCacheUtils {
    //本地缓存
    public static final String CACHE_PATH = Environment.getDownloadCacheDirectory()+"/local_cache";

    //向本地中存储
    public static void setBitmapToLocal(String str, Bitmap bitmap) throws Exception {
        String fileName = MD5Encoder.encode(str);
        File file = new File(CACHE_PATH,fileName);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()){//如果文件夾不存在，創建文件夾
            parentFile.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream(file);
        fos.flush();

        //图片转换为输出流
        bitmap.compress(Bitmap.CompressFormat.PNG,100,fos);
    }

    //从本地读取
    public static Bitmap getBitmapFromLocal(String str) throws Exception {
        String fileName = MD5Encoder.encode(str);
        File file = new File(CACHE_PATH,fileName);
        Bitmap bitmap = BitmapFactory.decodeStream(new FileInputStream(file));
        return bitmap;
    }
}
