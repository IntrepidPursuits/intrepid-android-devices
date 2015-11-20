package io.intrepid.intrepiddevices.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;

/**
 * Created by GuyIntrepid on 11/19/15.
 */
public class GsonUtils {
    private static Gson gson = new Gson();

    public static HashMap<String, String> volleyHash(Object obj) {
        return gson.fromJson(gson.toJson(obj), new TypeToken<HashMap<String, String>>() {
        }.getType());
    }
}
