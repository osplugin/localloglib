package com.mjsoftking.localloglib.event;

/**
 * 打印Exception日志文件，文件名后携带 Exception
 */
public class LogExceptionEvent extends BaseLogMessageEvent {

    public LogExceptionEvent(Throwable e) {
        super(e);
    }

    public LogExceptionEvent(String msg) {
        super(msg);
    }

    public LogExceptionEvent(String msg, Throwable e) {
        super(msg, e);
    }

    /**
     * 文件级别
     */
    @Override
    public String getLogFileLevel() {
        return "Exception";
    }
}
