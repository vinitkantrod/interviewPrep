package com.vinit.dsalgo.arrays.algoexpert;

public class MonotonicArray {

    public static boolean isMonotonic(int[] array) {
        // Write your code here.
        if ( array.length == 0 || array.length == 1) return true;
        Boolean shouldIncrease = false;
        Boolean shouldDecrease = false;
        for (int i = 1; i < array.length; i++) {
            if (!shouldIncrease && !shouldDecrease) {
                if (array[i] > array[i - 1]) {
                    shouldIncrease = true;
                }
                if (array[i] < array[i - 1]) {
                    shouldDecrease = true;
                }
            } else if (shouldIncrease && array[i] < array[i - 1]) {
                return false;
            } else if (shouldDecrease && array[i] > array[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = {-1,-1,-5,-10,-1100,-1100,-1101,-1102,-9001};
        System.out.println(isMonotonic(array));
    }
}
