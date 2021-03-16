package com.vinit.dsalgo.greedy.algoexpert;

import java.util.Arrays;

public class MinimumWaitingTime {

    public static int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int totalWaitingTime = 0;
        for (int i = 0; i < queries.length ; i++) {
            int duration = queries[i];
            int queriesLeft = queries.length - (i + 1);
            totalWaitingTime += duration * queriesLeft;
        }
        return totalWaitingTime;
    }
    public static void main(String args[]) {
        int[] q = {3,2,1,2,6};
//        int[] q = {5 ,1, 4};
        System.out.println(minimumWaitingTime(q));
    }
}
