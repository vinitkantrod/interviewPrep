package com.vinit.dsalgo.arrays.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsWithCandies {

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int maxCandies = Integer.MIN_VALUE;
        for (int idx = 0; idx < candies.length; idx++) {
            if ( candies[idx] > maxCandies ) {
                maxCandies = candies[idx];
            }
        }
        for (int idx = 0; idx < candies.length; idx++) {
            result.add((candies[idx] + extraCandies) >= maxCandies ? true : false);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] candies = {1,2,3,5,3,0};
        int extraCandies = 3;
        System.out.println(Arrays.asList(kidsWithCandies(candies, extraCandies)));
    }
}
