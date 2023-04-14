package com.vinit.dsalgo.arrays.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CellInRange2194 {

    public static List<String> cellsInRange(String s) {
        char startCol = s.charAt(0);
        char endCol = s.charAt(3);
        char startRow = s.charAt(1);
        char endRow = s.charAt(4);
        List<String> stringList = new ArrayList<>();
        for (char c = startCol; c <= endCol; c++) {
            for (char r = startRow; r <= endRow; r++) {
                stringList.add(new String(new char[]{c,r}));
            }
        }
        return stringList;
    }

    public static void main(String[] args) {
        String s = "K1:L2";
        System.out.println(Arrays.asList(cellsInRange(s)));
    }
}
