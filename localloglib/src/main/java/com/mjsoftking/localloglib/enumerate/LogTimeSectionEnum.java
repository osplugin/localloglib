package com.mjsoftking.localloglib.enumerate;

public enum LogTimeSectionEnum {

    YYYY("yyyy"),
    YYYY_MM("yyyy-MM"),
    YYYY_MM_DD("yyyy-MM-dd"),
    YYYY_MM_DD_HH("yyyy-MM-dd HH");

    LogTimeSectionEnum(String label) {
        this.label = label;
    }

    private final String label;

    public String getLabel() {
        return label;
    }
}
