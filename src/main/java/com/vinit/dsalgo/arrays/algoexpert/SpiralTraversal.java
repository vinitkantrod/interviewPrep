package com.vinit.dsalgo.arrays.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralTraversal {

    public static List<Integer> spiralTraverse(int[][] array) {
        int rowLength = array.length;
        int colLength = array[0].length;
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = array.length - 1;
        int colEnd = array[0].length - 1;
        List<Integer> data = new ArrayList<Integer>();
        for (int i = 0; i < (rowLength * colLength); i++) {
            for (int row = colStart; row <= colEnd; row++) {
                data.add(array[rowStart][row]);
            }
            for (int col = rowStart + 1; col <= rowEnd; col++) {
                data.add(array[col][colEnd]);
            }
            for (int row = colEnd - 1; row >= colStart; row--) {
                data.add(array[rowEnd][row]);
            }
            for (int row = rowEnd - 1; row >= rowStart + 1; row--) {
                data.add(array[row][colStart]);
            }
            rowStart++;
            colEnd--;
            rowEnd--;
            colStart++;
        }
        return data;
    }

    public static void main(String args[]) {
        int[][] n = {{1,2,3,4}, {12,13,14,5}, {11,16,15, 6}, {10, 9, 8, 7}};
        System.out.println(Arrays.toString(spiralTraverse(n).toArray()));
    }
}
