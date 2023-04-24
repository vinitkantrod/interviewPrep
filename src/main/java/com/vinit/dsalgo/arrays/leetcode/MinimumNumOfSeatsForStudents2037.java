package com.vinit.dsalgo.arrays.leetcode;

import java.util.Arrays;

public class MinimumNumOfSeatsForStudents2037 {

    public static int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int moves = 0;
        for (int i = 0; i < seats.length; i++) {
            moves += (Math.abs(seats[i] - students[i]));
        }
        return moves;
    }
    public static void main(String[] args) {
//        int[] se = {3,1,5};
//        int[] st = {2,7,4};
        int[] se = {4,1,5,9};
        int[] st = {1,3,2,6};
        System.out.println(minMovesToSeat(se, st));
    }
}
