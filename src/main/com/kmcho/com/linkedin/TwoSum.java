package com.kmcho.com.linkedin;

import android.util.SparseIntArray;

interface TwoSumInterface {
    /**
     * Stores @param input in an internal data structure.
     */
    void store(int input);

    /**
     * Returns true if there is any pair of numbers in the internal data structure which
     * have sum @param val, and false otherwise.
     * For example, if the numbers 1, -2, 3, and 6 had been stored,
     * the method should return true for 4, -1, and 9, but false for 10, 5, and 0
     */
    boolean test(int val);
}

public class TwoSum implements TwoSumInterface {
    SparseIntArray sparseArray = new SparseIntArray();

    @Override
    public void store(int input) {
        sparseArray.put(input, 1);
    }

    @Override
    public boolean test(int val) {
        for (int i = 0; i < sparseArray.size(); i++) {
            int value = sparseArray.keyAt(i);
            int diff = val - value;
            if (value * 2 == val) continue;
            if (sparseArray.get(diff, 0) == 1) {
                return true;
            }
        }
        return false;
    }
}
