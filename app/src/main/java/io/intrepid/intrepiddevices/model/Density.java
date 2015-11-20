package io.intrepid.intrepiddevices.model;

/**
 * Created by GuyIntrepid on 11/6/15.
 */
public enum Density {
    LDPI,
    MDPI,
    HDPI,
    XHDPI,
    XXHDPI,
    XXXHDPI;

    public static Density fromValue(float value) {
        if (value <= 0.75f) {
            return LDPI;
        }
        if (value <= 1f) {
            return MDPI;
        }
        if (value <= 1.5f) {
            return HDPI;
        }
        if (value <= 2f) {
            return XHDPI;
        }
        if (value <= 3f) {
            return XXHDPI;
        }
        return XXXHDPI;
    }
}
