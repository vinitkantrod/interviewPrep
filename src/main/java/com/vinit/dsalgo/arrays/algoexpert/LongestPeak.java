package com.vinit.dsalgo.arrays.algoexpert;

public class LongestPeak {

    public static int longestPeak(int[] array) {
        // Write your code here.
        if (array.length < 3) return 0;
        int peakLength = 0;
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i-1] < array[i] && array[i] > array[i+1]) {
                int len = expandAroundCorner(array, i);
                peakLength = Math.max(peakLength, len);
            }
        }
        return peakLength;
    }

    public static int expandAroundCorner(int[] array, int index) {
        int leftCount = 1;
        int rightCount = 1;
        int i = index - 1;
        while (i < array.length - 1 && i > 0 && array[i-1] < array[i]) {
            leftCount++;
            i--;
        }
        i = index + 1;
        while (i < array.length - 1 && i > 0 && array[i] > array[i+1]) {
            rightCount++;
            i++;
        }
        return (leftCount + rightCount + 1);
    }
    public static void main(String[] args) {
//        int[] array = {1,2,3,3,4,0,10,6,5,-1,-3,2,3};
        int[] array = {1,3,2};
        System.out.println(longestPeak(array));
    }
}
