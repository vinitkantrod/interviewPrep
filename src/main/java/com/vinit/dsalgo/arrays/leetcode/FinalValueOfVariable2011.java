package com.vinit.dsalgo.arrays.leetcode;

public class FinalValueOfVariable2011 {

    public int finalValueAfterOperations(String[] operations) {
        int c = 0;
        for (String s : operations) {
            if (s.contains("-")) c--;
            else c++;
        }
        return c;
    }
}
