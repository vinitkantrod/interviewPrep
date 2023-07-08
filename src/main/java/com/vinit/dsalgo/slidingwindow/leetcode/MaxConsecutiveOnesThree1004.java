package com.vinit.dsalgo.slidingwindow.leetcode;

public class MaxConsecutiveOnesThree1004 {
    public static int longestOnes(int[] nums, int k) {
        int left = 0, right;
        for (right = 0; right < nums.length; right++) {
            // If we included a zero in the window we reduce the value of k.
            // Since k is the maximum zeros allowed in a window.
            if (nums[right] == 0) {
                k--;
            }
            // A negative k denotes we have consumed all allowed flips and window has
            // more than allowed zeros, thus increment left pointer by 1 to keep the window size same.
            if (k < 0) {
                // If the left element to be thrown out is zero we increase k.
                k += 1 - nums[left];
                left++;
            }
        }
        return right - left;

//        int count = 0;
//        int tempK = 0;
//        int i = 0;
//        for (; i < nums.length; i++) {
//            System.out.println(i);
//            if (nums[i] == 0) {
//                tempK++;
//            }
//            count++;
//            if(tempK == k) break;
//        }
//        int ans = count;
//        System.out.println("i:" + i);
//        int j = i + 1;
//        i = 0;
//        for(int j = i + 1; j < nums.length; j++) {
//            if (nums[j] == 0 && nums[i] == 0) {
//                continue;
//            }
//        }
//        System.out.println(count);
//        return 0;
    }
    public static void main(String[] args) {
        int[] n = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(longestOnes(n, 3));
    }
}
