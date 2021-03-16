package com.vinit.dsalgo.graphs.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RemoveIsland {

    public static int[][] removeIslands(int[][] matrix) {
        Boolean[][] visited = new Boolean[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            visited[i] = new Boolean[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j++) {
                visited[i][j] = false;
            }
        }
        System.out.println("initial");
        printMatrix(matrix, visited);
        for (int col = 0; col < matrix[0].length; col++ ) {
            traverseNode(0, col, matrix, visited, false);
        }
        System.out.println("first row");
        printMatrix(matrix, visited);
        for (int row = 1; row < matrix.length; row++ ) {
            traverseNode(row, 0, matrix, visited, false);
        }
        System.out.println("first col");
        printMatrix(matrix, visited);
        for (int row = 1; row < matrix.length; row++ ) {
            traverseNode(row, matrix[row].length - 1, matrix, visited, false);
        }
        System.out.println("last col");
        printMatrix(matrix, visited);
        for (int col = 1; col < matrix[matrix.length - 1].length - 1; col++ ) {
            traverseNode(matrix.length - 1, col, matrix, visited, false);
        }
        System.out.println("last row");
        printMatrix(matrix, visited);
        for (int i = 1; i < matrix.length - 1; i++ ) {
            for (int j = 1; j < matrix[i].length - 1; j++) {
                traverseNode(i, j, matrix, visited, true);
            }
        }
        printMatrix(matrix, visited);
        return matrix;
    }

    public static void printMatrix(int[][] matrix, Boolean[][] visited) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " | ");
            }
            System.out.println("");
        }
        System.out.println("\nvisited matrix----- \n");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(visited[i][j] + " | ");
            }
            System.out.println("");
        }
    }
    public static void traverseNode(int i, int j, int[][] matrix, Boolean[][] visited, Boolean toCheck) {
        Stack<List<Integer>> neighbourNodes = new Stack<>();
        neighbourNodes.push(new ArrayList<Integer>(Arrays.asList(i, j)));
        while (!neighbourNodes.empty()) {
            List<Integer> currentNodes = neighbourNodes.pop();
            i = currentNodes.get(0);
            j = currentNodes.get(1);
            if (visited[i][j]) continue;
            if (toCheck & !visited[i][j])
                matrix[i][j] = 0;
            visited[i][j] = true;
            if (matrix[i][j] == 0) continue;
            List<List<Integer>> unvisitedNeighbours = unvisitedNeighbours(i, j, matrix, visited);
            for (List<Integer> nodes : unvisitedNeighbours) {
                neighbourNodes.push(nodes);
            }
        }
    }

    public static List<List<Integer>> unvisitedNeighbours(int i, int j, int[][] matrix, Boolean[][] visited) {
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
//        int[][] matrix = {{1,0,0,0,0,0}, {0,1,0,1,1,1}, {0,0,1,0,1,0}, {1,1,0,0,1,0}, {1,0,1,1,0,0}, {1,0,0,0,0,1} };
        int[][] matrix = {{1,0,0,1,0}, {0,1,0,1,0}, {0,0,1,1,0} };
        removeIslands(matrix);
    }
}
