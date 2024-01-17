package com.vinit.dsalgo.algoexpert.arrays;

public class FirstDuplicateValue {

    public int firstDuplicateValue(int[] array) {
        for (int val : array) {
            int absValue = Math.abs(val);
            if (array[absValue - 1] < 0) return absValue;
            array[absValue - 1] *= -1;
        }
        return -1;
    }
}
