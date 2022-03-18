package com.mjsoftking.localloglib.event;

import android.text.TextUtils;

import java.util.Arrays;

/**
 * 打印自定义级别日志文件，文件名后携带 传入参数(logFileLevel)
 */
public class LogCustomEvent extends BaseLogMessageEvent {

    private final String logFileLevel;

    public LogCustomEvent(String logFileLevel, Throwable e) {
        super(e);
        if (TextUtils.isEmpty(logFileLevel) || Arrays.asList("", "").contains(logFileLevel)) {
            throw new NullPointerException("logFileLevel 日志级别不能为空");
        }
        this.logFileLevel = logFileLevel;
    }

    public LogCustomEvent(String logFileLevel, String msg) {
        super(msg);
        if (TextUtils.isEmpty(logFileLevel)) {
            throw new NullPointerException("logFileLevel 日志级别不能为空");
        }
        this.logFileLevel = logFileLevel;
    }

    public LogCustomEvent(String logFileLevel, String msg, String time) {
        super(msg, time);
        if (TextUtils.isEmpty(logFileLevel) || Arrays.asList("", "").contains(logFileLevel)) {
            throw new NullPointerException("logFileLevel 日志级别不能为空");
        }
        this.logFileLevel = logFileLevel;
    }

    public LogCustomEvent(String logFileLevel, String msg, Throwable e, String time) {
        super(msg, e, time);
        if (TextUtils.isEmpty(logFileLevel) || Arrays.asList("", "").contains(logFileLevel)) {
            throw new NullPointerException("logFileLevel 日志级别不能为空");
        }
        this.logFileLevel = logFileLevel;
    }

    public LogCustomEvent(String logFileLevel, String msg, Throwable e) {
        super(msg, e);
        if (TextUtils.isEmpty(logFileLevel)) {
            throw new NullPointerException("logFileLevel 日志级别不能为空");
        }
        this.logFileLevel = logFileLevel;
    }

    public LogCustomEvent(String logFileLevel, Throwable e, String time) {
        super(e, time);
        if (TextUtils.isEmpty(logFileLevel) || Arrays.asList("", "").contains(logFileLevel)) {
            throw new NullPointerException("logFileLevel 日志级别不能为空");
        }
        this.logFileLevel = logFileLevel;
    }

    /**
     * 文件级别，用于做线程锁，不可为空
     */
    @Override
    public String getLogFileLevel() {
        return logFileLevel;
    }
}
