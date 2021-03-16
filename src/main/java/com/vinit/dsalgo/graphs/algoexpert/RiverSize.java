package com.vinit.dsalgo.graphs.algoexpert;

import java.util.*;

public class RiverSize {

    public static List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        boolean[][] visited = new boolean[matrix.length][];
        List<Integer> sizes = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            visited[i] = new boolean[matrix[i].length];
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (visited[i][j]) continue;
                if (matrix[i][j] == 0) continue;
                traverseNode(i, j, matrix, visited, sizes);
            }
        }
        return sizes;
    }

    public static void traverseNode(int i , int j, int[][] matrix, boolean[][] visited, List<Integer> sizes) {
        int currentRiverSize = 0;
        Stack<List<Integer>> neighbourNodes = new Stack<>();
        neighbourNodes.push(new ArrayList<Integer>(Arrays.asList(i, j)));
        while (!neighbourNodes.empty()) {
            List<Integer> currentNodes = neighbourNodes.pop();
            i = currentNodes.get(0);
            j = currentNodes.get(1);
            if (visited[i][j]) continue;
            visited[i][j] = true;
            if (matrix[i][j] == 0) continue;
            currentRiverSize += 1;
            List<List<Integer>> unvisitedNeighbours = unvisitedNeighbours(i, j, matrix, visited);
            for (List<Integer> nodes : unvisitedNeighbours) {
                neighbourNodes.push(nodes);
            }
        }
        if ( currentRiverSize > 0 ) sizes.add(currentRiverSize);
    }

    public static List<List<Integer>> unvisitedNeighbours(int i, int j, int[][] matrix, boolean[][] visited) {
        List<List<Integer>> neighbours = new ArrayList<>();
        if (i > 0 && !visited[i -1][j])
            neighbours.add(new ArrayList<>(Arrays.asList(i - 1, j)));
        if (i < matrix.length - 1 && !visited[i + 1][j])
            neighbours.add(new ArrayList<>(Arrays.asList(i + 1, j)));
        if (j > 0 && !visited[i][j - 1])
            neighbours.add(new ArrayList<>(Arrays.asList(i, j - 1)));
        if (j < matrix[i].length - 1 && !visited[i][j + 1])
            neighbours.add(new ArrayList<>(Arrays.asList(i, j + 1)));
        return neighbours;
    }
    public static void main(String args[]) {
        int[][] mat = {{1,0,0,1,0}, {1,0,1,0,0}, {0,0,1,0,1}, {1,0,1,0,1}, {1,0,1,1,0} };
        System.out.println(Arrays.toString(riverSizes(mat).toArray()));
    }
}
