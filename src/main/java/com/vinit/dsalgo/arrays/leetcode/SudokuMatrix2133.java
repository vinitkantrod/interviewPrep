package com.vinit.dsalgo.arrays.leetcode;

import java.util.HashSet;
import java.util.Set;

public class SudokuMatrix2133 {

    public static boolean checkValid(int[][] matrix) {
//        int n = matrix.length;
//        for (int i = 0; i < n; i++) {
//            // check for uniqueness in row
//            Set<Integer> valSet = new HashSet<>();
//            for (int j = 0; j < n; j++) {
//                if (valSet.contains(matrix[i][j])) return false;
//                valSet.add(matrix[i][j]);
//            }
//        }
//        return true;

        int rowsLength = matrix.length;
        int colsLength = matrix[0].length;
        HashSet<String> elements = new HashSet<>();
        for(int i=0;i<rowsLength;i++){
            for(int j=0;j<colsLength;j++){
                if(!elements.add("Row"+i+"ele"+matrix[i][j]) || !elements.add("Col"+j+"ele"+matrix[i][j]))
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] mat = {{1,2,3}, {2,1,3}, {3,2,1}};
        System.out.println(checkValid(mat));
    }
}
