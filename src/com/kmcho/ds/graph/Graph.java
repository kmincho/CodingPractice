package com.kmcho.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

class Graph {
    int size;
    int[][] matrix;

    private void runDFS(int start) {
        boolean[] visited = new boolean[size];
        DFS(start, visited);
        System.out.println();
    }

    private void DFS(int current, boolean[] visited) {
        visited[current] = true;
        System.out.print(current + " ");

        for (int next = 0; next < size; next++) {
            if (hasEdge(current, next) && !visited[next]) {
                DFS(next, visited);
            }
        }

        return;
    }

    private void runBFS(int start) {
        boolean[] visited = new boolean[size];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (queue.size() > 0) {
            int current = queue.poll();

            System.out.print(current + " ");

            for (int next = 0; next < size; next++) {
                if (hasEdge(current, next) && !visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
        System.out.println();
    }

    public Graph(int size) {
        this.size = size;
        matrix = new int[size][size];
    }

    public void addEdge(int from, int to) {
        matrix[from][to] = 1;
    }

    public boolean hasEdge(int from, int to) {
        return matrix[from][to] == 1;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.runBFS(2);
        graph.runDFS(2);


        Graph graph2 = new Graph(6);
        graph2.addEdge(0, 1);
        graph2.addEdge(0, 2);
        graph2.addEdge(1, 0);
        graph2.addEdge(1, 3);
        graph2.addEdge(1, 4);
        graph2.addEdge(2, 0);
        graph2.addEdge(2, 4);
        graph2.addEdge(3, 1);
        graph2.addEdge(3, 4);
        graph2.addEdge(3, 5);
        graph2.addEdge(4, 1);
        graph2.addEdge(4, 2);
        graph2.addEdge(4, 3);
        graph2.addEdge(4, 5);
        graph2.addEdge(5, 3);
        graph2.addEdge(5, 4);

        graph2.runBFS(0);
        graph2.runDFS(0);
    }
}
