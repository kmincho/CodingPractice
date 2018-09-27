package com.kmcho.com.geeks.graph.path;

/**
 * Dijkstra algorithm
 * https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
 *
 * Given an adjacency matrix (graph),
 * the task is to find the shortest distance of all the vertex's from the source vertex.
 * You are required to complete the function dijkstra which takes 3 arguments.
 * The first argument is the adjacency matrix (graph),
 * the second argument is the source vertex s and
 * the third argument is V denoting the size of the matrix.
 *
 * The function prints V space separated integers
 * where i'th integer denotes the shortest distance of the i'th vertex from source vertex.
 *
 * Input:
 * The first line of input contains an integer T denoting the no of test cases. Then T test cases follow.
 * The first line of each test case contains an integer V denoting the size of the adjacency matrix and
 * in the next line are V space separated values of the matrix (graph).
 * The third line of each test case contains an integer denoting the source vertex s.
 *
 * Output:
 * For each test case output will be V space separated integers
 * where the ith integer denote the shortest distance of ith vertex from source vertex.
 *
 * Constraints:
 * 1<=T<=20
 * 1<=V<=20
 * 0<=s 1<=graph[][]<=1000
 *
 * Example:
 * Input
 * 2
 * 2
 * 0 25 25 0
 * 0
 * 3
 * 0 1 43 1 0 6 43 6 0
 * 2
 *
 * Output
 * 0 25
 * 7 6 0
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
