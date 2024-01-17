package com.vinit.dsalgo.algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ValidateSubSequence {

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        if (array.isEmpty()) return false;
        if (sequence.isEmpty()) return true;
        int i = 0;
        int j = 0;
        while (i < array.size() && j < sequence.size()) {
            if (Objects.equals(array.get(i), sequence.get(j))) {
                j++;
            }
            i++;
        }
        System.out.println(j);
        return j == sequence.size();
    }
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(5,1,22,25,6,-1,8,10));
        List<Integer> seq = new ArrayList<>(Arrays.asList(1,6,-1,10));
        System.out.println(isValidSubsequence(arr, seq));
    }
}
