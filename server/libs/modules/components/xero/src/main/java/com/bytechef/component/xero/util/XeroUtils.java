package com.bytechef.component.xero.util;

import java.util.HashMap;
import java.util.Map;

public final class XeroUtils {


    public static Map<String, String> getMapFilterNull(String... keyValueArray){
        Map<String, String> map = new HashMap<>();
        String key;
        String value;

        for (int i = 0; i < keyValueArray.length; i = i + 2) {
            key = keyValueArray[i];
            value = keyValueArray[i+1];
            if (key != null && value != null) {
                map.put(key, value);
            }
        }
        return map;
    }
}
