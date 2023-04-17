package com.vinit.dsalgo.greedy.algoexpert;

import java.util.Arrays;
import java.util.Collections;

public class TandemBicycle {

    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        // Write your code here.
        int n = redShirtSpeeds.length;
        int[] newList = new int[2 * n];
        int sum = 0;
        if (!fastest) {
            Arrays.sort(redShirtSpeeds);
            Arrays.sort(blueShirtSpeeds);
            for (int i = 0; i < n; i++) {
                sum += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
            }
        } else {
            for (int i = 0; i < n; i++) newList[i] = redShirtSpeeds[i];
            for (int i = 0; i < n; i++) newList[n + i] = blueShirtSpeeds[i];
            Arrays.sort(newList);
            if (fastest) {
                for (int i = n; i < 2 * n; i++) {
                    sum += newList[i];
                }
            } else {
                for (int i = 0; i < n; i++) {
                    sum += newList[i];
                }
            }
        }
        return sum;
    }
}
