package com.vinit.dsalgo.arrays.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrixTwo59 {

    public static int[][] generateMatrix(int n) {
        int[][] array = new int[n][n];
        int rowLength = n;
        int colLength = n;
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = n - 1;
        int colEnd = n - 1;
        int insertNum = 1;
//        List<Integer> data = new ArrayList<Integer>();
        // As we would be completing one round of the matrix in single loop,
        // hence divided the total by 4.
        // we would need to iterate only that no of times how much it takes from start to
        // the middle of the matrix hence we divided the num of elements in the
        // matrix by 2 and then by 4 to minimise the iterations
        for (int i = 0; i < (((rowLength * colLength) / 2) / 4) + 1; i++) {
            if (rowStart > rowEnd || colStart > colEnd) break;
            for (int col = colStart; col <= colEnd; col++) {
                array[rowStart][col] = insertNum++;
//                data.add(array[rowStart][col]);
            }
            // completed one top row and hence removed from the cal
            rowStart++;
            if (rowStart > rowEnd || colStart > colEnd) break;
            for (int row = rowStart; row <= rowEnd; row++) {
//                data.add(array[row][colEnd]);
                array[row][colEnd] = insertNum++;
            }
            // completed last col and hence removed from the cal
            colEnd--;
            if (rowStart > rowEnd || colStart > colEnd) break;
            for (int col = colEnd; col >= colStart; col--) {
//                data.add(array[rowEnd][col]);
                array[rowEnd][col] = insertNum++;
            }
            // completed last row and hence removed from the cal
            rowEnd--;
            if (rowStart > rowEnd || colStart > colEnd) break;
            for (int row = rowEnd; row >= rowStart; row--) {
//                data.add(array[row][colStart]);
                array[row][colStart] = insertNum++;
            }
            // completed first col and hence removed from the cal
            colStart++;
        }
        // print
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(generateMatrix(4));
    }
}
