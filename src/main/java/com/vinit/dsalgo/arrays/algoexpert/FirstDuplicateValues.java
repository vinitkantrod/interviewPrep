package com.vinit.dsalgo.arrays.algoexpert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FirstDuplicateValues {

    public static int firstDuplicateValue(int[] array) {
//        Map<Integer, Boolean> data = new HashMap<>();
//        for (int i = 0; i < array.length; i++) {
//            if (data.containsKey(array[i])) {
//                return array[i];
//            } else {
//                data.put(array[i], true);
//            }
//        }
//        return -1;
        // With Constant Space of O(1)
        for (int val : array) {
            int absValue = Math.abs(array[val]);
            if (array[absValue - 1] < 0) return absValue;
            array[absValue - 1] *= -1;
        }
        return -1;
    }

    public static void main(String args[]) {
        int[] array = {2,1,5,2,3,3,4};
        System.out.println(firstDuplicateValue(array));
    }
}
