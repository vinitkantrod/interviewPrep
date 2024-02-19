//package com.vinit.dsalgo.algoexpert.graph;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class RemoveIsland {
//
//    public static int[][] removeIslands(int[][] matrix) {
//        // Write your code here.
//        // mark -1 for removal and
//        int passes = convertNegatives(matrix);
//    }
//
//    public static int convertNegatives(int[][] matrix) {
//        ArrayList<int[]> nextPassQueues = getAllPositivePosition(matrix);
//        int passes = 0;
//        while (nextPassQueues.size() > 0) {
//            ArrayList<int[]> currentPassQueue = nextPassQueues;
//            nextPassQueues = new ArrayList<>();
//            while (currentPassQueue.size() > 0) {
//                int[] val = currentPassQueue.remove(0);
//                int currRow = val[0];
//                int currCol = val[1];
//                ArrayList<int[]> getNeighbourPosition =
//                        getAdjecentPositions(currRow, currCol, matrix);
//                for (int[] p : getNeighbourPosition) {
//                    int r = p[0];
//                }
//            }
//        }
//        return passes;
//    }
//
//    public static ArrayList<int[]> getAdjecentPositions(int i, int j, int[][] matrix) {
//        ArrayList<int[]> neighbours = new ArrayList<>();
//        if (i > 0) neighbours.add(new int[]{i - 1, j});
//        if (j > 0) neighbours.add(new int[]{i, j - 1});
//        if (i < matrix.length - 1) neighbours.add(new int[]{i + 1, j});
//        if (i < matrix[0].length - 1) neighbours.add(new int[]{i, j + 1});
//        return neighbours;
//    }
//
//    public static ArrayList<int[]> getAllPositivePosition(int[][] matrix) {
//        ArrayList<int[]> possitivePositions = new ArrayList<>();
//        for (int i = 0; i < matrix.length; ++i) {
//            for (int j = 0; j < matrix[0].length; ++j) {
//                if (matrix[i][j] > 0) possitivePositions.add(new int[]{i,j});
//            }
//        }
//        return possitivePositions;
//    }
//    public static void main(String[] args) {
//        int[][] m = new int[][]{{1,0,0,0,0,0},{0,1,0,1,1,1},{0,0,1,0,1,0},{1,1,0,0,1,0},{1,0,1,1,0,0,},{1,0,0,0,0,1}};
//        removeIslands(m);
//    }
//}
