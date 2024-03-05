package com.vinit.interviews.pocketfm;

import java.util.Arrays;

public class PocketFmTwo {

    public static int waterPercolate(int[] array) {
        if (array.length <= 1) return 0;
        int leftMax = 0;
        int[] leftArray = new int[array.length];
        int i;
        for (i = 0; i < array.length; i++) {
            leftMax = Math.max(leftMax, array[i]);
            leftArray[i] = leftMax - array[i];
        }
        System.out.println(Arrays.toString(leftArray));
        int rightMax = 0;
        int[] rightArray = new int[array.length];
        for (i = array.length - 1; i>=0; i--) {
            rightMax = Math.max(rightMax, array[i]);
            rightArray[i] = rightMax - array[i];
        }
        System.out.println(Arrays.toString(rightArray));
        int totalAmount = 0;
        for (i = 0 ; i < array.length; i++) {
            totalAmount += Math.min(leftArray[i], rightArray[i]);
        }
        return totalAmount;
    }

    public static void main(String[] args) {
//            int[] arr = new int[]{3,0,2,0,4};
        int[] arr = new int[]{4,2,0,3,2,5};
        System.out.println(waterPercolate(arr));
    }
}
