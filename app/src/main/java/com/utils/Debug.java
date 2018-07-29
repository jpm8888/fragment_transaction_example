package com.utils;

import android.util.Log;


public class Debug {
    private final static boolean IS_DEBUG = true;
    private final static String DEFAULT_TAG = "rpfes";

    public static void log(Object... msg) {
        log(DEFAULT_TAG, msg);
    }

    public static void log(String tag, Object... msg) {
        if (!IS_DEBUG) return;
        for (int i = 0; i < msg.length; i++) Log.d(tag, msg.toString());
    }
}
