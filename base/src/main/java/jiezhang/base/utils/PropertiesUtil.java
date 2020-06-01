package jiezhang.base.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.Map.Entry;

public class PropertiesUtil {
    public static Map<String, String> loadProperties(String filePath) {

        if (null == filePath || "".equals(filePath.trim())) {
            return null;
        }
        filePath = filePath.trim();
        InputStream is = PropertiesUtil.class.getClassLoader().getResourceAsStream(filePath);
        Properties prop = new Properties();
        try {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Set<Entry<Object, Object>> set = prop.entrySet();
        Iterator<Entry<Object, Object>> it = set.iterator();
        String key = null, value = null;
        Map<String, String> map = new HashMap<String, String>(set.size());
        while (it.hasNext()) {
            Entry<Object, Object> entry = it.next();
            key = String.valueOf(entry.getKey());
            value = String.valueOf(entry.getValue());
            map.put(key, value);
        }
        return map;
    }
}
