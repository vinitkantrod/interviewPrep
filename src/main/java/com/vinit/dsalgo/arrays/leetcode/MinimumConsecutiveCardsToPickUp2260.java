package com.vinit.dsalgo.arrays.leetcode;

import java.util.*;

public class MinimumConsecutiveCardsToPickUp2260 {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, List<Integer>> positionMap = new HashMap<>();
        int minWindowSize = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) {
            if (positionMap.containsKey(cards[i])) {
                List<Integer> arr = positionMap.get(cards[i]);
                int width = i - arr.get(arr.size() - 1) + 1;
                if (width < minWindowSize) minWindowSize = width;
                arr.add(i);
                positionMap.put(cards[i], arr);
            } else {
                positionMap.put(cards[i], new ArrayList<>(Arrays.asList(i)));
            }
        }
        if (minWindowSize == Integer.MAX_VALUE) return -1;
        else return minWindowSize;
    }
}
