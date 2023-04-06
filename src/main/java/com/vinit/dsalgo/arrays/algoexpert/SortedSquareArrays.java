package com.vinit.dsalgo.arrays.algoexpert;

import java.util.Arrays;

public class SortedSquareArrays {

    public static int[] sortedSquaredArray(int[] array) {
//        int smallerIdx = 0;
//        int largerIdx = array.length - 1;
//        int[] res = new int[array.length];
//        for (int idx = 0; idx < array.length; idx++) {
//            if (Math.abs(array[smallerIdx]) < Math.abs(array[largerIdx])) {
//                res[idx] = array[smallerIdx] * array[smallerIdx];
//                smallerIdx++;
//            } else {
//                res[idx] = array[largerIdx] * array[largerIdx];
//                largerIdx--;
//            }
//        }
//        return res;
//        Decreasing Squares
        int[] result = new int[array.length];
        int smallerValueIdx = 0;
        int largerValueIdx = array.length - 1;
        for (int idx = array.length - 1; idx >= 0; idx--) {
            int smallerValue = array[smallerValueIdx];
            int largerValue = array[largerValueIdx];
            if (Math.abs(smallerValue) > Math.abs(largerValue)) {
                result[idx] = smallerValue * smallerValue;
                smallerValueIdx++;
            } else {
                result[idx] = largerValue * largerValue;
                largerValueIdx--;
            }
        }
        return result;
    }

    public static void main(String args[]) {
//        int[] n = {1,2,3,4,5,6,7,8,9};
//        int[] n = {-4,-3,-2,0,1,2,3,4,5,6,7,8,9};
        int[] n = {-7, -3, 1,9, 22, 30};
        System.out.println(Arrays.toString(sortedSquaredArray(n)));
    }
}
