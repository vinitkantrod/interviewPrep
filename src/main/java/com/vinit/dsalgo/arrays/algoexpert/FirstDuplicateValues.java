package com.vinit.dsalgo.arrays.algoexpert;

import java.util.HashMap;
import java.util.Map;

public class FirstDuplicateValues {

    public int firstDuplicateValue(int[] array) {
        Map<Integer, Boolean> data = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (data.containsKey(array[i])) {
                return array[i];
            } else {
                data.put(array[i], true);
            }
        }
        return -1;
    }

    public static void main(String args[]) {

    }
}
