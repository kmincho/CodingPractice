package com.kmcho.com.geeks_for_geeks.greedy;

import java.util.*;

/**
 * Greedy Algorithm - Activity Selection Problem
 * https://practice.geeksforgeeks.org/problems/activity-selection/0
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
