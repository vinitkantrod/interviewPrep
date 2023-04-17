package com.vinit.dsalgo.arrays.leetcode;

public class MakeArrayZero2357 {

    public static int minimumOperations(int[] nums) {
        int minOps = 0;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && nums[i] < minValue) minValue = nums[i];
        }
        if (minValue == 0) return minOps;
        while (minValue > 0) {
            System.out.println(minValue);
            Boolean isSubtracted = false;
            int newMinValue = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
               if (nums[i] > 0) {
                   nums[i] = nums[i] - minValue;
                   isSubtracted = true;
               }
               if (nums[i] != 0 && nums[i] < newMinValue) {
                   newMinValue = nums[i];
               }
            }
            if (!isSubtracted) break;
            minValue = newMinValue;
            minOps++;
        }
        return minOps;

        // Time complexity:
        //n log(n) to sort the array + n to traverse the array once to find all unique positive integers.
        //
        //Space complexity:
        //O(1) in stack, n sized input array.

//        Arrays.sort(nums);
//
//        /*  28 march, 2023 */
//        int uniques = 0;
//
//        for(int i = 0; i<nums.length; ){
//            int j;
//            for(j=i+1; j<nums.length && nums[j] == nums[i]; j++){}
//            i = j;
//            uniques++;
//        }
//
//        if(nums[0] == 0) return un
    }

    public static void main(String[] args) {
        int[] x= {1,5,0,3,5};
        System.out.println(minimumOperations(x));
    }
}
