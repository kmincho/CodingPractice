package com.kmcho.com.geeks_for_geeks.graph.path;

/**
 * Dijkstra algorithm
 * https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
 */

class GfG {
    public static void dijkstra(int graph[][], int src, int V) {
        int[][] dist = new int[V][V];
        boolean[] visited = new boolean[V];

        int current = src;

        for (int i = 0; i < V; i++) {
            int min = Integer.MAX_VALUE;
            int next = -1;

            visited[current] = true;
            dist[i][current] = i == 0 ? 0 : dist[i - 1][current];

            for (int j = 0; j < V; j++) {

                if (j == current) continue;

                if (visited[j] || graph[current][j] == 0) {
                    if (i > 0) {
                        dist[i][j] = dist[i - 1][j];
                    } else {
                        dist[i][j] = Integer.MAX_VALUE;
                    }
                } else {
                    int value = dist[i][current] + graph[current][j];
                    if (i == 0 || value < dist[i - 1][j]) {
                        dist[i][j] = value;
                    } else {
                        dist[i][j] = dist[i - 1][j];
                    }

                    if (dist[i][j] < min) {
                        min = dist[i][j];
                        next = j;
                    }
                }
            }

            current = next;
        }

        for (int i = 0; i < V; i++)
            System.out.print (dist[V - 1][i] + " ");
    }
}
