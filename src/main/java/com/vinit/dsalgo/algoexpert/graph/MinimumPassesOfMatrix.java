package com.vinit.dsalgo.algoexpert.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumPassesOfMatrix {

    public static int minimumPassesOfMatrix(int[][] matrix) {
        int passes = convertNegatives(matrix);
        return  !containsNegative(matrix) ? passes - 1 : -1;
    }

    public static boolean containsNegative(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < 0) return true;
            }
        }
        return false;
    }
    public static int convertNegatives(int[][] matrix) {
        ArrayList<int[]> nextPassQueues = getAllPositivePosition(matrix);
        int passes = 0;
        while (nextPassQueues.size() > 0) {
            System.out.println("Next Queue: ");
            nextPassQueues.stream().forEach(e -> System.out.println(Arrays.toString(e)));
            ArrayList<int[]> currentPassQueue = nextPassQueues;
            nextPassQueues = new ArrayList<>();
            while (currentPassQueue.size() > 0) {
                int[] val = currentPassQueue.remove(0);
                int currRow = val[0];
                int currCol = val[1];
                ArrayList<int[]> getNeighbourPosition =
                        getAdjecentPositions(currRow, currCol, matrix);
                for (int[] p : getNeighbourPosition) {
                    System.out.println("N: " + Arrays.toString(p));
                    int r = p[0];
                    int c = p[1];
                    if (matrix[r][c] < 0) {
                        matrix[r][c] *= -1;
                        nextPassQueues.add(p);
                    }
                }
            }
            passes += 1;
        }
        return passes;
    }

    public static ArrayList<int[]> getAdjecentPositions(int i, int j, int[][] matrix) {
        ArrayList<int[]> neighbours = new ArrayList<>();
        if (i > 0) neighbours.add(new int[]{i - 1, j});
        if (j > 0) neighbours.add(new int[]{i, j - 1});
        if (i < matrix.length - 1) neighbours.add(new int[]{i + 1, j});
        if (j < matrix[0].length - 1) neighbours.add(new int[]{i, j + 1});
        return neighbours;
    }

    public static ArrayList<int[]> getAllPositivePosition(int[][] matrix) {
        ArrayList<int[]> possitivePositions = new ArrayList<>();
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] > 0) possitivePositions.add(new int[]{i,j});
            }
        }
        return possitivePositions;
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{{0,-2,-1}, {-5,2,0}, {-6,-2,0}};
        System.out.println(minimumPassesOfMatrix(m));
    }
}
