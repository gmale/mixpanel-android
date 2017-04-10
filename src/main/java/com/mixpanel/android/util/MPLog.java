package com.mixpanel.android.util;

import android.util.Log;
import java.io.IOException;
import com.mixpanel.android.mpmetrics.MPConfig;

public class MPLog {

    public static final int VERBOSE = 2;
    public static final int DEBUG = 3;
    public static final int INFO = 4;
    public static final int WARN = 5;
    public static final int ERROR = 6;
    public static final int NONE = Integer.MAX_VALUE;

    private static int sMinLevel = MPConfig.DEBUG ? VERBOSE : WARN;
    private static Appendable logger;

    public static void setLevel(int minLevel) {
        sMinLevel = minLevel;
    }

    public static void setLogger(Appendable appendable) {
        logger = appendable;
    }

    public static void v(String tag, String message) {
        if (shouldLog(VERBOSE)) {
            Log.v(tag, message);
            try { if(logger != null)logger.append(message); } catch(IOException e) {}
        }
    }

    public static void v(String tag, String message, Throwable throwable) {
        if (shouldLog(VERBOSE)) {
            Log.v(tag, message, throwable);
            try { if(logger != null)logger.append(message); } catch(IOException e) {}
        }
    }

    public static void d(String tag, String message) {
        if (shouldLog(DEBUG)) {
            Log.d(tag, message);
            try { if(logger != null)logger.append(message); } catch(IOException e) {}
        }
    }

    public static void d(String tag, String message, Throwable throwable) {
        if (shouldLog(DEBUG)) {
            Log.d(tag, message, throwable);
            try { if(logger != null)logger.append(message); } catch(IOException e) {}
        }
    }

    public static void i(String tag, String message) {
        if (shouldLog(INFO)) {
            Log.i(tag, message);
            try { if(logger != null)logger.append(message); } catch(IOException e) {}
        }
    }

    public static void i(String tag, String message, Throwable throwable) {
        if (shouldLog(INFO)) {
            Log.i(tag, message, throwable);
            try { if(logger != null)logger.append(message); } catch(IOException e) {}
        }
    }

    public static void w(String tag, String message) {
        if (shouldLog(WARN)) {
            Log.w(tag, message);
            try { if(logger != null)logger.append(message); } catch(IOException e) {}
        }
    }

    public static void w(String tag, String message, Throwable throwable) {
        if (shouldLog(WARN)) {
            Log.w(tag, message, throwable);
            try { if(logger != null)logger.append(message); } catch(IOException e) {}
        }
    }

    public static void e(String tag, String message) {
        if (shouldLog(ERROR)) {
            Log.e(tag, message);
            try { if(logger != null)logger.append(message); } catch(IOException e) {}
        }
    }

    public static void e(String tag, String message, Throwable throwable) {
        if (shouldLog(ERROR)) {
            Log.e(tag, message, throwable);
            try { if(logger != null)logger.append(message); } catch(IOException e) {}
        }
    }

    public static void wtf(String tag, String message) {
        if (shouldLog(ERROR)) {
            Log.wtf(tag, message);
            try { if(logger != null)logger.append(message); } catch(IOException e) {}
        }
    }

    public static void wtf(String tag, String message, Throwable throwable) {
        if (shouldLog(ERROR)) {
            Log.wtf(tag, message, throwable);
            try { if(logger != null)logger.append(message); } catch(IOException e) {}
        }
    }

    private static boolean shouldLog(int level) {
        return sMinLevel <= level || logger != null;
    }
}
