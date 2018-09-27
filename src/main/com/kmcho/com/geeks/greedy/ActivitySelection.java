package com.kmcho.com.geeks.greedy;

import java.util.*;

/**
 * Greedy Algorithm - Activity Selection Problem
 * https://practice.geeksforgeeks.org/problems/activity-selection/0
 *
 * Given N activities with their start and finish times.
 * Select the maximum number of activities that can be performed by a single person,
 * assuming that a person can only work on a single activity at a time.
 *
 * Note : The start time and end time of two activities may coincide.
 *
 * Input:
 * The first line contains T denoting the number of testcases. Then follows description of testcases.
 * First line is N number of activities then
 * second line contains N numbers which are starting time of activities.
 * Third line contains N finishing time of activities.
 *
 * Output:
 * For each test case, output a single number denoting maximum activities which can be performed in new line.
 *
 *
 * Constraints:
 * 1<=T<=50
 * 1<=N<=1000
 * 1<=A[i]<=100
 *
 *
 * Example:
 * Input:
 * 1
 * 6
 * 1 3 2 5 8 5
 * 2 4 6 7 9 9
 *
 * Output:
 * 4
 */
public class ActivitySelection {
    private static class Task {
        int start;
        int end;
    }

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int c = scanner.nextInt();

            Task[] tasks = new Task[c];

            for (int j = 0; j < c; j++) {
                tasks[j] =  new Task();
            }

            for (int j = 0; j < c; j++) {
                tasks[j].start = scanner.nextInt();
            }
            for (int j = 0; j < c; j++) {
                tasks[j].end = scanner.nextInt();
            }

            activitySelection(tasks);
        }
    }

    private static void activitySelection(Task[] tasks) {
        Arrays.sort(tasks, Comparator.comparing((Task task) -> task.end));

        List<Task> output = new ArrayList<>();
        int last = 0;
        output.add(tasks[0]);

        for (int i = last + 1; i < tasks.length; i++) {
            if (tasks[last].end <= tasks[i].start) {
                output.add(tasks[i]);
                last = i;
            }
        }

        System.out.println(output.size());
    }
}
