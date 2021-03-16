package com.vinit.dsalgo.recursion;

import java.util.*;

public class StairCaseTraversal {

    public static int staircaseTraversal(int height, int maxSteps) {
        Map<Integer, Integer> storedProc = new HashMap<>();
        storedProc.put(1, 1);
        storedProc.put(0, 1);
        return numberOfWays(height, maxSteps, storedProc);
    }

    public static int numberOfWays(int height, int maxSteps, Map<Integer, Integer> storedProc) {
        if (storedProc.containsKey(height)) return storedProc.get(height);
        int numOfWays = 0;
        for (int i = 1; i < Math.min(height,maxSteps) + 1; i++) {
            numOfWays += numberOfWays(height - i, maxSteps, storedProc);
        }
        storedProc.put(height, numOfWays);
        System.out.println(storedProc);
        return numOfWays;
    }

    public static int iterativeStairCaseTraversal(int height, int maxSteps) {
        int[] numOfWays = new int[height + 1];
        Arrays.fill(numOfWays, 0);
        numOfWays[0] = 1;
        numOfWays[1] = 1;
        for (int currentHeight = 2; currentHeight < height + 1; currentHeight++) {
            int steps = 1;
            while (steps <= currentHeight && steps <= maxSteps) {
                numOfWays[currentHeight] = numOfWays[currentHeight] + numOfWays[currentHeight - steps];
                steps++;
            }
        }
        return numOfWays[height];
    }

    public static void main(String args[]) {
        System.out.println(iterativeStairCaseTraversal(5, 3));
    }
}
