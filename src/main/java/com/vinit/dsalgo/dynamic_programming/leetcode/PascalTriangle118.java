package com.vinit.dsalgo.dynamic_programming.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle118 {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(Arrays.asList(1)));
        if (numRows == 1) {
            return res;
        }
        res.add(new ArrayList<>(Arrays.asList(1,1)));
        if (numRows == 2) {
            return res;
        }
        for (int i = 2; i < numRows; i++) {
            List<Integer> lst = new ArrayList<>();
            lst.add(1);
            for (int k = 1; k < i; k++) {
                lst.add(res.get(res.size() - 1).get(k - 1) + res.get(res.size() - 1).get(k));
            }
            lst.add(1);
            res.add(lst);
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.println(Arrays.asList(res.get(i)));
        }
        return res;
    }
    public static void main(String[] args) {
        generate(5);
    }
}
