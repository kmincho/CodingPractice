package algorithm;

import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);

        int listCount = scanner.nextInt();
        scanner.nextLine();

        int[] listSize = new int[listCount];
        for (int i = 0; i < listCount; i++) {
            listSize[i] = scanner.nextInt();
        }
        scanner.nextLine();
        for (int i = 0; i < listCount; i++) {
            for (int j = 0; j < listSize[i]; j++) {

            }
        }
    }
}
