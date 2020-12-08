package com.mjsoftking.localloglib.event;

/**
 * 打印运行时日志文件，文件名后携带 Runtime
 */
public class LogRuntimeEvent extends BaseLogMessageEvent {

    public LogRuntimeEvent(Throwable e) {
        super(e);
    }

    public LogRuntimeEvent(String msg) {
        super(msg);
    }

    public LogRuntimeEvent(String msg, Throwable e) {
        super(msg, e);
    }

    /**
     * 文件级别
     */
    @Override
    public String getLogFileLevel() {
        return "Runtime";
    }
}
