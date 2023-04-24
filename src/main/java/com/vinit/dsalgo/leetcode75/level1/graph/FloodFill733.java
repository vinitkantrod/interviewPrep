package com.vinit.dsalgo.leetcode75.level1.graph;

import java.util.Arrays;

public class FloodFill733 {

    static int[] X = {0,0,1,-1};
    static int[] Y = {1,-1,0,0};

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int existingColor = image[sr][sc];
        fill(image, m, n, sr, sc, existingColor, color);
        for (int i = 0; i < image.length; i++) {
            System.out.println(Arrays.toString(image[i]));
        }
        return image;
    }

    public static void fill(int[][] image, int m, int n, int sr, int sc, int existingColor, int color) {
        if (sr < 0 || sc < 0 || sr >= m || sc >= n) return;
        if (image[sr][sc] != existingColor || image[sr][sc] == color) return;
        image[sr][sc] = color;
        for (int l = 0; l < 4; l++) {
            fill(image, m, n,X[l] + sr, Y[l] + sc, existingColor, color);
        }
    }
    public static void main(String[] args) {
//        int[][] grid = {{1,1,1}, {1,1,0}, {1,0,1}};
//        System.out.println(floodFill(grid, 1,1,2));
        int[][] grid = {{0,0,0}, {0,0,0}};
        System.out.println(floodFill(grid, 1,0,2));
    }
}
