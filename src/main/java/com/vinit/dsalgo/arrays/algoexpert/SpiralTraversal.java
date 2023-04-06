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
        // As we would be completing one round of the matrix in single loop,
        // hence divided the total by 4.
        // we would need to iterate only that no of times how much it takes from start to
        // the middle of the matrix hence we divided the num of elements in the
        // matrix by 2 and then by 4 to minimise the iterations
        for (int i = 0; i < (((rowLength * colLength) / 2) / 4) + 1; i++) {
            if (rowStart > rowEnd || colStart > colEnd) break;
            for (int col = colStart; col <= colEnd; col++) {
                data.add(array[rowStart][col]);
            }
            // completed one top row and hence removed from the cal
            rowStart++;
            if (rowStart > rowEnd || colStart > colEnd) break;
            for (int row = rowStart; row <= rowEnd; row++) {
                data.add(array[row][colEnd]);
            }
            // completed last col and hence removed from the cal
            colEnd--;
            if (rowStart > rowEnd || colStart > colEnd) break;
            for (int col = colEnd; col >= colStart; col--) {
                data.add(array[rowEnd][col]);
            }
            // completed last row and hence removed from the cal
            rowEnd--;
            if (rowStart > rowEnd || colStart > colEnd) break;
            for (int row = rowEnd; row >= rowStart; row--) {
                data.add(array[row][colStart]);
            }
            // completed first col and hence removed from the cal
            colStart++;
        }
        return data;
    }

    public static void main(String args[]) {
        int[][] n = {{1,2,3,4}, {12,13,14,5}, {11,16,15, 6}, {10, 9, 8, 7}};
//        int[][] n = {{1,2,3,4}, {10,11,12,5}, {9, 8, 7, 6}};
        System.out.println(Arrays.toString(spiralTraverse(n).toArray()));
    }
}
