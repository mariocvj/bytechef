package com.bytechef.component.xero.util;

import java.util.HashMap;
import java.util.Map;

public final class XeroUtils {


    public static Map<String, Object> getMapFilterNull(Object... keyValueArray){
        Map<String, Object> map = new HashMap<>();
        String key;
        Object value;

        for (int i = 0; i < keyValueArray.length; i = i + 2) {
            key = keyValueArray[i].toString();
            value = keyValueArray[i+1];
            if (key != null && value != null) {
                map.put(key, value);
            }
        }
        return map;
    }
}
