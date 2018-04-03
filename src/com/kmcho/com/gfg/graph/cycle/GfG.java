package com.kmcho.com.gfg.graph.cycle;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
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
