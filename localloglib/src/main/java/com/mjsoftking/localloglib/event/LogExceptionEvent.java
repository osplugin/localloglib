package com.mjsoftking.localloglib.event;

/**
 * 打印Exception日志文件，文件名后携带 Exception
 */
public class LogExceptionEvent extends BaseLogMessageEvent {

    public LogExceptionEvent(Throwable e) {
        this(e, false);
    }

    public LogExceptionEvent(String msg) {
        this(msg, false);
    }

    public LogExceptionEvent(String msg, Throwable e) {
        this(msg, e, false);
    }

    public LogExceptionEvent(Throwable e, boolean localLogFileAppendName) {
        super(e);
        this.localLogFileAppendName = localLogFileAppendName;
    }

    public LogExceptionEvent(Throwable e, String time, boolean localLogFileAppendName) {
        super(e, time);
        this.localLogFileAppendName = localLogFileAppendName;
    }

    public LogExceptionEvent(String msg, boolean localLogFileAppendName) {
        super(msg);
        this.localLogFileAppendName = localLogFileAppendName;
    }

    public LogExceptionEvent(String msg, String time, boolean localLogFileAppendName) {
        super(msg, time);
        this.localLogFileAppendName = localLogFileAppendName;
    }

    public LogExceptionEvent(String msg, Throwable e, boolean localLogFileAppendName) {
        super(msg, e);
        this.localLogFileAppendName = localLogFileAppendName;
    }

    public LogExceptionEvent(String msg, Throwable e, String time, boolean localLogFileAppendName) {
        super(msg, e, time);
        this.localLogFileAppendName = localLogFileAppendName;
    }

    private final boolean localLogFileAppendName;

    /**
     * 文件级别
     */
    @Override
    public String getLogFileLevel() {
        return "Exception";
    }

    @Override
    public boolean isLocalLogFileAppendName() {
        return localLogFileAppendName;
    }
}
