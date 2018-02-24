package algorithm;

public class kPermutation {
    public static void main(String[] args) {
        String[] input = {"a", "b", "c", "d", "e", "f", "g"};
        int k = 2;

        permutation(input, new String(), k);

    }

    static void permutation(String[] array, String output, int k) {
        int size = array.length;

        if (k == 0) {
            System.out.println(output);
            return;
        }

        for (int i = 0; i < size; i++) {
            String[] input = getArrayRemoved(array, array[i]);
            String output2;

            if (output.isEmpty()) {
                output2 = new String(array[i]);
            } else {
                output2 = new String(output + ", " + array[i]);
            }

            permutation(input, output2, k - 1);

        }
    }

    static String[] getArrayRemoved(String[] input, String removed) {
        String[] result = new String[input.length - 1];

        int i = 0;
        for (String s : input) {
            if (!s.equals(removed)) {
                result[i++] = s;
            }
        }

        return result;
    }
}
