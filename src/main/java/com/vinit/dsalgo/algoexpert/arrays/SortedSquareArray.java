package com.vinit.dsalgo.algoexpert.arrays;

import java.util.Arrays;

public class SortedSquareArray {

    public static int[] sortedSquaredArray(int[] array) {
        // Write your code here.
        // O(nLogn)
//        int[] result = new int[array.length];
//        for (int i = 0; i < array.length; i++) {
//            result[i] = array[i] * array[i];
//        }
//        Arrays.sort(result);
//        return result;
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * array[i];
        }
        System.out.println(Arrays.toString(array));
        int k = array.length - 1;
        int i = 0;
        int j = array.length - 1;
        while (i <= j) {
            if (array[i] > array[j]) {
                result[k--] = array[i++];
            } else {
                result[k--] = array[j--];
            }
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-4,-2,1,2,3,5,6,8,9};
        System.out.println(Arrays.toString(sortedSquaredArray(arr)));
    }
}
