package com.mjsoftking.localloglib.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;


/**
 * 应用包信息工具类
 */
public class AppPackageInfoUtils {

    /**
     * 获取版本号(内部识别号)
     * <p>
     * 读取不到时返回 -1
     */
    public static int getVersionCode(Context context) {
        return getVersionCode(context, -1);
    }

    /**
     * 获取版本号(内部识别号)
     *
     * @param defaultValue 读取不到时的默认值
     */
    public static int getVersionCode(Context context, int defaultValue) {
        try {
            PackageInfo pi = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return pi.versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

    /**
     * 获取版本号
     *
     * @param defaultValue R.string常量
     */
    public static String getVersion(Context context, int defaultValue) {
        return getVersion(context, context.getString(defaultValue));
    }

    /**
     * 获取版本号
     */
    public static String getVersion(Context context, String defaultValue) {
        try {
            PackageInfo pi = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return pi.versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

}
