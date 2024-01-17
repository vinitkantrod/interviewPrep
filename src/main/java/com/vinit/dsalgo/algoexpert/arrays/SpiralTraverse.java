package com.vinit.dsalgo.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralTraverse {

    public static List<Integer> spiralTraverse(int[][] array) {
        // Write your code here.
        List<Integer> result = new ArrayList<>();
        int rowLength = array.length;
        int colLength = array[0].length;
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = array.length - 1;
        int colEnd = array[0].length - 1;
        for (int i = 0; i < (((rowLength * colLength) / 2) / 4) + 1; i++) {
            if (rowStart > rowEnd || colStart > colEnd) break;
            for (int col = colStart; col <= colEnd; col++) {
                result.add(array[rowStart][col]);
            }
            rowStart++;
            if (rowStart > rowEnd || colStart > colEnd) break;
            for (int row = rowStart; row <= rowEnd; row++) {
                result.add(array[row][colEnd]);
            }
            colEnd--;
            if (rowStart > rowEnd || colStart > colEnd) break;
            for (int col = colEnd; col >= colStart; col--) {
                result.add(array[rowEnd][col]);
            }
            rowEnd--;
            if (rowStart > rowEnd || colStart > colEnd) break;
            for (int row = rowEnd; row >= rowStart; row--) {
                result.add(array[row][colStart]);
            }
            colStart++;
        }

        return result;
    }

    public static void main(String[] args) {
        int arr[][] = new int[][]{{1,2,3,4}, {12,13,14,5}, {11,16,15,6}, {10,9,8,7}};
        System.out.println(Arrays.asList(spiralTraverse(arr)));
    }
}
