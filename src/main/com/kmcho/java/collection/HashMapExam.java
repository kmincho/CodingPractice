package com.kmcho.java.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapExam {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("001", "dog");
        map.put("002", "cat");
        map.put("003", "tiger");
        map.put("004", "lion");

        // #1
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }
        System.out.println();

        // #2
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }
        System.out.println();

        // #3
        for (String key : map.keySet()) {
            System.out.println("key = " + key + ", value = " + map.get(key));
        }
    }
}
