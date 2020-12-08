package com.mjsoftking.localloglib.event;

/**
 * 打印Info日志文件，文件名后携带 Info
 */
public class LogInfoEvent extends BaseLogMessageEvent {

    public LogInfoEvent(Throwable e) {
        super(e);
    }

    public LogInfoEvent(String msg) {
        super(msg);
    }

    public LogInfoEvent(String msg, Throwable e) {
        super(msg, e);
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
