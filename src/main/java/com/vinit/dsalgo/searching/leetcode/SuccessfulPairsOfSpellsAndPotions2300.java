package com.vinit.dsalgo.searching.leetcode;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] pairs = new int[spells.length];
        int m = potions.length;
        int maxPotion = potions[m - 1];
        for (int i = 0; i < spells.length; i++) {
            long minPotion = (long) Math.ceil((1 * success) / spells[i]);
            if (minPotion > maxPotion) {
                pairs[i] = 0;
                continue;
            }
            int index = search(potions, (int) minPotion);
            pairs[i] = m - index;

        }
        return pairs;
    }

    private int search(int[] potions, int minPotion) {
        int low = 0;
        int high = potions.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (potions[mid] < minPotion) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}
