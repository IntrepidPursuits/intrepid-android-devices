package io.intrepid.intrepiddevices;

import android.os.Build;

import org.junit.Test;

import io.intrepid.intrepiddevices.model.Device;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void sdflkj() {
        Device device = new Device();
        device.setAndroidVersion(Build.VERSION.SDK_INT);
        device.setDetailedVersion(Build.VERSION.RELEASE);
        device.setManufacturerName(Build.MANUFACTURER);
        assertEquals("intrepid", device.getManufacturerName());
    }
}