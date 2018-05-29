package com.kmcho.algorithm.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

/**
 * Find Sets Of Numbers That Add Up To 16
 *
 * https://www.youtube.com/watch?v=nqlNzOcnCfs
 */
public class FindSetsNum {
    public static void main(String[] args) {
        int[] array = {2, 4, 6, 10};

        System.out.println(countSets(array, 16));
        System.out.println(dpCountSets(array, 16));
    }

    private static int countSets(int[] array, int total) {
        return findSetsOfNum(array, total, array.length - 1);
    }

    private static int findSetsOfNum(int[] array, int total, int i) {
        if (total == 0) return 1;
        else if (total < 0) return 0;
        else if (i < 0) return 0;
        else if (array[i] > total) {
            return findSetsOfNum(array, total, i - 1);
        } else {
            return findSetsOfNum(array, total - array[i], i - 1) + findSetsOfNum(array, total, i - 1);
        }
    }

    // dp (=dynamic programming) version
    private static int dpCountSets(int[] array, int total) {
        Map<Integer, Integer> map = new HashMap<>();
        return dpFindSetsOfNum(array, total, array.length - 1, map);
    }

    private static int dpFindSetsOfNum(int[] array, int total, int i, Map<Integer, Integer> map) {
        String key = total + ":" + i;

        Integer value = map.get(key.hashCode());
        if (value != null) {
            return value;
        }

        int result;

        if (total == 0) result = 1;
        else if (total < 0) result =  0;
        else if (i < 0) result = 0;
        else if (array[i] > total) {
            result = dpFindSetsOfNum(array, total, i - 1, map);
        } else {
            result = dpFindSetsOfNum(array, total - array[i], i - 1, map) + dpFindSetsOfNum(array, total, i - 1, map);
        }
        map.put(key.hashCode(), result);
        return result;
    }
}
