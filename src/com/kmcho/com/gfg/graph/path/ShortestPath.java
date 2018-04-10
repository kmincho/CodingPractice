package com.kmcho.com.gfg.graph.path;

import java.util.Scanner;

public class ShortestPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] graph = new int[21][21];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = sc.nextInt();
                }
            }
            int src = sc.nextInt();
            GfG g = new GfG();
            g.dijkstra(graph, src, n);
            System.out.println();
        }
    }
}

