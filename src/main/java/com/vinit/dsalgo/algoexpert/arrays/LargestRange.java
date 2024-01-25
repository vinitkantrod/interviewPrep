package com.vinit.dsalgo.algoexpert.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestRange {

    public static int[] largestRange(int[] array) {
        // Write your code here.
        int[] bestRange = new int[2];
        int longestRange = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i : array) {
            map.put(i, false);
        }
        for (int i : array) {
            if (map.get(i)) continue;
            int currentRange = 1;
            int left = i - 1;
            int right = i + 1;
            while (map.containsKey(left)) {
                map.put(left, true);
                currentRange++;
                left--;
            }
            while (map.containsKey(right)) {
                map.put(right, true);
                currentRange++;
                right++;
            }
            System.out.println(left + "-" + right);
            System.out.println(currentRange);
            if (currentRange > longestRange) {
                longestRange = currentRange;
                bestRange = new int[] {left + 1, right -1};
            }
        }
        return bestRange;
    }

    public static void main(String[] args) {
//        int[] range = new int[] {1,11,3,0,15,5,2,4,10,7,12,6};
        int[] range = new int[] {1};
        System.out.println(Arrays.toString(largestRange(range)));
    }
}
