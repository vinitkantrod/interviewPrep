package com.vinit.dsalgo.arrays.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TwoNumberSum {

    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
//        if (array.length == 0) {
//            return new int[0];
//        }
        for (int i = 0; i < array.length; i++) {
            if (hashMap.containsKey(targetSum - array[i])) {
                res.add(targetSum - array[i]);
                res.add(array[i]);
            } else {
                hashMap.put(array[i], true);
            }
        }
        if (res.size() > 0) {
            return res.stream().mapToInt(Integer::intValue).toArray();
        } else {
            return new int[0];
        }
    }
    public static void main(String[] args) {
        int[] array = {3,5,-4,8,11,1,-1,6};
        int targetSum = 10;
        System.out.println(Arrays.toString(twoNumberSum(array, targetSum)));
    }
}
