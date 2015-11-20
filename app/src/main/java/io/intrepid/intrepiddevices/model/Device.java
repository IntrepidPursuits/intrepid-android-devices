package io.intrepid.intrepiddevices.model;

/**
 * Created by GuyIntrepid on 11/6/15.
 */
public class Device {

    private String serialNumber;
    private String manufacturerName;
    private String modelName;
    private int androidVersion;
    private int screenHeightPixels;
    private int screenWidthPixels;

    // "5.0.1"
    private String detailedVersion;

    //Small, Normal, Large, Extra Large
    private int screenLayoutSize;

    //LDPI, MDPI...
    private float screenDensity;

    //who actually paid for this device
    private String ownerName;
    private String ownerEmail;

    //who is using it now
    private String currentUserName;
    private String currentUserEmail;

    private boolean isBatteryCharging;
    private float remainingBattery;

    //should probably have something like comments later
    private String notes;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(int androidVersion) {
        this.androidVersion = androidVersion;
    }

    public int getScreenHeightPixels() {
        return screenHeightPixels;
    }

    public void setScreenHeightPixels(int screenHeightPixels) {
        this.screenHeightPixels = screenHeightPixels;
    }

    public int getScreenWidthPixels() {
        return screenWidthPixels;
    }

    public void setScreenWidthPixels(int screenWidthPixels) {
        this.screenWidthPixels = screenWidthPixels;
    }

    public String getDetailedVersion() {
        return detailedVersion;
    }

    public void setDetailedVersion(String detailedVersion) {
        this.detailedVersion = detailedVersion;
    }

    public int getScreenLayoutSize() {
        return screenLayoutSize;
    }

    public void setScreenLayoutSize(int screenLayoutSize) {
        this.screenLayoutSize = screenLayoutSize;
    }

    public float getScreenDensity() {
        return screenDensity;
    }

    public void setScreenDensity(float screenDensity) {
        this.screenDensity = screenDensity;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getCurrentUserName() {
        return currentUserName;
    }

    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }

    public String getCurrentUserEmail() {
        return currentUserEmail;
    }

    public void setCurrentUserEmail(String currentUserEmail) {
        this.currentUserEmail = currentUserEmail;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isBatteryCharging() {
        return isBatteryCharging;
    }

    public void setIsBatteryCharging(boolean isBatteryCharging) {
        this.isBatteryCharging = isBatteryCharging;
    }

    public float getRemainingBattery() {
        return remainingBattery;
    }

    public void setRemainingBattery(float remainingBattery) {
        this.remainingBattery = remainingBattery;
    }

}
