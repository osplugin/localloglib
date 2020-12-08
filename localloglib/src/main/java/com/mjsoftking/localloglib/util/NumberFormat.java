package com.mjsoftking.localloglib.util;

public class NumberFormat {

    public static int intFormat(String text, int defaultValue) {
        return intFormat(text, 10, defaultValue);
    }

    public static int intFormat(String text, int radix, int defaultValue) {
        try {
            return Integer.parseInt(text, radix);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static double doubleFormat(String text, double defaultValue) {
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static float floatFormat(String text, float defaultValue) {
        try {
            return Float.parseFloat(text);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static boolean booleanFormat(String text) {
        return Boolean.parseBoolean(text);
    }

}
