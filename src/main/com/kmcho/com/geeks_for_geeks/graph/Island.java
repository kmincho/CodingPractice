package com.kmcho.com.geeks_for_geeks.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1
 *
 * + Test Case 1
 * Input
 * 1
 * 3 3
 * 1 1 0 0 0 1 1 0 1
 *
 * Output
 * 2
 *
 * + Test Case 2
 * Input
 * 1
 5 8
 * 0 1 0 1 1 1 0 1 0 1 0 1 0 0 1 0 1 0 0 0 0 0 1 1 0 1 0 0 0 0 1 0 0 0 0 1 1 0 0 0
 *
 * Output
 * 3
 */

class Island {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int height = in.nextInt();
            int width = in.nextInt();

            int[][] matrix = new int[height][width];

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    int value = in.nextInt();
                    matrix[i][j] = value;
                }
            }

            System.out.println("number of islands = " + findNumIslands(matrix, height, width));
        }
    }

    static int findNumIslands(int[][] matrix, int height, int width) {
        List<Integer>[] graph = buildGraph(matrix, height, width);

        int vertex = height * width;
        boolean[] visited = new boolean[vertex];

        int result = 0;

        for (int i = 0; i < vertex; i++) {
            if (graph[i].size() > 0 && !visited[i]) {
                result++;
                DFS(graph, i, visited);
            }
        }

        return result;
    }

    static void DFS(List<Integer>[] graph, int start, boolean[] visited) {
        visited[start] = true;

        Iterator<Integer> iterator = graph[start].iterator();
        while (iterator.hasNext()) {
            int next = iterator.next();
            if (!visited[next]) {
                DFS(graph, next, visited);
            }
        }
    }

    static List<Integer>[] buildGraph(int[][] matrix, int height, int width) {
        int vertex = height * width;
        List<Integer>[] graph = new ArrayList[vertex];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int node = i * width + j;
                graph[node] = new ArrayList<>();
                if (matrix[i][j] == 1) {
                    addChildren(matrix, graph[node], i, j, height, width);
                }
            }
        }

        return graph;
    }

    static void addChildren(int[][] matrix, List<Integer> parent, int y, int x, int height, int width) {
        for (int i = -1; i < 2; i++) {
            int yy = y + i;
            for (int j = -1; j < 2; j++) {
                int xx = x + j;
                if (xx >= 0 && xx < width
                        && yy >= 0 && yy < height) {
                    if (matrix[yy][xx] == 1) {
                        parent.add(yy * width + xx);
                    }
                }
            }
        }
    }
}
