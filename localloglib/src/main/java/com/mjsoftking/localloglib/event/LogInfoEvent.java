package com.mjsoftking.localloglib.event;

/**
 * 打印Info日志文件，文件名后携带 Info
 */
public class LogInfoEvent extends BaseLogMessageEvent {

    public LogInfoEvent(Throwable e) {
        super(e);
    }

    public LogInfoEvent(Throwable e, String time) {
        super(e, time);
    }

    public LogInfoEvent(String msg) {
        super(msg);
    }

    public LogInfoEvent(String msg, String time) {
        super(msg, time);
    }

    public LogInfoEvent(String msg, Throwable e) {
        super(msg, e);
    }

    public LogInfoEvent(String msg, Throwable e, String time) {
        super(msg, e, time);
    }

    /**
     * 文件级别，
     * 注意：此为普通日志级别，不在文件名上打印出来，但需要此参数作为线程锁
     */
    @Override
    public String getLogFileLevel() {
        return "Info";
    }
}
