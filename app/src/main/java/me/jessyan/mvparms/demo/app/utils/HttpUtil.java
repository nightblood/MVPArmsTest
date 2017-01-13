package me.jessyan.mvparms.demo.app.utils;

import android.util.DisplayMetrics;
import android.util.Log;
import android.webkit.CookieManager;

import java.util.concurrent.Executor;

import common.WEApplication;

public class HttpUtil {

    public static final String APP_DEVICE_RESOLUTION = Constants.APP_NAME + "_device_resolution";
    public static final String APP_DEVICE_IMAGE_TYPE = Constants.APP_NAME + "_device_image_type";
    public static final String APP_DEVICE_ID = Constants.APP_NAME + "_device_id";
    public static final String APP_SITE_ID = Constants.APP_NAME + "_site_id";
    public static final String APP_USER_LOGIN_KEY = Constants.APP_NAME + "_user_loginkey";
    public static final String APP_REQUEST_TOKEN = Constants.APP_NAME + "_request_token";
    public static final String APP_NETWORK_TYPE = Constants.APP_NAME + "_network_environment";
    private final static int MAX_DOWNLOAD_THREAD = 3; // 有效的值范围[1, 3], 设置为3时, 可能阻塞图片加载.
//    private static final Executor executor = new PriorityExecutor(MAX_DOWNLOAD_THREAD, true);
    private static WEApplication app;
    private static String DEVICE_RESOLUTION = null;
    private static String DEVICE_IMAGE_TYPE = null;
    private static String DEVICE_ID = null;
    private static String SITE_ID = null;
    private static String USER_AGENT = null;

    public static void init(WEApplication application) {
        app = application;
    }


    public static String getUserAgent() {
        if (USER_AGENT == null) {
            StringBuilder ua = new StringBuilder(Constants.APP_NAME);
            ua.append("/" + AppUtils.getAppVersionName(app));
            ua.append("/" + AppUtils.getAppVersionCode(app));
            ua.append("/Android");// 手机系统平台
            ua.append("/" + android.os.Build.VERSION.RELEASE);// 手机系统版本
            ua.append("/" + android.os.Build.MODEL); // 手机型号
            USER_AGENT = ua.toString();
        }
        Log.d("getUserAgent", USER_AGENT);
        return USER_AGENT;
    }

    public static String getCookiesString() {
        StringBuilder cookies = new StringBuilder();
        if (DEVICE_RESOLUTION == null || DEVICE_IMAGE_TYPE == null) {
            DisplayMetrics dm = ScreenUtils.getDisplayMetrics();
            DEVICE_RESOLUTION = dm.widthPixels + "*" + dm.heightPixels;
            int dpi = dm.densityDpi;
            if (dpi <= 320) {
                DEVICE_IMAGE_TYPE = "m";
            } else if (dpi > 320 && dpi <= 480) {
                DEVICE_IMAGE_TYPE = "h";
            } else {
                DEVICE_IMAGE_TYPE = "x";
            }
        }
        cookies.append(APP_DEVICE_RESOLUTION + "=" + DEVICE_RESOLUTION + ";");
        cookies.append(APP_DEVICE_IMAGE_TYPE + "=" + DEVICE_IMAGE_TYPE + ";");
        cookies.append(APP_NETWORK_TYPE + "=" + getNetworkType() + ";");
        cookies.append(APP_DEVICE_ID + "=" + getDeviceId() + ";");
        cookies.append(APP_SITE_ID + "=" + getSiteId() + ";");
        cookies.append(APP_USER_LOGIN_KEY + "=" + ("") + ";");
//        cookies.append(APP_USER_LOGIN_KEY + "=" + (app.isLogin() ? app.getCurrentUserInfo().getLogin_key() : "") + ";");
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        String token = Constants.AUTH_KEY + "_" + getDeviceId() + "_" + getUserAgent() + "_" + timestamp;
//        token = MD5Util.md5String(token) + "_" + timestamp;
        token = EncryptUtils.encryptMD5ToString(token)+ "_" + timestamp;
        cookies.append(APP_REQUEST_TOKEN + "=" + token);
        Log.d("getCookiesString", cookies.toString());
        return cookies.toString();
    }

    public static void injectCookies(String domain, String webUA, CookieManager cookieManager) {
        if (DEVICE_RESOLUTION == null || DEVICE_IMAGE_TYPE == null) {
            DisplayMetrics dm = ScreenUtils.getDisplayMetrics();
            DEVICE_RESOLUTION = dm.widthPixels + "x" + dm.heightPixels;
            int dpi = dm.densityDpi;
            if (dpi <= 320) {
                DEVICE_IMAGE_TYPE = "m";
            } else if (dpi > 320 && dpi <= 480) {
                DEVICE_IMAGE_TYPE = "h";
            } else {
                DEVICE_IMAGE_TYPE = "x";
            }
        }
        cookieManager.setCookie(domain, APP_DEVICE_RESOLUTION + "=" + DEVICE_RESOLUTION + " ; Domain=" + domain);
        cookieManager.setCookie(domain, APP_DEVICE_IMAGE_TYPE + "=" + DEVICE_IMAGE_TYPE + " ; Domain=" + domain);
        cookieManager.setCookie(domain, APP_NETWORK_TYPE + "=" + getNetworkType() + " ; Domain=" + domain);
        cookieManager.setCookie(domain, APP_DEVICE_ID + "=" + getDeviceId() + " ; Domain=" + domain);
        cookieManager.setCookie(domain, APP_SITE_ID + "=" + getSiteId() + " ; Domain=" + domain);
//        cookieManager.setCookie(domain, APP_USER_LOGIN_KEY + "=" + (app.isLogin() ? app.getCurrentUserInfo().getLogin_key() : "") + " ; Domain=" + domain);
        cookieManager.setCookie(domain, APP_USER_LOGIN_KEY + "=" + ("") + ";");
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        String token = Constants.AUTH_KEY + "_" + getDeviceId() + "_" + webUA + "_" + timestamp;
//        token = MD5Util.md5String(token) + "_" + timestamp;
        token = EncryptUtils.encryptMD5ToString(token)+ "_" + timestamp;
        cookieManager.setCookie(domain, APP_REQUEST_TOKEN + "=" + token + " ; Domain=" + domain);
    }

    public static String getNetworkType() {
        NetworkUtils.NetworkType networkType = NetworkUtils.getNetworkType();
        switch (networkType) {
            case NETWORK_2G:
                return "2G";
            case NETWORK_3G:
                return "3G";
            case NETWORK_4G:
                return "4G";
            case NETWORK_WIFI:
                return "wifi";
            case NETWORK_UNKNOWN:
                return "2G";
            default:
                return "";
        }
    }

    public static String getDeviceId() {
        if (DEVICE_ID == null) {
            DEVICE_ID = DeviceIDUtil.getE0575_Device_ID(app);
        }
        return DEVICE_ID;
    }

    public static String getSiteId() {
//        return app.getGlobalSetting().getSite().getId();
        return "0";
    }
/*
    public static Callback.Cancelable download(String url, String target, boolean autoResume, boolean autoRename, DownloadCallback callback) {
        RequestParams params = new RequestParams(url);
        params.setAutoResume(autoResume);
        params.setAutoRename(autoRename);
        params.setSaveFilePath(target);
        params.setExecutor(executor);
        params.setCancelFast(true);
        Callback.Cancelable cancelable = x.http().get(params, callback);
        return cancelable;
    }

    public static void removeDownload(Callback.Cancelable cancelable) {
        if (cancelable == null) {
            return;
        }
        cancelable.cancel();
    }*/


}
