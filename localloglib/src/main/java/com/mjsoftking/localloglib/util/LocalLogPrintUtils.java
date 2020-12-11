package com.mjsoftking.localloglib.util;

import com.mjsoftking.localloglib.event.LogCommonEvent;
import com.mjsoftking.localloglib.event.LogCustomEvent;
import com.mjsoftking.localloglib.event.LogDebugEvent;
import com.mjsoftking.localloglib.event.LogExceptionEvent;
import com.mjsoftking.localloglib.event.LogInfoEvent;
import com.mjsoftking.localloglib.event.LogRuntimeEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * 打印器
 */
public class LocalLogPrintUtils {

    public static void commonPrintf(String msg) {
        EventBus.getDefault().post(new LogCommonEvent(msg));
    }

    public static void commonPrintf(String msg, Throwable e) {
        EventBus.getDefault().post(new LogCommonEvent(msg, e));
    }

    public static void commonPrintf(Throwable e) {
        EventBus.getDefault().post(new LogCommonEvent(e));
    }

    public static void customPrintf(String logFileLevel,String msg) {
        EventBus.getDefault().post(new LogCustomEvent(logFileLevel, msg));
    }

    public static void customPrintf(String logFileLevel,String msg, Throwable e) {
        EventBus.getDefault().post(new LogCustomEvent(logFileLevel, msg, e));
    }

    public static void customPrintf(String logFileLevel, Throwable e) {
        EventBus.getDefault().post(new LogCustomEvent(logFileLevel, e));
    }


    public static void debugPrintf(String msg) {
        EventBus.getDefault().post(new LogDebugEvent(msg));
    }

    public static void debugPrintf(String msg, Throwable e) {
        EventBus.getDefault().post(new LogDebugEvent(msg, e));
    }

    public static void debugPrintf(Throwable e) {
        EventBus.getDefault().post(new LogDebugEvent(e));
    }

    public static void infoPrintf(String msg) {
        EventBus.getDefault().post(new LogInfoEvent(msg));
    }

    public static void infoPrintf(String msg, Throwable e) {
        EventBus.getDefault().post(new LogInfoEvent(msg, e));
    }

    public static void infoPrintf(Throwable e) {
        EventBus.getDefault().post(new LogInfoEvent(e));
    }

    public static void runtimePrintf(String msg) {
        EventBus.getDefault().post(new LogRuntimeEvent(msg));
    }

    public static void runtimePrintf(String msg, Throwable e) {
        EventBus.getDefault().post(new LogRuntimeEvent(msg, e));
    }

    public static void runtimePrintf(Throwable e) {
        EventBus.getDefault().post(new LogRuntimeEvent(e));
    }

    public static void exceptionPrintf(String msg) {
        EventBus.getDefault().post(new LogExceptionEvent(msg));
    }

    public static void exceptionPrintf(String msg, Throwable e) {
        EventBus.getDefault().post(new LogExceptionEvent(msg, e));
    }

    public static void exceptionPrintf(Throwable e) {
        EventBus.getDefault().post(new LogExceptionEvent(e));
    }
}
