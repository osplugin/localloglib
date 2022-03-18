package com.mjsoftking.localloglib.event;

/**
 * 打印普通级别日志文件，文件名后不携带其他字符
 */
public class LogCommonEvent extends BaseLogMessageEvent {

    public LogCommonEvent(Throwable e) {
        super(e);
    }

    public LogCommonEvent(Throwable e, String time) {
        super(e, time);
    }

    public LogCommonEvent(String msg) {
        super(msg);
    }

    public LogCommonEvent(String msg, String time) {
        super(msg, time);
    }

    public LogCommonEvent(String msg, Throwable e) {
        super(msg, e);
    }

    public LogCommonEvent(String msg, Throwable e, String time) {
        super(msg, e, time);
    }

    /**
     * 文件级别，
     * 注意：此为普通日志级别，不在文件名上打印出来，但需要此参数作为线程锁
     */
    @Override
    public String getLogFileLevel() {
        return LogCommonEvent.class.getSimpleName();
    }
}
