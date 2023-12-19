package com.vinit.dsalgo.arrays.leetcode;

import java.util.*;

public class SumOfValuesAtIndicesWithKSetBit2859 {

    public static int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        Map<Integer, Integer> setMap = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            int bitValue = Integer.parseInt(Integer.toBinaryString(i), 2);
            System.out.println("bitValue: " + bitValue);
            int setCount = countSetBit(bitValue);
            System.out.println("setCount: " + setCount);
            setMap.put(setCount, setMap.getOrDefault(setCount, 0) + nums.get(i));
        }
        System.out.println(setMap);
        return setMap.getOrDefault(k, 0);
    }

    public static int countSetBit(int n ) {
        int count = 0;
        while (n > 0) {
            count+= n & 1;
            n >>= 1;
        }
        return count;
    }
    public static void main(String[] args) {
        List<Integer> s = new ArrayList<>(Arrays.asList(5,10,1,5,2));
        System.out.println(sumIndicesWithKSetBits(s, 1));
    }
}
