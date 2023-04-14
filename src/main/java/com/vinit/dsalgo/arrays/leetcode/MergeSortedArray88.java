package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;

public class MergeSortedArray88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        if (m == 0) {
//            for (int i = 0; i < n; i++) {
//                nums1[i] = nums2[i];
//            }
//            return;
//        }
//        int newidx = m;
//        int newArrStart = m;
//        for (int i = 0; i < n; i++) {
//            nums1[newidx] = nums2[i];
//            newidx++;
//        }
//        System.out.println(Arrays.toString(nums1));
//        int i = 0;
//        while (newArrStart < (m + n) && i < newArrStart) {
//            if (nums1[i] > nums1[newArrStart]) {
//                int temp = nums1[i];
//                nums1[i] = nums1[newArrStart];
//                nums1[newArrStart] = temp;
//                i++;
////                newArrStart++;
//            } else i++;
//            if (i == newArrStart) newArrStart++;
//        }
//        System.out.println(Arrays.toString(nums1));

        // LC code
        int i=m-1; // will point at m-1 index of nums1 array
        int j=n-1; // will point at n-1 index of nums2 array
        int k=nums1.length-1; //will point at the last position of the nums1 array

        // Now traversing the nums2 array
        while(j>=0){
            // If element at i index of nums1 > element at j index of nums2
            // then it is largest among two arrays and will be stored at k position of nums1
            // using i>=0 to make sure we have elements to compare in nums1 array
            if(i>=0 && nums1[i]>nums2[j]){
                nums1[k]=nums1[i];
                k--;
                i--; //updating pointer for further comparisons
            }else{
                // element at j index of nums2 array is greater than the element at i index of nums1 array
                // or there is no element left to compare with the nums1 array
                // and we just have to push the elements of nums2 array in the nums1 array.
                nums1[k] = nums2[j];
                k--;
                j--; //updating pointer for further comparisons
            }
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,6,0,0,0};
        int m = 3;
        int[] num2 = {2,5,7};
        int n = 3;
//        int[] num1 = {1,2,4,5,6,0};
//        int m = 5;
//        int[] num2 = {3};
//        int n = 1;
//        int[] num1 = {4,5,6,0,0,0};
//        int m = 3;
//        int[] num2 = {1,2,3};
//        int n = 3;
        merge(num1, m, num2, n);
    }
}
