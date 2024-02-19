package com.vinit.dsalgo.arrays.algoexpert;

import java.util.Arrays;

public class ArrayPartition {

    public static int arrayPairSum(int[] nums) {
//        int maxSum = 0;
//        Arrays.sort(nums);
//        for (int i= 0; i < nums.length; i += 2) maxSum += nums[i];
//        return maxSum;

        int K = 10;
        // Store the frequency of each element
        int[] elementToCount = new int[2 * K + 1];
        for (int element : nums) {
            System.out.println(element+"-"+(element + K));
            // Add K to element to offset negative values
            elementToCount[element + K]++;
        }
        System.out.println(Arrays.toString(elementToCount));
        // Initialize sum to zero
        int maxSum = 0;
        boolean isEvenIndex = true;
        for (int element = 0; element <= 2 * K; element++) {
            System.out.println("element:" + element);
            while (elementToCount[element] > 0) {
                System.out.println("||" + elementToCount[element] + " - " + isEvenIndex);
                // Add element if it is at even position
                maxSum += (isEvenIndex ? element - K : 0);
                System.out.println("max: " + maxSum);
                // Flip the value (one to zero or zero to one)
                isEvenIndex = !isEvenIndex;
                // Decrement the frequency count
                elementToCount[element]--;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,4,3,2};
        System.out.println(arrayPairSum(a));
    }
}
