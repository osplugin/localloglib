package com.mjsoftking.localloglib.util;

import android.content.Context;
import android.os.Environment;

import java.io.File;

public class FolderUtil {

    /**
     * 创建文件夹
     *
     * @param folderName 文件夹的全路径
     */
    public static boolean creteFolder(String folderName) {
        File dirFirstFolder = new File(folderName);
        //如果该文件夹不存在，则进行创建
        if (!dirFirstFolder.exists()) {
            //创建文件夹
            return dirFirstFolder.mkdirs();
        }
        return true;
    }


    /**
     * 根据包名获得文件夹名称
     *
     * @param context
     * @return
     */
    public static String readFolderByPackage(Context context) {
        String packageName = context.getPackageName();
        return packageName.substring(packageName.indexOf(".") + 1).replace(".", "_");
    }

    /**
     * 获取sd卡根路径
     */
    public static String getSDRoot() {
        return Environment.getExternalStorageDirectory() + "/";
    }
}

