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
        commonPrintf(msg, null, true);
    }

    public static void commonPrintf(String msg, Throwable e) {
        commonPrintf(msg, e, true);
    }

    public static void commonPrintf(Throwable e) {
        commonPrintf(null, e, true);
    }

    public static void commonPrintf(String msg, boolean print) {
        commonPrintf(msg, null, print);
    }

    /**
     * @param msg   文本描述
     * @param e     异常对象
     * @param print 是否打印，针对特定模式下不需要打印部分日志
     */
    public static void commonPrintf(String msg, Throwable e, boolean print) {
        if (print) {
            EventBus.getDefault().post(new LogCommonEvent(msg, e));
        }
    }

    public static void commonPrintf(Throwable e, boolean print) {
        commonPrintf(null, e, print);
    }


    public static void customPrintf(String logFileLevel, String msg) {
        customPrintf(logFileLevel, msg, null, true);
    }

    public static void customPrintf(String logFileLevel, String msg, Throwable e) {
        customPrintf(logFileLevel, msg, e, true);
    }

    public static void customPrintf(String logFileLevel, Throwable e) {
        customPrintf(logFileLevel, null, e, true);
    }

    public static void customPrintf(String logFileLevel, String msg, boolean print) {
        customPrintf(logFileLevel, msg, null, print);
    }

    /**
     * @param msg   文本描述
     * @param e     异常对象
     * @param print 是否打印，针对特定模式下不需要打印部分日志
     */
    public static void customPrintf(String logFileLevel, String msg, Throwable e, boolean print) {
        if (print) {
            EventBus.getDefault().post(new LogCustomEvent(logFileLevel, msg, e));
        }
    }

    public static void customPrintf(String logFileLevel, Throwable e, boolean print) {
        customPrintf(logFileLevel, null, e, print);
    }


    public static void debugPrintf(String msg) {
        debugPrintf(msg, null, true);
    }

    public static void debugPrintf(String msg, Throwable e) {
        debugPrintf(msg, e, true);
    }

    public static void debugPrintf(Throwable e) {
        debugPrintf(null, e, true);
    }

    public static void debugPrintf(String msg, boolean print) {
        debugPrintf(msg, null, print);
    }

    /**
     * @param msg   文本描述
     * @param e     异常对象
     * @param print 是否打印，针对特定模式下不需要打印部分日志
     */
    public static void debugPrintf(String msg, Throwable e, boolean print) {
        if (print) {
            EventBus.getDefault().post(new LogDebugEvent(msg, e));
        }
    }

    public static void debugPrintf(Throwable e, boolean print) {
        debugPrintf(null, e, print);
    }


    public static void infoPrintf(String msg) {
        infoPrintf(msg, null, true);
    }

    public static void infoPrintf(String msg, Throwable e) {
        infoPrintf(msg, e, true);
    }

    public static void infoPrintf(Throwable e) {
        infoPrintf(null, e, true);
    }

    public static void infoPrintf(String msg, boolean print) {
        infoPrintf(msg, null, print);
    }

    /**
     * @param msg   文本描述
     * @param e     异常对象
     * @param print 是否打印，针对特定模式下不需要打印部分日志
     */
    public static void infoPrintf(String msg, Throwable e, boolean print) {
        if (print) {
            EventBus.getDefault().post(new LogInfoEvent(msg, e));
        }
    }

    public static void infoPrintf(Throwable e, boolean print) {
        infoPrintf(null, e, print);
    }


    public static void runtimePrintf(String msg) {
        runtimePrintf(msg, null, true);
    }

    public static void runtimePrintf(String msg, Throwable e) {
        runtimePrintf(msg, e, true);
    }

    public static void runtimePrintf(Throwable e) {
        runtimePrintf(null, e, true);
    }

    public static void runtimePrintf(String msg, boolean print) {
        runtimePrintf(msg, null, print);
    }

    /**
     * @param msg   文本描述
     * @param e     异常对象
     * @param print 是否打印，针对特定模式下不需要打印部分日志
     */
    public static void runtimePrintf(String msg, Throwable e, boolean print) {
        if (print) {
            EventBus.getDefault().post(new LogRuntimeEvent(msg, e));
        }
    }

    public static void runtimePrintf(Throwable e, boolean print) {
        runtimePrintf(null, e, print);
    }


    public static void exceptionPrintf(String msg) {
        exceptionPrintf(msg, null, true);
    }

    public static void exceptionPrintf(String msg, Throwable e) {
        exceptionPrintf(msg, e, true);
    }

    public static void exceptionPrintf(Throwable e) {
        exceptionPrintf(null, e, true);
    }

    public static void exceptionPrintf(String msg, boolean print) {
        exceptionPrintf(msg, null, print);
    }

    /**
     * @param msg   文本描述
     * @param e     异常对象
     * @param print 是否打印，针对特定模式下不需要打印部分日志
     */
    public static void exceptionPrintf(String msg, Throwable e, boolean print) {
        if (print) {
            EventBus.getDefault().post(new LogExceptionEvent(msg, e));
        }
    }

    public static void exceptionPrintf(Throwable e, boolean print) {
        exceptionPrintf(null, e, print);
    }
}
