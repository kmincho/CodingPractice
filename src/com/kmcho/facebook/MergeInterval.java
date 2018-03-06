package com.kmcho.facebook;

import java.util.*;

public class MergeInterval {
    public static void main(String[] args) {
        List<Interval> intervalList = new ArrayList<>();
        intervalList.add(new Interval(9, 11));
        intervalList.add(new Interval(1, 3));
        intervalList.add(new Interval(13, 15));
        intervalList.add(new Interval(14, 18));
        intervalList.add(new Interval(2, 3));
        intervalList.add(new Interval(1, 2));

        List<Interval> mergedInterval = mergeInterval(intervalList);
        System.out.println(mergedInterval.toString());
    }

    static List<Interval> mergeInterval(List<Interval> intervalList) {
        Collections.sort(intervalList);

        Stack<Interval> stack = new Stack<>();
        stack.push(intervalList.get(0));

        for (int i = 1; i < intervalList.size(); i++) {
            Interval top = stack.pop();
            Interval current = intervalList.get(i);

            if (isOverlapped(top, current)) {
                Interval interval = mergeInterval(top, current);
                stack.push(interval);
            } else {
                stack.push(top);
                stack.push(current);
            }
        }

        List<Interval> result = new ArrayList<>();
        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    static boolean isOverlapped(Interval first, Interval second) {
        if (second.start <= first.end && first.start < second.end) return true;
        if (first.start <= second.end && second.start < first.end) return true;

        return false;
    }

    static Interval mergeInterval(Interval first, Interval second) {
        if (first.end >= second.start) {
            return new Interval(first.start, second.end);
        } else {
            return new Interval(second.start, first.end);
        }
    }

    static class Interval implements Comparable<Interval> {
        private int start;
        private int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval interval) {
            if (start < interval.start) return -1;
            else if (start > interval.start) return 1;

            return 0;
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }
}
