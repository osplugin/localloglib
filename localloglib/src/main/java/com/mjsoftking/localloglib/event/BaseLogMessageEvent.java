package com.mjsoftking.localloglib.event;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * created by majian
 * on 2020/10/27
 * PackageName com.leo.device.util.event
 */
public abstract class BaseLogMessageEvent {

    private final String msg;
    private final String time;
    private final Throwable e;

    public BaseLogMessageEvent(Throwable e) {
        this.msg = e.getMessage();
        this.e = e;
        this.time = null;
    }

    public BaseLogMessageEvent(Throwable e, String time) {
        this.msg = e.getMessage();
        this.e = e;
        this.time = time;
    }

    public BaseLogMessageEvent(String msg) {
        this.msg = msg;
        this.e = null;
        this.time = null;
    }

    public BaseLogMessageEvent(String msg, String time) {
        this.msg = msg;
        this.e = null;
        this.time = time;
    }

    public BaseLogMessageEvent(String msg, Throwable e) {
        this.msg = msg;
        this.e = e;
        this.time = null;
    }

    public BaseLogMessageEvent(String msg, Throwable e, String time) {
        this.msg = msg;
        this.time = time;
        this.e = e;
    }

    /**
     * 文件级别，用于做线程锁，不可为空
     */
    public abstract String getLogFileLevel();

    /**
     * 是否在部分类型日志下追加文件名后的附加名
     *
     * @return 默认追加
     */
    public boolean isLocalLogFileAppendName() {
        return true;
    }

    public String getTime() {
        if (null == time) {
            return "";
        }
        return time;
    }

    public String getMsg() {
        if (null == msg) {
            return "";
        }
        return msg;
    }

    public String getThrowable() {
        if (null != e) {
            try {
                Writer writer = new StringWriter();
                PrintWriter pw = new PrintWriter(writer);
                e.printStackTrace(pw);
                Throwable cause = e.getCause();
                // 循环着把所有的异常信息写入writer中
                while (cause != null) {
                    cause.printStackTrace(pw);
                    cause = cause.getCause();
                }
                pw.close();// 记得关闭
                return writer.toString();
            } catch (Exception exception) {
                return "堆栈信息打印失败";
            }
        }
        return null;
    }
}
