package com.vinit.dsalgo.algoexpert.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximizeExpression {

    public static int maximizeExpression(int[] array) {
        // Write your code here.
        if (array.length < 4) return 0;
        int n = array.length;
        List<Integer> maxA = new ArrayList<>(List.of(array[0]));
        List<Integer> maxAMinusB = new ArrayList<>(List.of(Integer.MIN_VALUE));
        List<Integer> maxAMinusBPlusC = new ArrayList<>(List.of(Integer.MIN_VALUE, Integer.MIN_VALUE));
        List<Integer> maxAMinusBPlusCMinusD = new ArrayList<>(List.of(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE));
        for (int i = 1; i < n; i++)
            maxA.add(Math.max(maxA.get(i - 1), array[i]));
        for (int i = 1; i < n; i++)
            maxAMinusB.add(
                    Math.max(maxAMinusB.get(i - 1), maxA.get(i - 1) - array[i])
            );
        for (int i = 2; i < n; i++)
            maxAMinusBPlusC.add(
                    Math.max(array[i] + maxAMinusB.get(i - 1), maxAMinusBPlusC.get(i - 1))
            );
        for (int i = 3; i < n; i++) {
            maxAMinusBPlusCMinusD.add(
                    Math.max(maxAMinusBPlusC.get(i - 1) - array[i], maxAMinusBPlusCMinusD.get(i - 1))
            );
        }
        return maxAMinusBPlusCMinusD.get(maxAMinusBPlusCMinusD.size() - 1);
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,6,1,-3,2,7};
        System.out.println(maximizeExpression(a));
    }

}
