package com.vinit.dsalgo.leetcode75.level1.simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix54 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = matrix.length;
        int colEnd = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        while (colStart <= colEnd || rowStart <= rowEnd) {
            for (int i = colStart; i < colEnd; i++) {
                res.add(matrix[rowStart][i]);
            }
            rowStart++;
            if (rowStart >= rowEnd) break;
            for (int i = rowStart; i < rowEnd; i++) {
                res.add(matrix[i][colEnd - 1]);
            }
            colEnd--;
            if (colEnd <= colStart) break;
            for (int i = colEnd-1; i >= colStart; i--) {
                res.add(matrix[rowEnd-1][i]);
            }
            rowEnd--;
            if (rowEnd <= rowStart) break;
            for (int i = rowEnd - 1; i >= rowStart; i--) {
                res.add(matrix[i][colStart]);
            }
            colStart++;
            if (colStart >= colEnd) break;
        }
        System.out.println(Arrays.asList(res));
        return res;
    }

    public static void main(String[] args) {
//        int[][] matrix= {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] matrix= {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        System.out.println(Arrays.asList(spiralOrder(matrix)));
    }
}
