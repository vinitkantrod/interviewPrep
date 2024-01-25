package com.vinit.dsalgo.algoexpert.arrays;

import java.util.Arrays;
import java.util.Map;

public class SubsortArray {
    public static int[] subarraySort(int[] array) {
        // Write your code here.
        int minOutOfOrder = Integer.MAX_VALUE;
        int maxOutOfOrder = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (isOutOfOrder(i, num, array)) {
                minOutOfOrder = Math.min(minOutOfOrder, num);
                maxOutOfOrder = Math.max(maxOutOfOrder, num);
            }
        }
        System.out.println(minOutOfOrder + " - " + maxOutOfOrder);
        if (minOutOfOrder == Integer.MAX_VALUE) return new int[] {-1, -1};
        int leftIdx = 0;
        while (minOutOfOrder >= array[leftIdx]) leftIdx++;
        int rightIdx = array.length - 1;
        while (maxOutOfOrder <= array[rightIdx]) rightIdx--;
        return new int[] {leftIdx, rightIdx};
    }

    public static Boolean isOutOfOrder(int i, int num, int[] array) {
        if (i == 0) return num > array[i + 1];
        else if (i == array.length - 1) return num < array[i - 1];
        else return num < array[i - 1] || num > array[i + 1];
    }
    public static void main(String[] args) {
//        int[] arr=  new int[] {1,2,4,7,10,11,7,12,6,7,16,18,19};
        int[] arr=  new int[] {2,1};
        System.out.println(Arrays.toString(subarraySort(arr)));
    }
}
