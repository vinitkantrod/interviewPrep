package com.vinit.dsalgo.arrays.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidateSubSequence {


    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        if (array.size() == 0) return false;
        if (sequence.size() == 0) return true;
        int i = 0;
        int j = 0;
        while (i < array.size() && j < sequence.size()) {
            if (array.get(i) == sequence.get(j)) {
                j++;
            }
            i++;
        }
        if (j == sequence.size()) return true;
        return false;
    }

    public static void main(String args[]) {
        List<Integer> arrays = new ArrayList<>(Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10));
        List<Integer> sequence = new ArrayList<>(Arrays.asList(22, 25, 6));
        System.out.println(isValidSubsequence(arrays, sequence));
    }
}
