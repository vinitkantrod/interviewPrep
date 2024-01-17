package com.vinit.dsalgo.algoexpert.arrays;

public class BestSeat {

    public static int bestSeat(int[] seats) {
        // Write your code here.
        int maxZeroLength = 0;
        int seat = -1;
        int start = 1;
        while (start < seats.length) {
            if (seats[start] == 1) {
                start++;
                continue;
            }
            int currentZeroCount = 0;
            int endIdx = start;
            int mid = -1;
            while (seats[endIdx] == 0 ) {
                currentZeroCount += 1;
                endIdx += 1;
            }
            if (currentZeroCount > maxZeroLength) {
                mid = (endIdx - start - 1) / 2;
                seat = start + mid;
                maxZeroLength = currentZeroCount;
            }
            start = endIdx;
        }
        return seat;
    }

    public static void main(String[] args) {
//        int[] s = new int[]{1,0,1,0,0,0,1};
//        int[] s = new int[]{1,0,0,0,0,0,1};
        int[] s = new int[]{1,0,0,1,0,0,1};
        System.out.println(bestSeat(s));
    }
}
