package com.mjsoftking.localloglib.inter;

/**
 * 显示在文件名上的追加内容，附加在级别后，自行处理获取此数据的情况。
 * 默认为""，此数据可动态设定，例如登录后可以附加名字
 */
public interface ILocalLogFileAppendName {
    String appendName();
}
