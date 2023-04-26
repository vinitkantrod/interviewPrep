package com.vinit.dsalgo.arrays.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeperateTheDigitsInArray2553 {

    public static int[] separateDigits(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<Integer> tempList = new ArrayList<>();
            while (num > 0) {
                int temp = num % 10;
                num = num / 10;
                tempList.add(0, temp);
            }
            lst.addAll(tempList);
            System.out.println(Arrays.asList(lst));
        }
        return lst.stream().mapToInt(i -> i).toArray();
    }
    public static void main(String[] args) {
        int[] n = {13,67,45,85,9,117,1};
        System.out.println(separateDigits(n));
    }
}

