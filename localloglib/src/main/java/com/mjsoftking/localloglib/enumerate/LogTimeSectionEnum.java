package com.mjsoftking.localloglib.enumerate;

public enum LogTimeSectionEnum {

    YYYY("yyyy","年"),
    YYYY_MM("yyyy-MM","年月"),
    YYYY_MM_DD("yyyy-MM-dd","年月日"),

    YYYY_MM_DD_HH("yyyy-MM-dd HH","年月日时-空格衔接日期和时间部分"),
    YYYY_MM_DD_HH_MM("yyyy-MM-dd HH:mm","年月日时分-空格衔接日期和时间部分"),
    YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd HH:mm:ss","年月日时分秒-空格衔接日期和时间部分"),

    YYYY_MM_DD__HH("yyyy-MM-dd_HH","年月日时-下划线衔接日期和时间部分"),
    YYYY_MM_DD__HH_MM("yyyy-MM-dd_HH:mm","年月日时分-下划线衔接日期和时间部分"),
    YYYY_MM_DD__HH_MM_SS("yyyy-MM-dd_HH:mm:ss","年月日时分秒-下划线衔接日期和时间部分");

    LogTimeSectionEnum(String label, String desc) {
        this.label = label;
    }

    private final String label;

    public String getLabel() {
        return label;
    }
}
