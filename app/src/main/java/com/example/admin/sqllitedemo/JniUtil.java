package com.example.admin.sqllitedemo;

/**
 * Created by admin on 2017/11/20.
 */

public class JniUtil {

    public static native String getFromC();

    static {
        System.loadLibrary("native");
    }
}
