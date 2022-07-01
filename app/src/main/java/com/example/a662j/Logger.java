package com.example.a662j;

import android.util.Log;

/**
 * Created by Eldor Turgunov on 01.07.2022.
 * 6.6.2j
 * eldorturgunov777@gmail.com
 */
public class Logger {
    public static void d(String tag, String msg) {
        if (VolleyHttp.IS_TESTER) Log.d(tag, msg);
    }

    public static void i(String tag, String msg) {
        if (VolleyHttp.IS_TESTER) Log.i(tag, msg);
    }

    public static void v(String tag, String msg) {
        if (VolleyHttp.IS_TESTER) Log.v(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (VolleyHttp.IS_TESTER) Log.e(tag, msg);
    }
}
