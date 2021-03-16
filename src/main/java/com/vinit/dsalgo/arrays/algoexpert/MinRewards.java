package com.vinit.dsalgo.arrays.algoexpert;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MinRewards {

    public static int minRewards(int[] scores) {
        int minScoreIdx = 0;
        int rewardCount = 0;
        if (scores.length == 1) return 1;
        int minScore = scores[0];
        int[] rewardsArr = new int[scores.length];
        Arrays.fill(rewardsArr, 1);
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > scores[i - 1]) {
                rewardsArr[i] = rewardsArr[i - 1] + 1;
            }
        }
        System.out.println(Arrays.toString(rewardsArr));
        for (int i = rewardsArr.length - 2; i >= 0; i--) {
            if (scores[i] > scores[i + 1]) {
                rewardsArr[i] = Math.max(rewardsArr[i], rewardsArr[i + 1] + 1);
            }
        }
        System.out.println(Arrays.toString(rewardsArr));
        for (int i = 0; i < rewardsArr.length; i++) {
            rewardCount += rewardsArr[i];
        }
        return IntStream.of(rewardsArr).sum();
    }

    public static void main(String args[]) {
//        int[] rewards =  {8,4,2,1,3,6,7,9,5};
        int[] rewards =  {0,4,2,1,3};
        System.out.println(minRewards(rewards));
    }
}
