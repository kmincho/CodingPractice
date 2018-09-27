package com.kmcho.com.geeks.divide_and_conquer.quick_sort;

class GfG {
    /* This function takes last element as pivot, places  the pivot element
    at its correct position in sorted  array, and places all smaller (smaller
    than pivot) to left of pivot and all greater elements to right  of pivot */
    int partition(int arr[], int low, int high) {
        int q = low;
        int pivot = high;
        for (int j = low; j < high; j++) {
            if (arr[pivot] < arr[j]) continue;
            else swap(arr, q++, j);
        }
        swap(arr, q, pivot);

        return q;
    }

    private void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
