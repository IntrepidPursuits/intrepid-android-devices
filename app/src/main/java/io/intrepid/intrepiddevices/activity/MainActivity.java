package io.intrepid.intrepiddevices.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.intrepid.intrepiddevices.R;
import io.intrepid.intrepiddevices.model.Device;
import io.intrepid.intrepiddevices.util.GsonUtils;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.owner_edit_text)
    EditText ownerEditText;
    @Bind(R.id.owner_email_edit_text)
    EditText ownerEmailEditText;
    @Bind(R.id.user_edit_text)
    EditText userEditText;
    @Bind(R.id.user_email_edit_text)
    EditText userEmailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private Device generateDevice() {
        Device device = new Device();
        device.setAndroidVersion(Build.VERSION.SDK_INT);
        device.setDetailedVersion(Build.VERSION.RELEASE);
        device.setManufacturerName(Build.MANUFACTURER);
        device.setScreenLayoutSize(getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK);
        device.setSerialNumber(Build.SERIAL);
        //less pretty version - Build.PRODUCT
        device.setModelName(Build.MODEL);
        fillBatteryInfo(device);
        fillHeightAndWidth(device);
        return device;
    }

    private void fillBatteryInfo(Device device) {
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = registerReceiver(null, ifilter);
        int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                status == BatteryManager.BATTERY_STATUS_FULL;
        device.setIsBatteryCharging(isCharging);

        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        float batteryPct = level / (float) scale;
        device.setRemainingBattery(batteryPct);
    }

    private void fillHeightAndWidth(Device device) {
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
        device.setScreenHeightPixels(displayMetrics.heightPixels);
        device.setScreenWidthPixels(displayMetrics.widthPixels);
        device.setScreenDensity(displayMetrics.density);
    }

    @OnClick(R.id.submit_button)
    public void submit() {
        Device device = generateDevice();
        device.setCurrentUserEmail(userEmailEditText.getText().toString());
        device.setCurrentUserName(userEditText.getText().toString());
        device.setOwnerEmail(ownerEmailEditText.getText().toString());
        device.setOwnerName(ownerEditText.getText().toString());
        post(device);
    }


    //temporary - posts to google doc
    private void post(final Device device) {
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest sr = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycbw_I_sRVFbOW7C9v49lQladyHXRHyYO4ufWCj8wHHzWotUMuaxG/exec", new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this, R.string.update_successful, Toast.LENGTH_SHORT).show();
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, R.string.update_error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return GsonUtils.volleyHash(device);
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        };
        queue.add(sr);
    }

}
