package com.vinit.dsalgo.hashtable.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku36 {

    Map<Integer, Integer[][]> map;
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";
                    if (
                        !seen.add(b + i) ||
                        !seen.add(j + b) ||
                        !seen.add(i/3 + b + j/3)
                    ) return false;
                }
            }
        }
        return true;

//        map = new HashMap<>();
//        buildMap(map);
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                if (board[i][j] != Character.MIN_VALUE) {
//                    // check for row uniqueness
//                    if (
//                        !colUniqueness(i, board[i][j],  board) ||
//                    // check for col uniqueness
//                        !rowUniqueness(j, board[i][j], board) ||
//                    // check for uniqueness
//                        !cellUniqueness(i, j, board[i][j], board)) return false;
//                }
//            }
//        }
//        return true;
    }

    public static Boolean colUniqueness(int i, char c, char[][] board) {
        int charCount = 0;
        for (int j = 0; j < 9; j++) {
            if (board[i][j] == c) charCount++;
        }
        return charCount == 1;
    }

    public static Boolean rowUniqueness(int j, char c, char[][] board) {
        int charCount = 0;
        for (int i = 0; i < 9; i++) {
            if (board[i][j] == c) charCount++;
        }
        return charCount == 1;
    }

    public static int getCell(int i, int j) {
        if (i <= 2) {
            if (j <= 2) return 1;
            if (j >= 3 && j <= 5) return 2;
            else return 3;
        } else if (i >= 3 && i <= 5) {
            if (j <= 2) return 4;
            if (j >= 3 && j <= 5) return 5;
            else return 6;
        } else {
            if (j <= 2) return 7;
            if (j >= 3 && j <= 5) return 8;
            else return 9;
        }
    }
    public static void buildMap(Map<Integer, Integer[][]> map) {
        Integer[][] i = new Integer[9][2];
        i[0] = new Integer[]{0,0};i[1] = new Integer[]{0,1};i[2] = new Integer[]{0,2};
        i[3] = new Integer[]{1,0};i[4] = new Integer[]{1,1};i[5] = new Integer[]{1,2};
        i[6] = new Integer[]{2,0};i[7] = new Integer[]{2,1};i[8] = new Integer[]{2,2};
        map.put(1, i);
        i[0] = new Integer[]{3,0};i[1] = new Integer[]{3,1};i[2] = new Integer[]{3,2};
        i[3] = new Integer[]{4,0};i[4] = new Integer[]{4,1};i[5] = new Integer[]{4,2};
        i[6] = new Integer[]{5,0};i[7] = new Integer[]{5,1};i[8] = new Integer[]{5,2};
        map.put(4, i);
        i[0] = new Integer[]{6,0};i[1] = new Integer[]{6,1};i[2] = new Integer[]{6,2};
        i[3] = new Integer[]{7,0};i[4] = new Integer[]{7,1};i[5] = new Integer[]{7,2};
        i[6] = new Integer[]{8,0};i[7] = new Integer[]{8,1};i[8] = new Integer[]{8,2};
        map.put(7, i);

        // Second col
        i[0] = new Integer[]{0,3};i[1] = new Integer[]{0,4};i[2] = new Integer[]{0,5};
        i[3] = new Integer[]{1,3};i[4] = new Integer[]{1,4};i[5] = new Integer[]{1,5};
        i[6] = new Integer[]{2,3};i[7] = new Integer[]{2,4};i[8] = new Integer[]{2,5};
        map.put(2, i);
        i[0] = new Integer[]{3,3};i[1] = new Integer[]{3,4};i[2] = new Integer[]{3,5};
        i[3] = new Integer[]{4,3};i[4] = new Integer[]{4,4};i[5] = new Integer[]{4,5};
        i[6] = new Integer[]{5,3};i[7] = new Integer[]{5,4};i[8] = new Integer[]{5,5};
        map.put(5, i);
        i[0] = new Integer[]{6,3};i[1] = new Integer[]{6,4};i[2] = new Integer[]{6,5};
        i[3] = new Integer[]{7,3};i[4] = new Integer[]{7,4};i[5] = new Integer[]{7,5};
        i[6] = new Integer[]{8,3};i[7] = new Integer[]{8,4};i[8] = new Integer[]{8,5};
        map.put(8, i);

        // 3rd cell
        i[0] = new Integer[]{0,6};i[1] = new Integer[]{0,7};i[2] = new Integer[]{0,8};
        i[3] = new Integer[]{1,6};i[4] = new Integer[]{1,7};i[5] = new Integer[]{1,8};
        i[6] = new Integer[]{2,6};i[7] = new Integer[]{2,7};i[8] = new Integer[]{2,8};
        map.put(3, i);
        i[0] = new Integer[]{3,6};i[1] = new Integer[]{3,7};i[2] = new Integer[]{3,8};
        i[3] = new Integer[]{4,6};i[4] = new Integer[]{4,7};i[5] = new Integer[]{4,8};
        i[6] = new Integer[]{5,6};i[7] = new Integer[]{5,7};i[8] = new Integer[]{5,8};
        map.put(6, i);
        i[0] = new Integer[]{6,6};i[1] = new Integer[]{6,7};i[2] = new Integer[]{6,8};
        i[3] = new Integer[]{7,6};i[4] = new Integer[]{7,7};i[5] = new Integer[]{7,8};
        i[6] = new Integer[]{8,6};i[7] = new Integer[]{8,7};i[8] = new Integer[]{8,8};
        map.put(9, i);
    }
}
