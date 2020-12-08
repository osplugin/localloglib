package com.mjsoftking.localloglib.util;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;


/**
 * meta-data 资源参数读取
 */
public class AppMetaDataUtils {

    /**
     * 从Application获取
     *
     * @param context 上下文
     * @param key     key
     */
    public static String fromApplication(Context context, String key) {
        try {
            ApplicationInfo info = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            return info.metaData.getString(key);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 从activity获取
     *
     * @param context  上下文
     * @param activity activity的class
     * @param key      key
     */
    public static <T extends Activity> String fromActivity(Context context, Class<T> activity, String key) {
        try {
            ActivityInfo info = context.getPackageManager()
                    .getActivityInfo(new ComponentName(context, activity),
                            PackageManager.GET_META_DATA);
            return info.metaData.getString(key);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 从服务获取
     *
     * @param context 上下文
     * @param service 服务的class
     * @param key     key
     */
    public static <T extends Service> String fromService(Context context, Class<T> service, String key) {
        try {
            ComponentName cn = new ComponentName(context, service);
            ServiceInfo info = context.getPackageManager().getServiceInfo(cn, PackageManager.GET_META_DATA);
            return info.metaData.getString(key);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 从广播获取
     *
     * @param context  上下文
     * @param receiver 广播的class
     * @param key      key
     */
    public static <T extends BroadcastReceiver> String fromReceiver(Context context, Class<T> receiver, String key) {
        try {
            ComponentName cn = new ComponentName(context, receiver);
            ActivityInfo info = context.getPackageManager().getReceiverInfo(cn, PackageManager.GET_META_DATA);
            return info.metaData.getString(key);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
