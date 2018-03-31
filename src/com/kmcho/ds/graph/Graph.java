package com.kmcho.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    int size;
    int[][] matrix;

    private void BFS(int start) {
        boolean[] visited = new boolean[size];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (queue.size() > 0) {
            int v = queue.poll();

            System.out.print(v + " ");

            for (int j = 0; j < size; j++) {
                if (existEdge(v, j) && !visited[j]) {
                    queue.add(j);
                    visited[j] = true;
                }
            }
        }
    }

    public Graph(int size) {
        this.size = size;
        matrix = new int[size][size];
    }

    public void addEdge(int from, int to) {
        matrix[from][to] = 1;
    }

    public boolean existEdge(int from, int to) {
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

        graph.BFS(2);

//        Graph graph = new Graph(6);
//        graph.addEdge(0, 1);
//        graph.addEdge(0, 2);
//        graph.addEdge(1, 0);
//        graph.addEdge(1, 3);
//        graph.addEdge(1, 4);
//        graph.addEdge(2, 0);
//        graph.addEdge(2, 4);
//        graph.addEdge(3, 1);
//        graph.addEdge(3, 4);
//        graph.addEdge(3, 5);
//        graph.addEdge(4, 1);
//        graph.addEdge(4, 2);
//        graph.addEdge(4, 3);
//        graph.addEdge(4, 5);
//        graph.addEdge(5, 3);
//        graph.addEdge(5, 4);
//
//        graph.BFS(0);
    }
}
