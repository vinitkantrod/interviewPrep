package com.vinit.dsalgo.recursion.algoexpert;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBinaryTreeTopologies {

    public static int numberOfBinaryTreeTopologies(int n) {
        Map<Integer, Integer> trees = new HashMap<>();
        trees.put(0, 1);
        return traverse(n, trees);
    }

    public static int traverse(int n, Map<Integer, Integer> trees) {
        if (trees.containsKey(n)) return trees.get(n);
        int numOfTrees = 0;
        for (int leftTreeSize = 0; leftTreeSize < n; leftTreeSize++) {
            int rightTreeSize = n - 1 - leftTreeSize;
            int numOfLeftTrees = numberOfBinaryTreeTopologies(leftTreeSize);
            int numOfRightTrees = numberOfBinaryTreeTopologies(rightTreeSize);
            numOfTrees += numOfLeftTrees * numOfRightTrees;
        }
        trees.put(n, numOfTrees);
        return numOfTrees;
    }
    public static void main(String args[]) {
        System.out.println(numberOfBinaryTreeTopologies(5));
    }
}
