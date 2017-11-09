package com.example.brevity.retropostdemo.utils;

import android.content.Context;

public class AppConfig {
    public static Boolean isInternetPresent = false;

    public static String add = "http://1.22.161.26:9017/Supplier/Login";
    public static boolean isDebug = true;

    public interface WsMethodType {
        int POST = 0;
        int GET = 1;
        int PUT = 2;
        int POSTMapData = 3;
    }

    public interface HeaderType {
        int Authorization = 0;
        int Custom = 1;
        int None = 2;
    }

    public interface ServerUrl {
        //TODO To change local and partialLive server url
        String WsPrefix = "http://1.22.161.26:4186/Api";
        /*String Local = "http://1.22.161.26:6565/";
        String live = "";
        String PartialLive = "http://1.22.161.26:3535/";*/
    }

    public interface Frequency {
        int Daily = 1;
        int Weekly = 2;
    }

    public interface ServerCredintial {
        String UserName = "settings";
        String Password = "#fmcg123";
    }

    public interface WsEndPoint {
        String Login = "/auth/";
    }


    public static String getPreferencePrefix(Context context) {
        return "/data/data/" + context.getPackageName() + "/shared_prefs/";
    }


    public interface HeaderData {
        String Username = "ClickATick";
        String Password = "ClickATick";
    }


    public interface StandardStatusCodes {
        int SUCCESS = 200;
        int BAD_REQUEST = 400;
        //        int POLICY_NOT_FULL_FILLED = 420;
//        int IS_EXISTS = 421;
        int INTERNAL_SERVER_ERROR = 500;
        int NO_DATA_FOUND = 404;
        int TIME_OUT = 408;
        int UNAUTHORISE = 401;
        int CONFLICT = 409;
    }

    public interface LogType {
        /**
         * Priority constant for the println method; use Log.v.
         */
        int VERBOSE = 2;

        /**
         * Priority constant for the println method; use Log.d.
         */
        int DEBUG = 3;

        /**
         * Priority constant for the println method; use Log.i.
         */
        int INFO = 4;

        /**
         * Priority constant for the println method; use Log.w.
         */
        int WARN = 5;

        /**
         * Priority constant for the println method; use Log.e.
         */
        int ERROR = 6;

        /**
         * Priority constant for the println method.
         */
        int ASSERT = 7;

    }
    public interface SnackBarType {
        int LENGTH_INDEFINITE = -2;
        int LENGTH_SHORT = -1;
        int LENGTH_LONG = 0;
    }
}