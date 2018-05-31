package com.kmcho.com.square;

import java.util.*;

// St. Alfonzo’s Pancake House is the largest specialty pancake restaurant in the US. They want to develop a POS system. Part of this system is a daily distribution of their available pancakes. Each day the available catalog is sent to all stores. Each type of pancake has a unique identifier and a set of attributes. The catalog is distributed as a list of lists, where the inner list is: [pancake id, attribute key, attribute value]. All pancakes have “name” and “price” attributes.

// To make transmitting the catalog more efficient, we want to only transmit differences. Write a function that takes two catalogs and returns the differences in the same format as the input. For this you only need to worry about changes, no additions or removals.

// String clientCatalog[][] = {
//         { "001", "name", "Plain" },
//         { "001", "price", "3.00" },
//         { "002", "name", "Chocolate" },
//         { "002", "price", "4.50" },
//         { "003", "name", "Gluten-free" },
//         { "003", "price", "3.00" },
//         { "004", "name", "Whole Wheat" },
//         { "004", "price", "5.00" }};

// String serverCatalog[][] = {
//         { "001", "name", "Vanilla" },
//         { "001", "price", "2.00" },
//         { "003", "name", "Gluten-free" },
//         { "002", "name", "Chocolate" },
//         { "003", "price", "4.00" },
//         { "002", "price", "4.50" },
//         { "004", "name", "Whole Wheat" },
//         { "004", "price", "5.00" }};

// String differences[][] = {
//         { "001", "name", "Vanilla" },
//         { "001", "price", "2.00" },
//         { "003", "price", "4.00" }};

class Catalog {
    public static void main(String[] args) {

        String clientCatalog[][] = {
                { "001", "name", "Plain" },
                { "001", "price", "3.00" },
                { "002", "name", "Chocolate" },
                { "002", "price", "4.50" },
                { "003", "name", "Gluten-free" },
                { "003", "price", "3.00" },
                { "004", "name", "Whole Wheat" },
                { "004", "price", "5.00" }};

        String serverCatalog[][] = {
                { "001", "name", "Vanilla" },
                { "001", "price", "2.00" },
                { "003", "name", "Gluten-free" },
                { "002", "name", "Chocolate" },
                { "003", "price", "4.00" },
                { "002", "price", "4.50" },
                { "004", "name", "Whole Wheat" },
                { "004", "price", "5.00" }};

        HashMap<String, String> clientMap = loadCatalog(clientCatalog);
        HashMap<String, String> serverMap = loadCatalog(serverCatalog);

        String[][] result = findDifference(clientMap, serverMap);

        for (String[] aResult : result) {
            System.out.println(aResult[0] + ":" + aResult[1] + ":" + aResult[2]);
        }
    }

    private static String[][] findDifference(HashMap<String, String> client, HashMap<String, String> server) {
        List<String[]> results = new ArrayList<>();
        Iterator<Map.Entry<String, String>> iterator = client.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();

            String key = pair.getKey();
            String serverValue = server.get(key);

            if (serverValue != null) {
                if (!pair.getValue().equals(serverValue)) {
                    String[] keyArray = parseKey(key);
                    results.add(new String[] { keyArray[0], keyArray[1], serverValue });
                }
            }
        }

        return results.toArray(new String[results.size()][3]);
    }

    private static String generateKey(String id, String attribute) {
        return id + ":" + attribute;
    }

    private static String[] parseKey(String key) {
        return key.split(":");
    }

    private static HashMap<String, String> loadCatalog(String[][] catalog) {
        HashMap<String, String> map = new HashMap<>();
        for (String[] aCatalog : catalog) {
            String key = generateKey(aCatalog[0], aCatalog[1]);
            String value = aCatalog[2];
            map.put(key, value);
        }
        return map;
    }
}

