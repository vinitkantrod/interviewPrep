package com.vinit.dsalgo.arrays.leetcode;

import java.util.ArrayList;
import java.util.List;

public class KidsWithNGreatestCandies1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int i = 0; i < candies.length; i++) if (candies[i] > max) max = candies[i];
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < candies.length; i++ ) {
            result.add(candies[i] + extraCandies >= max ? true : false);
        }
        return result;
    }
}
