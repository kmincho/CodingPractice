package algorithm;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Interval<Integer>> intervals = new ArrayList<>();

        for (int i = 0;i < n; i++) {
            int low = scanner.nextInt();
            int high = scanner.nextInt();
            intervals.add(new Interval<>(low, high));
        }

        showMergedIntervals(intervals);
    }

    static void showMergedIntervals(List<Interval<Integer>> intervals) {
        Element[] elements = new Element[intervals.size() * 2];
        int i = 0;
        for (Interval<Integer> interval : intervals) {
            elements[i * 2] = new Element(interval.getLow(), 0);
            elements[i * 2 + 1] = new Element(interval.getHigh(), 1);
            i++;
        }
        Arrays.sort(elements);

        List<Interval<Integer>> resultList = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        for (int j = 0; j < elements.length; j++) {
            Element element = elements[j];
            if (element.getType() == 0) {
                stack.push(element.getValue());
            } else {
                int v = stack.pop();
                if (stack.isEmpty()) {
                    resultList.add(new Interval<>(v, element.getValue()));
                }
            }
        }
        for (Interval interval : resultList) {
            System.out.println(interval.toString());
        }
    }

    private static class Interval<T> {
        private T low;
        private T high;

        public Interval(T low, T high) {
            this.low = low;
            this.high = high;
        }

        public T getLow() {
            return low;
        }

        public T getHigh() {
            return high;
        }

        public String toString() {
            return new String("(" + low + ", " + high + ")");
        }
    }

    private static class Element implements Comparable<Element>{
        private int value;
        private int type;

        public Element(int value, int type) {
            this.value = value;
            this.type = type;
        }

        @Override
        public int compareTo(Element o) {
            if (value > o.getValue()) return 1;
            else if (value < o.getValue()) return -1;
            else return 0;
        }

        public int getValue() {
            return value;
        }

        public int getType() {
            return type;
        }

    }
}




