package com.vinit.dsalgo.algoexpert.arrays;

import java.util.Arrays;
import java.util.Map;

public class MinRewards {

    public static int minRewards(int[] scores) {
        // Write your code here.
        int[] result = new int[scores.length];
//        Arrays.fill(result,0);
        for (int i = 0; i < scores.length; i++) {
            int left = i;
            int right =  i;
            int leftCount = 0;
            while (left - 1 >= 0 && scores[left - 1] < scores[left]) {
                left--;
                leftCount++;
            }
            int rightCount = 0;
            while (right + 1 < scores.length && scores[right + 1] < scores[right]) {
                right++;
                rightCount++;
            }
            result[i] = 1 + Math.max(leftCount,rightCount);
        }
        return Arrays.stream(result).sum();
    }

    public static void main(String[] args) {
        int[] scores = new int[]{8,4,2,1,3,6,7,9,5};
        System.out.println(minRewards(scores));
    }
}
