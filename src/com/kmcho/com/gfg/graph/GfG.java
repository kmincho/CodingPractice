package com.kmcho.com.gfg.graph;


import java.util.Iterator;
import java.util.LinkedList;

class GfG {
    public boolean hasCycle(int v, LinkedList<Integer>[] alist, boolean[] visited, boolean[] explored) {
        for (int i = 0; i < v; i++) {
            if (DFS(i, alist, visited, explored)) {
                return true;
            }
        }
        return false;
    }

    public boolean DFS(int v, LinkedList<Integer>[] alist, boolean[] visited, boolean[] explored) {
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
                if (DFS(next, alist, visited, explored)) {
                    return true;
                }
            }
        }

        explored[v] = false;

        return false;
    }
}
