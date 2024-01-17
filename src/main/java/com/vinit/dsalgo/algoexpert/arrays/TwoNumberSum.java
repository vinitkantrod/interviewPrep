package com.vinit.dsalgo.algoexpert.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoNumberSum {
    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Map<Integer, Integer> sumMap = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < array.length; i++) {
            if (sumMap.containsKey(targetSum - array[i])) {
                result[0] = array[i];
                result[1] = targetSum - array[i];
                return result;
            } else {
                sumMap.put(array[i], i);
            }
        }
        return new int[0];
    }
    public static void main(String[] args) {
        int[] r = new int[]{3,5,-4,8,11,1,-1,6};
        System.out.println(Arrays.toString(twoNumberSum(r, 10)));
    }
}
