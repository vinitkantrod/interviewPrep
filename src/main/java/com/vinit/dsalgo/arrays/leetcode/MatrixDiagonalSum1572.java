package com.vinit.dsalgo.arrays.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MatrixDiagonalSum1572 {

    public static int diagonalSum(int[][] mat) {
        int sum = 0;
        Set<String> stringSet = new HashSet<>();
        // forward diagonal
        int x = 0;
        int y = 0;
        while (x < mat.length && y < mat[0].length) {
            String key = String.valueOf(x) + ":" + String.valueOf(y);
            sum += mat[x][y];
            stringSet.add(key);
            System.out.println(x + ":" + y + "=" + sum);
            x++;
            y++;
        }
        x = 0;
        y = mat[0].length - 1;
        while (x < mat.length && y >= 0) {
            String key = String.valueOf(x) + ":" + String.valueOf(y);
            if (!stringSet.contains(key)) {
                sum += mat[x][y];
                stringSet.add(key);
                System.out.println(x + ":" + y + "=" + sum);
            }
            x++;
            y--;
        }
        return sum;
    }
    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(diagonalSum(mat));
    }
}
