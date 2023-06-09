package com.vinit.dsalgo.arrays.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfAllOddLengthSubArray1588 {
    static int sum;
    public static int sumOddLengthSubarrays(int[] arr) {
        sum = 0;
        for (int i = 0; i < arr.length; i++) {
            subArray(arr, i, new ArrayList<>());
        }
        return sum;
    }

    public static void subArray(int[] arr, int index, List<Integer> list) {
        if (index == arr.length) return;
        list.add(arr[index]);
        if (list.size() % 2 == 1) {
            sum += getSum(list);
        }
        subArray(arr, index + 1, list);
    }

    public static int getSum(List<Integer> list) {
        int s = 0;
        for (int i = 0; i < list.size(); i++) s += list.get(i);
        return s;
    }
    public static void main(String[] args) {
        int[] arr = {1,4,2,5,3};
        System.out.println(sumOddLengthSubarrays(arr));
    }
}
