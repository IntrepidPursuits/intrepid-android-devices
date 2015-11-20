package io.intrepid.intrepiddevices.model;

import android.content.res.Configuration;

/**
 * Created by GuyIntrepid on 11/6/15.
 */
public enum ScreenLayoutSize {
    UNDEFINED,
    SMALL,
    NORMAL,
    LARGE,
    X_LARGE;

    public static ScreenLayoutSize fromValue(int value) {
        switch (value) {
            case Configuration.SCREENLAYOUT_SIZE_SMALL:
                return SMALL;
            case Configuration.SCREENLAYOUT_SIZE_NORMAL:
                return NORMAL;
            case Configuration.SCREENLAYOUT_SIZE_LARGE:
                return LARGE;
            case Configuration.SCREENLAYOUT_SIZE_XLARGE:
                return X_LARGE;
        }
        return UNDEFINED;
    }
}
