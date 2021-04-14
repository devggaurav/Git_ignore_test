package com.bjs.mdmV2;

import android.util.Log;

import java.util.Locale;

/**
 * Created by ${GC} on 17/10/17.
 *
 * @author gaurav
 */
public final class LogUtil {
    private final static String TAG = "logs";
    private final static String MATCH = "%s->%s->%d";
    private final static String CONNECTOR = ":<--->:";

    private static boolean SWITCH = true;

    private static String buildHeader() {
        StackTraceElement stack = Thread.currentThread().getStackTrace()[4];
        return stack == null ? "UNKNOWN" : String.format(Locale.getDefault(),
                MATCH, stack.getClassName(), stack.getMethodName(), stack.getLineNumber()) + CONNECTOR;
    }

    public static void v(Object msg) {
        if (SWITCH) Log.v(TAG, buildHeader() + msg.toString());
    }

    public static void d(Object msg) {
        if (SWITCH) Log.d(TAG, buildHeader() + msg.toString());
    }

    public static void i(Object msg) {
        if (SWITCH) Log.i(TAG, buildHeader() + msg.toString());
    }

    public static void w(Object msg) {
        if (SWITCH) Log.w(TAG, buildHeader() + msg.toString());
    }

    public static void e(Object msg) {

        if (msg != null) {
            if (SWITCH) Log.e(TAG, buildHeader() + msg.toString());
        } else {
            if (SWITCH) Log.e(TAG, buildHeader() + " I am null");
        }
    }
}