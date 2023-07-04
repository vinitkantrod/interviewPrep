package com.vinit.dsalgo.arrays.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleTwo119 {

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(Arrays.asList(1)));
        if (rowIndex == 0) {
            return res.get(rowIndex);
        }
        res.add(new ArrayList<>(Arrays.asList(1,1)));
        if (rowIndex == 1) {
            return res.get(rowIndex);
        }
        for (int i = 2; i <= rowIndex; i++) {
            List<Integer> lst = new ArrayList<>();
            lst.add(1);
            for (int k = 1; k < i; k++) {
                lst.add(res.get(res.size() - 1).get(k - 1) + res.get(res.size() - 1).get(k));
            }
            lst.add(1);
            res.add(lst);
        }
        return res.get(rowIndex);
    }
}
