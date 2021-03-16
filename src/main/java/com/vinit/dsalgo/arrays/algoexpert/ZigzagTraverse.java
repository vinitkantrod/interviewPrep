package com.vinit.dsalgo.arrays.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigzagTraverse {

    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        List<Integer> res = new ArrayList<>();
        int row = 0, col = 0, width = array.get(0).size() - 1, height = array.size() - 1;
        Boolean isGoingDown = true;
        while (!isOutOfBound(row, col, width, height)) {
            res.add(array.get(row).get(col));
            if (isGoingDown) {
                if (col == 0 || row == height) {
                    isGoingDown = false;
                    if (row == height) col++;
                    else row++;
                } else {
                    row++;
                    col--;
                }
            }
            else {
                if (row == 0 || col == width) {
                    isGoingDown = true;
                    if (col == width) row++;
                    else col++;
                } else {
                    row--;
                    col++;
                }
            }
        }
        System.out.println(Arrays.toString(res.toArray()));
        return res;
    }

    public static Boolean isOutOfBound(int row, int col, int width, int height) {
        return row < 0 || col < 0 || row > height || col > width;
    }

    public static void main(String args[]) {
        List<List<Integer>> zigzag = new ArrayList<>();
        zigzag.add(new ArrayList<>(Arrays.asList(1,3,4,10)));
        zigzag.add(new ArrayList<>(Arrays.asList(2,5,9,11)));
        zigzag.add(new ArrayList<>(Arrays.asList(6,8,12,15)));
        zigzag.add(new ArrayList<>(Arrays.asList(7,13,14,16)));
        zigzagTraverse(zigzag);
    }
}
