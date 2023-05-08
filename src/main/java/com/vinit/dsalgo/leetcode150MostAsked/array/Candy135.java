package com.vinit.dsalgo.leetcode150MostAsked.array;

import java.util.Arrays;

public class Candy135 {

    public static int candy(int[] ratings) {
        int total = ratings.length;
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        System.out.println(Arrays.toString(ratings));
        for (int i = 1; i < ratings.length; i++) {
            left[i] = ratings[i] > ratings[i - 1] ? left[i-1]+1 : 0;
        }
        System.out.println(Arrays.toString(left));
        for (int i = ratings.length - 2; i >= 0; i--) {
            right[i] = ratings[i] > ratings[i + 1] ? right[i+1]+1 : 0;
        }
        System.out.println(Arrays.toString(right));
        for (int i = 0; i < ratings.length; i++) {
            total += Math.max(left[i], right[i]);
        }
        return total;
    }

    public static void main(String[] args) {
//        int[] r = {1,0,2};
//        int[] r = {1,2,2};
        int[] r = {1,3,2,3,4,5,4,3,2,1,0};
        System.out.println(candy(r));
    }
}
