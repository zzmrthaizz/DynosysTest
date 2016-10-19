package com.thai.dynosystest.utils;

import android.app.Activity;
import android.util.DisplayMetrics;

import com.thai.dynosystest.SaveData;

/**
 * Created by user on 17/10/2016.
 */

public class Utils {
    public static int getDeviceWidth(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;

    }

    public static int getDeviceHeight(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.heightPixels;

    }

    public static void saveDeviceSize(Activity activity) {
        SaveData.getInstance(activity).setDeviceWidth(getDeviceWidth(activity));
        SaveData.getInstance(activity).setDeviceHeight(getDeviceHeight(activity));
    }
}
