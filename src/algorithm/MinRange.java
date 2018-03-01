package algorithm;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * https://careercup.com/question?id=16759664
 *
 * You have k lists of sorted integers. Find the smallest range that includes at least one number from each of the k lists.
 *
 * For example,
 * List 1: [4, 10, 15, 24, 26]
 * List 2: [0, 9, 12, 20]
 * List 3: [5, 18, 22, 30]
 *
 * The smallest range here would be [20, 24] as it contains 24 from list 1, 20 from list 2, and 22 from list 3.
 */

public class MinRange {
    public static void main(String[] args) {
        int[][] input = {
                {4, 10, 15, 24, 26},
                {0, 9, 12, 20},
                {5, 18, 22, 30}
        };

        int[] index = {0 ,0, 0};

//        int[][] input = {
//                {24, 4, 10, 15, 26},
//                {9, 20, 0, 12},
//                {5, 18, 22, 30},
//                {7}
//        };
//
//        int[] index = {0 ,0, 0, 0};

        sortArrays(input);

        int minRangeSize = Integer.MAX_VALUE;
        int[] minRange = {0, 0};

        while (index != null) {
            int[] range = getRange(input, index);
            int rangeSize = range[1] - range[0];
            if (rangeSize < minRangeSize) {
                minRangeSize = rangeSize;
                minRange = range;
            }

            index = moveIndex(input, index);
        }

        System.out.println(Arrays.toString(minRange));
    }

    static void sortArrays(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            Arrays.sort(input[i]);
        }
    }

    static int[] getRange(int[][] inputArray, int[] indexArray) {
        int[] values = getValues(inputArray, indexArray);

        int min = IntStream.of(values).min().getAsInt();
        int max = IntStream.of(values).max().getAsInt();

        return new int[] {min, max};
    }

    static int[] moveIndex(int[][] inputArray, int[] indexArray) {

        int index = getArrayIndexToMove(inputArray, indexArray);

        if (index == -1) {
            return null;
        }

        indexArray[index]++;

        return indexArray;
    }

    static int[] getValues(int[][] inputArray, int[] indexArray) {
        int[] values = new int[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            values[i] = inputArray[i][indexArray[i]];
        }

        return values;
    }

    static int getArrayIndexToMove(int[][] inputArray, int[] indexArray) {
        int[] values = getValues(inputArray, indexArray);

        int min = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < values.length; i++) {
            if (indexArray[i] == inputArray[i].length - 1) {
                continue;
            }

            if (values[i] < min) {
                index = i;
                min = values[i];
            }
        }

        return index;
    }
}
