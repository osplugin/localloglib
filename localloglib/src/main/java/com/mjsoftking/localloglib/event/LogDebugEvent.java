package com.mjsoftking.localloglib.event;

/**
 * 打印Debug日志文件，文件名后携带 Debug
 */
public class LogDebugEvent extends BaseLogMessageEvent {

    public LogDebugEvent(Throwable e) {
        super(e);
    }

    public LogDebugEvent(Throwable e, String time) {
        super(e, time);
    }

    public LogDebugEvent(String msg) {
        super(msg);
    }

    public LogDebugEvent(String msg, String time) {
        super(msg, time);
    }

    public LogDebugEvent(String msg, Throwable e) {
        super(msg, e);
    }

    public LogDebugEvent(String msg, Throwable e, String time) {
        super(msg, e, time);
    }

    /**
     * 文件级别
     */
    @Override
    public String getLogFileLevel() {
        return "Debug";
    }
}
