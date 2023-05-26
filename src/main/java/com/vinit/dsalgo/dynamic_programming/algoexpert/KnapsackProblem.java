package com.vinit.dsalgo.dynamic_programming.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapsackProblem {

    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        List<List<Integer>> result = new ArrayList<>();
        int[][] knapsack = new int[items.length + 1][capacity + 1];
        for (int i = 0; i < items.length + 1; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                knapsack[i][j] = 0;
            }
        }
//        for (int i = 0; i < items.length + 1; i++) {
//            for (int j = 0; j < capacity + 1; j++) {
//                System.out.print(knapsack[i][j] + " ");
//            }
//            System.out.println("");
//        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < items.length + 1; i++) {
            List<List<Integer>> tempRes = new ArrayList<>();
            int currentValue = items[i - 1][0];
            int currentWeight = items[i - 1][1];
            tempRes.add(new ArrayList<>());
            for (int c = 0; c < capacity + 1; c++) {
                if (currentWeight > c) {
                    knapsack[i][c] = knapsack[i - 1][c];
                }
                else {
                    knapsack[i][c] = Math.max(
                            knapsack[i - 1][c],
                            knapsack[i - 1][c - currentWeight] + currentValue
                    );
                }
//                System.out.println(i + " - " + tempRes.get(0));
            }
        }
        for (int i = 0; i < items.length + 1; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                System.out.print(knapsack[i][j] + " ");
            }
            System.out.println("");
        }
        List<List<Integer>> res1 = new ArrayList<>();
//        res1.add(knapsack[items.length - 1][capacity]);
//        res.add(0, getKnapsack(items, knapsack, capacity, 0));
        return res;
//        return knapsack[items.length - 1][capacity];
    }

    public static List<Integer> getKnapsack(int[][] items, int[][] knapsack, int capacity, int weight) {
        List<Integer> sequence = new ArrayList<>();

        return sequence;
    }
    public static void main(String[] args) {
        int[][] k = {{1,2}, {4,3}, {5,6}, {6,7}};
        knapsackProblem(k, 10);
    }
}
