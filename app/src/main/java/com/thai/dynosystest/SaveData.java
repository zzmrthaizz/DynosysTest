package com.thai.dynosystest;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.thai.dynosystest.utils.Constant;


/**
 * Save preferences daa
 */
public class SaveData {

    /**
     * The save data.
     */
    private static SaveData saveData = null;

    /**
     * The share preference.
     */
    private SharedPreferences sharePreference;

    /**
     * Instantiates a new save data.
     *
     * @param context the context
     */
    public SaveData(Context context) {
        sharePreference = PreferenceManager.getDefaultSharedPreferences(context);
    }

    /**
     * Gets the single instance of SaveData.
     *
     * @param context the context
     * @return single instance of SaveData
     */
    public static SaveData getInstance(Context context) {
        if (saveData == null) {
            saveData = new SaveData(context);
        }
        return saveData;
    }

    public void setDeviceWidth(int deviceWidth) {
        sharePreference.edit().putInt(Constant.DEVICE_WIDTH, deviceWidth).apply();
    }

    public int getDeviceWidth() {
        return sharePreference.getInt(Constant.DEVICE_WIDTH, 0);
    }

    public void setDeviceHeight(int deviceHeight) {
        sharePreference.edit().putInt(Constant.DEVICE_HEIGHT, deviceHeight).apply();
    }

    public int getDeviceHeight() {
        return sharePreference.getInt(Constant.DEVICE_HEIGHT, 0);
    }

}
