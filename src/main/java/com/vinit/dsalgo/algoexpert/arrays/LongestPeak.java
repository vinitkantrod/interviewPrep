package com.vinit.dsalgo.algoexpert.arrays;

public class LongestPeak {

    public static int longestPeak(int[] array) {
        // Write your code here.
        int longestPeak = 0;
        int i = 1;
        while (i < array.length - 1) {
            Boolean isPeak = array[i - 1] < array[i] && array[i] > array[i + 1];
            if (!isPeak) {
                i += 1;
                continue;
            }
            int leftIdx = i - 2;
            while (leftIdx >= 0 && array[leftIdx] < array[leftIdx + 1]) {
                leftIdx--;
            }
            int rightIdx = i + 2;
            while (rightIdx < array.length && array[rightIdx] < array[rightIdx - 1]) {
                rightIdx++;
            }
            int currePeak = rightIdx - leftIdx - 1;
            if (currePeak > longestPeak) longestPeak = currePeak;
            i = rightIdx;
        }
        return longestPeak;

    }

    public static void main(String[] args) {

    }
}
