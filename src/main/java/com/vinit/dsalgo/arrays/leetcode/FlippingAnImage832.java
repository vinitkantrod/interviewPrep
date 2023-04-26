package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;

public class FlippingAnImage832 {

    public static int[][] flipAndInvertImage(int[][] image) {
        int m = image.length;
        int n = image[0].length;
        for (int i = 0; i < image.length; i++) {
            System.out.println("before: " + Arrays.toString(image[i]));
            int x = 0;
            int y = n - 1;
            while (x < y) {
                int temp = image[i][x];
                System.out.println("x: " + temp + ", y: " + image[i][y]);
                image[i][x] = image[i][y];
                image[i][y] = temp;
                swap(image, i , x);
                swap(image, i, y);
                System.out.println("x: " + image[i][x] + ", y: " + image[i][y]);
                x++;
                y--;
            }
            if (x == y) swap(image, i, x);
            System.out.println("after: " + Arrays.toString(image[i]));
        }
        return image;
    }

    public static void swap(int[][] image, int i, int x) {
        if (image[i][x] == 0) image[i][x] = 1;
        else image[i][x] = 0;
    }
    public static void main(String[] args) {
        int[][] image = {{1,1,0}, {1,0,1}, {0,0,0}};
        System.out.println(Arrays.toString(flipAndInvertImage(image)));
    }
}
