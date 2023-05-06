package com.vinit.dsalgo.hashtable.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementTwo503 {

    public static int[] nextGreaterElements(int[] nums) {
        // Not Working as numbers are not unique. discard map based solution
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) map.put(nums[i], i);
        int m = nums.length;
        System.out.println(map);
        int[] arr = new int[m];
        Arrays.fill(arr, -1);
        for (int i = 0; i < m; i++) {
            int n = nums[i];
            int currentIdx = map.get(n);
            int idx = currentIdx + 1;
            if (idx == m) idx = 0;
            System.out.println("n: " + n);
            while (idx != currentIdx) {
                System.out.println("idx: "+idx+ ", nums: " + nums[idx]);
                if (nums[idx] > n) {
                    arr[i] = nums[idx];
                    System.out.println(Arrays.toString(arr));
                    break;
                }
                idx++;
                if (idx == m) idx = 0;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] n = {100,1,11,1,120,111,123,1,-1,-100};
        System.out.println(Arrays.toString(nextGreaterElements(n)));
    }
}
