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
        for (int i = 0; i < items.length + 1; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                System.out.print(knapsack[i][j] + " ");
            }
            System.out.println("");
        }
        for (int i = 1; i < items.length + 1; i++) {
            int currentValue = items[i - 1][0];
            int currentWeight = items[i - 1][1];
            for (int c = 0; c < capacity + 1; c++) {
                if (currentWeight > c) knapsack[i][c] = knapsack[i - 1][c];
                else {
                    knapsack[i][c] = Math.max(
                            knapsack[i - 1][c],
                            knapsack[i - 1][c - currentWeight] + currentValue
                    );
                }
            }
        }
        for (int i = 0; i < items.length + 1; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                System.out.print(knapsack[i][j] + " ");
            }
            System.out.println("");
        }
        return getKnapsack(items, knapsack, capacity, knapsack[items.length + 1][items[0].length + 1]);
    }

    public static List<List<Integer>> getKnapsack(int[][] items, int[][] knapsack, int capacity, int weight) {
        return new ArrayList<List<Integer>>();
    }
    public static void main(String[] args) {
        int[][] k = {{1,2}, {4,3}, {5,6}, {6,7}};
        knapsackProblem(k, 10);
    }
}
