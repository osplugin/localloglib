package com.mjsoftking.localloglib;


import android.annotation.SuppressLint;
import android.text.TextUtils;

import com.mjsoftking.localloglib.enumerate.LogTimeSectionEnum;
import com.mjsoftking.localloglib.event.BaseLogMessageEvent;
import com.mjsoftking.localloglib.event.LogCommonEvent;
import com.mjsoftking.localloglib.inter.ILocalLogFileAppendName;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 本地日志系统
 */
public class LocalLogSystem {

    private static LocalLogSystem localLogSystem;

    /**
     * 初始化成为观察者，监听打印日志事件
     * <p>
     * 注意：请在获取 存储权限 后 调用
     */
    public static synchronized LocalLogSystem init(String folderName) {
        dispose();
        localLogSystem = new LocalLogSystem(folderName);
        return localLogSystem;
    }

    /**
     * 销毁
     */
    public static void dispose() {
        if (null != localLogSystem) {
            EventBus.getDefault().unregister(localLogSystem);
            localLogSystem = null;
        }
    }

    private LocalLogSystem(String folderName) {
        if (TextUtils.isEmpty(folderName)) {
            throw new NullPointerException("输出文件夹不能为空");
        }
        //赋值
        this.folderName = folderName;
    }

    /**
     * 文件夹名称
     */
    private String folderName;
    /**
     * 文件名称前缀
     */
    private String fileName;
    /**
     * 打印文件内容的编码方式
     * <p>
     * 默认 UTF_8
     */
    private Charset charset;

    /**
     * 打印文件的文件名后缀
     * <p>
     * 默认 log
     */
    private String fileSuffix;

    /**
     * 打印文件的文件名后的附件名，附加名可以是动态获取的，每次打印时获取，如果报错或null，则为""
     * <p>
     * 默认 ""
     */
    private ILocalLogFileAppendName localLogFileAppendName;

    /**
     * 日志文件名分段
     * <p>
     * 每份日志文件按照 年/年月/年月日/年月日时 级别分段
     * <p>
     * 注意：不设置时则所有日志信息按照分类打印至同一分类的一个文件内
     */
    private LogTimeSectionEnum logTimeSection;

    protected String getFolderName() {
        //如果末尾没有 “/”，则追加
        if (folderName.lastIndexOf("/") != folderName.length() - 1) {
            folderName += "/";
        }
        //创建文件夹。需要保证拥有权限
        File file = new File(folderName);
        if (!file.exists()) {
            file.mkdirs();
        }
        return folderName;
    }

    protected String getFileName() {
        if (TextUtils.isEmpty(fileName)) {
            fileName = "Log";
        }
        return fileName;
    }

    protected Charset getCharset() {
        if (null == charset) {
            charset = Charset.forName("UTF-8");
        }
        return charset;
    }

    protected LogTimeSectionEnum getLogTimeSection() {
        return logTimeSection;
    }

    protected String getFileSuffix() {
        if (TextUtils.isEmpty(fileSuffix)) {
            fileSuffix = "log";
        }
        return fileSuffix;
    }

    protected ILocalLogFileAppendName getLocalLogFileAppendName() {
        if (null == localLogFileAppendName) {
            localLogFileAppendName = () -> "";
        }
        return localLogFileAppendName;
    }

    public LocalLogSystem setLocalLogFileAppendName(ILocalLogFileAppendName localLogFileAppendName) {
        this.localLogFileAppendName = localLogFileAppendName;
        return this;
    }

    public LocalLogSystem setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
        return this;
    }

    public LocalLogSystem setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public LocalLogSystem setCharset(Charset charset) {
        this.charset = charset;
        return this;
    }

    public LocalLogSystem setLogTimeSection(LogTimeSectionEnum logTimeSection) {
        this.logTimeSection = logTimeSection;
        return this;
    }

    /**
     * 完成初始化，并注册成为观察者
     */
    public void complete() {
        //注册观察者
        EventBus.getDefault().register(this);
    }

    /**
     * 打印日志，不可主动调用
     */
    @SuppressLint("SimpleDateFormat")
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void printf(BaseLogMessageEvent event) {
        //intern 保证是存储在内存常量中，是同一个对象
        synchronized (event.getLogFileLevel().intern()) {
            FileWriter fw = null;
            BufferedWriter bw = null;
            String datetime;
            try {
                String appendName = "";
                try {
                    appendName = getLocalLogFileAppendName().appendName();
                    appendName = (null == appendName ? "" : appendName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String logName = getFolderName() +
                        getFileName() +
                        (TextUtils.isEmpty(event.getLogFileLevel()) || event instanceof LogCommonEvent ? "" : ("-" + event.getLogFileLevel())) +
                        appendName +
                        (null == getLogTimeSection() ? "" :
                                " " + new SimpleDateFormat(getLogTimeSection().getLabel()).format(new Date())) +
                        "." + getFileSuffix();

                File file = new File(logName);
                if (!file.exists()) {
                    file.createNewFile();
                }

                SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                datetime = tempDate.format(new Date());
                fw = new FileWriter(file, true);
                // 创建FileWriter对象，用来写入字符流
                bw = new BufferedWriter(fw);
                // 将缓冲对文件的输出
                String throwable = event.getThrowable();
                String myReadLine = "[" + datetime + "] " + event.getMsg() +
                        (TextUtils.isEmpty(throwable) ? "" : ("\r\n堆栈信息：\r\n" + throwable));

                // 写入文件
                bw.write(new String(myReadLine.getBytes(), getCharset()));
                bw.newLine();
                // 刷新该流的缓冲
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != bw)
                        bw.close();

                    if (null != fw)
                        fw.close();
                } catch (IOException e1) {
                    //empty
                }
            }
        }
    }

}
