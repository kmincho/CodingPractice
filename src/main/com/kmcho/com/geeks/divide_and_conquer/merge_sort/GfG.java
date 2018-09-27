package com.kmcho.com.geeks.divide_and_conquer.merge_sort;

class GfG {
    // Merges two subarrays of arr[].  First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int p = 0;
        int i = l;
        int j = m + 1;
        while (i <= m || j <= r) {
            if (i <= m && j <= r) {
                temp[p++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
            } else {
                temp[p++] = i <= m ? arr[i++] : arr[j++];
            }
        }

        for (int k = 0; k < temp.length; k++) {
            arr[l + k] = temp[k];
        }
    }
}
