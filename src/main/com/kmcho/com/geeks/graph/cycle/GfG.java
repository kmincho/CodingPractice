package com.kmcho.com.geeks.graph.cycle;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
 *
 * Given a directed graph your task is to complete the method isCycle to detect if there is a cycle in the graph or not.
 * You should not read any input from stdin/console.
 * There are multiple test cases. For each test case, this method will be called individually.
 *
 * Input (only to be used for Expected Output):
 * The first line of the input contains an integer 'T' denoting the number of test cases.
 * Then 'T' test cases follow. Each test case consists of two lines. Description of test cases is as follows:
 * The First line of each test case contains two integers 'N' and 'M'
 * which denotes the no of vertices and no of edges respectively.
 * The Second line of each test case contains 'M' space separated pairs u and v denoting that there is an unidirected edge from u to v .
 *
 * Output:
 * The method should return true if there is a cycle else it should return false.
 *
 * Constraints:
 * 1 <=T<= 100
 * 1<=N,M<=100
 * 0 <=u,v<= N-1
 *
 * Example:
 * Input:
 * 2
 * 2 2
 * 0 1 0 0
 * 4 3
 * 0 1 1 2 2 3
 *
 * Output:
 * 1
 * 0
 */
class GfG {
    public boolean hasCycle(int v, LinkedList<Integer>[] alist, boolean[] visited, boolean[] explored) {
        for (int i = 0; i < v; i++) {
            if (findCycle(i, alist, visited, explored)) {
                return true;
            }
        }
        return false;
    }

    public boolean findCycle(int v, LinkedList<Integer>[] alist, boolean[] visited, boolean[] explored) {
        if (visited[v]) {
            return false;
        }

        visited[v] = true;
        explored[v] = true;

        Iterator<Integer> iterator = alist[v].iterator();

        while (iterator.hasNext()) {
            int next = iterator.next();
            if (explored[next]) {
                return true;
            } else {
                if (findCycle(next, alist, visited, explored)) {
                    return true;
                }
            }
        }

        explored[v] = false;

        return false;
    }
}
