package com.vinit.dsalgo.arrays.algoexpert;

import java.util.Arrays;

public class SubArraySort {

    public static int[] subarraySort(int[] array) {
        // Write your code here.
//        int[] sortedArray = array.clone();
//        Arrays.sort(sortedArray); // WC TC: O(NLogN)
//        int startIdx = array.length - 1;
//        int endIdx = 0;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] != sortedArray[i]) {
//                if (startIdx > i) {
//                    startIdx = i;
//                }
//                if (endIdx < i) {
//                    endIdx = i;
//                }
//            }
//        }
//        if (startIdx == array.length - 1 && endIdx == 0) return new int[] {-1, -1};
//        return new int[] {startIdx, endIdx};

        int leftIdx = 0;
        int rightIdx = array.length - 1;
        int startIdx = Integer.MAX_VALUE;
        int endIdx = Integer.MIN_VALUE;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i+1] < array[i]) {
                leftIdx = i;
                break;
            }
        }
        for (int j = array.length - 1; j > 0; j--) {
            if (array[j - 1] > array[j]) {
                rightIdx = j;
                break;
            }
        }


        System.out.println(leftIdx + " - " + rightIdx);
        return new int[] {};
    }
    public static void main(String[] args) {
        int[] array = {1,2,4,7,10,11,7,12,6,7,16,18,19};
        System.out.println(Arrays.toString(subarraySort(array)));
    }
}
