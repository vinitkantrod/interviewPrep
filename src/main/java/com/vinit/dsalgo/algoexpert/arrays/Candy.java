package com.vinit.dsalgo.algoexpert.arrays;

import java.util.Arrays;

public class Candy {

    public static int candy(int[] ratings) {
        int total = ratings.length;
        int len = ratings.length;
        int[] left = new int[len];
        int[] right = new int[len];
        for (int i = 1; i < len; i++) {
            left[i] = ratings[i] > ratings[i - 1] ? ratings[i - 1] + 1 : 0;
        }
        System.out.println(Arrays.toString(left));
        for (int i = len - 2; i >= 0; i--) {
            right[i] = ratings[i] > ratings[i + 1] ? ratings[i + 1] + 1 : 0;
        }
        System.out.println(Arrays.toString(right));
        System.out.println(total);
        for (int i = 0; i < len; i++) {
            total += Math.max(left[i], right[i]);
            System.out.println(i + " - " + total);
        }
        return total;
    }

    public static void main(String[] args) {
        int[] r = new int[]{1,0,2};
        System.out.println(candy(r));
    }
}
